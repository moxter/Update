/* MenuParser.java */
/* Generated By:JavaCC: Do not edit this line. MenuParser.java */
package org.mxupdate.update.userinterface;

import java.lang.reflect.InvocationTargetException;

import org.mxupdate.update.userinterface.helper.ChildRefList_mxJPO.AbstractRef;
import org.mxupdate.update.userinterface.helper.ChildRefList_mxJPO.CommandRef;
import org.mxupdate.update.userinterface.helper.ChildRefList_mxJPO.MenuRef;
import org.mxupdate.update.util.AbstractParser_mxJPO;
import org.mxupdate.update.util.AbstractParser_mxJPO.ParseException;
import org.mxupdate.update.util.AbstractParser_mxJPO.SimpleCharStream;
import org.mxupdate.update.util.AbstractParser_mxJPO.Token;
import org.mxupdate.update.util.AbstractParser_mxJPO.TokenMgrError;
import org.mxupdate.update.util.AdminPropertyList_mxJPO.AdminProperty;

/**
 * Parses the update format for {@link Menu_mxJPO}.
 */
@SuppressWarnings("unused")
class MenuParser_mxJPO
    extends AbstractParser_mxJPO implements MenuParserConstants_mxJPO {

/**************************************************************************** */

/**
 * Parses one complete menu definition.
 *
 * @param _menu     target menu to update with parsed values
 */
  final public void parse(Menu_mxJPO _menu) throws ParseException, SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {Token tmp;
    AdminProperty property;
    AbstractRef ref;
    int refIdx = 0;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case SYMBOLICNAME:
      case DESCRIPTION:
      case HIDDEN_TRUE:
      case HIDDEN_FALSE:
      case TREEMENU_TRUE:
      case TREEMENU_FALSE:
      case ALT:
      case HREF:
      case LABEL:
      case COMMAND:
      case MENU:
      case SETTING:
      case PROPERTY:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case SYMBOLICNAME:{
        jj_consume_token(SYMBOLICNAME);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.appendValue(_menu, "symbolicNames", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.appendValue(_menu, "symbolicNames", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[1] = jj_gen;
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
this.setValue(_menu, "description", this.getString(tmp.image));
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
this.setValue(_menu, "description", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case HIDDEN_TRUE:{
        jj_consume_token(HIDDEN_TRUE);
this.setValue(_menu, "hidden", true);
        break;
        }
      case HIDDEN_FALSE:{
        jj_consume_token(HIDDEN_FALSE);
this.setValue(_menu, "hidden", false);
        break;
        }
      case TREEMENU_TRUE:{
        jj_consume_token(TREEMENU_TRUE);
this.setValue(_menu, "treeMenu", true);
        break;
        }
      case TREEMENU_FALSE:{
        jj_consume_token(TREEMENU_FALSE);
this.setValue(_menu, "treeMenu", false);
        break;
        }
      case ALT:{
        jj_consume_token(ALT);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(_menu, "alt", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(_menu, "alt", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case HREF:{
        jj_consume_token(HREF);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(_menu, "href", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(_menu, "href", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case LABEL:{
        jj_consume_token(LABEL);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(_menu, "label", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(_menu, "label", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case SETTING:{
        jj_consume_token(SETTING);
property = new AdminProperty();this.appendValue(this.getValue(_menu, "properties"), "propertiesStack", property);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SETTING_STRING:{
          tmp = jj_consume_token(SETTING_STRING);
this.setValue(property, "name", "%" + this.getString(tmp.image));
          break;
          }
        case SETTING_SINGLE:{
          tmp = jj_consume_token(SETTING_SINGLE);
this.setValue(property, "name", "%" + this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
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
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case COMMAND:{
        jj_consume_token(COMMAND);
ref = new CommandRef();this.setValue(ref, "column", refIdx++);this.appendValue(this.getValue(_menu, "children"), "childrenStack", ref);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(ref, "name", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(ref, "name", this.getString(tmp.image));
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case MENU:{
        jj_consume_token(MENU);
ref = new MenuRef();this.setValue(ref, "column", refIdx++);this.appendValue(this.getValue(_menu, "children"), "childrenStack", ref);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(ref, "name", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(ref, "name", this.getString(tmp.image));
          break;
          }
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case PROPERTY:{
        jj_consume_token(PROPERTY);
property = new AdminProperty();this.appendValue(this.getValue(_menu, "properties"), "propertiesStack", property);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(property, "name", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(property, "name", this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        label_2:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case PROPERTYTO:
          case PROPERTYVAL:{
            ;
            break;
            }
          default:
            jj_la1[11] = jj_gen;
            break label_2;
          }
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case PROPERTYVAL:{
            jj_consume_token(PROPERTYVAL);
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
              jj_la1[12] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
            break;
            }
          case PROPERTYTO:{
            jj_consume_token(PROPERTYTO);
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case ADMINTYPE_STRING:{
              tmp = jj_consume_token(ADMINTYPE_STRING);
this.setValue(property, "refAdminType", this.getString(tmp.image));
              break;
              }
            case ADMINTYPE_SINGLE:{
              tmp = jj_consume_token(ADMINTYPE_SINGLE);
this.setValue(property, "refAdminType", this.getSingle(tmp.image));
              break;
              }
            default:
              jj_la1[13] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case STRING:{
              tmp = jj_consume_token(STRING);
this.setValue(property, "refAdminName", this.getString(tmp.image));
              break;
              }
            case SINGLE:{
              tmp = jj_consume_token(SINGLE);
this.setValue(property, "refAdminName", this.getSingle(tmp.image));
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

  /** Generated Token Manager. */
  public MenuParserTokenManager_mxJPO token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[17];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x90ffe0,0x30000,0xc0000,0x30000,0x30000,0x30000,0x600000,0x30000,0x30000,0x30000,0x30000,0x3000000,0x30000,0xc000000,0x30000,0x3000000,0x90ffe0,};
   }

  /** Constructor with InputStream. */
  public MenuParser_mxJPO(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MenuParser_mxJPO(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MenuParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MenuParser_mxJPO(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MenuParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
   } else {
      jj_input_stream.ReInit(stream, 1, 1);
   }
   if (token_source == null) {
      token_source = new MenuParserTokenManager_mxJPO(jj_input_stream);
   }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MenuParser_mxJPO(MenuParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MenuParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 17; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
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
