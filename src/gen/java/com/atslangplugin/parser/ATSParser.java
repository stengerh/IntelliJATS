// This is a generated file. Not intended for manual editing.
package com.atslangplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.atslangplugin.psi.ATSTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ATSParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == KEY) {
      result_ = KEY(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return ATSFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // KEY*
  static boolean ATSFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ATSFile")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!KEY(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ATSFile", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // NONE |
  // AT |
  // BACKSLASH |
  // BANG |
  // BQUOTE |
  // COLON |
  // COLONLT |
  // DOLLAR |
  // DOT |
  // DOTDOT |
  // DOTDOTDOT |
  // DOTINT |
  // EQ |
  // EQGT |
  // EQLT |
  // EQLTGT |
  // EQSLASHEQGT |
  // EQGTGT |
  // EQSLASHEQGTGT |
  // HASH |
  // LT |
  // GT |
  // GTLT |
  // DOTLT |
  // GTDOT |
  // DOTLTGTDOT |
  // MINUSGT |
  // MINUSLT |
  // MINUSLTGT |
  // TILDE |
  // ABSTYPE |
  // AND |
  // AS |
  // ASSUME |
  // BEGIN |
  // CASE |
  // CLASSDEC |
  // DATASORT |
  // DATATYPE |
  // DO |
  // DYNLOAD |
  // ELSE |
  // END |
  // EXCEPTION |
  // EXTERN |
  // EXTYPE |
  // EXTVAR |
  // FIX |
  // FIXITY |
  // FORSTAR |
  // FUN |
  // IF |
  // IMPLEMENT |
  // IMPORT |
  // IN |
  // LAM |
  // LET |
  // LOCAL |
  // MACDEF |
  // NONFIX |
  // OVERLOAD |
  // OF |
  // OP |
  // REC |
  // REFAT |
  // REQUIRE |
  // SCASE |
  // SIF |
  // SORTDEF |
  // STACST |
  // STADEF |
  // STALOAD |
  // STATIC |
  // SYMELIM |
  // SYMINTR |
  // THEN |
  // TKINDEF |
  // TRY |
  // TYPE |
  // TYPEDEF |
  // VAL |
  // VAR |
  // WHEN |
  // WHERE |
  // WHILE |
  // WHILESTAR |
  // WITH |
  // WITHTYPE |
  // ADDRAT |
  // FOLDAT |
  // FREEAT |
  // VIEWAT |
  // DLRARRPSZ |
  // DLRDELAY |
  // DLREFFMASK |
  // DLREFFMASK_ARG |
  // DLREXTERN |
  // DLREXTKIND |
  // DLREXTYPE |
  // DLREXTYPE_STRUCT |
  // DLREXTVAL |
  // DLREXTFCALL |
  // DLREXTMCALL |
  // DLRBREAK |
  // DLRCONTINUE |
  // DLRRAISE |
  // DLRLST |
  // DLRREC |
  // DLRTUP |
  // DLRMYFILENAME |
  // DLRMYLOCATION |
  // DLRMYFUNCTION |
  // DLRSHOWTYPE |
  // DLRVCOPYENV |
  // SRPASSERT |
  // SRPDEFINE |
  // SRPELIF |
  // SRPELIFDEF |
  // SRPELIFNDEF |
  // SRPELSE |
  // SRPENDIF |
  // SRPERROR |
  // SRPIF |
  // SRPIFDEF |
  // SRPIFNDEF |
  // SRPINCLUDE |
  // SRPPRINT |
  // SRPTHEN |
  // SRPUNDEF |
  // INT |
  // CHAR |
  // FLOAT |
  // CDATA |
  // STRING |
  // COMMA |
  // SEMICOLON |
  // LPAREN |
  // RPAREN |
  // LBRACKET |
  // RBRACKET |
  // LBRACE |
  // RBRACE |
  // ATLPAREN |
  // QUOTELPAREN |
  // ATLBRACKET |
  // QUOTELBRACKET |
  // HASHLBRACKETOLON |
  // ATLBRACE |
  // QUOTELBRACE |
  // BQUOTELPAREN |
  // COMMALPAREN |
  // PERCENTLPAREN |
  // EXTCODE |
  // COMMENT_LINE |
  // COMMENT_BLOCK |
  // COMMENT_REST |
  // PERCENT |
  // QMARK |
  // EOF
  public static boolean KEY(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEY")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, KEY, "<key>");
    result_ = consumeToken(builder_, NONE);
    if (!result_) result_ = consumeToken(builder_, AT);
    if (!result_) result_ = consumeToken(builder_, BACKSLASH);
    if (!result_) result_ = consumeToken(builder_, BANG);
    if (!result_) result_ = consumeToken(builder_, BQUOTE);
    if (!result_) result_ = consumeToken(builder_, COLON);
    if (!result_) result_ = consumeToken(builder_, COLONLT);
    if (!result_) result_ = consumeToken(builder_, DOLLAR);
    if (!result_) result_ = consumeToken(builder_, DOT);
    if (!result_) result_ = consumeToken(builder_, DOTDOT);
    if (!result_) result_ = consumeToken(builder_, DOTDOTDOT);
    if (!result_) result_ = consumeToken(builder_, DOTINT);
    if (!result_) result_ = consumeToken(builder_, EQ);
    if (!result_) result_ = consumeToken(builder_, EQGT);
    if (!result_) result_ = consumeToken(builder_, EQLT);
    if (!result_) result_ = consumeToken(builder_, EQLTGT);
    if (!result_) result_ = consumeToken(builder_, EQSLASHEQGT);
    if (!result_) result_ = consumeToken(builder_, EQGTGT);
    if (!result_) result_ = consumeToken(builder_, EQSLASHEQGTGT);
    if (!result_) result_ = consumeToken(builder_, HASH);
    if (!result_) result_ = consumeToken(builder_, LT);
    if (!result_) result_ = consumeToken(builder_, GT);
    if (!result_) result_ = consumeToken(builder_, GTLT);
    if (!result_) result_ = consumeToken(builder_, DOTLT);
    if (!result_) result_ = consumeToken(builder_, GTDOT);
    if (!result_) result_ = consumeToken(builder_, DOTLTGTDOT);
    if (!result_) result_ = consumeToken(builder_, MINUSGT);
    if (!result_) result_ = consumeToken(builder_, MINUSLT);
    if (!result_) result_ = consumeToken(builder_, MINUSLTGT);
    if (!result_) result_ = consumeToken(builder_, TILDE);
    if (!result_) result_ = consumeToken(builder_, ABSTYPE);
    if (!result_) result_ = consumeToken(builder_, AND);
    if (!result_) result_ = consumeToken(builder_, AS);
    if (!result_) result_ = consumeToken(builder_, ASSUME);
    if (!result_) result_ = consumeToken(builder_, BEGIN);
    if (!result_) result_ = consumeToken(builder_, CASE);
    if (!result_) result_ = consumeToken(builder_, CLASSDEC);
    if (!result_) result_ = consumeToken(builder_, DATASORT);
    if (!result_) result_ = consumeToken(builder_, DATATYPE);
    if (!result_) result_ = consumeToken(builder_, DO);
    if (!result_) result_ = consumeToken(builder_, DYNLOAD);
    if (!result_) result_ = consumeToken(builder_, ELSE);
    if (!result_) result_ = consumeToken(builder_, END);
    if (!result_) result_ = consumeToken(builder_, EXCEPTION);
    if (!result_) result_ = consumeToken(builder_, EXTERN);
    if (!result_) result_ = consumeToken(builder_, EXTYPE);
    if (!result_) result_ = consumeToken(builder_, EXTVAR);
    if (!result_) result_ = consumeToken(builder_, FIX);
    if (!result_) result_ = consumeToken(builder_, FIXITY);
    if (!result_) result_ = consumeToken(builder_, FORSTAR);
    if (!result_) result_ = consumeToken(builder_, FUN);
    if (!result_) result_ = consumeToken(builder_, IF);
    if (!result_) result_ = consumeToken(builder_, IMPLEMENT);
    if (!result_) result_ = consumeToken(builder_, IMPORT);
    if (!result_) result_ = consumeToken(builder_, IN);
    if (!result_) result_ = consumeToken(builder_, LAM);
    if (!result_) result_ = consumeToken(builder_, LET);
    if (!result_) result_ = consumeToken(builder_, LOCAL);
    if (!result_) result_ = consumeToken(builder_, MACDEF);
    if (!result_) result_ = consumeToken(builder_, NONFIX);
    if (!result_) result_ = consumeToken(builder_, OVERLOAD);
    if (!result_) result_ = consumeToken(builder_, OF);
    if (!result_) result_ = consumeToken(builder_, OP);
    if (!result_) result_ = consumeToken(builder_, REC);
    if (!result_) result_ = consumeToken(builder_, REFAT);
    if (!result_) result_ = consumeToken(builder_, REQUIRE);
    if (!result_) result_ = consumeToken(builder_, SCASE);
    if (!result_) result_ = consumeToken(builder_, SIF);
    if (!result_) result_ = consumeToken(builder_, SORTDEF);
    if (!result_) result_ = consumeToken(builder_, STACST);
    if (!result_) result_ = consumeToken(builder_, STADEF);
    if (!result_) result_ = consumeToken(builder_, STALOAD);
    if (!result_) result_ = consumeToken(builder_, STATIC);
    if (!result_) result_ = consumeToken(builder_, SYMELIM);
    if (!result_) result_ = consumeToken(builder_, SYMINTR);
    if (!result_) result_ = consumeToken(builder_, THEN);
    if (!result_) result_ = consumeToken(builder_, TKINDEF);
    if (!result_) result_ = consumeToken(builder_, TRY);
    if (!result_) result_ = consumeToken(builder_, TYPE);
    if (!result_) result_ = consumeToken(builder_, TYPEDEF);
    if (!result_) result_ = consumeToken(builder_, VAL);
    if (!result_) result_ = consumeToken(builder_, VAR);
    if (!result_) result_ = consumeToken(builder_, WHEN);
    if (!result_) result_ = consumeToken(builder_, WHERE);
    if (!result_) result_ = consumeToken(builder_, WHILE);
    if (!result_) result_ = consumeToken(builder_, WHILESTAR);
    if (!result_) result_ = consumeToken(builder_, WITH);
    if (!result_) result_ = consumeToken(builder_, WITHTYPE);
    if (!result_) result_ = consumeToken(builder_, ADDRAT);
    if (!result_) result_ = consumeToken(builder_, FOLDAT);
    if (!result_) result_ = consumeToken(builder_, FREEAT);
    if (!result_) result_ = consumeToken(builder_, VIEWAT);
    if (!result_) result_ = consumeToken(builder_, DLRARRPSZ);
    if (!result_) result_ = consumeToken(builder_, DLRDELAY);
    if (!result_) result_ = consumeToken(builder_, DLREFFMASK);
    if (!result_) result_ = consumeToken(builder_, DLREFFMASK_ARG);
    if (!result_) result_ = consumeToken(builder_, DLREXTERN);
    if (!result_) result_ = consumeToken(builder_, DLREXTKIND);
    if (!result_) result_ = consumeToken(builder_, DLREXTYPE);
    if (!result_) result_ = consumeToken(builder_, DLREXTYPE_STRUCT);
    if (!result_) result_ = consumeToken(builder_, DLREXTVAL);
    if (!result_) result_ = consumeToken(builder_, DLREXTFCALL);
    if (!result_) result_ = consumeToken(builder_, DLREXTMCALL);
    if (!result_) result_ = consumeToken(builder_, DLRBREAK);
    if (!result_) result_ = consumeToken(builder_, DLRCONTINUE);
    if (!result_) result_ = consumeToken(builder_, DLRRAISE);
    if (!result_) result_ = consumeToken(builder_, DLRLST);
    if (!result_) result_ = consumeToken(builder_, DLRREC);
    if (!result_) result_ = consumeToken(builder_, DLRTUP);
    if (!result_) result_ = consumeToken(builder_, DLRMYFILENAME);
    if (!result_) result_ = consumeToken(builder_, DLRMYLOCATION);
    if (!result_) result_ = consumeToken(builder_, DLRMYFUNCTION);
    if (!result_) result_ = consumeToken(builder_, DLRSHOWTYPE);
    if (!result_) result_ = consumeToken(builder_, DLRVCOPYENV);
    if (!result_) result_ = consumeToken(builder_, SRPASSERT);
    if (!result_) result_ = consumeToken(builder_, SRPDEFINE);
    if (!result_) result_ = consumeToken(builder_, SRPELIF);
    if (!result_) result_ = consumeToken(builder_, SRPELIFDEF);
    if (!result_) result_ = consumeToken(builder_, SRPELIFNDEF);
    if (!result_) result_ = consumeToken(builder_, SRPELSE);
    if (!result_) result_ = consumeToken(builder_, SRPENDIF);
    if (!result_) result_ = consumeToken(builder_, SRPERROR);
    if (!result_) result_ = consumeToken(builder_, SRPIF);
    if (!result_) result_ = consumeToken(builder_, SRPIFDEF);
    if (!result_) result_ = consumeToken(builder_, SRPIFNDEF);
    if (!result_) result_ = consumeToken(builder_, SRPINCLUDE);
    if (!result_) result_ = consumeToken(builder_, SRPPRINT);
    if (!result_) result_ = consumeToken(builder_, SRPTHEN);
    if (!result_) result_ = consumeToken(builder_, SRPUNDEF);
    if (!result_) result_ = consumeToken(builder_, INT);
    if (!result_) result_ = consumeToken(builder_, CHAR);
    if (!result_) result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = consumeToken(builder_, CDATA);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, COMMA);
    if (!result_) result_ = consumeToken(builder_, SEMICOLON);
    if (!result_) result_ = consumeToken(builder_, LPAREN);
    if (!result_) result_ = consumeToken(builder_, RPAREN);
    if (!result_) result_ = consumeToken(builder_, LBRACKET);
    if (!result_) result_ = consumeToken(builder_, RBRACKET);
    if (!result_) result_ = consumeToken(builder_, LBRACE);
    if (!result_) result_ = consumeToken(builder_, RBRACE);
    if (!result_) result_ = consumeToken(builder_, ATLPAREN);
    if (!result_) result_ = consumeToken(builder_, QUOTELPAREN);
    if (!result_) result_ = consumeToken(builder_, ATLBRACKET);
    if (!result_) result_ = consumeToken(builder_, QUOTELBRACKET);
    if (!result_) result_ = consumeToken(builder_, HASHLBRACKETOLON);
    if (!result_) result_ = consumeToken(builder_, ATLBRACE);
    if (!result_) result_ = consumeToken(builder_, QUOTELBRACE);
    if (!result_) result_ = consumeToken(builder_, BQUOTELPAREN);
    if (!result_) result_ = consumeToken(builder_, COMMALPAREN);
    if (!result_) result_ = consumeToken(builder_, PERCENTLPAREN);
    if (!result_) result_ = consumeToken(builder_, EXTCODE);
    if (!result_) result_ = consumeToken(builder_, COMMENT_LINE);
    if (!result_) result_ = consumeToken(builder_, COMMENT_BLOCK);
    if (!result_) result_ = consumeToken(builder_, COMMENT_REST);
    if (!result_) result_ = consumeToken(builder_, PERCENT);
    if (!result_) result_ = consumeToken(builder_, QMARK);
    if (!result_) result_ = consumeToken(builder_, EOF);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

}
