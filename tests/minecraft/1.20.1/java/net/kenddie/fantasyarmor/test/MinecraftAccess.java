package net.kenddie.fantasyarmor.test;

import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.TransientCraftingContainer;

final class MinecraftAccess extends NbtAccess {
    static Player player(GameTestHelper h) { return h.makeMockSurvivalPlayer(); }
    static CraftingContainer craftingContainer(int width, int height) {
        return new TransientCraftingContainer(new TestMenu(), width, height);
    }
    static net.minecraft.core.cauldron.CauldronInteraction cauldronInteraction(net.minecraft.world.item.ItemStack stack) {
        return net.minecraft.core.cauldron.CauldronInteraction.WATER.get(stack.getItem());
    }
    private MinecraftAccess() {}
}
