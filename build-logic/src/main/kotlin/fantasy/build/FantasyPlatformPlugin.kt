package fantasy.build

import fantasy.definitions.targets
import fantasy.definitions.armor
import fantasy.definitions.languages
import fantasy.definitions.craftingRecipes
import fantasy.definitions.recipeItemsByMinecraft
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
        configureModSources(if (target.minecraft == "1.12.2") emptyList() else listOf(
            "minecraft/${target.minecraft}/src/main/java",
            if (target.loader.id == "fabric" && target.minecraft in setOf("1.16.5", "1.18.2"))
                "loaders/fabric/src/main/java/net/kenddie/fantasyarmor/config"
            else "loaders/${target.loader.id}/src/main/java",
        ))
        configureResources(target)
        if (MinecraftVersions[target.minecraft].loader(target.loader).tests != null) configureArmorTests()
    }

    private fun Project.configureResources(target: Target) {
        configureModResources()
        extensions.configure<ResourcesExtension> {
            generate("generateContentResources") {
                contents.set(contentResources(mod.id, armor, languages, craftingRecipes(target.minecraft), MinecraftVersions[target.minecraft].resources, recipeItemsByMinecraft[target.minecraft].orEmpty()))
                outputDirectory.set(layout.buildDirectory.dir("generated/resources/content"))
            }
        }
    }
}
