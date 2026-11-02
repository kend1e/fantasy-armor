package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.config.FAConfig;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID)
public final class ArmorSetEffects {
    @SubscribeEvent
    public static void tick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START || event.player.world.isRemote || !FAConfig.effects()) return;
        EntityPlayer player = event.player;
        FAArmorItem first = null;
        for (EntityEquipmentSlot slot : new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET}) {
            if (!(player.getItemStackFromSlot(slot).getItem() instanceof FAArmorItem)) return;
            FAArmorItem piece = (FAArmorItem) player.getItemStackFromSlot(slot).getItem();
            if (piece.armorType != slot || first != null && !first.getArmorSet().equals(piece.getArmorSet())) return;
            first = piece;
        }
        for (EffectEntry entry : FAConfig.effects(first.getArmorSet())) {
            Potion effect = Potion.getPotionFromResourceLocation(entry.id());
            if (effect == null) continue;
            PotionEffect current = player.getActivePotionEffect(effect);
            if (current == null || EffectEntry.shouldRefresh(current.getDuration(), FAConfig.threshold())) {
                int duration = entry.duration() == -1 ? Integer.MAX_VALUE : entry.duration();
                player.addPotionEffect(new PotionEffect(effect, duration, entry.amplifier(), true, FAConfig.particles()));
            }
        }
    }
    private ArmorSetEffects() {}
}
