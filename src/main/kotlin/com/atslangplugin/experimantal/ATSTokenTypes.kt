
//TODO: seems to corespond to datatype token_node in pats_lexing.sats,
// a more stable solution might be to generate this from the ATS compiler source,
// in theory the lexer could be implemented that way
// now that abstract datatypes are finally a thing in Java land

//TODO: these Int's are likely infinite precision,

//TODO: handle the "bad char"

// TODO: transpose the comments into "javadoc" style comments

package com.atslangplugin.experimantal

import com.atslangplugin.ATSLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

//TODO: object

//from pats_basics.sats
sealed class Fxtykind {
    class FXK_infix() : Fxtykind()
    class FXK_infixl() : Fxtykind()
    class FXK_infixr() : Fxtykind()
    class FXK_prefix() : Fxtykind()
    class FXK_postfix() : Fxtykind()
}

sealed class Caskind {
    /** case */
    class CK_case() : Caskind()

    /** case+ */
    class CK_case_pos : Caskind()

    /** case- */
    class CK_case_neg : Caskind()
}

sealed class Funkind {
    //TODO: javadoc
// nonrec fun
    class FK_fn() : Funkind()

    // tailrec fun
    class FK_fnx() : Funkind()

    // recursive fun
    class FK_fun() : Funkind()

    // nonrec proof fun
    class FK_prfn() : Funkind()

    // recursive proof fun
    class FK_prfun() : Funkind()

    // proof axiom
    class FK_praxi() : Funkind()

    // casting fun
    class FK_castfn() : Funkind()
}


//TODO: rename to be consistent with sata
sealed class ATSTokenType(@NonNls debugName: String) : IElementType(debugName, ATSLanguage) {
    //TODO: needed?
    override fun toString(): String {
        return "ATSTokenType." + super.toString()
    }

    /**	// dummy	*/
    class T_NONE() : ATSTokenType("T_NONE")

    /**	// @	*/
    class T_AT() : ATSTokenType("T_AT")

    /**	// |	*/
    class T_BAR() : ATSTokenType("T_BAR")

    /**	// !	*/
    class T_BANG() : ATSTokenType("T_BANG")

    /**	// `	*/
    class T_BQUOTE() : ATSTokenType("T_BQUOTE")

    /**	// \	*/
    class T_BACKSLASH() : ATSTokenType("T_BACKSLASH")

    /**	// :	*/
    class T_COLON() : ATSTokenType("T_COLON")

    /**	// :<	*/
    class T_COLONLT() : ATSTokenType("T_COLONLT")

    /**	// $	*/
    class T_DOLLAR() : ATSTokenType("T_DOLLAR")

    /**	// .	*/
    class T_DOT() : ATSTokenType("T_DOT")

    /**	// ..	*/
    class T_DOTDOT() : ATSTokenType("T_DOTDOT")

    /**	// ...	*/
    class T_DOTDOTDOT() : ATSTokenType("T_DOTDOTDOT")

    /**	.[0-9]+	*/
    class T_DOTINT(val i: Int) : ATSTokenType("T_DOTINT")

    /**	// =	*/
    class T_EQ() : ATSTokenType("T_EQ")

    /**	// =>	*/
    class T_EQGT() : ATSTokenType("T_EQGT")

    /**	// =<	*/
    class T_EQLT() : ATSTokenType("T_EQLT")

    /**	// =<>	*/
    class T_EQLTGT() : ATSTokenType("T_EQLTGT")

    /**	// =/=>	*/
    class T_EQSLASHEQGT() : ATSTokenType("T_EQSLASHEQGT")

    /**	// =>>	*/
    class T_EQGTGT() : ATSTokenType("T_EQGTGT")

    /**	// =/=>>	*/
    class T_EQSLASHEQGTGT() : ATSTokenType("T_EQSLASHEQGTGT")

    /**	// #	*/
    class T_HASH() : ATSTokenType("T_HASH")

