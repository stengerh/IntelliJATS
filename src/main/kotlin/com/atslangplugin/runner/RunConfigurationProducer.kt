package com.atslangplugin.runner

import com.atslangplugin.psi.ATSFile
import com.intellij.execution.Executor
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.execution.configuration.EnvironmentVariablesData
import com.intellij.execution.configurations.*
import com.intellij.execution.process.KillableProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import com.intellij.util.getOrCreate
import com.intellij.util.ui.FormBuilder
import org.jdom.Element
import java.io.File
import javax.swing.JPanel


data class AtsRunConfigurationFactory(val runConfigurationType: RunnerConfigurationType) : ConfigurationFactory(runConfigurationType) {
    override fun createTemplateConfiguration(project: Project) = AtsRunConfiguration(project, this, "name")
    override fun isConfigurationSingletonByDefault() = true
}

class MakefileRunConfigurationEditor() : SettingsEditor<AtsRunConfiguration>() {
//    private val filenameField = TextFieldWithBrowseButton()
//    private val targetCompletionProvider = TextFieldWithAutoCompletion.StringsCompletionProvider(emptyList(), MakefileTargetIcon)
//    private val targetField = TextFieldWithAutoCompletion<String>(project, targetCompletionProvider, true, "")
//    private val environmentVarsComponent = EnvironmentVariablesComponent()

    private val panel: JPanel by lazy {
        FormBuilder.createFormBuilder()
                .panel
    }

//    init {
//        filenameField.addBrowseFolderListener("Makefile", "Makefile path", project, MakefileFileChooserDescriptor())
//        filenameField.textField.document.addDocumentListener(object : DocumentAdapter() {
//            override fun textChanged(event: DocumentEvent) {
//                updateTargetCompletion(filenameField.text)
//            }
//        })
//    }
//
//    fun updateTargetCompletion(filename: String) {
//        val file = LocalFileSystem.getInstance().findFileByPath(filename)
//        if (file != null) {
//            val psiFile = PsiManager.getInstance(project).findFile(file)
//            if (psiFile != null) {
//                targetCompletionProvider.setItems(name.kropp.intellij.makefile.findTargets(psiFile).map { it.name })
//                return
//            }
//        }
//        targetCompletionProvider.setItems(emptyList())
//    }

    override fun createEditor() = panel

    override fun applyEditorTo(configuration: AtsRunConfiguration) {
//        configuration.filename = filenameField.text
//        configuration.target = targetField.text
//        configuration.environmentVariables = environmentVarsComponent.envData
    }

    override fun resetEditorFrom(configuration: AtsRunConfiguration) {
//        filenameField.text = configuration.filename
//        targetField.text = configuration.target
//        environmentVarsComponent.envData = configuration.environmentVariables
//
//        updateTargetCompletion(configuration.filename)
    }
}

//a (for now) dummy class that sets up the runner
class AtsRunConfiguration(project: Project, factory: AtsRunConfigurationFactory, name: String) : LocatableConfigurationBase(project, factory, name) {
    var filename = ""
    //    var target = ""
    var environmentVariables = EnvironmentVariablesData.DEFAULT
//
//    private companion object {
//        const val MAKEFILE = "makefile"
//        const val FILENAME = "filename"
//        const val TARGET = "target"
//    }


    override fun checkConfiguration() {
    }

    override fun getConfigurationEditor() = MakefileRunConfigurationEditor() //MakefileRunConfigurationEditor(project)

    override fun writeExternal(element: Element?) {
        super.writeExternal(element)
        // this is why I hate jave

        val child = element!!.getOrCreate("ats")
        child.setAttribute("filename", filename)

//        child.setAttribute(TARGET, target)
        environmentVariables.writeExternal(child)
    }

    override fun readExternal(element: Element?) {
        super.readExternal(element)
        val child = element?.getChild("ats")
        if (child != null) {
            filename = child.getAttributeValue("filename") ?: ""
//            target = child.getAttributeValue(TARGET) ?: ""
            environmentVariables = EnvironmentVariablesData.readExternal(child)
        }
    }

