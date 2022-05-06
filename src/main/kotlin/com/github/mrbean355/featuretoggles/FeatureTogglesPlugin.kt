package com.github.mrbean355.featuretoggles

import org.gradle.api.Plugin
import org.gradle.api.Project

class FeatureTogglesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.afterEvaluate { project ->
            project.tasks.register("generateFeatureToggleDsl", GenerateFeatureToggleDslTask::class.java)
        }
    }
}