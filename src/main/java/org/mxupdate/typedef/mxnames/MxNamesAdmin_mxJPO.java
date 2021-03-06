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

package org.mxupdate.typedef.mxnames;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import org.mxupdate.typedef.EMxAdmin_mxJPO;
import org.mxupdate.typedef.TypeDef_mxJPO;
import org.mxupdate.update.util.ParameterCache_mxJPO;
import org.mxupdate.update.util.StringUtil_mxJPO;

import matrix.util.MatrixException;

/**
 * Searches for all administration object of given type definition and
 * returns all found names as set.
 *
 * @author The MxUpdate Team
 */
public class MxNamesAdmin_mxJPO
    implements IMatcherMxNames_mxJPO
{
    @Override
    public SortedSet<String> match(final ParameterCache_mxJPO _paramCache,
                                   final TypeDef_mxJPO _typeDef,
                                   final Collection<String> _matches)
        throws MatrixException
    {
        final SortedSet<String> ret = new TreeSet<>();
        final EMxAdmin_mxJPO mxClassDef = EMxAdmin_mxJPO.valueOfByClass(_typeDef.getMxUpdateType());
        for (final String mxName : mxClassDef.evalList(_paramCache))  {
            if (StringUtil_mxJPO.match(mxName, _matches))  {
                ret.add(mxName);
            }
        }
        return ret;
    }
}