    /**	// < // for opening a tmparg	*/
    class T_LT() : ATSTokenType("T_LT")

    /**	// > // for closing a tmparg	*/
    class T_GT() : ATSTokenType("T_GT")

    /**	// <>	*/
    class T_GTLT() : ATSTokenType("T_GTLT")

    /**	// .< // opening termetric	*/
    class T_DOTLT() : ATSTokenType("T_DOTLT")

    /**	// >. // closing termetric	*/
    class T_GTDOT() : ATSTokenType("T_GTDOT")

    /**	// .<>. // for empty termetric	*/
    class T_DOTLTGTDOT() : ATSTokenType("T_DOTLTGTDOT")

    /**	// ->	*/
    class T_MINUSGT() : ATSTokenType("T_MINUSGT")

    /**	// -<	*/
    class T_MINUSLT() : ATSTokenType("T_MINUSLT")

    /**	// -<>	*/
    class T_MINUSLTGT() : ATSTokenType("T_MINUSLTGT")

    /**	// ~ // often for 'not', 'free', etc.	*/
    class T_TILDE() : ATSTokenType("T_TILDE")

// HX: for absprop, abstype, abst@ype;
    /**	absview, absvtype, absvt@ype*/
    class T_ABSTYPE(val i: Int) : ATSTokenType("T_ABSTYPE")

    /**	// for implementing abstypes	*/
    class T_ASSUME() : ATSTokenType("T_ASSUME")

    /**	// for re-assuming abstypes	*/
    class T_REASSUME() : ATSTokenType("T_REASSUME")

    /**	// as // for refas-pattern	*/
    class T_AS() : ATSTokenType("T_AS")

    /**	// and	*/
    class T_AND() : ATSTokenType("T_AND")

    /**	// begin // initiating a sequence	*/
    class T_BEGIN() : ATSTokenType("T_BEGIN")

    /**	case, case-, case+, prcase */
    class T_CASE(val caskind: Caskind) : ATSTokenType("T_CASE")

    /**	// classdec	*/
    class T_CLASSDEC() : ATSTokenType("T_CLASSDEC")

    /**	// datasort	*/
    class T_DATASORT() : ATSTokenType("T_DATASORT")

    /**	 datatype, dataprop, dataview, dataviewtype */
    class T_DATATYPE(val i: Int) : ATSTokenType("T_DATATYPE")

    /**	// [do]	*/
    class T_DO() : ATSTokenType("T_DO")

    /**	// [else]	*/
    class T_ELSE() : ATSTokenType("T_ELSE")

    /**	// the [end] keyword	*/
    class T_END() : ATSTokenType("T_END")

    /**	// [exception]	*/
    class T_EXCEPTION() : ATSTokenType("T_EXCEPTION")

    /**	// extern	*/
    class T_EXTERN() : ATSTokenType("T_EXTERN")

    /**	// externally named type	*/
    class T_EXTYPE() : ATSTokenType("T_EXTYPE")

    /**	// externally named variable	*/
    class T_EXTVAR() : ATSTokenType("T_EXTVAR")

    /**	fix and fix@ */
    class T_FIX(val i: Int) : ATSTokenType("T_FIX")

    /**	infix, infixl, infixr, prefix, postfix */
    class T_FIXITY(fxtykind: Fxtykind) : ATSTokenType("T_FIXITY")

    /**	// for	*/
    class T_FOR() : ATSTokenType("T_FOR")

    /**	// for*	*/
    class T_FORSTAR() : ATSTokenType("T_FORSTAR")

    /**	fn, fnx, fun, prfn and prfun */
    class T_FUN(valfunkind: Funkind) : ATSTokenType("T_FUN")

    /**	// (dynamic) if	*/
    class T_IF() : ATSTokenType("T_IF")

    /**	// (dynamic) ifcase	*/
    class T_IFCASE() : ATSTokenType("T_IFCASE")

