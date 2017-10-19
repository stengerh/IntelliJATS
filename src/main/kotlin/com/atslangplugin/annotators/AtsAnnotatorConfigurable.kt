package com.atslangplugin.annotators

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.uiDesigner.core.Spacer
import com.intellij.util.ui.FormBuilder
import com.intellij.util.ui.UIUtil
import javax.swing.JComponent

//largely from the makefile plugin

class AtsAnnotatorConfigurable(
        private val project: Project?,
        private val settings: AtsAnnotatorProjectSettings
) : Configurable {
    private val pathField = TextFieldWithBrowseButton()

    init {
        pathField.addBrowseFolderListener("ATS", "Path to patsopt executable", project, FileChooserDescriptor(true, false, false, false, false, false))
    }

    override fun isModified(): Boolean {
        return settings.settings?.path != pathField.text
    }

    override fun getDisplayName() = "ATS"
    override fun apply() {
        settings.settings?.path = pathField.text
    }

    override fun createComponent(): JComponent {
        return FormBuilder.createFormBuilder()
                .setAlignLabelOnRight(false)
                .setHorizontalGap(UIUtil.DEFAULT_HGAP)
                .setVerticalGap(UIUtil.DEFAULT_VGAP)
                .addLabeledComponent("Path to &patsopt executable", pathField)
                .addComponentFillVertically(Spacer(), 0)
                .panel
    }

    override fun reset() {
        pathField.text = settings.settings?.path!!
    }

    override fun getHelpTopic() = null
}