    override fun getState(executor: Executor, executionEnvironment: ExecutionEnvironment): RunProfileState? {
//        val makePath = ServiceManager.getService(project, MakefileProjectSettings::class.java).settings?.path ?: DEFAULT_MAKE_PATH
        return object : CommandLineState(executionEnvironment) {
            override fun startProcess(): ProcessHandler {
//                val args = mutableListOf("-f", filename)
//                if (!target.isNullOrEmpty()) {
//                    args += target
//                }
//                executionEnvironment

                println(filename)
                print(File(filename).parent)
                println(File(filename).nameWithoutExtension)
                println(File(filename).name)

//                println(factory.)

                //TODO: this is a bit hacky how do other things (like C++) with a build/run cycle handle this?
                //TODO: only dats files are runnable
                val cmd = GeneralCommandLine()
                        .withExePath("patscc") //TODO: make configurable, there are many ways to compile ATS
                        .withWorkDirectory(File(filename).parent)
                        .withEnvironment(environmentVariables.envs) // ehhhh
//                        .withParentEnvironmentType(if (environmentVariables.isPassParentEnvs) GeneralCommandLine.ParentEnvironmentType.CONSOLE else GeneralCommandLine.ParentEnvironmentType.NONE)
                        .withParameters(listOf(
                                "-o", File(filename).nameWithoutExtension,
                                "-DATS_MEMALLOC_LIBC",
                                "--debug",
                                //                                "--dynamic",
                                File(filename).name
                                //,
//                                , ";", //"echo 'ji'"//File(filename).nameWithoutExtension
//                                File(filename).parent + "\\" + File(filename).nameWithoutExtension + ".exe"
                        )) //+ ".exe"


//                File(filename).getParentFile().

                val cmd2 = GeneralCommandLine()
                        .withExePath(File(filename).parent + "/" + File(filename).nameWithoutExtension ) //+ ".exe") //TODO: make configurable, there are many ways to compile ATS
                        .withWorkDirectory(File(filename).parent)

                val processHandler = KillableProcessHandler(cmd)//ColoredProcessHandler(cmd) ATS doesn't colloe output I don't think

//                processHandler.
                ProcessTerminatedListener.attach(processHandler)

//                patscc -o assign_sol -DATS_MEMALLOC_LIBC --debug assign_sol.dats
                return processHandler
            }
        }
    }
}


class AtsRunConfigurationProducer : RunConfigurationProducer<AtsRunConfiguration>(RunnerConfigurationType()) {
    //TODO: clean javadocs, copied for super

    /**
     * Sets up a configuration based on the specified context.

     * @param configuration a clone of the template run configuration of the specified type
     * *
     * @param context       contains the information about a location in the source code.
     * *
     * @param sourceElement a reference to the source element for the run configuration (by default contains the element at caret,
     * *                      can be updated by the producer to point to a higher-level element in the tree).
     * *
     * *
     * @return true if the context is applicable to this run configuration producer, false if the context is not applicable and the
     * * configuration should be discarded.
     */
    public override fun setupConfigurationFromContext(configuration: AtsRunConfiguration, context: ConfigurationContext, sourceElement: Ref<PsiElement>): Boolean {
        if (context.psiLocation?.containingFile !is ATSFile) {
            return false
        }
        //intrestingly, this has an almost reasonable starting configuration, it's different enough that it could cause some ubscure errors
        configuration.filename = context.location?.virtualFile?.path ?: ""
//        configuration.target = findTarget(context)?.name ?: ""
//
//        if (!configuration.target.isNullOrEmpty()) {
//            configuration.name = configuration.target
//        } else {
//            configuration.name = File(configuration.filename).name
//        }

        return true
    }

    /**
     * Checks if the specified configuration was created from the specified context.
     * @param configuration a configuration instance.
     * *
     * @param context       contains the information about a location in the source code.
     * *
     * @return true if this configuration was created from the specified context, false otherwise.
     */
    override fun isConfigurationFromContext(configuration: AtsRunConfiguration, context: ConfigurationContext): Boolean {
        return configuration.filename == context.location?.virtualFile?.path
    }

}