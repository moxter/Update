/* ProgramParser.java */
/* Generated By:JavaCC: Do not edit this line. ProgramParser.java */
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

package org.mxupdate.update.program;

import java.lang.reflect.InvocationTargetException;

import org.mxupdate.update.program.ProgramCI_mxJPO.Execute;
import org.mxupdate.update.program.ProgramCI_mxJPO.Kind;
import org.mxupdate.update.util.AbstractParser_mxJPO;
import org.mxupdate.update.util.AbstractParser_mxJPO.ParseException;
import org.mxupdate.update.util.AbstractParser_mxJPO.SimpleCharStream;
import org.mxupdate.update.util.AbstractParser_mxJPO.Token;
import org.mxupdate.update.util.AbstractParser_mxJPO.TokenMgrError;
import org.mxupdate.update.util.AdminPropertyList_mxJPO.AdminProperty;

/**
 * Parses the update format for {@link ProgramCI_mxJPO}.
 */
@SuppressWarnings("unused")
class ProgramParser_mxJPO
    extends AbstractParser_mxJPO implements ProgramParserConstants_mxJPO {

/**************************************************************************** */

/**
 * Parses one complete page definition.
 *
 * @param _page     target page to update with parsed values
 */
  final public void parse(final ProgramCI_mxJPO _prog) throws ParseException, SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {Token tmp;
    AdminProperty property;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case KIND:
      case SYMBOLICNAME:
      case DESCRIPTION:
      case HIDDEN_TRUE:
      case HIDDEN_FALSE:
      case NEEDSBUSINESSOBJECT_TRUE:
      case NEEDSBUSINESSOBJECT_FALSE:
      case DOWNLOADABLE_TRUE:
      case DOWNLOADABLE_FALSE:
      case PIPE_TRUE:
      case PIPE_FALSE:
      case POOLED_TRUE:
      case POOLED_FALSE:
      case RULE:
      case EXECUTE:
      case CODE:
      case FILE:
      case PROPERTY:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case KIND:{
        jj_consume_token(KIND);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case EKL:{
          jj_consume_token(EKL);
this.setValue(_prog, "kind",                       Kind.EKL);
          break;
          }
        case EXTERNAL:{
          jj_consume_token(EXTERNAL);
this.setValue(_prog, "kind",                       Kind.EXTERNAL);
          break;
          }
        case MQL:{
          jj_consume_token(MQL);
this.setValue(_prog, "kind",                       Kind.MQL);
          break;
          }
        case JAVA:{
          jj_consume_token(JAVA);
this.setValue(_prog, "kind",                       Kind.JAVA);
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
this.appendValue(_prog, "symbolicNames",           this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.appendValue(_prog, "symbolicNames",           this.getSingle(tmp.image));
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
this.setValue(_prog, "description",                this.getString(tmp.image));
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
this.setValue(_prog, "description",                this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case HIDDEN_TRUE:{
        jj_consume_token(HIDDEN_TRUE);
this.setValue(_prog, "hidden",                     true);
        break;
        }
      case HIDDEN_FALSE:{
        jj_consume_token(HIDDEN_FALSE);
this.setValue(_prog, "hidden",                     false);
        break;
        }
      case NEEDSBUSINESSOBJECT_TRUE:{
        jj_consume_token(NEEDSBUSINESSOBJECT_TRUE);
this.setValue(_prog, "needsBusinessObjectContext", true);
        break;
        }
      case NEEDSBUSINESSOBJECT_FALSE:{
        jj_consume_token(NEEDSBUSINESSOBJECT_FALSE);
this.setValue(_prog, "needsBusinessObjectContext", false);
        break;
        }
      case DOWNLOADABLE_TRUE:{
        jj_consume_token(DOWNLOADABLE_TRUE);
this.setValue(_prog, "downloadable",               true);
        break;
        }
      case DOWNLOADABLE_FALSE:{
        jj_consume_token(DOWNLOADABLE_FALSE);
this.setValue(_prog, "downloadable",               false);
        break;
        }
      case PIPE_TRUE:{
        jj_consume_token(PIPE_TRUE);
this.setValue(_prog, "pipe",                       true);
        break;
        }
      case PIPE_FALSE:{
        jj_consume_token(PIPE_FALSE);
this.setValue(_prog, "pipe",                       false);
        break;
        }
      case POOLED_TRUE:{
        jj_consume_token(POOLED_TRUE);
this.setValue(_prog, "pooled",                     true);
        break;
        }
      case POOLED_FALSE:{
        jj_consume_token(POOLED_FALSE);
this.setValue(_prog, "pooled",                     false);
        break;
        }
      case RULE:{
        jj_consume_token(RULE);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(_prog, "rule",                       this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(_prog, "rule",                       this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case EXECUTE:{
        jj_consume_token(EXECUTE);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IMMEDIATE:{
          jj_consume_token(IMMEDIATE);
this.setValue(_prog, "execute",                    Execute.IMMEDIATE);
          break;
          }
        case DEFERRED:{
          jj_consume_token(DEFERRED);
this.setValue(_prog, "execute",                    Execute.DEFERRED);
          break;
          }
        case USER:{
          jj_consume_token(USER);
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case STRING:{
            tmp = jj_consume_token(STRING);
this.setValue(_prog, "user",                       this.getString(tmp.image));
            break;
            }
          case SINGLE:{
            tmp = jj_consume_token(SINGLE);
this.setValue(_prog, "user",                       this.getSingle(tmp.image));
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
        break;
        }
      case CODE:{
        jj_consume_token(CODE);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case MULTILINESTRING:{
          tmp = jj_consume_token(MULTILINESTRING);
this.setValue(_prog, "code",                       this.getCode(tmp.image));
          break;
          }
        case MULTILINESINGLE:{
          tmp = jj_consume_token(MULTILINESINGLE);
this.setValue(_prog, "code",                       this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case FILE:{
        jj_consume_token(FILE);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case STRING:{
          tmp = jj_consume_token(STRING);
this.setValue(_prog, "file",                       this.getString(tmp.image));
          break;
          }
        case SINGLE:{
          tmp = jj_consume_token(SINGLE);
this.setValue(_prog, "file",                       this.getSingle(tmp.image));
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case PROPERTY:{
        jj_consume_token(PROPERTY);
property = new AdminProperty();this.appendValue(_prog, "properties", "propertiesStack", property);
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
          jj_la1[9] = jj_gen;
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
            jj_la1[10] = jj_gen;
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
              jj_la1[11] = jj_gen;
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
              jj_la1[12] = jj_gen;
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
              jj_la1[13] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
            break;
            }
          default:
            jj_la1[14] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        break;
        }
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  /** Generated Token Manager. */
  public ProgramParserTokenManager_mxJPO token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[16];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x18fffc20,0x3c0,0x60000000,0x80000000,0x60000000,0x60000000,0x7000000,0x80000000,0x60000000,0x60000000,0x0,0x60000000,0x0,0x60000000,0x0,0x18fffc20,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x2,0x0,0x0,0x1,0x0,0x0,0x0,0x1,0x0,0x0,0xc,0x0,0x30,0x0,0xc,0x2,};
   }

  /** Constructor with InputStream. */
  public ProgramParser_mxJPO(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ProgramParser_mxJPO(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ProgramParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ProgramParser_mxJPO(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ProgramParserTokenManager_mxJPO(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
   } else {
      jj_input_stream.ReInit(stream, 1, 1);
   }
   if (token_source == null) {
      token_source = new ProgramParserTokenManager_mxJPO(jj_input_stream);
   }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ProgramParser_mxJPO(ProgramParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ProgramParserTokenManager_mxJPO tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[38];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 16; i++) {
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
    for (int i = 0; i < 38; i++) {
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
