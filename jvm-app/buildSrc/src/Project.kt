import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ModuleDependency
import org.gradle.kotlin.dsl.withType

fun ModuleDependency.features(vararg capabilityModules: Any) =
    capabilities { capabilityModules.forEach { requireCapability("$group:$it") } }

fun Project.withPlugin(id: String, action: Plugin<*>.() -> Unit) = plugins.withId(id, action)

inline fun <reified T : Plugin<*>> Project.withPlugin(noinline action: T.() -> Unit) =
    plugins.withType<T>().configureEach(action)

inline fun <reified T : Plugin<*>> Project.withPluginEagerly(noinline action: T.() -> Unit) =
    plugins.withType<T>(action)
