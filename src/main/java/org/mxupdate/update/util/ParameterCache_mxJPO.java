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

package org.mxupdate.update.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.mxupdate.mapping.Mapping_mxJPO;
import org.mxupdate.mapping.ParameterDef_mxJPO;
import org.mxupdate.mapping.ParameterDef_mxJPO.Type;

import matrix.db.Context;

/**
 * The class is used to stored the defined parameters from the console.
 *
 * @author The MxUpdate Team
 */
public class ParameterCache_mxJPO
{
    /** Mapping between parameter definition and the related boolean value. */
    private final Map<String,Boolean> mapBoolean;
    /** Mapping between parameter definition and the related integer value. */
    private final Map<String,Integer> mapInteger;
    /** Mapping between parameter definition and the related list of string values. */
    private final Map<String,Collection<String>> mapList;
    /** Mapping between parameter definition and the related map of string values. */
    private final Map<String,Map<String,?>> mapMap;
    /** Mapping between the enumeration name of the parameter and the string value. */
    private final Map<String,String> mapString;

    /** Stores as parameter the related MX context. */
    private final Context context;

    /** Stores the used writer instance for the logging instances. */
    private final PrintWriter writer;

    /** Stores the writer of the logging string. */
    private final StringWriter stringWriter;

    /** Stores the used mapping from this parameter cache instance. */
    private final Mapping_mxJPO mapping;

    /** Session Cache. */
    private final Map<CacheKey,Object> cache = new HashMap<>();

    /**
     * Creates a new instance of the parameter cache. All default values from
     * the parameter definitions are predefined in the parameter cache.
     *
     * @param _context      MX context
     * @param _stringLog    if set to <i>true</i> log via string writer,
     *                      <i>false</i> log via <code>System.out</code>
     * @throws Exception if the mapping could not be initialized
     * @see #context
     * @see #mapBoolean
     * @see #mapList
     * @see #mapMap
     * @see #mapString
     * @see #writer
     * @see #stringWriter
     */
    public ParameterCache_mxJPO(final Context _context,
                                final boolean _stringLog)
            throws Exception
    {
        this(_context, _stringLog, null);
    }

    /**
     * Creates a new instance of the parameter cache. All default values from
     * the parameter definitions are predefined in the parameter cache.
     *
     * @param _context      MX context
     * @param _stringLog    if set to <i>true</i> log via string writer,
     *                      <i>false</i> log via <code>System.out</code>
     * @param _paramValues  predefined parameter values to set
     * @throws Exception if the mapping could not be initialized or a
     *                   predefined parameter in <code>_paramValues</code> is
     *                   not known
     * @see #context
     * @see #mapBoolean
     * @see #mapList
     * @see #mapMap
     * @see #mapString
     * @see #writer
     * @see #stringWriter
     */
    public ParameterCache_mxJPO(final Context _context,
                                final boolean _stringLog,
                                final Map<String,String> _paramValues)
            throws Exception
    {
        this.context = _context;

        this.mapping = this.initMapping(_context);

        this.mapBoolean = new HashMap<>();
        this.mapInteger = new HashMap<>();
        this.mapList = new HashMap<>();
        this.mapMap = new HashMap<>();
        this.mapString = new HashMap<>();

        // evaluate default parameter values
        for (final ParameterDef_mxJPO paramDef : this.mapping.getAllParameterDefs())  {
            if (paramDef.getDefaultValue() != null)  {
                this.defineParameter(paramDef, paramDef.getDefaultValue());
            }
        }
        // evaluate predefined parameter values
        if (_paramValues != null)  {
            for (final Map.Entry<String,String> paramValue : _paramValues.entrySet())  {
                final ParameterDef_mxJPO paramDef = this.mapping.getParameterDef(paramValue.getKey());
                if (paramDef == null)  {
                    throw new Exception("unknown parameter definition '" + paramValue.getKey() + "'");
                }
                this.defineParameter(paramDef, paramValue.getValue());
            }
        }

        if (_stringLog)  {
            this.stringWriter = new StringWriter();
            this.writer = new PrintWriter(this.stringWriter);
        } else  {
            this.stringWriter = null;
            this.writer = new PrintWriter(System.out);
        }
    }

