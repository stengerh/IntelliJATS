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

    //TODO: this is super general, people would probly like it if it where refactored into its own project
//TODO: use intelliJ's internal GeneralCommandLine.
    fun String.runCommand(workingDir: File): String? {
        println(this)
        val errorBuff = ByteArrayOutputStream()
        val parts = this.split("\\s".toRegex())
        //TODO: set a configurable timeout
        val exec = ProcessExecutor().
                command(parts).
                directory(workingDir)//.readOutput(false)
                .redirectError(errorBuff).
                execute();
        //TODO: does it block?
        val errors = errorBuff.toString() // (java.nio.charset.Charset.defaultCharset())
        println("done: " + errors)
        return errors

    }
}