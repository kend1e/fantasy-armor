package net.kenddie.fantasyarmor.test;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import java.util.List;

final class MinecraftAccess {
    static final Holder<MobEffect> STRENGTH = MobEffects.DAMAGE_BOOST;
    static final Holder<MobEffect> RESISTANCE = MobEffects.DAMAGE_RESISTANCE;
    static ResourceLocation id(String path) { return ResourceLocation.fromNamespaceAndPath("fantasy_armor", path); }
    static net.minecraft.world.entity.player.Player player(GameTestHelper h) { return h.makeMockPlayer(net.minecraft.world.level.GameType.SURVIVAL); }
    static Item item(String id) { return BuiltInRegistries.ITEM.get(ResourceLocation.parse(id)); }
    static void check(GameTestHelper h, boolean condition, String message) { h.assertTrue(condition, message); }
    static void applySettings(ItemStack stack) { ((FAArmorItem) stack.getItem()).applyServerSettings(stack); }
    static boolean unbreakable(ItemStack stack) { return stack.has(DataComponents.UNBREAKABLE); }
    static boolean dyeable(ItemStack stack) { return stack.is(ItemTags.DYEABLE); }
    static int redDyeColor() { return 0xB02E26; }
    static ItemStack roundTrip(GameTestHelper h, ItemStack stack) {
        return ItemStack.parse(h.getLevel().registryAccess(), stack.save(h.getLevel().registryAccess())).orElseThrow();
    }
    static ItemStack dye(GameTestHelper h, ItemStack stack) {
        return RecipeAccess.craft(h, 2, 2, List.of(stack, ItemStack.EMPTY, new ItemStack(Items.RED_DYE), ItemStack.EMPTY)).orElseThrow();
    }
    static void verifyUpgradeData(GameTestHelper h) {
        var base = new ItemStack(Items.NETHERITE_HELMET);
        base.set(DataComponents.CUSTOM_NAME, net.minecraft.network.chat.Component.literal("Smithing control"));
        base.set(DataComponents.DYED_COLOR, new net.minecraft.world.item.component.DyedItemColor(0x123456, false));
        base.setDamageValue(17);
        var result = RecipeAccess.upgrade(h, new ItemStack(Items.GOLD_NUGGET), base, TestSupport.stack("moon_crystal")).orElseThrow();
        check(h, base.getHoverName().equals(result.getHoverName()), "Smithing must preserve name");
        check(h, result.getOrDefault(DataComponents.DAMAGE, 0) == 17, "Smithing must preserve raw damage");
        result.getItem().onCraftedBy(result, h.getLevel(), player(h));
        check(h, result.getDamageValue() == 17, "Crafted armor must expose preserved damage");
        check(h, result.get(DataComponents.DYED_COLOR).rgb() == 0x123456, "Smithing must preserve color");
    }
    static net.minecraft.core.cauldron.CauldronInteraction cauldronInteraction(net.minecraft.world.item.ItemStack stack) {
        return net.minecraft.core.cauldron.CauldronInteraction.WATER.map().get(stack.getItem());
    }
    private MinecraftAccess() {}
}
