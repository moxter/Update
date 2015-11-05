/* Generated By:JavaCC: Do not edit this line. ProgramParserConstants.java */
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


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
interface ProgramParserConstants_mxJPO {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int PACKAGE = 5;
  /** RegularExpression Id. */
  int KIND = 6;
  /** RegularExpression Id. */
  int EKL = 7;
  /** RegularExpression Id. */
  int EXTERNAL = 8;
  /** RegularExpression Id. */
  int JAVA = 9;
  /** RegularExpression Id. */
  int MQL = 10;
  /** RegularExpression Id. */
  int UUID = 11;
  /** RegularExpression Id. */
  int SYMBOLICNAME = 12;
  /** RegularExpression Id. */
  int DESCRIPTION = 13;
  /** RegularExpression Id. */
  int HIDDEN_TRUE = 14;
  /** RegularExpression Id. */
  int HIDDEN_FALSE = 15;
  /** RegularExpression Id. */
  int NEEDSBUSINESSOBJECT_TRUE = 16;
  /** RegularExpression Id. */
  int NEEDSBUSINESSOBJECT_FALSE = 17;
  /** RegularExpression Id. */
  int DOWNLOADABLE_TRUE = 18;
  /** RegularExpression Id. */
  int DOWNLOADABLE_FALSE = 19;
  /** RegularExpression Id. */
  int PIPE_TRUE = 20;
  /** RegularExpression Id. */
  int PIPE_FALSE = 21;
  /** RegularExpression Id. */
  int POOLED_TRUE = 22;
  /** RegularExpression Id. */
  int POOLED_FALSE = 23;
  /** RegularExpression Id. */
  int RULE = 24;
  /** RegularExpression Id. */
  int EXECUTE = 25;
  /** RegularExpression Id. */
  int IMMEDIATE = 26;
  /** RegularExpression Id. */
  int DEFERRED = 27;
  /** RegularExpression Id. */
  int USER = 28;
  /** RegularExpression Id. */
  int CODE = 29;
  /** RegularExpression Id. */
  int FILE = 30;
  /** RegularExpression Id. */
  int STRING = 31;
  /** RegularExpression Id. */
  int SINGLE = 32;
  /** RegularExpression Id. */
  int MULTILINESTRING = 33;
  /** RegularExpression Id. */
  int MULTILINESINGLE = 34;
  /** RegularExpression Id. */
  int PROPERTY = 35;
  /** RegularExpression Id. */
  int PROPERTYTO = 36;
  /** RegularExpression Id. */
  int PROPERTYVAL = 37;
  /** RegularExpression Id. */
  int ADMINTYPE_STRING = 38;
  /** RegularExpression Id. */
  int ADMINTYPE_SINGLE = 39;

  /** Lexical state. */
  int ADMINREF_EXPECTED = 0;
  /** Lexical state. */
  int MULTILINESTRING_EXPECTED = 1;
  /** Lexical state. */
  int STRING_EXPECTED = 2;
  /** Lexical state. */
  int DEFAULT = 3;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "<token of kind 4>",
    "\"package\"",
    "\"kind\"",
    "\"ekl\"",
    "\"external\"",
    "\"java\"",
    "\"mql\"",
    "\"uuid\"",
    "\"symbolicname\"",
    "\"description\"",
    "\"hidden\"",
    "\"!hidden\"",
    "\"needsbusinessobject\"",
    "\"!needsbusinessobject\"",
    "\"downloadable\"",
    "\"!downloadable\"",
    "\"pipe\"",
    "\"!pipe\"",
    "\"pooled\"",
    "\"!pooled\"",
    "\"rule\"",
    "\"execute\"",
    "\"immediate\"",
    "\"deferred\"",
    "\"user\"",
    "\"code\"",
    "\"file\"",
    "<STRING>",
    "<SINGLE>",
    "<MULTILINESTRING>",
    "<MULTILINESINGLE>",
    "\"property\"",
    "\"to\"",
    "\"value\"",
    "<ADMINTYPE_STRING>",
    "<ADMINTYPE_SINGLE>",
  };

}
