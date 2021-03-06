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

package org.mxupdate.mapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.mxupdate.typedef.TypeDef_mxJPO;
import org.mxupdate.update.util.MqlUtil_mxJPO;
import org.mxupdate.update.util.ParameterCache_mxJPO;

import matrix.util.MatrixException;

/**
 * The class is used to map from used names within the MxUpdate JPOs and the
 * internal used names within MX.
 *
 * @author The MxUpdate Team
 */
public class Mapping_mxJPO
{
    /** Name of the MX program where the mapping definition is stored as properties. */
    private static final String PROP_NAME = "org.mxupdate.mapping.properties";

    /** Used prefix of property definition within the property file. */
    private static final String PREFIX_PROPERTYDEF = "PropertyDef.";
    /** Length of the prefix of property definition within the property file. */
    private static final int LENGTH_PROPERTYDEF = Mapping_mxJPO.PREFIX_PROPERTYDEF.length();

    /** Used prefix of parameter definition within the property file. */
    private static final String PREFIX_PARAMETERDEF = "ParameterDef.";
    /** Length of the {@link #PREFIX_PARAMETERDEF prefix of parameter definition} within the property file. */
    private static final int LENGTH_PARAMETERDEF = Mapping_mxJPO.PREFIX_PARAMETERDEF.length();

    /** Properties holding all mapping definitions. */
    private final Properties properties = new Properties();

    /** Maps from the mode enumeration {@link Action_mxJPO} to the related instance holding the parameter names and description. */
    private final Map<Action_mxJPO,AbstractValue_mxJPO> modeMap = new HashMap<>();

    /** Maps from the name of the parameter to the parameter instance. */
    private final Map<String,ParameterDef_mxJPO> parameterDefMap = new HashMap<>();

    /** Mapping between internal used admin property definitions and the MX attribute names. */
    private final Map<PropertyDef_mxJPO,String> propertyAttributes = new HashMap<>();

    /** Mapping between internal used admin property definitions and the MX admin property names. */
    private final Map<PropertyDef_mxJPO,String> propertyEnum2Names = new HashMap<>();

    /** Mapping between MX admin property name and the internal used admin property definition. */
    private final Map<String,PropertyDef_mxJPO> propertyNames2Enum = new HashMap<>();

    /** Maps from the name of the type definition group to the related type definition group instance. */
    private final Map<String,TypeDef_mxJPO> typeDefMap = new HashMap<>();

    /** Sorted type definition used to define the order of the update. */
    private final Set<TypeDef_mxJPO> typeDefSorted = new TreeSet<>();

    /** Maps from the name of the type definition group to the related type definition group instance. */
    private final Map<String,TypeDefGroup_mxJPO> typeDefGroupMap = new HashMap<>();

    /**
     *
     * @param _paramCache   parameter cache
     * @throws MatrixException if the property program {@link #PROP_NAME} could
     *                         not be read
     * @throws IOException     if the properties could not be parsed
     */
    public Mapping_mxJPO(final ParameterCache_mxJPO _paramCache)
        throws MatrixException, IOException, Exception
    {
        this.properties.putAll(this.readProperties(_paramCache));

        // map attributes and types
        for (final Map.Entry<Object,Object> entry : this.properties.entrySet())  {
            this.evalKeyValue(_paramCache, (String) entry.getKey(), (String) entry.getValue());
        }
        // executes the checks for the parameter definitions
        final Map<String,String> checkResult = new HashMap<>();
        for (final ParameterDef_mxJPO param : this.parameterDefMap.values())  {
            param.evalCheck(_paramCache, checkResult);
        }

        this.typeDefSorted.addAll(this.typeDefMap.values());
    }

    /**
     * Evaluates the given {@code _key} with {@code _value}.
     *
     * @param _paramCache   parameter cache with the MX context
     * @param _key          key to evaluate
     * @param _value        value to evaluate
     * @throws Exception if evaluate failed
     */
    protected void evalKeyValue(final ParameterCache_mxJPO _paramCache,
                                final String _key,
                                final String _value)
        throws Exception
    {
        if (_key.startsWith("Action."))  {
            Action_mxJPO.defineValue(this, _key.substring(7), _value);
        } else if (_key.startsWith(Mapping_mxJPO.PREFIX_PARAMETERDEF))  {
            ParameterDef_mxJPO.defineValue(this, _key.substring(Mapping_mxJPO.LENGTH_PARAMETERDEF), _value);
        } else if (_key.startsWith(Mapping_mxJPO.PREFIX_PROPERTYDEF))  {
            PropertyDef_mxJPO.defineValue(this, _key.substring(Mapping_mxJPO.LENGTH_PROPERTYDEF), _value);
        } else if (_key.startsWith("TypeDef."))  {
            TypeDef_mxJPO.defineValue(_paramCache, this.typeDefMap, _key.substring(8), _value);
        } else if (_key.startsWith("TypeDefGroup."))  {
            TypeDefGroup_mxJPO.defineValue(this, _key.substring(13), _value);
        }
    }

