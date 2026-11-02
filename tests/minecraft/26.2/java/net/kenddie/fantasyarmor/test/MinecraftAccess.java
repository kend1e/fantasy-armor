package net.kenddie.fantasyarmor.test;

import net.minecraft.resources.Identifier;

final class MinecraftAccess extends ComponentAccess {
    static Identifier id(String value) { return Identifier.parse(value); }
    static net.minecraft.core.cauldron.CauldronInteraction cauldronInteraction(net.minecraft.world.item.ItemStack stack) {
        return net.minecraft.core.cauldron.CauldronInteractions.WATER.get(stack);
    }
    private MinecraftAccess() {}
}
