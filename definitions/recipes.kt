package fantasy.definitions

import fantasy.gradle.minecraft.RecipeItem

private val beforeCavesAndCliffs = mapOf(
    "minecraft:raw_gold" to RecipeItem("minecraft:gold_ore"),
    "minecraft:amethyst_shard" to RecipeItem("minecraft:magenta_dye"),
)

val recipeItemsByMinecraft = mapOf(
    "1.12.2" to beforeCavesAndCliffs + mapOf(
        "minecraft:honeycomb" to RecipeItem("minecraft:yellow_dye"),
        "minecraft:phantom_membrane" to RecipeItem("minecraft:rabbit_hide"),
        "minecraft:dried_kelp" to RecipeItem("minecraft:beetroot_seeds"),
        "minecraft:lily_of_the_valley" to RecipeItem("minecraft:white_tulip"),
    ),
    "1.15.2" to beforeCavesAndCliffs,
    "1.16.5" to beforeCavesAndCliffs,
)

fun craftingRecipes(minecraft: String) = materials.map { material ->
    material.craftingRecipe(mod.id).let { recipe ->
        if (material.id == moonCrystal.id && minecraft in setOf("1.12.2", "1.15.2", "1.16.5")) recipe.copy(
            ingredients = mapOf("#" to "minecraft:ink_sac", "X" to "minecraft:diamond"),
        ) else recipe
    }
}
