/* Generated By:JavaCC: Do not edit this line. RuleDefParserConstants.java */
package org.mxupdate.update.datamodel.rule;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface RuleDefParserConstants_mxJPO {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int DESCRIPTION = 5;
  /** RegularExpression Id. */
  int HIDDEN_TRUE = 6;
  /** RegularExpression Id. */
  int HIDDEN_FALSE = 7;
  /** RegularExpression Id. */
  int PROPERTY = 8;
  /** RegularExpression Id. */
  int PROPERTYTO = 9;
  /** RegularExpression Id. */
  int PROPERTYVAL = 10;
  /** RegularExpression Id. */
  int REVOKE = 11;
  /** RegularExpression Id. */
  int LOGIN = 12;
  /** RegularExpression Id. */
  int OWNER = 13;
  /** RegularExpression Id. */
  int PUBLIC = 14;
  /** RegularExpression Id. */
  int USER = 15;
  /** RegularExpression Id. */
  int KEY = 20;
  /** RegularExpression Id. */
  int ACCESS = 21;
  /** RegularExpression Id. */
  int ACCESS_STRING = 26;
  /** RegularExpression Id. */
  int ACCESS_SINGLE_STRING = 27;
  /** RegularExpression Id. */
  int ACCESS_STRING_APOSTROPHE = 28;
  /** RegularExpression Id. */
  int ACCESS_STRING_CHAR = 29;
  /** RegularExpression Id. */
  int FILTER = 30;
  /** RegularExpression Id. */
  int LOCALFILTER = 31;
  /** RegularExpression Id. */
  int ORGANIZATION_ANY = 32;
  /** RegularExpression Id. */
  int ORGANIZATION_SINGLE = 33;
  /** RegularExpression Id. */
  int ORGANIZATION_ANCESTOR = 34;
  /** RegularExpression Id. */
  int ORGANIZATION_DESCENDANT = 35;
  /** RegularExpression Id. */
  int ORGANIZATION_RELATED = 36;
  /** RegularExpression Id. */
  int PROJECT_ANY = 37;
  /** RegularExpression Id. */
  int PROJECT_SINGLE = 38;
  /** RegularExpression Id. */
  int PROJECT_ANCESTOR = 39;
  /** RegularExpression Id. */
  int PROJECT_DESCENDANT = 40;
  /** RegularExpression Id. */
  int PROJECT_RELATED = 41;
  /** RegularExpression Id. */
  int OWNER_ANY = 42;
  /** RegularExpression Id. */
  int OWNER_CONTEXT = 43;
  /** RegularExpression Id. */
  int RESERVE_ANY = 44;
  /** RegularExpression Id. */
  int RESERVE_CONTEXT = 45;
  /** RegularExpression Id. */
  int RESERVE_NO = 46;
  /** RegularExpression Id. */
  int RESERVE_INCLUSIVE = 47;
  /** RegularExpression Id. */
  int MATURITY_ANY = 48;
  /** RegularExpression Id. */
  int MATURITY_NO = 49;
  /** RegularExpression Id. */
  int MATURITY_PUBLIC = 50;
  /** RegularExpression Id. */
  int MATURITY_PROTECTED = 51;
  /** RegularExpression Id. */
  int MATURITY_PRIVATE = 52;
  /** RegularExpression Id. */
  int MATURITY_NOTPRIVATE = 53;
  /** RegularExpression Id. */
  int MATURITY_PPP = 54;
  /** RegularExpression Id. */
  int CATEGORY_ANY = 55;
  /** RegularExpression Id. */
  int CATEGORY_OEM = 56;
  /** RegularExpression Id. */
  int CATEGORY_GOLDPARTNER = 57;
  /** RegularExpression Id. */
  int CATEGORY_PARTNER = 58;
  /** RegularExpression Id. */
  int CATEGORY_SUPPLIER = 59;
  /** RegularExpression Id. */
  int CATEGORY_CUSTOMER = 60;
  /** RegularExpression Id. */
  int CATEGORY_CONTRACTOR = 61;
  /** RegularExpression Id. */
  int STRING = 66;
  /** RegularExpression Id. */
  int SINGLE = 67;
  /** RegularExpression Id. */
  int APOSTROPHE = 68;
  /** RegularExpression Id. */
  int CHAR = 69;
  /** RegularExpression Id. */
  int ADMINTYPE_STRING = 74;
  /** RegularExpression Id. */
  int ADMINTYPE_SINGLE = 75;
  /** RegularExpression Id. */
  int ADMINTYPE_APOSTROPHE = 76;
  /** RegularExpression Id. */
  int ADMINTYPE_CHAR = 77;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int ACCESS_EXPECTED = 1;
  /** Lexical state. */
  int ACCESS_STRING_EXPECTED = 2;
  /** Lexical state. */
  int STRING_EXPECTED = 3;
  /** Lexical state. */
  int ADMINREF_EXPECTED = 4;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\"",
    "\"description\"",
    "\"hidden\"",
    "\"!hidden\"",
    "\"property\"",
    "\"to\"",
    "\"value\"",
    "\"revoke\"",
    "\"login\"",
    "\"owner\"",
    "\"public\"",
    "\"user\"",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"key\"",
    "<ACCESS>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<ACCESS_STRING>",
    "<ACCESS_SINGLE_STRING>",
    "\"\\\"\"",
    "<ACCESS_STRING_CHAR>",
    "\"filter\"",
    "\"localfilter\"",
    "<ORGANIZATION_ANY>",
    "<ORGANIZATION_SINGLE>",
    "<ORGANIZATION_ANCESTOR>",
    "<ORGANIZATION_DESCENDANT>",
    "<ORGANIZATION_RELATED>",
    "<PROJECT_ANY>",
    "<PROJECT_SINGLE>",
    "<PROJECT_ANCESTOR>",
    "<PROJECT_DESCENDANT>",
    "<PROJECT_RELATED>",
    "<OWNER_ANY>",
    "<OWNER_CONTEXT>",
    "<RESERVE_ANY>",
    "<RESERVE_CONTEXT>",
    "<RESERVE_NO>",
    "<RESERVE_INCLUSIVE>",
    "<MATURITY_ANY>",
    "<MATURITY_NO>",
    "<MATURITY_PUBLIC>",
    "<MATURITY_PROTECTED>",
    "<MATURITY_PRIVATE>",
    "<MATURITY_NOTPRIVATE>",
    "<MATURITY_PPP>",
    "<CATEGORY_ANY>",
    "<CATEGORY_OEM>",
    "<CATEGORY_GOLDPARTNER>",
    "<CATEGORY_PARTNER>",
    "<CATEGORY_SUPPLIER>",
    "<CATEGORY_CUSTOMER>",
    "<CATEGORY_CONTRACTOR>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<STRING>",
    "<SINGLE>",
    "\"\\\"\"",
    "<CHAR>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<ADMINTYPE_STRING>",
    "<ADMINTYPE_SINGLE>",
    "\"\\\"\"",
    "<ADMINTYPE_CHAR>",
  };

}
