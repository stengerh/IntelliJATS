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
//    return exec.toString()
        val errors = errorBuff.toString() // (java.nio.charset.Charset.defaultCharset())
        println("done: " + errors)
        return errors
//        try {
//
////            val errorBuff = StringWriter()
//
//
////            val cl = CommandLine.parse(this)
//
//
////            infos = StringWriter()
////            errors = StringWriter()
////            val pb = ProcessBuilder(command)
////            if (directory != null)
////                pb.directory(directory)
////            val process = pb.start()
////            val seInfo = StreamBoozer(process.getInputStream(), PrintWriter(infos, true))
////            val seError = StreamBoozer(process.getErrorStream(), PrintWriter(errors, true))
////            seInfo.start()
////            seError.start()
////            status = process.waitFor()
////            seInfo.join()
////            seError.join()
//
//
//
//            val proc = ProcessBuilder(*parts.toTypedArray())
//                    .directory(workingDir)
////                    .redirectOutput(ProcessBuilder.Redirect.INHERIT) //good for debug ut slows things down //TODO: set to whatever does logging?
//                    .redirectOutput(ProcessBuilder.Redirect.PIPE)
//                    .redirectError(ProcessBuilder.Redirect.PIPE)
//                    .start()
////            return proc.inputStream.bufferedReader().readText()
//
//            val errors = proc.getErrorStream().bufferedReader().readText()
//            println("done: "+errors)
//            return errors
//        } catch(e: IOException) {
//            println(e.message)
//            //TODO: weak, should phone home an error
//            e.printStackTrace()
//            return null
//        }
    }
}