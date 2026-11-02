package fantasy.build

import fantasy.definitions.*
import fantasy.gradle.Loader
import fantasy.gradle.Target
import fantasy.gradle.minecraft.MinecraftVersions
import fantasy.gradle.resources.json
import fantasy.gradle.testing.*
import org.gradle.api.Project
import org.gradle.api.tasks.SourceSet
import org.gradle.kotlin.dsl.*

fun Project.configureArmorTests(): SourceSet {
    validateTestCatalog(armorTests, targets)
    val target = extensions.getByType<Target>()
    val version = MinecraftVersions[target.minecraft]
    val registration = version.loader(target.loader).tests
    val profile = testProfile(providers.gradleProperty("testProfile").getOrElse("defaults"), armor)
    return configureModTests(TestSuite(
        module = TestModule("${mod.id}_tests", "net.kenddie.fantasyarmor.test", "ArmorTests", "${mod.id}.test.report"),
        cases = armorTests,
        sourceDirectories = listOf("tests/common/java",
            if (target.loader == Loader.FABRIC && target.minecraft == "1.19.2") "tests/fabric-1.19.2/java"
            else if (target.loader == Loader.FABRIC && target.minecraft in setOf("1.18.2", "1.19.2", "1.19.3", "1.19.4")) "tests/fabric-1.19.4/java"
            else if (target.loader == Loader.FORGE && registration != TestRegistration.FORGE_FUNCTIONS)
                "tests/mock-player/java" else "tests/server-player/java",
            "loaders/${target.loader.id}/src/test/java") + testSources.getValue(target.minecraft).map { "tests/minecraft/$it/java" },
        profile = profile.id,
        resources = mapOf("armor_test_profile.json" to json(profile),
            "armor_test_recipes.json" to json(armor.map { mapOf("id" to it.id, "template" to it.upgradeIngredient, "addition" to it.addition) })),
        configFiles = profile.files(target.loader, version.loader(target.loader).testServerConfigDirectory),
        configured = profile.id != "defaults",
        modId = mod.id,
        displayName = "${mod.name} Tests",
        license = mod.license,
    ))
}
