package com.github.mrbean355.featuretoggles

import com.android.build.gradle.AppExtension
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateFeatureToggleDslTask : DefaultTask() {

    @get:OutputDirectory
    val outputDir = File("${project.buildDir}/generated/source/feature-toggles/")

    @TaskAction
    fun run() {
        outputDir.deleteRecursively()
        outputDir.mkdirs()

        val appExtension = project.extensions.getByType(AppExtension::class.java)
        appExtension.applicationVariants.all {
            println("${it.name} - ${it.productFlavors.joinToString { it.name }} - ${it.buildType.name}")
        }

        println(appExtension.flavorDimensionList)

        FileSpec.builder("com.github.mrbean355.demo", "Demo")
            .addType(TypeSpec.classBuilder("Demo").build())
            .build()
            .writeTo(outputDir)
    }
}