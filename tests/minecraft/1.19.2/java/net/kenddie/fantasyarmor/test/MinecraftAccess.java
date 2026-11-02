package net.kenddie.fantasyarmor.test;

import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;

final class MinecraftAccess extends NbtAccess {
    static Player player(GameTestHelper h) { return h.makeMockPlayer(); }
    static CraftingContainer craftingContainer(int width, int height) {
        return new CraftingContainer(new TestMenu(), width, height);
    }
    private MinecraftAccess() {}
}
