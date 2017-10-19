package com.atslangplugin.annotators
//TODO: rename to astproject settings?

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StoragePathMacros

@State(name = "ATS.Settings", storages = arrayOf(Storage(StoragePathMacros.WORKSPACE_FILE)))
class AtsAnnotatorProjectSettings : PersistentStateComponent<AtsAnnotatorSettings> {
    var settings: AtsAnnotatorSettings? = AtsAnnotatorSettings()

    override fun getState() = settings

    override fun loadState(state: AtsAnnotatorSettings?) {
        settings = state
    }
}