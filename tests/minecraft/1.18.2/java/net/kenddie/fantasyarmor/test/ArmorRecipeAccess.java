package net.kenddie.fantasyarmor.test;

import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import java.util.List;
import java.util.Optional;

final class ArmorRecipeAccess {
    static final boolean PRESERVES_DATA = false;
    static Optional<ItemStack> upgrade(GameTestHelper h, ItemStack template, ItemStack base, ItemStack addition) {
        return RecipeAccess.craft(h, 2, 2, List.of(template, base, addition, ItemStack.EMPTY));
    }

    private ArmorRecipeAccess() {}
}