    /**
     * Reads the code of the program {@link #PROP_NAME} and evaluates the code
     * of the program as properties.
     *
     * @param _paramCache   parameter cache
     * @return read properties from MX
     * @throws MatrixException  if the program could not be read
     * @throws IOException      if the code of the program could not be parsed
     *                          as properties
     * @see #PROP_NAME
     */
    protected Properties readProperties(final ParameterCache_mxJPO _paramCache)
        throws MatrixException, IOException
    {
        final Properties ret = new Properties();

        InputStream is = null;

        is = this.getClass().getResourceAsStream("/org/mxupdate/mapping.properties");

        if (is == null)  {
            final String code = MqlUtil_mxJPO.execMql(_paramCache.getContext(),
                    new StringBuilder()
                            .append("print prog \"").append(Mapping_mxJPO.PROP_NAME)
                            .append("\" select code dump"),
                    false);
            is = new ByteArrayInputStream(code.getBytes());
        }

        try {
            ret.load(is);
        } finally  {
            is.close();
        }

        return ret;
    }

    /**
     * Returns the mapping of the mode enumeration item and the related
     * instance holding the parameter names and description.
     *
     * @return mapping between mode enumeration and related instance
     * @see #modeMap
     */
    protected Map<Action_mxJPO,AbstractValue_mxJPO> getModeMap()
    {
        return this.modeMap;
    }

    /**
     * Returns for given name the related parameter instance.
     *
     * @param _name name of the searched parameter instance
     * @return found parameter instance (or <code>null</code> if not found)
     * @see #parameterDefMap
     */
    public ParameterDef_mxJPO getParameterDef(final String _name)
    {
        return this.parameterDefMap.get(_name);
    }

    /**
     * Returns the list of all parameter instances.
     *
     * @return list of all parameter instances
     * see #MAP
     */
    public Collection<ParameterDef_mxJPO> getAllParameterDefs()
    {
        return this.parameterDefMap.values();
    }

    /**
     * Returns the mapping of parameter names and the related parameter
     * definition instance.
     *
     * @return mapping between type name and the related parameter definition
     *         instance
     * @see #parameterDefMap
     */
    protected Map<String,ParameterDef_mxJPO> getParameterDefMap()
    {
        return this.parameterDefMap;
    }

    /**
     * Returns the mapping between internal used admin property definitions and
     * the MX attribute names.
     *
     * @return mapping
     * @see #propertyAttributes
     */
    protected Map<PropertyDef_mxJPO,String> getPropertyAttributes()
    {
        return this.propertyAttributes;
    }

    /**
     * Returns the mapping between internal used admin property definitions and
     * the MX admin property names.
     *
     * @return mapping
     * @see #propertyEnum2Names
     */
    protected Map<PropertyDef_mxJPO,String> getPropertyEnum2Names()
    {
        return this.propertyEnum2Names;
    }

    /**
     * Returns the mapping between MX admin property name and the internal
     * used admin property definition.
     *
     * @return mapping
     * @see #propertyNames2Enum
     */
    protected Map<String,PropertyDef_mxJPO> getPropertyNames2Enum()
    {
        return this.propertyNames2Enum;
    }

    /**
     * Returns for given name the related type definition instance.
     *
     * @param _name name of the searched type definition instance
     * @return found type definition instance (or <code>null</code> if not
     *         found)
     * @see #typeDefMap
     */
    public TypeDef_mxJPO getTypeDef(final String _name)
    {
        return this.typeDefMap.get(_name);
    }

    /**
     * Returns the sorted list of all type definition instances.
     *
     * @return list of all sorted type definition instances
     * @see #typeDefSorted
     */
    public Collection<TypeDef_mxJPO> getAllTypeDefsSorted()
    {
        return this.typeDefSorted;
    }

    /**
     * Returns for given name the related type definition group instance.
     *
     * @param _name name of the searched type definition group instance
     * @return found type definition group instance (or <code>null</code> if
     *         not found)
     * @see #typeDefGroupMap
     */
    public TypeDefGroup_mxJPO getTypeDefGroup(final String _name)
    {
        return this.typeDefGroupMap.get(_name);
    }

    /**
     * Returns the list of all type definition group instances.
     *
     * @return list of all type definition group instances
     * @see #typeDefGroupMap
     */
    public Collection<TypeDefGroup_mxJPO> getAllTypeDefGroups()
    {
        return this.typeDefGroupMap.values();
    }

    /**
     * Returns the mapping between the type definition group name and the
     * related type definition group instance.
     *
     * @return mapping between type definition group name and the related type
     *         definition group instance
     * @see #typeDefGroupMap
     */
    protected Map<String,TypeDefGroup_mxJPO> getTypeDefGroupMap()
    {
        return this.typeDefGroupMap;
    }
}
