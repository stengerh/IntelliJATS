package com.atslangplugin

import com.intellij.openapi.fileTypes.ExtensionFileNameMatcher
import com.intellij.openapi.fileTypes.FileNameMatcher
import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import java.util.*


class ATSFileTypeFactory : FileTypeFactory() {

    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(ATSFileTypeDynamic)
        fileTypeConsumer.consume(ATSFileTypeInclude)
        fileTypeConsumer.consume(ATSFileTypeStatic)
    }
}