    /**
     * Defines the parameter depending of the parameter definition
     * <code>_paramDef</code> with related <code>_value</code>.
     *
     * @param _paramDef instance of the parameter definition
     * @param _value    string value of the parameter to define
     */
    protected void defineParameter(final ParameterDef_mxJPO _paramDef,
                                   final String _value)
    {
        switch (_paramDef.getType())  {
            case BOOLEAN:
                this.mapBoolean.put(_paramDef.getName(),
                                    Boolean.parseBoolean(_value));
                break;
            case INTEGER:
                this.mapInteger.put(_paramDef.getName(),
                                    Integer.parseInt(_value));
                break;
            case LIST:
                this.mapList.put(_paramDef.getName(),
                                 _value.isEmpty()
                                         ? new ArrayList<String>()
                                         : new ArrayList<>(Arrays.asList(_value.split(","))));
                break;
            case MAP:
                if ((_value != null) && !"".equals(_value))  {
                    final Map<String,String> values = new HashMap<>();
                    for (final String entry : _value.split(","))  {
                        final String[] entryArr = entry.split("=", 2);
                        values.put(entryArr[0], (entryArr.length > 1) ? entryArr[1] : null);
                    }
                    this.mapMap.put(_paramDef.getName(), values);
                }
                break;
            case STRING:
                this.mapString.put(_paramDef.getName(), _value);
                break;
            default:
                throw new Error("unknown parameter type " + _paramDef.getType());
        }
    }

    /**
     * Initializes the mapping for the parameter cache. The initialize is
     * defined in a own method so that the method could be overwritten for test
     * purposes.
     *
     * @param _context      MX context for this request
     * @return initialized mapping
     * @throws Exception if mapping could not be initialized
     */
    protected Mapping_mxJPO initMapping(final Context _context)
        throws Exception
    {
        return new Mapping_mxJPO(this);
    }

    /**
     * Evaluated given parameter and defines the values for given parameter
     * depending on the list of arguments.
     * <ul>
     * <li><b>boolean parameter</b>: the boolean map defines for the parameter
     *     the converted value from the default value</li>
     * <li><b>list parameter</b>: the next argument is added to the value list
     *     </li>
     * <li><b>string parameter</b>: the next argument is defined as string
     *     value</li>
     * </ul>
     *
     * @param _paramDef parameter definition
     * @param _args     list of arguments from the command line
     * @param _index    current index within the list of arguments
     * @return new index of the current index within the list of arguments
     * @see #mapBoolean
     * @see #mapList
     * @see #mapString
     */
    public int evalParameter(final ParameterDef_mxJPO _paramDef,
                             final String[] _args,
                             final int _index)
    {
        int index = _index;

        if (_paramDef.getType() == Type.BOOLEAN)  {
            this.mapBoolean.put(_paramDef.getName(),
                                !Boolean.parseBoolean(_paramDef.getDefaultValue()));
        } else if (_paramDef.getType() == Type.INTEGER)  {
            this.mapInteger.put(_paramDef.getName(),
                                Integer.parseInt(_args[++index]));
        } else if (_paramDef.getType() == Type.LIST)  {
            if (!this.mapList.containsKey(_paramDef.getName()))  {
                this.mapList.put(_paramDef.getName(), new ArrayList<String>());
            }
            this.mapList.get(_paramDef.getName()).add(_args[++index]);
        } else if (_paramDef.getType() == Type.STRING)  {
            this.mapString.put(_paramDef.getName(), _args[++index]);
        }

        return index;
    }

    /**
     * Evaluated if given key is defined in one of the value maps
     * ({@link #mapBoolean}, {@link #mapInteger}, {@link #mapList},
     * {@link #mapMap}, {@link #mapString}).
     *
     * @param _key      searched key
     * @return <i>true</i> if the given key is defined; otherwise <i>false</i>
     *         is returned
     * @see #mapBoolean
     * @see #mapList
     * @see #mapMap
     * @see #mapString
     */
    public boolean contains(final ValueKeys _key)
    {
        return    this.mapBoolean.containsKey(_key.name())
               || this.mapList   .containsKey(_key.name())
               || this.mapInteger.containsKey(_key.name())
               || this.mapMap    .containsKey(_key.name())
               || this.mapString .containsKey(_key.name());
    }

