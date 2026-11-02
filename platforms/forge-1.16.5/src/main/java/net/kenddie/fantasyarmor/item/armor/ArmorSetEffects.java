package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;

public final class ArmorSetEffects {
    public static void tick(PlayerEntity player, boolean enabled, int refreshThreshold, boolean particles, boolean icon) {
        if (!enabled || !hasFullSet(player)) return;
        FAArmorItem armor = (FAArmorItem) player.getItemBySlot(EquipmentSlotType.HEAD).getItem();
        for (EffectEntry entry : armor.getFullSetEffects()) {
            net.minecraft.potion.Effect effect = Registry.MOB_EFFECT.get(ResourceLocation.tryParse(entry.id()));
            if (effect == null) continue;
            EffectInstance existing = player.getEffect(effect);
            if (existing == null || EffectEntry.shouldRefresh(existing.getDuration(), refreshThreshold)) {
                int duration = entry.duration() == -1 ? Integer.MAX_VALUE : entry.duration();
                player.addEffect(new EffectInstance(effect, duration, entry.amplifier(), true, particles, icon));
            }
        }
    }

    private static boolean hasFullSet(PlayerEntity player) {
        if (!(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof FAArmorItem)
                || !(player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof FAArmorItem)
                || !(player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof FAArmorItem)
                || !(player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof FAArmorItem)) {
            return false;
        }
        FAArmorItem helmet = (FAArmorItem) player.getItemBySlot(EquipmentSlotType.HEAD).getItem();
        FAArmorItem chestplate = (FAArmorItem) player.getItemBySlot(EquipmentSlotType.CHEST).getItem();
        FAArmorItem leggings = (FAArmorItem) player.getItemBySlot(EquipmentSlotType.LEGS).getItem();
        FAArmorItem boots = (FAArmorItem) player.getItemBySlot(EquipmentSlotType.FEET).getItem();
        return helmet.getSlot() == EquipmentSlotType.HEAD
                && chestplate.getSlot() == EquipmentSlotType.CHEST
                && leggings.getSlot() == EquipmentSlotType.LEGS
                && boots.getSlot() == EquipmentSlotType.FEET
                && helmet.getArmorSet().equals(chestplate.getArmorSet())
                && helmet.getArmorSet().equals(leggings.getArmorSet())
                && helmet.getArmorSet().equals(boots.getArmorSet());
    }

    private ArmorSetEffects() {}
}
