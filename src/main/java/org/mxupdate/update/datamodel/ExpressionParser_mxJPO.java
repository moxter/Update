/* ExpressionParser.java */
/* Generated By:JavaCC: Do not edit this line. ExpressionParser.java */
package org.mxupdate.update.datamodel;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.mxupdate.update.util.AbstractParser_mxJPO;
import org.mxupdate.update.util.AbstractParser_mxJPO.ParseException;
import org.mxupdate.update.util.AbstractParser_mxJPO.SimpleCharStream;
import org.mxupdate.update.util.AbstractParser_mxJPO.Token;
import org.mxupdate.update.util.AbstractParser_mxJPO.TokenMgrError;
import org.mxupdate.update.util.AdminPropertyList_mxJPO.AdminProperty;

/**
 * Parses the update format for {@link Expression_mxJPO}.
 */
@SuppressWarnings("unused")
class ExpressionParser_mxJPO
    extends AbstractParser_mxJPO implements ExpressionParserConstants_mxJPO {

/**************************************************************************** */

/**
 * Parses one complete expression definition.
 *
 * @param _expression   target expression to update with parsed values
 */
  final public void parse(final Expression_mxJPO _expression) throws ParseException, SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {Token tmp;
    String tmpStr;
    AdminProperty property = null;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case SYMBOLICNAME:
      case DESCRIPTION:
      case HIDDEN_TRUE:
      case HIDDEN_FALSE:
      case VALUE:
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
this.appendValue(_expression, "symbolicNames", this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.appendValue(_expression, "symbolicNames", this.getSingle(tmp.image));
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
this.setValue(_expression, "description",      this.getString(tmp.image));property = null;
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
this.setValue(_expression, "description",      this.getSingle(tmp.image));property = null;
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
this.setValue(_expression, "hidden",           true); property = null;
        break;
        }
      case HIDDEN_FALSE:{
        jj_consume_token(HIDDEN_FALSE);
this.setValue(_expression, "hidden",           false);property = null;
        break;
        }
      case VALUE:{
        jj_consume_token(VALUE);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case MULTILINESTRING:{
          tmp = jj_consume_token(MULTILINESTRING);
tmpStr = this.getString(tmp.image);
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
tmpStr = this.getSingle(tmp.image);
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
// hint: token value is used twice
                                                                                // (for property and as expression value)
                                                                                // => staffed via property variable
                                                                                if (property == null)  {
                                                                                    this.setValue(_expression, "value", tmpStr);
                                                                                } else  {
                                                                                    this.setValue(property, "value", tmpStr);
                                                                                    property = null;
                                                                                }
        break;
        }
      case PROPERTY:{
        jj_consume_token(PROPERTY);
property = new AdminProperty();this.appendValue(_expression, "properties", "propertiesStack", property);
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
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
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
            jj_la1[5] = jj_gen;
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
            jj_la1[6] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          ;
        }
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  /** Generated Token Manager. */
  public ExpressionParserTokenManager_mxJPO token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[9];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x43e0,0xc00,0x3000,0x3000,0xc00,0x30000,0xc00,0x8000,0x43e0,};
   }

  /** Constructor with InputStream. */
  public ExpressionParser_mxJPO(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ExpressionParser_mxJPO(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ExpressionParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ExpressionParser_mxJPO(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ExpressionParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
   } else {
      jj_input_stream.ReInit(stream, 1, 1);
   }
   if (token_source == null) {
      token_source = new ExpressionParserTokenManager_mxJPO(jj_input_stream);
   }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ExpressionParser_mxJPO(ExpressionParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ExpressionParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[18];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 9; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 18; i++) {
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
