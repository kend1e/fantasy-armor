package net.kenddie.fantasyarmor.test;

import net.kenddie.fantasyarmor.item.armor.ArmorSetEffects;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import static net.kenddie.fantasyarmor.test.TestSupport.*;

public final class InfiniteEffectTests {
    public static void run(GameTestHelper h) {
        var player = player(h);
        player.addEffect(new MobEffectInstance(MinecraftAccess.STRENGTH, -1, 0));
        equip(player, "eclipse_soldier");
        ArmorSetEffects.tick(player, true, 241, false, true);
        check(h, player.getEffect(MinecraftAccess.STRENGTH).getDuration() == -1, "Infinite effect must not be replaced");
        player.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
        ArmorSetEffects.tick(player, false, 241, false, true);
        check(h, player.getEffect(MinecraftAccess.STRENGTH).getDuration() == -1, "Disabling effects must retain existing infinite effect");
        h.succeed();
    }
    private InfiniteEffectTests() {}
}
