/*
 *  This file is part of MxUpdate <http://www.mxupdate.org>.
 *
 *  MxUpdate is a deployment tool for a PLM platform to handle
 *  administration objects as single update files (configuration item).
 *
 *  Copyright (C) 2008-2016 The MxUpdate Team - All Rights Reserved
 *
 *  You may use, distribute and modify MxUpdate under the terms of the
 *  MxUpdate license. You should have received a copy of the MxUpdate
 *  license with this file. If not, please write to <info@mxupdate.org>,
 *  or visit <www.mxupdate.org>.
 *
 */

package org.mxupdate.update.userinterface;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.mxupdate.mapping.TypeDef_mxJPO;
import org.mxupdate.update.userinterface.helper.ChildRefList_mxJPO;
import org.mxupdate.update.userinterface.helper.ChildRefList_mxJPO.WriteAppendChildSyntax;
import org.mxupdate.update.util.AbstractParser_mxJPO.ParseException;
import org.mxupdate.update.util.DeltaUtil_mxJPO;
import org.mxupdate.update.util.MqlBuilder_mxJPO.MultiLineMqlBuilder;
import org.mxupdate.update.util.ParameterCache_mxJPO;
import org.mxupdate.update.util.StringUtil_mxJPO;
import org.mxupdate.update.util.UpdateException_mxJPO;

/**
 * The class parses the information about the portal and writes the script used
 * to update portals.
 *
 * @author The MxUpdate Team
 */
public class Portal_mxJPO
    extends AbstractCommand_mxJPO<Portal_mxJPO>
{
    /**
     * Set of all ignored URLs from the XML definition for portals.
     *
     * @see #parse(ParameterCache_mxJPO, String, String)
     */
    private static final Set<String> IGNORED_URLS = new HashSet<String>();
    static  {
        Portal_mxJPO.IGNORED_URLS.add("/channelRefList");
    }

    /** All referenced children. */
    private final ChildRefList_mxJPO children = new ChildRefList_mxJPO();

    /**
     * Constructor used to initialize the type definition enumeration.
     *
     * @param _typeDef  defines the related type definition enumeration
     * @param _mxName   MX name of the administration object
     */
    public Portal_mxJPO(final TypeDef_mxJPO _typeDef,
                        final String _mxName)
    {
        super(_typeDef, _mxName);
    }

    @Override()
    public void parseUpdate(final String _code)
        throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ParseException
    {
        new PortalParser_mxJPO(new StringReader(_code)).parse(this);
        this.prepare();
    }

    /**
     * Parses the {@link #alt}, {@link #href}, {@link #label} and the channel
     * reference {@link #children}.
     *
     * @param _paramCache   parameter cache with MX context
     * @param _url          url of the XML tag
     * @param _content      content of the XML tag
     * @return <i>true</i> if <code>_url</code> could be parsed; otherwise
     *         <i>false</i>
     */
    @Override()
    protected boolean parse(final ParameterCache_mxJPO _paramCache,
                            final String _url,
                            final String _content)
    {
        final boolean parsed;
        if (Portal_mxJPO.IGNORED_URLS.contains(_url))  {
            parsed = true;

        } else if (_url.startsWith("/channelRefList"))  {
            parsed = this.children.parse(_url.substring(15), _content);

        } else  {
            parsed = super.parse(_paramCache, _url, _content);
        }
        return parsed;
    }

    /**
     * Order the channel references.
     */
    @Override()
    protected void prepare()
    {
        this.children.prepare();

        super.prepare();
    }

    /**
     * Writes specific information about the cached portal to the given writer
     * instance. This includes
     * <ul>
     * <li>hidden flag (only if hidden)</li>
     * <li>{@link #label}</li>
     * <li>{@link #href}</li>
     * <li>{@link #alt}</li>
     * <li>settings defined as properties starting with &quot;%&quot; in
     *     {@link #getPropertiesMap()}</li>
     * <li>channel references {@link #children}</li>
     * </ul>
     *
     * @param _paramCache   parameter cache
     * @param _out          writer instance to the TCL update file
     * @throws IOException if the TCL update code could not be written
     */
    @Override()
    protected void write(final ParameterCache_mxJPO _paramCache,
                         final Appendable _out)
        throws IOException
    {
        this.writeHeader(_paramCache, _out);

        _out.append("mxUpdate portal \"${NAME}\"  {\n")
            .append("    description \"").append(StringUtil_mxJPO.convertUpdate(this.getDescription())).append("\"\n");
        if (this.isHidden())  {
            _out.append("    hidden\n");
        }
        _out.append("    label \"").append(StringUtil_mxJPO.convertUpdate(this.getLabel())).append("\"\n")
            .append("    href \"").append(StringUtil_mxJPO.convertUpdate(this.getHref())).append("\"\n")
            .append("    alt \"").append(StringUtil_mxJPO.convertUpdate(this.getAlt())).append("\"\n");
        this.getProperties().writeSettings(_paramCache, _out, "    ");

        this.children.write(_out);

        this.getProperties().writeProperties(_paramCache, _out, "    ");

        _out.append("}");
    }

    @Override()
    protected void calcDelta(final ParameterCache_mxJPO _paramCache,
                             final MultiLineMqlBuilder _mql,
                             final Portal_mxJPO _current)
        throws UpdateException_mxJPO
    {
        DeltaUtil_mxJPO.calcValueDelta(_mql, "description",         this.getDescription(),   _current.getDescription());
        DeltaUtil_mxJPO.calcFlagDelta(_mql,  "hidden",      false,  this.isHidden(),         _current.isHidden());
        DeltaUtil_mxJPO.calcValueDelta(_mql, "alt",                 this.getAlt(),           _current.getAlt());
        DeltaUtil_mxJPO.calcValueDelta(_mql, "href",                this.getHref(),          _current.getHref());
        DeltaUtil_mxJPO.calcValueDelta(_mql, "label",               this.getLabel(),         _current.getLabel());

        this.children.calcDelta(_mql, WriteAppendChildSyntax.PlaceWithNewRow, _current.children);

        this.getProperties().calcDelta(_mql, "", _current.getProperties());
    }
}
