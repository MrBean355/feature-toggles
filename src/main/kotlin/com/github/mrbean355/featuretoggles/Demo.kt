package com.github.mrbean355.featuretoggles

fun main() {
    configureToggles {
        "".toggle {
            debug = true
            release = false
        }
    }
}

fun configureToggles(
    block: FeatureToggleCollector<String>.() -> Unit
) {

}

interface FeatureToggleCollector<T> {
    fun T.toggle(block: FeatureToggleScope<T>.() -> Unit)
}

interface FeatureToggleScope<T> {
    var debug: Boolean
    var release: Boolean
}