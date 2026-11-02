package net.kenddie.fantasyarmor.test;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;

import static net.kenddie.fantasyarmor.test.TestSupport.*;

public final class DyeingTests {
    public static void run(GameTestHelper h) {
        for (var set : FAArmorSet.values()) {
            for (var piece : PIECES) {
                ItemStack original = stack(set.getName() + "_" + piece.getName());
                var armor = (FAArmorItem) original.getItem();
                check(h, MinecraftAccess.dyeable(original), "Armor must support vanilla dyeing");
                check(h, !armor.hasCustomColor(original), "New armor must not have custom color");
                var dyed = MinecraftAccess.dye(h, original);
                check(h, dyed.is(original.getItem()), "Dyeing must preserve armor identity");
                check(h, armor.hasCustomColor(dyed), "Vanilla dye crafting must set color");
                check(h, !armor.hasCustomColor(original), "Dye crafting must not mutate input");
                check(h, armor.getColor(dyed) == MinecraftAccess.redDyeColor(), "Dye color must follow vanilla red");
                ItemStack loaded = MinecraftAccess.roundTrip(h, dyed);
                check(h, armor.getColor(dyed) == armor.getColor(loaded) && armor.hasCustomColor(loaded),
                        "Color must survive save/load");
                armor.setColor(loaded, 0x123456);
                check(h, armor.getColor(loaded) == 0x123456, "Custom color accessor mismatch");
                loaded.setDamageValue(7);
                washInCauldron(h, loaded);
                check(h, loaded.is(original.getItem()) && loaded.getDamageValue() == 7,
                        "Washing must preserve armor identity and damage");
                check(h, !armor.hasCustomColor(loaded) && armor.getColor(loaded) == 0xA06540,
                        "Clearing color must restore default");
            }
        }
        h.succeed();
    }

    private static void washInCauldron(GameTestHelper h, ItemStack stack) {
        var pos = h.absolutePos(new net.minecraft.core.BlockPos(1, 1, 1));
        var level = h.getLevel();
        var state = net.minecraft.world.level.block.Blocks.WATER_CAULDRON.defaultBlockState()
                .setValue(net.minecraft.world.level.block.LayeredCauldronBlock.LEVEL, 3);
        level.setBlockAndUpdate(pos, state);
        var player = MinecraftAccess.player(h);
        player.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND, stack);
        var interaction = MinecraftAccess.cauldronInteraction(stack);
        check(h, interaction != null, "Armor must have a registered cauldron interaction");
        interaction.interact(state, level, pos, player, net.minecraft.world.InteractionHand.MAIN_HAND, stack);
        var washedState = level.getBlockState(pos);
        check(h, washedState.getValue(net.minecraft.world.level.block.LayeredCauldronBlock.LEVEL) == 2,
                "Washing must consume one water level");
        interaction.interact(washedState, level, pos, player, net.minecraft.world.InteractionHand.MAIN_HAND, stack);
        check(h, level.getBlockState(pos).equals(washedState), "Uncolored armor must not consume water");
    }

    private DyeingTests() {}
}