    /**		*/
    class T_IMPLEMENT(val i: Int) // 0/1/2: implmnt/implement/primplmnt	:ATSTokenType("T_IMPLEMENT")

    /**	// import (for packages)	*/
    class T_IMPORT() : ATSTokenType("T_IMPORT")

    /**	// in	*/
    class T_IN() : ATSTokenType("T_IN")

    /** lam, llam (linear lam) and lam@ (flat lam) */
    class T_LAM(val i: Int) : ATSTokenType("T_LAM")

    /**	// let	*/
    class T_LET() : ATSTokenType("T_LET")

    /**	// local	*/
    class T_LOCAL() : ATSTokenType("T_LOCAL")

    /**	0/1: macdef/macrodef */
    class T_MACDEF(val i: Int) : ATSTokenType("T_MACDEF")

    /**	// nonfix	*/
    class T_NONFIX() : ATSTokenType("T_NONFIX")

    /**	// overload	*/
    class T_OVERLOAD() : ATSTokenType("T_OVERLOAD")

    /**	// of	*/
    class T_OF() : ATSTokenType("T_OF")

    /**	// op // HX: taken from ML	*/
    class T_OP() : ATSTokenType("T_OP")

    /**	// rec	*/
    class T_REC() : ATSTokenType("T_REC")

    /**	// static if	*/
    class T_SIF() : ATSTokenType("T_SIF")

    /**	// static case	*/
    class T_SCASE() : ATSTokenType("T_SCASE")

    /**	// stacst	*/
    class T_STACST() : ATSTokenType("T_STACST")

    /**	// stadef	*/
    class T_STADEF() : ATSTokenType("T_STADEF")

    /**	// static	*/
    class T_STATIC() : ATSTokenType("T_STATIC")

    /**	// sortdef	*/
    class T_SORTDEF() : ATSTokenType("T_SORTDEF")

    /**	// symelim // symbol elimination	*/
    class T_SYMELIM() : ATSTokenType("T_SYMELIM")

    /**	// symintr // symbol introduction	*/
    class T_SYMINTR() : ATSTokenType("T_SYMINTR")

    /**	// the [then] keyword	*/
    class T_THEN() : ATSTokenType("T_THEN")

    /**	// tkindef // for introducting tkinds	*/
    class T_TKINDEF() : ATSTokenType("T_TKINDEF")

    /**	// try	*/
    class T_TRY() : ATSTokenType("T_TRY")

    /**	type, type+, type- */
    class T_TYPE(val i: Int) : ATSTokenType("T_TYPE")

    /**	typedef, propdef, viewdef, viewtypedef */
    class T_TYPEDEF(val i: Int) : ATSTokenType("T_TYPEDEF")

