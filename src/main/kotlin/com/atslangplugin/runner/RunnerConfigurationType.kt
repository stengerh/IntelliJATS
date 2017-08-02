package com.atslangplugin.runner

import com.atslangplugin.ATSIcons
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType


class RunnerConfigurationType : ConfigurationType {

    /**
     * Returns the display name of the configuration type. This is used, for example, to represent the configuration type in the run
     * configurations tree, and also as the name of the action used to create the configuration.

     * @return the display name of the configuration type.
     */
    override fun getDisplayName() = "ATS"

    /**
     * Returns the description of the configuration type. You may return the same text as the display name of the configuration type.

     * @return the description of the configuration type.
     */
    override fun getConfigurationTypeDescription() = "ATS build and run via patsopt"

    /**
     * Returns the 16x16 icon used to represent the configuration type.

     * @return the icon
     */
    //TODO: a specific ats run icon?
    override fun getIcon() = ATSIcons.FILE

    /**
     * Returns the ID of the configuration type. The ID is used to store run configuration settings in a project or workspace file and
     * must not change between plugin versions.

     * @return the configuration type ID.
     */
    override fun getId() = "ATS_RUN_CONFIGURATION"

    /**
     * Returns the configuration factories used by this configuration type. Normally each configuration type provides just a single factory.
     * You can return multiple factories if your configurations can be created in multiple variants (for example, local and remote for an
     * application server).

     * @return the run configuration factories.
     */
    override fun getConfigurationFactories() = arrayOf(AtsRunConfigurationFactory(this))
}