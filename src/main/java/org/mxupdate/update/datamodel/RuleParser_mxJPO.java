/* RuleParser.java */
/* Generated By:JavaCC: Do not edit this line. RuleParser.java */
package org.mxupdate.update.datamodel;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.mxupdate.update.datamodel.helper.AccessList_mxJPO;
import org.mxupdate.update.datamodel.helper.AccessList_mxJPO.Access;
import org.mxupdate.update.util.AbstractParser_mxJPO;
import org.mxupdate.update.util.AbstractParser_mxJPO.ParseException;
import org.mxupdate.update.util.AbstractParser_mxJPO.SimpleCharStream;
import org.mxupdate.update.util.AbstractParser_mxJPO.Token;
import org.mxupdate.update.util.AbstractParser_mxJPO.TokenMgrError;
import org.mxupdate.update.util.AdminPropertyList_mxJPO.AdminProperty;

/**
 * Parses the update format for {@link Rule_mxJPO}.
 */
@SuppressWarnings("unused")
class RuleParser_mxJPO
    extends AbstractParser_mxJPO implements RuleParserConstants_mxJPO {

/**************************************************************************** */

/**
 * Parses one complete rule definition.
 *
 * @param _rule   target rule to update with parsed values
 */
  final public void parse(final Rule_mxJPO _rule) throws ParseException, SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {Token tmp;
    AdminProperty property;
    Access access = new Access();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case SYMBOLICNAME:
      case DESCRIPTION:
      case HIDDEN_TRUE:
      case HIDDEN_FALSE:
      case ENFORCERESERVEACCESS_TRUE:
      case ENFORCERESERVEACCESS_FALSE:
      case REVOKE:
      case LOGIN:
      case OWNER:
      case PUBLIC:
      case USER:
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
this.appendValue(_rule, "symbolicNames",       this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.appendValue(_rule, "symbolicNames",       this.getSingle(tmp.image));
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
this.setValue(_rule, "description",            this.getString(tmp.image));
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
this.setValue(_rule, "description",            this.getSingle(tmp.image));
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
this.setValue(_rule, "hidden",                 true);
        break;
        }
      case HIDDEN_FALSE:{
        jj_consume_token(HIDDEN_FALSE);
this.setValue(_rule, "hidden",                 false);
        break;
        }
      case ENFORCERESERVEACCESS_TRUE:{
        jj_consume_token(ENFORCERESERVEACCESS_TRUE);
this.setValue(_rule, "enforcereserveaccess",   true);
        break;
        }
      case ENFORCERESERVEACCESS_FALSE:{
        jj_consume_token(ENFORCERESERVEACCESS_FALSE);
this.setValue(_rule, "enforcereserveaccess",   false);
        break;
        }
      case REVOKE:
      case LOGIN:
      case OWNER:
      case PUBLIC:
      case USER:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case REVOKE:{
          jj_consume_token(REVOKE);
this.setValue(access, "revoke",                true);
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          ;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case LOGIN:{
          jj_consume_token(LOGIN);
this.setValue(access, "login",                 true);
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          ;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case OWNER:{
          jj_consume_token(OWNER);
this.setValue(access, "kind",                  "owner");
          break;
          }
        case PUBLIC:{
          jj_consume_token(PUBLIC);
this.setValue(access, "kind",                  "public");
          break;
          }
        case USER:{
          jj_consume_token(USER);
this.setValue(access, "kind",                  "user");
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case ACCESS_STRING:{
            tmp = jj_consume_token(ACCESS_STRING);
this.setValue(access, "userRef",               this.getString(tmp.image));
            break;
            }
          case ACCESS_SINGLE_STRING:{
            tmp = jj_consume_token(ACCESS_SINGLE_STRING);
this.setValue(access, "userRef",               this.getSingle(tmp.image));
            break;
            }
          default:
            jj_la1[5] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        stateAccessDef(access);
this.appendValue(_rule, "accessList",          "accessList", access);/*reset*/access = new Access();
        break;
        }
      case PROPERTY:{
        jj_consume_token(PROPERTY);
property = new AdminProperty();this.appendValue(_rule, "properties", "propertiesStack", property);
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
          jj_la1[7] = jj_gen;
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
            jj_la1[8] = jj_gen;
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
              jj_la1[9] = jj_gen;
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
              jj_la1[10] = jj_gen;
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
              jj_la1[11] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
            break;
            }
          default:
            jj_la1[12] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void stateAccessDef(final Access _access) throws ParseException {Token tmp;
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case KEY:
      case ACCESS:
      case FILTER:
      case LOCALFILTER:
      case ORGANIZATION_ANY:
      case ORGANIZATION_SINGLE:
      case ORGANIZATION_ANCESTOR:
      case ORGANIZATION_DESCENDANT:
      case ORGANIZATION_RELATED:
      case PROJECT_ANY:
      case PROJECT_SINGLE:
      case PROJECT_ANCESTOR:
      case PROJECT_DESCENDANT:
      case PROJECT_RELATED:
      case OWNER_ANY:
      case OWNER_CONTEXT:
      case RESERVE_ANY:
      case RESERVE_CONTEXT:
      case RESERVE_NO:
      case RESERVE_INCLUSIVE:
      case MATURITY_ANY:
      case MATURITY_NO:
      case MATURITY_PUBLIC:
      case MATURITY_PROTECTED:
      case MATURITY_PRIVATE:
      case MATURITY_NOTPRIVATE:
      case MATURITY_PPP:
      case CATEGORY_ANY:
      case CATEGORY_OEM:
      case CATEGORY_GOLDPARTNER:
      case CATEGORY_PARTNER:
      case CATEGORY_SUPPLIER:
      case CATEGORY_CUSTOMER:
      case CATEGORY_CONTRACTOR:{
        ;
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case KEY:{
        jj_consume_token(KEY);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case ACCESS_STRING:{
          tmp = jj_consume_token(ACCESS_STRING);
this.setValue(_access, "key",              this.getString(tmp.image));
          break;
          }
        case ACCESS_SINGLE_STRING:{
          tmp = jj_consume_token(ACCESS_SINGLE_STRING);
this.setValue(_access, "key",              this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[15] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case FILTER:{
        jj_consume_token(FILTER);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case MULTILINESTRING:{
          tmp = jj_consume_token(MULTILINESTRING);
this.setValue(_access, "filter",           this.getString(tmp.image));
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
this.setValue(_access, "filter",           this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[16] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case LOCALFILTER:{
        jj_consume_token(LOCALFILTER);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case MULTILINESTRING:{
          tmp = jj_consume_token(MULTILINESTRING);
this.setValue(_access, "localfilter",      this.getString(tmp.image));
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
this.setValue(_access, "localfilter",      this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[17] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case ACCESS:{
        tmp = jj_consume_token(ACCESS);
this.appendValues(_access, "access",       Arrays.asList(
                                                                                                                    tmp.image.replaceFirst("^\\{", "").replaceFirst("\\}$", "")  // remove {}
                                                                                                                             .replaceAll("(\t)|(\n)", " ")                       // replace tabs, new lines
                                                                                                                             .replaceAll("( )+", " ")                            // multiple spaces => one space
                                                                                                                             .trim()                                             // remove trailing spaces
                                                                                                                             .split(" ")));
        break;
        }
      case ORGANIZATION_ANY:{
        jj_consume_token(ORGANIZATION_ANY);
this.setValue(_access, "organization",     "any");
        break;
        }
      case ORGANIZATION_SINGLE:{
        jj_consume_token(ORGANIZATION_SINGLE);
this.setValue(_access, "organization",     "single");
        break;
        }
      case ORGANIZATION_ANCESTOR:{
        jj_consume_token(ORGANIZATION_ANCESTOR);
this.setValue(_access, "organization",     "ancestor");
        break;
        }
      case ORGANIZATION_DESCENDANT:{
        jj_consume_token(ORGANIZATION_DESCENDANT);
this.setValue(_access, "organization",     "descendant");
        break;
        }
      case ORGANIZATION_RELATED:{
        jj_consume_token(ORGANIZATION_RELATED);
this.setValue(_access, "organization",     "related");
        break;
        }
      case PROJECT_ANY:{
        jj_consume_token(PROJECT_ANY);
this.setValue(_access, "project",          "any");
        break;
        }
      case PROJECT_SINGLE:{
        jj_consume_token(PROJECT_SINGLE);
this.setValue(_access, "project",          "single");
        break;
        }
      case PROJECT_ANCESTOR:{
        jj_consume_token(PROJECT_ANCESTOR);
this.setValue(_access, "project",          "ancestor");
        break;
        }
      case PROJECT_DESCENDANT:{
        jj_consume_token(PROJECT_DESCENDANT);
this.setValue(_access, "project",          "descendant");
        break;
        }
      case PROJECT_RELATED:{
        jj_consume_token(PROJECT_RELATED);
this.setValue(_access, "project",          "related");
        break;
        }
      case OWNER_ANY:{
        jj_consume_token(OWNER_ANY);
this.setValue(_access, "owner",            "any");
        break;
        }
      case OWNER_CONTEXT:{
        jj_consume_token(OWNER_CONTEXT);
this.setValue(_access, "owner",            "context");
        break;
        }
      case RESERVE_ANY:{
        jj_consume_token(RESERVE_ANY);
this.setValue(_access, "reserve",          "any");
        break;
        }
      case RESERVE_CONTEXT:{
        jj_consume_token(RESERVE_CONTEXT);
this.setValue(_access, "reserve",          "context");
        break;
        }
      case RESERVE_NO:{
        jj_consume_token(RESERVE_NO);
this.setValue(_access, "reserve",          "no");
        break;
        }
      case RESERVE_INCLUSIVE:{
        jj_consume_token(RESERVE_INCLUSIVE);
this.setValue(_access, "reserve",          "inclusive");
        break;
        }
      case MATURITY_ANY:{
        jj_consume_token(MATURITY_ANY);
this.setValue(_access, "maturity",         "any");
        break;
        }
      case MATURITY_NO:{
        jj_consume_token(MATURITY_NO);
this.setValue(_access, "maturity",         "no");
        break;
        }
      case MATURITY_PUBLIC:{
        jj_consume_token(MATURITY_PUBLIC);
this.setValue(_access, "maturity",         "public");
        break;
        }
      case MATURITY_PROTECTED:{
        jj_consume_token(MATURITY_PROTECTED);
this.setValue(_access, "maturity",         "protected");
        break;
        }
      case MATURITY_PRIVATE:{
        jj_consume_token(MATURITY_PRIVATE);
this.setValue(_access, "maturity",         "private");
        break;
        }
      case MATURITY_NOTPRIVATE:{
        jj_consume_token(MATURITY_NOTPRIVATE);
this.setValue(_access, "maturity",         "notprivate");
        break;
        }
      case MATURITY_PPP:{
        jj_consume_token(MATURITY_PPP);
this.setValue(_access, "maturity",         "ppp");
        break;
        }
      case CATEGORY_ANY:{
        jj_consume_token(CATEGORY_ANY);
this.setValue(_access, "category",         "any");
        break;
        }
      case CATEGORY_OEM:{
        jj_consume_token(CATEGORY_OEM);
this.setValue(_access, "category",         "oem");
        break;
        }
      case CATEGORY_GOLDPARTNER:{
        jj_consume_token(CATEGORY_GOLDPARTNER);
this.setValue(_access, "category",         "goldpartner");
        break;
        }
      case CATEGORY_PARTNER:{
        jj_consume_token(CATEGORY_PARTNER);
this.setValue(_access, "category",         "partner");
        break;
        }
      case CATEGORY_SUPPLIER:{
        jj_consume_token(CATEGORY_SUPPLIER);
this.setValue(_access, "category",         "supplier");
        break;
        }
      case CATEGORY_CUSTOMER:{
        jj_consume_token(CATEGORY_CUSTOMER);
this.setValue(_access, "category",         "customer");
        break;
        }
      case CATEGORY_CONTRACTOR:{
        jj_consume_token(CATEGORY_CONTRACTOR);
this.setValue(_access, "category",         "contractor");
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  /** Generated Token Manager. */
  public RuleParserTokenManager_mxJPO token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[19];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xf87e0,0x1800,0x6000,0x8000,0x10000,0xc00000,0xe0000,0x1800,0x0,0x1800,0x0,0x1800,0x0,0xf87e0,0xff300000,0xc00000,0x6000,0x6000,0xff300000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x6000000,0x0,0x18000000,0x0,0x6000000,0x1000000,0xffffff,0x0,0x0,0x0,0xffffff,};
   }

  /** Constructor with InputStream. */
  public RuleParser_mxJPO(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public RuleParser_mxJPO(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new RuleParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public RuleParser_mxJPO(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new RuleParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
   } else {
      jj_input_stream.ReInit(stream, 1, 1);
   }
   if (token_source == null) {
      token_source = new RuleParserTokenManager_mxJPO(jj_input_stream);
   }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public RuleParser_mxJPO(RuleParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(RuleParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[61];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 19; i++) {
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
    for (int i = 0; i < 61; i++) {
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
