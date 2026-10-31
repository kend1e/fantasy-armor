package fantasy.build

import fantasy.definitions.targets
import fantasy.definitions.armor
import fantasy.definitions.languages
import fantasy.definitions.craftingRecipes
import fantasy.definitions.mod
import fantasy.gradle.minecraft.MinecraftVersions
import fantasy.gradle.content.armor.contentResources
import fantasy.gradle.configureModResources
import fantasy.gradle.configureModSources
import fantasy.gradle.ResourcesExtension
import fantasy.gradle.Target
import fantasy.gradle.configureMod
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

class FantasyPlatformPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = with(project) {
        val target = targets.single { it.path == path }
        configureMod(mod, target)
        pluginManager.apply("fantasy.build.${target.loader.id}")
        configureModSources(listOf(
            "minecraft/${target.minecraft}/src/main/java",
            "loaders/${target.loader.id}/src/main/java",
        ))
        configureResources(target)
        configureArmorTests()
    }

    private fun Project.configureResources(target: Target) {
        configureModResources()
        extensions.configure<ResourcesExtension> {
            generate("generateContentResources") {
                contents.set(contentResources(mod.id, armor, languages, craftingRecipes, MinecraftVersions[target.minecraft].resources))
                outputDirectory.set(layout.buildDirectory.dir("generated/resources/content"))
            }
        }
    }
}
