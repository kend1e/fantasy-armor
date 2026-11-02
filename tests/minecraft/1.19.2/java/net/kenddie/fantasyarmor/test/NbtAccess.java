package net.kenddie.fantasyarmor.test;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.core.Registry;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.chat.Component;
import java.util.List;

class NbtAccess {
    static final MobEffect STRENGTH = MobEffects.DAMAGE_BOOST;
    static final MobEffect RESISTANCE = MobEffects.DAMAGE_RESISTANCE;
    static Item item(String id) { return Registry.ITEM.get(new ResourceLocation(id)); }
    static void check(GameTestHelper h, boolean condition, String message) { if (!condition) h.fail(message); }
    static void applySettings(ItemStack stack) { /* NBT-era items expose live settings through item overrides. */ }
    static boolean unbreakable(ItemStack stack) { return !stack.isDamageableItem(); }
    static boolean dyeable(ItemStack stack) { return stack.getItem() instanceof DyeableLeatherItem; }
    static int redDyeColor() { return 0xB02E26; }
    static ItemStack roundTrip(GameTestHelper h, ItemStack stack) { return ItemStack.of(stack.save(new CompoundTag())); }
    static ItemStack dye(GameTestHelper h, ItemStack stack) {
        return RecipeAccess.craft(h, 2, 2, List.of(stack, ItemStack.EMPTY, new ItemStack(Items.RED_DYE), ItemStack.EMPTY)).orElseThrow();
    }
    static void verifyUpgradeData(GameTestHelper h) {
        var base = new ItemStack(Items.NETHERITE_HELMET);
        base.setHoverName(Component.literal("Upgrade control"));
        base.setDamageValue(17);
        base.getOrCreateTagElement("display").putInt("color", 0x123456);
        var result = RecipeAccess.upgrade(h, new ItemStack(Items.GOLD_NUGGET), base, TestSupport.stack("moon_crystal")).orElseThrow();
        if (ArmorRecipeAccess.PRESERVES_DATA) {
            check(h, result.getHoverName().equals(base.getHoverName()), "Smithing must preserve name");
            check(h, result.getDamageValue() == 17, "Smithing must preserve damage");
            check(h, ((FAArmorItem) result.getItem()).getColor(result) == 0x123456, "Smithing must preserve color");
        } else {
            check(h, !result.hasCustomHoverName() && result.getDamageValue() == 0,
                    "Crafting must create fresh armor without copying base metadata");
            check(h, !((FAArmorItem) result.getItem()).hasCustomColor(result), "Crafting must not copy base color");
        }
        check(h, base.getDamageValue() == 17 && base.hasCustomHoverName(), "Upgrade must not mutate its input");
    }
}
