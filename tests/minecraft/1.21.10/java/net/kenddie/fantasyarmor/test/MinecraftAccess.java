package net.kenddie.fantasyarmor.test;

import net.minecraft.resources.ResourceLocation;

final class MinecraftAccess extends ComponentAccess {
    static ResourceLocation id(String value) { return ResourceLocation.parse(value); }
    static net.minecraft.core.cauldron.CauldronInteraction cauldronInteraction(net.minecraft.world.item.ItemStack stack) {
        return net.minecraft.core.cauldron.CauldronInteraction.WATER.map().get(stack.getItem());
    }
    private MinecraftAccess() {}
}
