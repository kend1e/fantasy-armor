package net.kenddie.fantasyarmor.test;

import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import java.util.List;
import java.util.Optional;

final class RecipeAccess {
    static Optional<ItemStack> craft(GameTestHelper h, int width, int height, List<ItemStack> items) {
        var input = MinecraftAccess.craftingContainer(width, height);
        for (int slot = 0; slot < items.size(); slot++) input.setItem(slot, items.get(slot));
        return h.getLevel().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, input, h.getLevel())
                .map(recipe -> recipe.assemble(input));
    }
    static Optional<ItemStack> upgrade(GameTestHelper h, ItemStack template, ItemStack base, ItemStack addition) {
        return ArmorRecipeAccess.upgrade(h, template, base, addition);
    }

    private RecipeAccess() {}
}
