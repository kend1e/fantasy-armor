package net.kenddie.fantasyarmor.test;

import com.google.gson.Gson;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static net.kenddie.fantasyarmor.test.TestSupport.*;

public final class RecipeTests {
    static final class ArmorRecipe {
        private String id;
        private String template;
        private String addition;
        String id() { return id; }
        String template() { return template; }
        String addition() { return addition; }
    }

    public static void run(GameTestHelper h) {
        var recipes = declarations();
        for (var recipe : recipes) {
            for (var piece : PIECES) {
                var template = new ItemStack(MinecraftAccess.item(recipe.template()));
                var base = new ItemStack(MinecraftAccess.item("minecraft:netherite_" + piece.getName()));
                var addition = new ItemStack(MinecraftAccess.item(recipe.addition()));
                String resultId = recipe.id() + "_" + piece.getName();
                var result = RecipeAccess.upgrade(h, template, base, addition).orElseThrow();
                check(h, result.is(item(resultId)) && result.getCount() == 1, "Wrong armor recipe result: " + resultId);
                check(h, RecipeAccess.upgrade(h, ItemStack.EMPTY, base, addition).isEmpty(), "Missing ingredient must be rejected: " + resultId);
                check(h, RecipeAccess.upgrade(h, template, base, new ItemStack(Items.DIRT)).isEmpty(), "Wrong addition must be rejected: " + resultId);
            }
        }
        var control = RecipeAccess.upgrade(h, new ItemStack(Items.GOLD_NUGGET), new ItemStack(Items.NETHERITE_HELMET), stack("moon_crystal")).orElseThrow();
        check(h, control.is(item("eclipse_soldier_helmet")), "Gold nugget must produce eclipse soldier helmet");
        MinecraftAccess.verifyUpgradeData(h);
        var crystal = RecipeAccess.craft(h, 3, 3, List.of(
                new ItemStack(Items.GLOW_INK_SAC), new ItemStack(Items.GLOW_INK_SAC), new ItemStack(Items.GLOW_INK_SAC),
                new ItemStack(Items.GLOW_INK_SAC), new ItemStack(Items.AMETHYST_SHARD), new ItemStack(Items.GLOW_INK_SAC),
                new ItemStack(Items.GLOW_INK_SAC), new ItemStack(Items.GLOW_INK_SAC), new ItemStack(Items.GLOW_INK_SAC))).orElseThrow();
        check(h, crystal.is(item("moon_crystal")), "Crystal crafting failed");
        h.succeed();
    }
    static ArmorRecipe[] declarations() {
        var stream = RecipeTests.class.getResourceAsStream("/armor_test_recipes.json");
        if (stream == null) throw new IllegalStateException("Missing recipe test declarations");
        ArmorRecipe[] recipes;
        try (var reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            recipes = new Gson().fromJson(reader, ArmorRecipe[].class);
        } catch (java.io.IOException e) { throw new IllegalStateException(e); }
        return recipes;
    }
    private RecipeTests() {}
}
