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

package org.mxupdate.test.data.datamodel;

import java.util.Arrays;

import org.mxupdate.test.AbstractTest;
import org.mxupdate.test.ExportParser;
import org.mxupdate.test.data.datamodel.helper.LocaleAttributeList;

/**
 * Used to define a type, create them and test the result.
 *
 * @author The MxUpdate Team
 */
public class TypeData
    extends AbstractDataWithTrigger<TypeData>
{
    /** Local attributes. */
    private final LocaleAttributeList attributes = new LocaleAttributeList();

    /**
     * Initialize this type data with given <code>_name</code>.
     *
     * @param _test     related test implementation (where this type is
     *                  defined)
     * @param _name     name of the type
     */
    public TypeData(final AbstractTest _test,
                    final String _name)
    {
        super(_test, AbstractTest.CI.DM_TYPE, _name);
    }

    /**
     * Appends given {@code _attributes}.
     *
     * @param _attributes    attributes list to append
     * @return this type data instance
     */
    public TypeData addLocalAttribute(final AbstractAttributeData<?>... _attributes)
    {
        this.attributes.addAll(Arrays.asList(_attributes));
        return this;
    }

    @Override()
    public String ciFile()
    {
        final StringBuilder strg = new StringBuilder();
        this.append4CIFileHeader(strg);
        strg.append("mxUpdate " + this.getCI().getMxType() + " \"${NAME}\" {\n");

        this.getFlags()     .append4Update("    ", strg);
        this.getValues()    .append4Update("    ", strg);
        this.getSingles()   .append4Update("    ", strg);
        this.getKeyValues() .append4Update("    ", strg);
        this.getDatas()     .append4Update("    ", strg);
        this.attributes     .append4Update("    ", strg);
        this.getTriggers()  .append4Update("    ", strg);
        this.getProperties().append4Update("    ", strg);

        strg.append("}");

        return strg.toString();
    }

    @Override()
    public void checkExport(final ExportParser _exportParser)
    {
        super.checkExport(_exportParser);

        this.attributes.checkExport(_exportParser);
    }
}