    //TODO: and so on...
//     /**	val, val+, val-, prval */
    //    class T_VAL(valkind) : ATSTokenType("T_VAL")
//
//    //TODO:Mark: why not bool?
//    /**	knd = 0/1: var/prvar*/
//    class T_VAR(val knd: Int) : ATSTokenType("T_VAR")
//
//    /**	// when	*/
//    class T_WHEN() : ATSTokenType("T_WHEN")
//
//    /**	// where	*/
//    class T_WHERE() : ATSTokenType("T_WHERE")
//
//    /**	// while	*/
//    class T_WHILE() : ATSTokenType("T_WHILE")
//
//    /**	// while*	*/
//    class T_WHILESTAR() : ATSTokenType("T_WHILESTAR")
//
//    /**	// with	*/
//    class T_WITH() : ATSTokenType("T_WITH")
//
//    /**		*/
//    class T_WITHTYPE(int) // withtype, withprop, withview, withviewtype	:ATSTokenType("T_WITHTYPE")
//    // end of [T_WITHTYPE] // HX: it is from DML and now rarely used
//
//    /**	// addr@	*/
//    class T_ADDRAT() : ATSTokenType("T_ADDRAT")
//
//    /**	// fold@	*/
//    class T_FOLDAT() : ATSTokenType("T_FOLDAT")
//
//    /**	// free@	*/
//    class T_FREEAT() : ATSTokenType("T_FREEAT")
//
//    /**	// view@	*/
//    class T_VIEWAT() : ATSTokenType("T_VIEWAT")
//

//    /**		*/	class	T_DLRDELAY	(int(*lin*)) // $delay/$ldelay	:ATSTokenType("T_DLRDELAY")
//
//    /**	// $arrpsz/$arrptrsize	*/	class	T_DLRARRPSZ	()	:ATSTokenType("T_DLRARRPSZ")
//
//    /**	// $tyrep(SomeType)	*/	class	T_DLRTYREP	()	:ATSTokenType("T_DLRTYREP")
//    /**	// $d2ctype(foo/foo<...>)	*/	class	T_DLRD2CTYPE	()	:ATSTokenType("T_DLRD2CTYPE")
//
//    /**	// $effmask	*/	class	T_DLREFFMASK	()	:ATSTokenType("T_DLREFFMASK")
//    /**		*/	class	T_DLREFFMASK_ARG	(int) // ntm(0), exn(1), ref(2), wrt(3), all(4)	:ATSTokenType("T_DLREFFMASK_ARG")
//
//    /**	// $extern	*/	class	T_DLREXTERN	()	:ATSTokenType("T_DLREXTERN")
//    /**	// externally named type	*/	class	T_DLREXTYPE	()	:ATSTokenType("T_DLREXTYPE")
//    /**	// $extkind	*/	class	T_DLREXTKIND	()	:ATSTokenType("T_DLREXTKIND")
//    /**	// externally named struct	*/	class	T_DLREXTYPE_STRUCT	()	:ATSTokenType("T_DLREXTYPE_STRUCT")
//
//    /**	// externally named value	*/	class	T_DLREXTVAL	()	:ATSTokenType("T_DLREXTVAL")
//    /**	// externally named fun-call	*/	class	T_DLREXTFCALL	()	:ATSTokenType("T_DLREXTFCALL")
//    /**	// externally named method-call	*/	class	T_DLREXTMCALL	()	:ATSTokenType("T_DLREXTMCALL")
//
//    /**	// $literal	*/	class	T_DLRLITERAL	()	:ATSTokenType("T_DLRLITERAL")
//
//    /**	// $myfilename	*/	class	T_DLRMYFILENAME	()	:ATSTokenType("T_DLRMYFILENAME")
//    /**	// $mylocation	*/	class	T_DLRMYLOCATION	()	:ATSTokenType("T_DLRMYLOCATION")
//    /**	// $myfunction	*/	class	T_DLRMYFUNCTION	()	:ATSTokenType("T_DLRMYFUNCTION")
//
//    /**		*/	class	T_DLRLST	int // $lst and $lst_t and $lst_vt	:ATSTokenType("T_DLRLST")
//    /**		*/	class	T_DLRREC	int // $rec and $rec_t and $rec_vt	:ATSTokenType("T_DLRREC")
//    /**		*/	class	T_DLRTUP	int // $tup and $tup_t and $tup_vt	:ATSTokenType("T_DLRTUP")
//
//    /**	// $break	*/	class	T_DLRBREAK	()	:ATSTokenType("T_DLRBREAK")
//    /**	// $continue	*/	class	T_DLRCONTINUE	()	:ATSTokenType("T_DLRCONTINUE")
//
//    /**	// $raise // raising exceptions	*/	class	T_DLRRAISE	()	:ATSTokenType("T_DLRRAISE")
//
//    /**	// $showtype // for debugging purpose	*/	class	T_DLRSHOWTYPE	()	:ATSTokenType("T_DLRSHOWTYPE")
//
//    /**		*/	class	T_DLRVCOPYENV	(int) // $vcopyenv_v(v)/$vcopyenv_vt(vt)	:ATSTokenType("T_DLRVCOPYENV")
//
//    /**	// $tempenver // for adding environvar	*/	class	T_DLRTEMPENVER	()	:ATSTokenType("T_DLRTEMPENVER")
//
//    /**	// $solver_assert // assert(d2e_prf)	*/	class	T_DLRSOLASSERT	()	:ATSTokenType("T_DLRSOLASSERT")
//    /**	// $solver_verify // verify(s2e_prop)	*/	class	T_DLRSOLVERIFY	()	:ATSTokenType("T_DLRSOLVERIFY")
//
//    /**	// #if	*/	class	T_SRPIF	()	:ATSTokenType("T_SRPIF")
//    /**	// #ifdef	*/	class	T_SRPIFDEF	()	:ATSTokenType("T_SRPIFDEF")
//    /**	// #ifndef	*/	class	T_SRPIFNDEF	()	:ATSTokenType("T_SRPIFNDEF")
//
//    /**	// #then	*/	class	T_SRPTHEN	()	:ATSTokenType("T_SRPTHEN")
//
//    /**	// #elif	*/	class	T_SRPELIF	()	:ATSTokenType("T_SRPELIF")
//    /**	// #elifdef	*/	class	T_SRPELIFDEF	()	:ATSTokenType("T_SRPELIFDEF")
//    /**	// #elifndef	*/	class	T_SRPELIFNDEF	()	:ATSTokenType("T_SRPELIFNDEF")
//    /**	// #else	*/	class	T_SRPELSE	()	:ATSTokenType("T_SRPELSE")
//
//    /**	// #endif	*/	class	T_SRPENDIF	()	:ATSTokenType("T_SRPENDIF")
//
//    /**	// #error	*/	class	T_SRPERROR	()	:ATSTokenType("T_SRPERROR")
//    /**	// #prerr	*/	class	T_SRPPRERR	()	:ATSTokenType("T_SRPPRERR")
//    /**	// #print	*/	class	T_SRPPRINT	()	:ATSTokenType("T_SRPPRINT")
//
//    /**	// #assert	*/	class	T_SRPASSERT	()	:ATSTokenType("T_SRPASSERT")
//
//    /**	// #undef	*/	class	T_SRPUNDEF	()	:ATSTokenType("T_SRPUNDEF")
//    /**	// #define	*/	class	T_SRPDEFINE	()	:ATSTokenType("T_SRPDEFINE")
//
//    /**	// #include	*/	class	T_SRPINCLUDE	()	:ATSTokenType("T_SRPINCLUDE")
//
//    /**	// #staload	*/	class	T_SRPSTALOAD	()	:ATSTokenType("T_SRPSTALOAD")
//    /**	// #dynload	*/	class	T_SRPDYNLOAD	()	:ATSTokenType("T_SRPDYNLOAD")
//
//    /**	// #require	*/	class	T_SRPREQUIRE	()	:ATSTokenType("T_SRPREQUIRE")
//
//    /**	// #pragma	*/	class	T_SRPPRAGMA	()	:ATSTokenType("T_SRPPRAGMA")
//    /**	// #codegen2	*/	class	T_SRPCODEGEN2	()	:ATSTokenType("T_SRPCODEGEN2")
//    /**	// #codegen3	*/	class	T_SRPCODEGEN3	()	:ATSTokenType("T_SRPCODEGEN3")
//
//    /**		*/	class	T_IDENT_alp	string // alnum	:ATSTokenType("T_IDENT_alp")
//    /**		*/	class	T_IDENT_sym	string // symbol	:ATSTokenType("T_IDENT_sym")
//    /**		*/	class	T_IDENT_arr	string // A[...]	:ATSTokenType("T_IDENT_arr")
//    /**		*/	class	T_IDENT_tmp	string // A<...>	:ATSTokenType("T_IDENT_tmp")
//    /**		*/	class	T_IDENT_dlr	string // $alnum	:ATSTokenType("T_IDENT_dlr")
//    /**		*/	class	T_IDENT_srp	string // #alnum	:ATSTokenType("T_IDENT_srp")
//    /**		*/	class	T_IDENT_ext	string // alnum!	:ATSTokenType("T_IDENT_ext")
//
//    /**		*/	class	T_INT	(int(*base*), string(*rep*), uint(*suffix*))	:ATSTokenType("T_INT")
//
//    /**		*/	class	T_CHAR	char (* character *)	:ATSTokenType("T_CHAR")
//
//    /**		*/	class	T_FLOAT	(int(*base*), string(*rep*), uint(*suffix*))	:ATSTokenType("T_FLOAT")
//
//    /**		*/	class	{n:int} T_CDATA	(arrayref(char, n), size_t(n)) // for binaries	:ATSTokenType("{n:int} T_CDATA")
//    /**		*/	class	T_STRING	(string)	:ATSTokenType("T_STRING")
//
//    /**	// ,	*/	class	T_COMMA	()	:ATSTokenType("T_COMMA")
//    /**	// ;	*/	class	T_SEMICOLON	()	:ATSTokenType("T_SEMICOLON")
//
//    /**	// (	*/	class	T_LPAREN	()	:ATSTokenType("T_LPAREN")
//    /**	// )	*/	class	T_RPAREN	()	:ATSTokenType("T_RPAREN")
//    /**	// [	*/	class	T_LBRACKET	()	:ATSTokenType("T_LBRACKET")
//    /**	// ]	*/	class	T_RBRACKET	()	:ATSTokenType("T_RBRACKET")
//    /**	// {	*/	class	T_LBRACE	()	:ATSTokenType("T_LBRACE")
//    /**	// }	*/	class	T_RBRACE	()	:ATSTokenType("T_RBRACE")
//
//    /**		*/	class	T_ATLPAREN	()  // @(	:ATSTokenType("T_ATLPAREN")
//    /**	// '(	*/	class	T_QUOTELPAREN	()	:ATSTokenType("T_QUOTELPAREN")
//    /**	// @[	*/	class	T_ATLBRACKET	()	:ATSTokenType("T_ATLBRACKET")
//    /**	// '[	*/	class	T_QUOTELBRACKET	()	:ATSTokenType("T_QUOTELBRACKET")
//    /**	// #[	*/	class	T_HASHLBRACKET	()	:ATSTokenType("T_HASHLBRACKET")
//    /**	// @{	*/	class	T_ATLBRACE	()	:ATSTokenType("T_ATLBRACE")
//    /**	// '{	*/	class	T_QUOTELBRACE	()	:ATSTokenType("T_QUOTELBRACE")
//
//    /**	// `( // macro syntax	*/	class	T_BQUOTELPAREN	()	:ATSTokenType("T_BQUOTELPAREN")
//    /**		*/	class	T_COMMALPAREN	()  // ,( // macro syntax	:ATSTokenType("T_COMMALPAREN")
//    /**	// %( // macro syntax	*/	class	T_PERCENTLPAREN	()	:ATSTokenType("T_PERCENTLPAREN")
//
//    /**		*/	class	T_EXTCODE	(int(*kind*), string) // external code	:ATSTokenType("T_EXTCODE")
//
//    /**	// line comment	*/	class	T_COMMENT_line	()	:ATSTokenType("T_COMMENT_line")
//    /**	// block comment	*/	class	T_COMMENT_block	()	:ATSTokenType("T_COMMENT_block")
//    /**	// rest-of-file comment	*/	class	T_COMMENT_rest	()	:ATSTokenType("T_COMMENT_rest")
//
//    /**	// for errors	*/	class	T_ERR	()	:ATSTokenType("T_ERR")
//
//    /**	// end-of-file	*/	class	T_EOF	()	:ATSTokenType("T_EOF")

}


sealed class CreateSubscriptionResult {
    /** asd */
    class Success(val subscription: Int) : CreateSubscriptionResult()

    class Failure(val errors: List<String>) : CreateSubscriptionResult()
}

