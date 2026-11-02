package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;

public final class ArmorSetEffects {
    public static void tick(Player player, boolean enabled, int refreshThreshold, boolean particles, boolean icon) {
        if (!enabled || !hasFullSet(player)) return;
        FAArmorItem armor = (FAArmorItem) player.getItemBySlot(EquipmentSlot.HEAD).getItem();
        for (EffectEntry entry : armor.getFullSetEffects()) {
            net.minecraft.world.effect.MobEffect effect = Registry.MOB_EFFECT.get(ResourceLocation.tryParse(entry.id()));
            if (effect == null) continue;
            MobEffectInstance existing = player.getEffect(effect);
            if (existing == null || EffectEntry.shouldRefresh(existing.getDuration(), refreshThreshold)) {
                int duration = entry.duration() == -1 ? Integer.MAX_VALUE : entry.duration();
                player.addEffect(new MobEffectInstance(effect, duration, entry.amplifier(), true, particles, icon));
            }
        }
    }

    private static boolean hasFullSet(Player player) {
        if (!(player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof FAArmorItem)
                || !(player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof FAArmorItem)
                || !(player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof FAArmorItem)
                || !(player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof FAArmorItem)) {
            return false;
        }
        FAArmorItem helmet = (FAArmorItem) player.getItemBySlot(EquipmentSlot.HEAD).getItem();
        FAArmorItem chestplate = (FAArmorItem) player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        FAArmorItem leggings = (FAArmorItem) player.getItemBySlot(EquipmentSlot.LEGS).getItem();
        FAArmorItem boots = (FAArmorItem) player.getItemBySlot(EquipmentSlot.FEET).getItem();
        return helmet.getSlot() == EquipmentSlot.HEAD
                && chestplate.getSlot() == EquipmentSlot.CHEST
                && leggings.getSlot() == EquipmentSlot.LEGS
                && boots.getSlot() == EquipmentSlot.FEET
                && helmet.getArmorSet().equals(chestplate.getArmorSet())
                && helmet.getArmorSet().equals(leggings.getArmorSet())
                && helmet.getArmorSet().equals(boots.getArmorSet());
    }

    private ArmorSetEffects() {}
}
