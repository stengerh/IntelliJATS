package com.atslangplugin.psi.impl

import com.atslangplugin.ATSFileTypeInclude
import com.atslangplugin.ATSLanguage
import com.atslangplugin.psi.ATSIncludeFile
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class ATSIncludeFileImpl(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ATSLanguage), ATSIncludeFile {
    override fun getFileType(): FileType = ATSFileTypeInclude
}