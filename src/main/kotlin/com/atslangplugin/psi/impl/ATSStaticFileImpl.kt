package com.atslangplugin.psi.impl

import com.atslangplugin.ATSFileTypeStatic
import com.atslangplugin.ATSLanguage
import com.atslangplugin.psi.ATSStaticFile
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class ATSStaticFileImpl(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ATSLanguage), ATSStaticFile {
    override fun getFileType(): FileType = ATSFileTypeStatic
}