package com.atslangplugin.psi.impl

import com.atslangplugin.ATSFileTypeDynamic
import com.atslangplugin.ATSLanguage
import com.atslangplugin.psi.ATSDynamicFile
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class ATSDynamicFileImpl(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ATSLanguage), ATSDynamicFile {
    override fun getFileType(): FileType = ATSFileTypeDynamic
}