    /**
     * Returns the MX context stored in this parameter cache.
     *
     * @return MX context
     * @see #context
     */
    public Context getContext()
    {
        return this.context;
    }

    /**
     * Returns the cache with all mappings.
     *
     * @return mapping instance
     * @see #mapping
     */
    public Mapping_mxJPO getMapping()
    {
        return this.mapping;
    }

    /**
     * Returns for given key the related boolean value.
     *
     * @param _key  key of searched boolean value
     * @return value of the boolean (or {@code null} if for the key no boolean
     *         value is defined)
     */
    public Boolean getValueBoolean(final ValueKeys _key)
    {
        return this.mapBoolean.get(_key.name());
    }

    /**
     * Returns for given key the related boolean value.
     *
     * @param _key  key of searched boolean value
     * @return value of the boolean (or <code>null</code> if for the key no
     *         boolean value is defined)
     */
    @Deprecated()
    public Boolean getValueBoolean(final String _key)
    {
        return this.mapBoolean.get(_key);
    }

    /**
     * Defines for given key a related boolean value.
     *
     * @param _key      key of the boolean value to define
     * @param _value    related value
     * @see #mapBoolean
     */
    public void defineValueBoolean(final String _key,
                                   final Boolean _value)
    {
        this.mapBoolean.put(_key, _value);
    }

    /**
     * Returns for given key the related integer value.
     *
     * @param _key  key of searched integer value
     * @return value of the integer (or <code>null</code> if for the key no
     *         integer value is defined)
     */
    public Integer getValueInteger(final ValueKeys _key)
    {
        return this.mapInteger.get(_key.name());
    }

    /**
     * Defines for given key a related integer value.
     *
     * @param _key      key of the integer value to define
     * @param _value    related value
     * @see #mapInteger
     */
    public void defineValueInteger(final String _key,
                                   final Integer _value)
    {
        this.mapInteger.put(_key, _value);
    }

    /**
     * Returns for given key the related list value.
     *
     * @param _key  key of searched list value
     * @return list for related key (or {@code null} if no list is not defined)
     */
    public Collection<String> getValueList(final ValueKeys _key)
    {
        return this.mapList.get(_key.name());
    }

    /**
     * Returns for given key the related list value.
     *
     * @param _key  key of searched list value
     * @return list for related key (or {@code null} if no list is not defined)
     */
    @Deprecated()
    public Collection<String> getValueList(final String _key)
    {
        return this.mapList.get(_key);
    }

    /**
     * Returns for given key the related map value.
     *
     * @param <T>       class of the value of the map
     * @param _key      key of searched map value
     * @return map for related key (or <code>null</code> if map is not defined)
     * @see #mapMap
     */
    @SuppressWarnings("unchecked")
    public <T> Map<String,T> getValueMap(final String _key)
    {
        return (Map<String,T>) this.mapMap.get(_key);
    }

    /**
     * Creates for given key a new map if not exists and returns this map.
     *
     * @param <T>       class of the value of the map
     * @param _key      key of searched / new created map value
     * @param _clazz    clazz of the value of the map
     * @return map for related key
     * @see #mapMap
     */
    @SuppressWarnings("unchecked")
    public <T> Map<String,T> defineValueMap(final String _key,
                                            final Class<T> _clazz)
    {
        if (!this.mapMap.containsKey(_key))  {
            this.mapMap.put(_key, new HashMap<String,T>());
        }
        return (Map<String,T>) this.mapMap.get(_key);
    }

    /**
     * Returns for given key the related string value.
     *
     * @param _key  key of searched string value
     * @return string value for related key (or <code>null</code> if no string
     *         value is defined)
     * @see #mapString
     */
    public String getValueString(final ValueKeys _key)
    {
        return this.mapString.get(_key.name());
    }

    /**
     * Returns for given key the related string value.
     *
     * @param _key  key of searched string value
     * @return string value for related key (or <code>null</code> if no string
     *         value is defined)
     * @see #mapString
     */
    @Deprecated()
    public String getValueString(final String _key)
    {
        return this.mapString.get(_key);
    }

