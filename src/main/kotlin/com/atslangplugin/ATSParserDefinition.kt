package com.atslangplugin

import com.atslangplugin.parser.ATSParserWrapper
import com.atslangplugin.psi.ATSFile
import com.atslangplugin.psi.ATSTokenTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import java.io.Reader

class ATSParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer {
        return FlexAdapter(ATSLexer(null as Reader?))
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        //TODO
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return ATSParserWrapper()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ATSFile(viewProvider)
    }

    override fun spaceExistanceTypeBetweenTokens(
            Left: ASTNode, Right: ASTNode
    ): ParserDefinition.SpaceRequirements {
        //TODO: this should be a lot more specific
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun createElement(node: ASTNode): PsiElement {
        return ATSTokenTypes.Factory.createElement(node)
    }

    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(
                ATSTokenTypes.COMMENT
        )

        val FILE = IFileElementType(ATSLanguage)
    }
}
