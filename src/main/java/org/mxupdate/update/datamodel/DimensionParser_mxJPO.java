/* DimensionParser.java */
/* Generated By:JavaCC: Do not edit this line. DimensionParser.java */
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

package org.mxupdate.update.datamodel;

import java.lang.reflect.InvocationTargetException;
import java.io.StringReader;
import java.util.Collection;
import java.util.Set;

import org.mxupdate.update.datamodel.Dimension_mxJPO;
import org.mxupdate.update.datamodel.Dimension_mxJPO.Unit;
import org.mxupdate.update.util.AbstractParser_mxJPO;
import org.mxupdate.update.util.AbstractParser_mxJPO.SimpleCharStream;
import org.mxupdate.update.util.AbstractParser_mxJPO.Token;
import org.mxupdate.update.util.AbstractParser_mxJPO.TokenMgrError;
import org.mxupdate.update.util.AdminPropertyList_mxJPO.AdminProperty;
import org.mxupdate.update.util.ParameterCache_mxJPO;

/**
 * Parses the update format for {@link DimensionCI_mxJPO}.
 */
@SuppressWarnings("unused")
class DimensionParser_mxJPO
    extends AbstractParser_mxJPO implements DimensionParserConstants_mxJPO {

/**************************************************************************** */

/**
 * Parses one complete dimension definition.
 *
 * @param _dimension    target dimension to update with parsed values
 */
  final public void parse(final Dimension_mxJPO _dimension) throws ParseException, SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {String tmpStr;
    Token tmp;
    Set<String> set;
    AdminProperty property;
    Unit unit;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case UUID:
      case SYMBOLICNAME:
      case DESCRIPTION:
      case HIDDEN_TRUE:
      case HIDDEN_TRUE_VIA_VALUE:
      case HIDDEN_TRUE_VIA_VALUE_APOSTROPHE:
      case HIDDEN_FALSE:
      case HIDDEN_FALSE_VIA_VALUE:
      case HIDDEN_FALSE_VIA_VALUE_APOSTROPHE:
      case UNIT:
      case PROPERTY:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case UUID:{
        jj_consume_token(UUID);
property = new AdminProperty();
                                                                                 this.appendValue(this.getValue(_dimension, "properties"), "propertiesStack", property);
                                                                                 this.setValue(property, "name",  "UUID");
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(property, "value", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(property, "value", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case SYMBOLICNAME:{
        jj_consume_token(SYMBOLICNAME);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.appendValue(_dimension, "symbolicNames", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.appendValue(_dimension, "symbolicNames", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case DESCRIPTION:{
        jj_consume_token(DESCRIPTION);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case MULTILINESTRING:{
          tmp = jj_consume_token(MULTILINESTRING);
this.setValue(_dimension, "description", this.getString(tmp.image));
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
this.setValue(_dimension, "description", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case HIDDEN_TRUE:
      case HIDDEN_TRUE_VIA_VALUE:
      case HIDDEN_TRUE_VIA_VALUE_APOSTROPHE:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case HIDDEN_TRUE:{
          jj_consume_token(HIDDEN_TRUE);
          break;
          }
        case HIDDEN_TRUE_VIA_VALUE:{
          jj_consume_token(HIDDEN_TRUE_VIA_VALUE);
          break;
          }
        case HIDDEN_TRUE_VIA_VALUE_APOSTROPHE:{
          jj_consume_token(HIDDEN_TRUE_VIA_VALUE_APOSTROPHE);
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
this.setValue(_dimension, "hidden", true);
        break;
        }
      case HIDDEN_FALSE:
      case HIDDEN_FALSE_VIA_VALUE:
      case HIDDEN_FALSE_VIA_VALUE_APOSTROPHE:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case HIDDEN_FALSE:{
          jj_consume_token(HIDDEN_FALSE);
          break;
          }
        case HIDDEN_FALSE_VIA_VALUE:{
          jj_consume_token(HIDDEN_FALSE_VIA_VALUE);
          break;
          }
        case HIDDEN_FALSE_VIA_VALUE_APOSTROPHE:{
          jj_consume_token(HIDDEN_FALSE_VIA_VALUE_APOSTROPHE);
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
this.setValue(_dimension, "hidden", false);
        break;
        }
      case UNIT:{
        jj_consume_token(UNIT);
unit = new Unit();
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case UNITNAME_STRING:{
          tmp = jj_consume_token(UNITNAME_STRING);
this.setValue(unit, "name", this.getString(tmp.image));
          break;
          }
        case UNITNAME_SINGLE:{
          tmp = jj_consume_token(UNITNAME_SINGLE);
this.setValue(unit, "name", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(UNITDEF_START);
        label_2:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case UNITDEF_DEFAULT_TRUE:
          case UNITDEF_DEFAULT_TRUE_VIA_VALUE:
          case UNITDEF_DEFAULT_TRUE_VIA_VALUE_APOSTROPHE:
          case UNITDEF_DEFAULT_FALSE:
          case UNITDEF_DEFAULT_FALSE_VIA_VALUE:
          case UNITDEF_DEFAULT_FALSE_VIA_VALUE_APOSTROPHE:
          case UNITDEF_DESCRIPTION:
          case UNITDEF_LABEL:
          case UNITDEF_MULTIPLIER:
          case UNITDEF_OFFSET:
          case UNITDEF_SETTING:
          case UNITDEF_PROPERTY:
          case UNITDEF_SYSTEM:{
            ;
            break;
            }
          default:
            jj_la1[7] = jj_gen;
            break label_2;
          }
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case UNITDEF_DEFAULT_TRUE:
          case UNITDEF_DEFAULT_TRUE_VIA_VALUE:
          case UNITDEF_DEFAULT_TRUE_VIA_VALUE_APOSTROPHE:{
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case UNITDEF_DEFAULT_TRUE:{
              jj_consume_token(UNITDEF_DEFAULT_TRUE);
              break;
              }
            case UNITDEF_DEFAULT_TRUE_VIA_VALUE:{
              jj_consume_token(UNITDEF_DEFAULT_TRUE_VIA_VALUE);
              break;
              }
            case UNITDEF_DEFAULT_TRUE_VIA_VALUE_APOSTROPHE:{
              jj_consume_token(UNITDEF_DEFAULT_TRUE_VIA_VALUE_APOSTROPHE);
              break;
              }
            default:
              jj_la1[8] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
this.setValue(unit, "defaultUnit", true);
            break;
            }
          case UNITDEF_DEFAULT_FALSE:
          case UNITDEF_DEFAULT_FALSE_VIA_VALUE:
          case UNITDEF_DEFAULT_FALSE_VIA_VALUE_APOSTROPHE:{
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case UNITDEF_DEFAULT_FALSE:{
              jj_consume_token(UNITDEF_DEFAULT_FALSE);
              break;
              }
            case UNITDEF_DEFAULT_FALSE_VIA_VALUE:{
              jj_consume_token(UNITDEF_DEFAULT_FALSE_VIA_VALUE);
              break;
              }
            case UNITDEF_DEFAULT_FALSE_VIA_VALUE_APOSTROPHE:{
              jj_consume_token(UNITDEF_DEFAULT_FALSE_VIA_VALUE_APOSTROPHE);
              break;
              }
            default:
              jj_la1[9] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
this.setValue(unit, "defaultUnit", false);
            break;
            }
          case UNITDEF_DESCRIPTION:{
            jj_consume_token(UNITDEF_DESCRIPTION);
            tmpStr = uvString();
this.setValue(unit, "description", tmpStr);
            break;
            }
          case UNITDEF_LABEL:{
            jj_consume_token(UNITDEF_LABEL);
            tmpStr = uvString();
this.setValue(unit, "label", tmpStr);
            break;
            }
          case UNITDEF_MULTIPLIER:{
            jj_consume_token(UNITDEF_MULTIPLIER);
            tmp = jj_consume_token(UNITDEF_DOUBLE_DOUBLE);
this.setValue(unit, "multiplier", Double.parseDouble(tmp.image));
            break;
            }
          case UNITDEF_OFFSET:{
            jj_consume_token(UNITDEF_OFFSET);
            tmp = jj_consume_token(UNITDEF_DOUBLE_DOUBLE);
this.setValue(unit, "offset", Double.parseDouble(tmp.image));
            break;
            }
          case UNITDEF_SETTING:{
            unitSetting(unit);
            break;
            }
          case UNITDEF_PROPERTY:{
            unitProperty(unit);
            break;
            }
          case UNITDEF_SYSTEM:{
            unitSystem(unit);
            break;
            }
          default:
            jj_la1[10] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        jj_consume_token(UNITDEF_END);
this.appendValue(_dimension, "units", unit);
        break;
        }
      case PROPERTY:{
        jj_consume_token(PROPERTY);
property = new AdminProperty();this.appendValue(_dimension, "properties", "propertiesStack", property);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PROPERTY_STRING_STRING:{
          tmp = jj_consume_token(PROPERTY_STRING_STRING);
this.setValue(property, "name", this.getString(tmp.image));
          break;
          }
        case PROPERTY_STRING_SINGLE:{
          tmp = jj_consume_token(PROPERTY_STRING_SINGLE);
this.setValue(property, "name", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case PROPERTYVAL:
          case PROPERTYTO:{
            ;
            break;
            }
          default:
            jj_la1[12] = jj_gen;
            break label_3;
          }
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case PROPERTYTO:{
            jj_consume_token(PROPERTYTO);
            tmp = jj_consume_token(PROPERTYTOTYPE);
this.setValue(property, "refAdminType", this.getSingle(tmp.image));
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case PROPERTY_STRING_STRING:{
              tmp = jj_consume_token(PROPERTY_STRING_STRING);
this.setValue(property, "refAdminName", this.getString(tmp.image));
              break;
              }
            case PROPERTY_STRING_SINGLE:{
              tmp = jj_consume_token(PROPERTY_STRING_SINGLE);
this.setValue(property, "refAdminName", this.getSingle(tmp.image));
              break;
              }
            default:
              jj_la1[13] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
            break;
            }
          case PROPERTYVAL:{
            jj_consume_token(PROPERTYVAL);
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case PROPERTY_STRING_STRING:{
              tmp = jj_consume_token(PROPERTY_STRING_STRING);
this.setValue(property, "value", this.getString(tmp.image));
              break;
              }
            case PROPERTY_STRING_SINGLE:{
              tmp = jj_consume_token(PROPERTY_STRING_SINGLE);
this.setValue(property, "value", this.getSingle(tmp.image));
              break;
              }
            default:
              jj_la1[14] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
            break;
            }
          default:
            jj_la1[15] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        break;
        }
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

/**
 * Parses one setting for a unit definition. The setting is stored on the
 * dimension as property where the name of the property is the key of the
 * setting with % as prefix.
 *
 * @param _unit     unit instance for which the setting must be parsed
 */
  final public void unitSetting(final Unit _unit) throws ParseException {Token tmp;
    final String key, value;
    jj_consume_token(UNITDEF_SETTING);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case UNITDEF_STRINGSTRING_STRING:{
      tmp = jj_consume_token(UNITDEF_STRINGSTRING_STRING);
key = this.getString(tmp.image);
      break;
      }
    case UNITDEF_STRINGSTRING_SINGLE:{
      tmp = jj_consume_token(UNITDEF_STRINGSTRING_SINGLE);
key = this.getSingle(tmp.image);
      break;
      }
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    value = uvString();
final AdminProperty prop = new AdminProperty();
        this.setValue(prop, "name", "%" + key);
        this.setValue(prop, "value", value);
        this.appendValue(_unit, "properties", "propertiesStack", prop);
  }

/**
 * Parses one property for a unit definition.
 *
 * @param _unit     unit instance for which the property must be parsed
 */
  final public void unitProperty(final Unit _unit) throws ParseException {Token tmp;
    String name = null;
    String value = null;
    String toType = null;
    String toName = null;
    jj_consume_token(UNITDEF_PROPERTY);
    name = uvString();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case UNITDEF_PROPERTYVAL:
      case UNITDEF_PROPERTYTO:{
        ;
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case UNITDEF_PROPERTYVAL:{
        jj_consume_token(UNITDEF_PROPERTYVAL);
        value = uvString();
        break;
        }
      case UNITDEF_PROPERTYTO:{
        jj_consume_token(UNITDEF_PROPERTYTO);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case UNITDEF_STRINGSTRING_STRING:{
          tmp = jj_consume_token(UNITDEF_STRINGSTRING_STRING);
toType = this.getString(tmp.image);
          break;
          }
        case UNITDEF_STRINGSTRING_SINGLE:{
          tmp = jj_consume_token(UNITDEF_STRINGSTRING_SINGLE);
toType = this.getSingle(tmp.image);
          break;
          }
        default:
          jj_la1[19] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        toName = uvString();
        break;
        }
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
final AdminProperty prop = new AdminProperty();
        this.setValue(prop, "name", name);
        this.setValue(prop, "value", value);
        this.setValue(prop, "refAdminType", toType);
        this.setValue(prop, "refAdminName", toName);
        this.appendValue(_unit, "properties", "propertiesStack", prop);
  }

/**
 * Parses the system information for a unit definition. The system information
 * is stored as property where the referenced admin type is set to unit and the
 * referenced admin name is the system unit.
 *
 * @param _unit     unit instance for which the system must be parsed
 */
  final public void unitSystem(final Unit _unit) throws ParseException {Token tmp;
    String name;
    String unit;
    jj_consume_token(UNITDEF_SYSTEM);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case UNITDEF_SYSTEMNAME_STRING:{
      tmp = jj_consume_token(UNITDEF_SYSTEMNAME_STRING);
name = this.getString(tmp.image);
      break;
      }
    case UNITDEF_SYSTEMNAME_SINGLE:{
      tmp = jj_consume_token(UNITDEF_SYSTEMNAME_SINGLE);
name = this.getSingle(tmp.image);
      break;
      }
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(UNITDEF_SYSTEMDEF_TO);
    jj_consume_token(UNITDEF_SYSTEMDEF_UNIT);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case UNITDEF_SYSTEMUNIT_STRING:{
      tmp = jj_consume_token(UNITDEF_SYSTEMUNIT_STRING);
unit = this.getString(tmp.image);
      break;
      }
    case UNITDEF_SYSTEMUNIT_SINGLE:{
      tmp = jj_consume_token(UNITDEF_SYSTEMUNIT_SINGLE);
unit = this.getSingle(tmp.image);
      break;
      }
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
final AdminProperty prop = new AdminProperty();
        this.setValue(prop, "name", name);
        this.setValue(prop, "refAdminType", "unit");
        this.setValue(prop, "refAdminName", unit);
        this.appendValue(_unit, "properties", "propertiesStack", prop);
  }

/**
 * Evaluates a simple string.
 *
 * @return evaluated simple string
 */
  final public String uvString() throws ParseException {Token tmp;
    String ret;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case UNITDEF_STRING_STRING:{
      tmp = jj_consume_token(UNITDEF_STRING_STRING);
ret = this.getString(tmp.image);
      break;
      }
    case UNITDEF_STRING_SINGLE:{
      tmp = jj_consume_token(UNITDEF_STRING_SINGLE);
ret = this.getSingle(tmp.image);
      break;
      }
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return ret;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public DimensionParserTokenManager_mxJPO token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[24];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x43fe0,0xc000,0xc000,0x30000,0x700,0x3800,0x180000,0xff800000,0x3800000,0x1c000000,0xff800000,0x0,0x0,0x0,0x0,0x0,0x43fe0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x20000,0x0,0x0,0x0,0x0,0x0,0x0,0x27,0x0,0x0,0x27,0xc00000,0xc0000,0xc00000,0xc00000,0xc0000,0x20000,0x300,0x18,0x300,0x18,0x1800,0x18000,0xc0,};
   }

  /** Constructor with InputStream. */
  public DimensionParser_mxJPO(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public DimensionParser_mxJPO(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new DimensionParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public DimensionParser_mxJPO(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new DimensionParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
   } else {
      jj_input_stream.ReInit(stream, 1, 1);
   }
   if (token_source == null) {
      token_source = new DimensionParserTokenManager_mxJPO(jj_input_stream);
   }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public DimensionParser_mxJPO(DimensionParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(DimensionParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[56];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 24; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 56; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