    /**
     * String of the logging.
     *
     * @return string of the logging buffer if logged into string writer
     * @see #stringWriter
     */
    public String getLogString()
    {
        return (this.stringWriter == null)
               ? null
               : this.stringWriter.getBuffer().toString();
    }

    /**
     * Logging in error level.
     *
     * @param _text     error text
     * @see #log(LogLevel, String)
     */
    public void logError(final String _text)
    {
        this.log(LogLevel.ERROR, _text);
    }

    /**
     * Logging in warning level.
     *
     * @param _text     warning text
     * @see #log(LogLevel, String)
     */
    public void logWarning(final String _text)
    {
        this.log(LogLevel.WARNING, _text);
    }

    /**
     * Logging in level information.
     *
     * @param _text     info text
     * @see #log(LogLevel, String)
     */
    public void logInfo(final String _text)
    {
        this.log(LogLevel.INFO, _text);
    }

    /**
     * Logging in debug level.
     *
     * @param _text     trace text
     * @see #log(LogLevel, String)
     */
    public void logDebug(final String _text)
    {
        this.log(LogLevel.DEBUG, _text);
    }

    /**
     * Logging in trace level.
     *
     * @param _text     trace text
     * @see #log(LogLevel, String)
     */
    public void logTrace(final String _text)
    {
        this.log(LogLevel.TRACE, _text);
    }

    /**
     * Appends to the log with defined <code>_logLevel</code> the
     * <code>_text</code>.
     *
     * @param _logLevel     level of the log
     * @param _text         text of the log
     */
    private void log(final LogLevel _logLevel,
                     final String _text)
    {
        for (final String line : _text.split("\n"))  {
            if (this.stringWriter == null)  {
                this.writer.append(_logLevel.getConsoleLog());
            } else  {
                this.writer.append(_logLevel.getPlugInLog());
            }
            this.writer.append(line).append('\n');
        }
        this.writer.flush();
    }

    public Object getCache(final CacheKey _key)
    {
        return this.cache.get(_key);
    }

    public void setCache(final CacheKey _key, final Object _value)
    {
        this.cache.put(_key, _value);
    }


    /**
     * Returns the string representation of the parameter cache. The string
     * representation includes all boolean values, list values and string
     * values.
     *
     * @return string representation of the parameter cache
     * @see #mapBoolean
     * @see #mapList
     * @see #mapMap
     * @see #mapString
     */
    @Override()
    public String toString()
    {
        return new StringBuilder()
                .append("[Parameter Cache ")
                    .append("boolean = ").append(this.mapBoolean).append(", ")
                    .append("list = ").append(this.mapList).append(", ")
                    .append("map = ").append(this.mapMap).append(", ")
                    .append("string = ").append(this.mapString)
                .append("]")
                .toString();
    }

    /**
     * Enumeration to configure the logging depending on console and plug-in.
     */
    private enum LogLevel
    {
        /** Log level error. */
        ERROR() {
            /**
             * Overwrites original method because an error tag is prefixed.
             *
             * @return always <code>ERROR! </code>
             */
            @Override()
            public String getConsoleLog()
            {
                return "ERROR! ";
            }
        },
        /** Log level warning. */
        WARNING {
            /**
             * Overwrites original method because a warning tag is prefixed.
             *
             * @return always <code>WARNING! </code>
             */
            @Override()
            public String getConsoleLog()
            {
                return "WARNING! ";
            }
        },
        /** Log level for information. */
        INFO,
        /** Log level debug. */
        DEBUG,
        /** Log level trace. */
        TRACE;

        /**
         * Returns the prefix for the console log which is typically an empty
         * string (means that there is no prefix for the console log).
         *
         * @return always zero length empty string
         */
        public String getConsoleLog()
        {
            return "";
        }

        /**
         * Returns the prefix for the plug-in log which is a concatenation of
         * '<code>[</code>', the name of the enumeration and '<code>]</code>'.
         *
         * @return prefix for the plug-in log
         */
        public String getPlugInLog()
        {
            return new StringBuilder().append('[').append(this.name()).append("] ").toString();
        }
    }

