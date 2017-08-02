package com.atslangplugin.annotators

import com.intellij.psi.PsiDirectory
import org.zeroturnaround.exec.ProcessExecutor
import java.io.ByteArrayOutputStream
import java.io.File


object CompilerHelper {

    //TODO: got to be a better way to get the full path
    fun recursivePath(dir: PsiDirectory?): String {
        return dir?.let { dir ->
            val parent = dir.parentDirectory
            recursivePath(parent) + dir.name + File.separator
        } ?: ""
    }

    //TODO: use intelliJ's internal GeneralCommandLine.
    fun String.runCommand(workingDir: File): String? {
        println(this)
        val errorBuff = ByteArrayOutputStream()
        val parts = this.split("\\s".toRegex())
        //TODO: set a configurable timeout
        val exec = ProcessExecutor().
                command(parts).
                directory(workingDir)
                .redirectError(errorBuff).
                execute();

        return errorBuff.toString()
    }
}