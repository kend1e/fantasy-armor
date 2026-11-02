package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.shared.ModConstants;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID)
public final class ArmorCauldronInteraction {
    @SubscribeEvent
    public static void wash(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        if (event.getEntityPlayer().isSneaking() || !(stack.getItem() instanceof FAArmorItem)) return;
        FAArmorItem armor = (FAArmorItem) stack.getItem();
        IBlockState state = event.getWorld().getBlockState(event.getPos());
        if (state.getBlock() != Blocks.CAULDRON || state.getValue(BlockCauldron.LEVEL) == 0 || !armor.hasColor(stack)) return;
        if (!event.getWorld().isRemote) {
            armor.removeColor(stack);
            ((BlockCauldron) state.getBlock()).setWaterLevel(event.getWorld(), event.getPos(), state, state.getValue(BlockCauldron.LEVEL) - 1);
            event.getEntityPlayer().addStat(StatList.ARMOR_CLEANED);
        }
        event.setCancellationResult(EnumActionResult.SUCCESS);
        event.setCanceled(true);
    }
    private ArmorCauldronInteraction() {}
}
