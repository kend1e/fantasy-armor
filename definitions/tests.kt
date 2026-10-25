package fantasy.definitions

import fantasy.gradle.testing.TestCase
import fantasy.gradle.Loader

val armorTests = listOf(
    TestCase("recipes", "RecipeTests"),
    TestCase("shapeless", "ShapelessRecipeTests", minecraft = setOf("1.19.4")),
    TestCase("dyeing", "DyeingTests"),
    TestCase("attributes", "AttributeTests"),
    TestCase("stack_update", "StackUpdateTests", minecraft = setOf("1.21.1", "1.21.10", "1.21.11", "26.1.2", "26.2", "26.3")),
    TestCase("sets", "SetTests"),
    TestCase("effects", "EffectTests"),
    TestCase("configs", "ConfigTests"),
    TestCase("config_fixture", "ConfigFixtureTests", loaders = setOf(Loader.FORGE)),
    TestCase("config_load", "ConfigLoadTests"),
    TestCase("config_restart_policy", "RestartPolicyTests", loaders = setOf(Loader.NEOFORGE)),
    TestCase("ticks", "TickTests"),
    TestCase("tick_cleanup", "TickCleanupTests"),
)

val testSources = mapOf(
    "1.19.4" to listOf("nbt", "crafting-container", "1.19.4"),
    "1.20.1" to listOf("nbt", "crafting-container", "1.20.1"),
    "1.21.1" to listOf("component-stacks", "1.21.1"),
    "1.21.10" to listOf("component-stacks", "components", "crafting-input", "1.21.10"),
    "1.21.11" to listOf("component-stacks", "components", "crafting-input", "1.21.11"),
    "26.1.2" to listOf("component-stacks", "26.1.2"),
    "26.2" to listOf("component-stacks", "26.2"),
    "26.3" to listOf("component-stacks", "26.3"),
)