    /**
     * Value keys.
     */
    public enum ValueKeys
    {
        /** Used default installer used within create / update if not defined as parameter. */
        DefaultInstaller,
        /** Installer from the command line used within create / update. */
        Installer,

        /** Path parameter. */
        Path,
        /** Path parameter for ignored files. */
        PathIgnoreFile,
        /** Path parameter for ignored paths. */
        PathIgnorePath,

        /** Boolean that the update continues if a error was thrown. */
        ParamContinueOnError,

        /** License text. */
        ActionLicenseText,
        /** License text separator. */
        ActionLicenseTextSeparator,
        /** Length of one license line. */
        ActionLicenseLengthLine,
        /** Public key of the license signature. */
        ActionLicensePublicKey,
        /** Text that the signature is NOT valid. */
        ActionLicenseSignatureIsNotValid,
        /** Text that the signature is valid. */
        ActionLicenseSignatureIsValid,
        /** Text that the installed version is NOT valid. */
        ActionLicenseVersionIsNotValid,
        /** Text that the installed version is valid. */
        ActionLicenseVersionIsValid,

        /** Parameter for copyright used for the help description. */
        HelpCopyright,
        /** Parameter for the description used for the help description. */
        HelpDescription,
        /** Parameter for the length of a description line used for the help description. */
        HelpLengthLine,
        /** Parameter for the length of the parameter line used for the help description. */
        HelpLengthParams,
        /** Parameter for the prefix used for the help description. */
        HelpPrefix,
        /** Parameter for the help usage used for the help description. */
        HelpUsage,

        /** Comment written above ignored business object attributes. */
        ExportBusIgnoredAttrText,
        /** Header used for file exports. */
        ExportFileHeader,
        /** List of admin property names used as information in front of the list of properties. */
        ExportInfoPropsListAdmin,
        /** List of business object property names used as information in front of the list of properties. */
        ExportInfoPropsListBus,
        /** End text for the information properties. */
        ExportInfoPropsTextEnd,
        /** Start text for the information properties. */
        ExportInfoPropsTextStart,

        /** Compiles all updated JPOs. */
        Compile,
        /** Check if an update is required by comparing the defined last modified date against the value of the file date property. */
        UpdateCheckFileDate,

        /** Info text used for the version print out. */
        VersionActionInfoText,

        /** Defines the application name. */
        RegisterApplicationName,
        /** Defines the program name where applications must be registered. */
        RegisterApplicationProg,
        /** Defines the author of MxUpdate. */
        RegisterAuthorName,
        /** Defines the installer of MxUpdate. */
        RegisterInstallerName,
        /** Defines the program where all administration objects must be registered with symbolic names. */
        RegisterSymbolicNames,

        /** Format of the file date used within installation. */
        InstallFileDateFormatJava,

        ////////////////////////////////////////////////////////////////////////

        /**
         * Name of the parameter to define that the &quot;dimension&quot;
         * for attributes from current MX version is supported. The
         * parameter is needed to support the case that an old MX version is
         * used....
         */
        DMAttrSupportsDimension,
        /**
         * Name of the parameter to define that the &quot;multivalue&quot;
         * flag for attributes from current MX version is supported. The
         * parameter is needed to support the case that an old MX version is
         * used....
         */
        DMAttrSupportsFlagMultiValue,
        /**
         * Name of the parameter to define that the &quot;rangevalue&quot;
         * flag for attributes from current MX version is supported. The
         * parameter is needed to support the case that an old MX version is
         * used....
         */
        DMAttrSupportsFlagRangeValue,
        /**
         * Name of the parameter to define that the &quot;resetonclone&quot;
         * flag for attributes from current MX version is supported. The
         * parameter is needed to support the case that an old MX version is
         * used....
         */
        DMAttrSupportsFlagResetOnClone,
        /**
         * Name of the parameter to define that the &quot;resetonrevision&quot;
         * flag for attributes from current MX version is supported. The
         * parameter is needed to support the case that an old MX version is
         * used....
         */
        DMAttrSupportsFlagResetOnRevision,
        /**
         * Name of the parameter to define that the &quot;maxlength&quot;
         * property for string attributes from current MX version is supported.
         * The parameter is needed to support the case that an old MX version
         * is used....
         */
        DMAttrSupportsPropMaxLength,
        /**
         * Name of the parameter to define that owners are allowed for
         * attributes.
         */
        DMAttrSupportsOwner,
        /**
         * Name of the parameter to define that units are allowed to remove.
         */
        DMDimAllowRemoveUnit,
        /**
         * Name of the parameter to define that a change of the default unit is
         * allowed.
         */
        DMDimAllowUpdateDefUnit,
        /**
         * Name of the parameter to define that the multiplier of an unit is
         * allowed to change.
         */
        DMDimAllowUpdateUnitMult,
        /**
         * Name of the parameter to define that the offset of an unit is allowed
         * to change.
         */
        DMDimAllowUpdateUnitOffs,
        /**
         * Name of the parameter to define that the &quot;view&quot;,
         * &quot;edit&quot; and &quot;print&quot; program
         * property for formats from current MX version is supported.
         * The parameter is needed to support the case that a new MX version
         * is used (where the view program is not working anymore).
         */
        DMFormatSupportsPrograms,

