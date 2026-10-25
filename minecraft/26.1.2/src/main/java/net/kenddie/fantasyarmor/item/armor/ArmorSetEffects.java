package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;

public final class ArmorSetEffects {
    public static void tick(Player player, boolean enabled, int refreshThreshold, boolean particles, boolean icon) {
        if (!enabled || !hasFullSet(player)) return;
        FAArmorItem armor = (FAArmorItem) player.getItemBySlot(EquipmentSlot.HEAD).getItem();
        for (EffectEntry entry : armor.getFullSetEffects()) {
            var effect = BuiltInRegistries.MOB_EFFECT.get(Identifier.parse(entry.id()));
            if (effect.isEmpty()) continue;
            var existing = player.getEffect(effect.get());
            if (existing == null || EffectEntry.shouldRefresh(existing.getDuration(), refreshThreshold)) {
                player.addEffect(new MobEffectInstance(effect.get(), entry.duration(), entry.amplifier(), true, particles, icon));
            }
        }
    }

    private static boolean hasFullSet(Player player) {
        if (!(player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof FAArmorItem helmet)
                || !(player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof FAArmorItem chestplate)
                || !(player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof FAArmorItem leggings)
                || !(player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof FAArmorItem boots)) {
            return false;
        }
        return helmet.getArmorType() == net.minecraft.world.item.equipment.ArmorType.HELMET
                && chestplate.getArmorType() == net.minecraft.world.item.equipment.ArmorType.CHESTPLATE
                && leggings.getArmorType() == net.minecraft.world.item.equipment.ArmorType.LEGGINGS
                && boots.getArmorType() == net.minecraft.world.item.equipment.ArmorType.BOOTS
                && helmet.getArmorSet().equals(chestplate.getArmorSet())
                && helmet.getArmorSet().equals(leggings.getArmorSet())
                && helmet.getArmorSet().equals(boots.getArmorSet());
    }

    private ArmorSetEffects() {}
}
