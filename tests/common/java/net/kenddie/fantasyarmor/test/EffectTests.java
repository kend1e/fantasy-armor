package net.kenddie.fantasyarmor.test;

import net.kenddie.fantasyarmor.item.armor.ArmorSetEffects;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

import static net.kenddie.fantasyarmor.test.TestSupport.*;

public final class EffectTests {
    public static void run(GameTestHelper h) {
        var player = player(h);
        equip(player, "eclipse_soldier");
        ArmorSetEffects.tick(player, true, 241, false, true);
        var entry = ((FAArmorItem) player.getItemBySlot(EquipmentSlot.HEAD).getItem()).getFullSetEffects().stream()
                .filter(e -> e.id().equals("minecraft:strength")).findFirst().orElseThrow();
        var effect = player.getEffect(MinecraftAccess.STRENGTH);
        check(h, effect != null && effect.getDuration() == entry.duration() && effect.getAmplifier() == entry.amplifier(),
                "Configured duration and amplifier must be applied");
        check(h, !effect.isVisible() && effect.showIcon(), "Particle/icon flags must be applied");
        player.addEffect(new MobEffectInstance(MinecraftAccess.STRENGTH, 500, entry.amplifier()));
        ArmorSetEffects.tick(player, true, 241, true, false);
        check(h, player.getEffect(MinecraftAccess.STRENGTH).getDuration() == 500, "Long effect must not be refreshed");
        player.removeEffect(MinecraftAccess.STRENGTH);
        player.addEffect(new MobEffectInstance(MinecraftAccess.STRENGTH, 241, entry.amplifier()));
        ArmorSetEffects.tick(player, true, 241, true, false);
        check(h, player.getEffect(MinecraftAccess.STRENGTH).getDuration() == 241, "Threshold is strict: equal duration must not refresh");
        player.removeEffect(MinecraftAccess.STRENGTH);
        player.addEffect(new MobEffectInstance(MinecraftAccess.STRENGTH, 240, entry.amplifier()));
        ArmorSetEffects.tick(player, true, 241, true, false);
        check(h, player.getEffect(MinecraftAccess.STRENGTH).getDuration() == entry.duration(), "Short effect must refresh");
        check(h, player.getEffect(MinecraftAccess.STRENGTH).isVisible()
                && !player.getEffect(MinecraftAccess.STRENGTH).showIcon(), "Refreshed effect must use requested particle/icon flags");
        player.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
        int remaining = player.getEffect(MinecraftAccess.STRENGTH).getDuration();
        ArmorSetEffects.tick(player, true, 241, false, true);
        check(h, player.getEffect(MinecraftAccess.STRENGTH).getDuration() == remaining, "Removing a piece must retain existing effect");
        player.removeEffect(MinecraftAccess.STRENGTH);
        player.addEffect(new MobEffectInstance(MinecraftAccess.STRENGTH, 2, entry.amplifier()));
        for (int tick = 0; tick < 3; tick++) {
            ArmorSetEffects.tick(player, true, 241, false, true);
            player.tick();
        }
        check(h, !player.hasEffect(MinecraftAccess.STRENGTH), "Effect must expire naturally without a full set");
        h.succeed();
    }

    private EffectTests() {}
}