        /** List of removed attributes for interfaces to be ignored. */
        DMInterfaceAttrIgnore,
        /** List of removed attributes for interfaces to be removed. */
        DMInterfaceAttrRemove,
        /** List of removed parent interfaces for interfaces to be ignored. */
        DMInterfaceParentIgnore,
        /** List of removed parent interfaces for interfaces to be removed. */
        DMInterfaceParentRemove,

        /** List of removed attributes for path types to be ignored. */
        DMPathTypeAttrIgnore,
        /** List of removed attributes for path types to be removed. */
        DMPathTypeAttrRemove,

        /** Boolean that the access of policies are sorted. */
        DMPolicyAllowExportAccessSorting,
        /** Boolean that policy supports the 'majorrevision' property for policies*/
        DMPolicySupportsMajorMinor,
        /** Boolean that policy states supports the published property. */
        DMPolicyStateSupportsPublished,
        /** Boolean that policy states supports the 'enforce reserve access' flag. */
        DMPolicyStateSupportsEnforceReserveAccess,

        /** List of removed attributes for relationships to be ignored. */
        DMRelationAttrIgnore,
        /** List of removed attributes for relationships to be removed. */
        DMRelationAttrRemove,
        /** Boolean that connections between connections from current MX version are supported. */
        DMRelationSupportRelCons,

        /** Boolean that the access of rules are sorted. */
        DMRuleAllowExportAccessSorting,
        /** Boolean that rules supports the 'enforce reserve access' flag. */
        DMRuleSupportsEnforceReserveAccess,

        /** List of removed attributes for types to be ignored. */
        DMTypeAttrIgnore,
        /** List of removed attributes for types to be removed. */
        DMTypeAttrRemove,

        /** List of MX System Unique Keys which must be ignored (because they can not be handled from MxUpdate). */
        SystemUniqueKeyMXSystemUniqueKeys,

        /** User role supports role type. */
        UserRoleSupportRoleType,
        /**
         * Defines the parameter for the match of persons for which workspace
         * objects are not handled (neither exported nor updated).
         */
        UserIgnoreWSO4Persons,
        /**
         * If the parameter is set the 'wants email' - flag for persons is ignored.
         * This means that the flag is not managed anymore from the MxUpdate Update
         * tool.
         */
        UserPersonIgnoreWantsEmail,
        /**
         * If the parameter is set the 'wants icon mail' - flag for persons
         * matching given string is ignored. This means that the flag is not
         * managed anymore from the MxUpdate Update tool.
         */
        UserPersonIgnoreWantsIconMail,
        /**
         * If the parameter is set, products for persons matching given string are
         * not updated.
         */
        UserPersonIgnoreProducts;
    }

    /**
     * Enumeration of keys to access the cached values.
     */
    public enum CacheKey
    {
        /** List of attribute names which are cached for easy reuse. */
        Attributes,
        /** List of evaluate mx names which are cached for easy reuse. */
        MxNames,
        /** List of program names which are cached for easy reuse. */
        Programs,
        /** Map between the JPO name and the class name used within MX for type definition. */
        TypeDefJPOs;
    }
}
