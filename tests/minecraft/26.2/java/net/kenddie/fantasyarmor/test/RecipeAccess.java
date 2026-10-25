package net.kenddie.fantasyarmor.test;

import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import java.util.List;
import java.util.Optional;

final class RecipeAccess {
    static Optional<ItemStack> upgrade(GameTestHelper h, ItemStack template, ItemStack base, ItemStack addition) {
        var input = new SmithingRecipeInput(template, base, addition);
        return h.getLevel().getServer().getRecipeManager().getRecipeFor(RecipeType.SMITHING, input, h.getLevel())
                .map(recipe -> recipe.value().assemble(input));
    }
    static Optional<ItemStack> craft(GameTestHelper h, int width, int height, List<ItemStack> items) {
        var input = CraftingInput.of(width, height, items);
        return h.getLevel().getServer().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, input, h.getLevel())
                .map(recipe -> recipe.value().assemble(input));
    }

    private RecipeAccess() {}
}
