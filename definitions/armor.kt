package fantasy.definitions

import fantasy.gradle.content.armor.*

// Shared starting values. Set defaults and then piece overrides take precedence.
private val baseArmor = mapOf(
    Piece.HELMET to Attributes(armor = 3.0, armorToughness = 3.0, knockbackResistance = 0.1, durability = 440.0),
    Piece.CHESTPLATE to Attributes(armor = 8.0, armorToughness = 3.0, knockbackResistance = 0.1, durability = 640.0),
    Piece.LEGGINGS to Attributes(armor = 6.0, armorToughness = 3.0, knockbackResistance = 0.1, durability = 580.0),
    Piece.BOOTS to Attributes(armor = 3.0, armorToughness = 3.0, knockbackResistance = 0.1, durability = 500.0),
)

val armor = armorCatalog(defaults = baseArmor, addition = "${mod.id}:${moonCrystal.id}") {
    armor("eclipse_soldier") {
        upgradeIngredient = "minecraft:gold_nugget"
        helmet {
            movementSpeed = 0.1
        }
        chestplate {
            knockbackResistance = 0.2
        }
        leggings {
            knockbackResistance = 0.2
        }
        effect("minecraft:strength")
        effect("minecraft:resistance")
    }

    armor("dragonslayer") {
        upgradeIngredient = "minecraft:nether_wart"
        helmet {
            knockbackResistance = 0.2
        }
        chestplate {
            knockbackResistance = 0.2
            attackSpeed = 0.1
        }
        leggings {
            knockbackResistance = 0.2
        }
        effect("minecraft:strength")
        effect("minecraft:fire_resistance")
    }

    armor("hero") {
        upgradeIngredient = "minecraft:iron_ingot"
        helmet {
            attackDamage = 0.1
            attackSpeed = 0.1
        }
        chestplate {
            attackDamage = 0.1
            attackSpeed = 0.1
        }
        effect("minecraft:regeneration")
    }

    armor("golden_horns") {
        upgradeIngredient = "minecraft:flint"
        helmet {
            movementSpeed = 0.03
            attackSpeed = 0.1
        }
        chestplate {
            movementSpeed = 0.01
            attackSpeed = 0.1
        }
        leggings {
            movementSpeed = 0.02
        }
        boots {
            movementSpeed = 0.04
        }
        effect("minecraft:haste", amplifier = 1)
    }

    armor("thief") {
        upgradeIngredient = "minecraft:leather"
        helmet {
            movementSpeed = 0.05
            attackSpeed = 0.1
            luck = 1.0
        }
        chestplate {
            movementSpeed = 0.05
            attackSpeed = 0.1
        }
        leggings {
            movementSpeed = 0.1
            attackSpeed = 0.1
        }
        boots {
            movementSpeed = 0.1
            attackSpeed = 0.05
        }
        effect("minecraft:jump_boost")
    }

    armor("wandering_wizard") {
        upgradeIngredient = "minecraft:spider_eye"
        defaults {
            movementSpeed = 0.05
        }
        helmet {
            luck = 2.0
        }
        effect("minecraft:water_breathing")
        effect("minecraft:night_vision")
        effect("minecraft:fire_resistance")
    }

    armor("chess_board_knight") {
        upgradeIngredient = "minecraft:honeycomb"
        defaults {
            knockbackResistance = 0.2
        }
        chestplate {
            maxHealth = 2.0
        }
        boots {
            maxHealth = 2.0
        }
        effect("minecraft:haste")
        effect("minecraft:regeneration")
        effect("minecraft:strength")
    }

    armor("dark_lord") {
        upgradeIngredient = "minecraft:bone"
        helmet {
            attackSpeed = 0.02
        }
        chestplate {
            knockbackResistance = 0.2
            attackSpeed = 0.03
        }
        leggings {
            knockbackResistance = 0.2
            attackSpeed = 0.03
        }
        boots {
            attackSpeed = 0.02
        }
        effect("minecraft:strength")
        effect("minecraft:night_vision")
        effect("minecraft:fire_resistance")
    }

    armor("sunset_wings") {
        upgradeIngredient = "minecraft:gunpowder"
        defaults {
            movementSpeed = 0.05
            maxHealth = 1.0
        }
        effect("minecraft:jump_boost")
    }

    armor("fog_guard") {
        upgradeIngredient = "minecraft:phantom_membrane"
        defaults {
            maxHealth = 1.0
        }
        helmet {
            attackSpeed = 0.1
        }
        chestplate {
            attackSpeed = 0.01
        }
        leggings {
            attackSpeed = 0.02
        }
        boots {
            attackSpeed = 0.03
        }
        effect("minecraft:fire_resistance")
        effect("minecraft:resistance")
    }

    armor("dark_cover") {
        upgradeIngredient = "minecraft:coal"
        helmet {
            maxHealth = 2.0
        }
        chestplate {
            knockbackResistance = 0.2
            attackSpeed = 0.1
        }
        leggings {
            knockbackResistance = 0.2
            maxHealth = 1.0
        }
        effect("minecraft:regeneration")
        effect("minecraft:strength")
    }

    armor("spark_of_dawn") {
        upgradeIngredient = "minecraft:amethyst_shard"
        helmet {
            maxHealth = 1.0
            attackSpeed = 0.1
        }
        chestplate {
            attackSpeed = 0.05
        }
        leggings {
            knockbackResistance = 0.2
            movementSpeed = 0.05
            maxHealth = 1.0
            attackSpeed = 0.05
        }
        boots {
            movementSpeed = 0.05
        }
        effect("minecraft:night_vision")
        effect("minecraft:fire_resistance")
    }

    armor("golden_execution") {
        upgradeIngredient = "minecraft:ender_pearl"
        defaults {
            knockbackResistance = 0.2
        }
        helmet {
            maxHealth = 2.0
            attackSpeed = 0.05
        }
        chestplate {
            maxHealth = 4.0
            attackSpeed = 0.05
        }
        leggings {
            maxHealth = 1.0
        }
        boots {
            maxHealth = 1.0
        }
        effect("minecraft:strength")
    }

    armor("forgotten_trace") {
        upgradeIngredient = "minecraft:prismarine_crystals"
        helmet {
            movementSpeed = 0.05
            luck = 1.0
        }
        chestplate {
            movementSpeed = 0.03
            maxHealth = 2.0
        }
        leggings {
            movementSpeed = 0.02
            maxHealth = 1.0
        }
        boots {
            knockbackResistance = 0.2
            movementSpeed = 0.05
            maxHealth = 1.0
            luck = 1.0
        }
        effect("minecraft:haste")
        effect("minecraft:regeneration")
    }

    armor("redeemer") {
        upgradeIngredient = "minecraft:emerald"
        helmet {
            maxHealth = 2.0
            attackSpeed = 0.05
            luck = 1.0
        }
        chestplate {
            movementSpeed = 0.02
            maxHealth = 2.0
            attackSpeed = 0.03
            luck = 1.0
        }
        leggings {
            knockbackResistance = 0.2
            movementSpeed = 0.04
        }
        boots {
            movementSpeed = 0.02
        }
        effect("minecraft:strength")
        effect("minecraft:fire_resistance")
    }

    armor("twinned") {
        upgradeIngredient = "minecraft:quartz"
        defaults {
            movementSpeed = 0.02
        }
        helmet {
            knockbackResistance = 0.2
            attackSpeed = 0.1
        }
        chestplate {
            attackSpeed = 0.02
        }
        leggings {
            knockbackResistance = 0.2
            attackSpeed = 0.05
        }
        boots {
            attackSpeed = 0.05
        }
        effect("minecraft:regeneration")
        effect("minecraft:haste", amplifier = 1)
    }

    armor("gilded_hunt") {
        upgradeIngredient = "minecraft:raw_gold"
        helmet {
            maxHealth = 1.0
            attackSpeed = 0.1
        }
        chestplate {
            maxHealth = 1.0
            attackSpeed = 0.1
        }
        effect("minecraft:jump_boost")
        effect("minecraft:strength")
    }

    armor("lady_maria") {
        upgradeIngredient = "minecraft:feather"
        helmet {
            attackSpeed = 0.05
            luck = 1.0
        }
        chestplate {
            movementSpeed = 0.05
            attackSpeed = 0.05
        }
        leggings {
            movementSpeed = 0.05
        }
        boots {
            movementSpeed = 0.03
        }
        effect("minecraft:strength")
        effect("minecraft:regeneration")
    }

    armor("crucible_knight") {
        upgradeIngredient = "minecraft:blaze_powder"
        helmet {
            knockbackResistance = 0.2
        }
        chestplate {
            knockbackResistance = 0.2
            maxHealth = 2.0
        }
        leggings {
            knockbackResistance = 0.2
        }
        effect("minecraft:fire_resistance")
        effect("minecraft:regeneration")
    }

    armor("evening_ghost") {
        upgradeIngredient = "minecraft:dried_kelp"
        helmet {
            movementSpeed = 0.05
            luck = 1.0
        }
        chestplate {
            movementSpeed = 0.03
            luck = 1.0
        }
        leggings {
            movementSpeed = 0.04
        }
        boots {
            movementSpeed = 0.05
        }
        effect("minecraft:regeneration")
        effect("minecraft:night_vision")
    }

    armor("ronin") {
        upgradeIngredient = "minecraft:sugar_cane"
        helmet {
            attackSpeed = 0.1
        }
        chestplate {
            attackSpeed = 0.1
        }
        leggings {
            movementSpeed = 0.03
        }
        boots {
            movementSpeed = 0.05
        }
        effect("minecraft:jump_boost")
    }

    armor("malenia") {
        upgradeIngredient = "minecraft:ghast_tear"
        helmet {
            movementSpeed = 0.07
            attackSpeed = 0.05
        }
        chestplate {
            knockbackResistance = 0.2
            movementSpeed = 0.05
            attackSpeed = 0.05
        }
        leggings {
            movementSpeed = 0.05
        }
        boots {
            movementSpeed = 0.08
        }
        effect("minecraft:regeneration")
    }

    armor("old_knight") {
        upgradeIngredient = "minecraft:obsidian"
        helmet {
            knockbackResistance = 0.2
            maxHealth = 1.0
        }
        chestplate {
            knockbackResistance = 0.2
            maxHealth = 2.0
        }
        leggings {
            knockbackResistance = 0.2
            maxHealth = 1.0
        }
        effect("minecraft:strength")
        effect("minecraft:resistance")
    }

    armor("silver_knight") {
        upgradeIngredient = "minecraft:snowball"
        helmet {
            attackSpeed = 0.03
            luck = 1.0
        }
        chestplate {
            knockbackResistance = 0.2
            attackSpeed = 0.03
            luck = 1.0
        }
        leggings {
            attackSpeed = 0.02
        }
        boots {
            luck = 1.0
        }
        effect("minecraft:luck")
        effect("minecraft:strength")
    }

    armor("dead_gladiator") {
        upgradeIngredient = "minecraft:red_sand"
        defaults {
            armorToughness = 2.0
        }
        helmet {
            attackDamage = 0.05
        }
        chestplate {
            knockbackResistance = 0.2
            attackDamage = 0.1
        }
        leggings {
            attackDamage = 0.05
        }
        effect("minecraft:regeneration")
    }

    armor("flesh_of_the_feaster") {
        upgradeIngredient = "minecraft:slime_ball"
        defaults {
            armorToughness = 1.0
        }
        helmet {
            maxHealth = 1.0
        }
        chestplate {
            knockbackResistance = 0.2
            maxHealth = 2.0
        }
        leggings {
            maxHealth = 1.0
        }
        effect("minecraft:resistance")
    }

    armor("wind_worshipper") {
        upgradeIngredient = "minecraft:paper"
        defaults {
            armorToughness = 2.0
        }
        helmet {
            attackSpeed = 0.03
        }
        chestplate {
            knockbackResistance = 0.2
            attackSpeed = 0.03
        }
        leggings {
            attackSpeed = 0.02
        }
        boots {
            movementSpeed = 0.03
        }
        effect("minecraft:jump_boost")
    }

    armor("grave_sentinel") {
        upgradeIngredient = "minecraft:lily_of_the_valley"
        defaults {
            armorToughness = 2.0
        }
        helmet {
            attackSpeed = 0.03
        }
        chestplate {
            knockbackResistance = 0.2
            attackSpeed = 0.03
        }
        leggings {
            attackSpeed = 0.02
        }
        boots {
            knockbackResistance = 0.2
            movementSpeed = 0.03
        }
        effect("minecraft:strength")
        effect("minecraft:fire_resistance")
    }

    armor("ornstein") {
        upgradeIngredient = "minecraft:gold_ingot"
        defaults {
            armorToughness = 2.0
        }
        helmet {
            maxHealth = 2.0
            attackDamage = 0.05
        }
        chestplate {
            knockbackResistance = 0.2
            maxHealth = 2.0
            attackDamage = 0.05
        }
        leggings {
            movementSpeed = 0.03
            maxHealth = 2.0
        }
        boots {
            knockbackResistance = 0.2
            movementSpeed = 0.03
        }
        effect("minecraft:regeneration")
        effect("minecraft:resistance")
    }

    armor("dawncrest") {
        upgradeIngredient = "minecraft:sunflower"
        helmet {
            maxHealth = 2.0
        }
        chestplate {
            maxHealth = 2.0
            knockbackResistance = 0.2
        }
        leggings {
            knockbackResistance = 0.2
        }
        boots {
            movementSpeed = 0.03
        }
        effect("minecraft:regeneration")
        effect("minecraft:fire_resistance")
    }
}
