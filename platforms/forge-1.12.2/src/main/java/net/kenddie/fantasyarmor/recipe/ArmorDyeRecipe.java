package net.kenddie.fantasyarmor.recipe;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID)
public final class ArmorDyeRecipe extends RecipesArmorDyes {
    @SubscribeEvent
    public static void register(RegistryEvent.Register<IRecipe> event) {
        event.getRegistry().register(new ArmorDyeRecipe().setRegistryName(ModConstants.MOD_ID, "armor_dyeing"));
    }

    @Override public boolean matches(InventoryCrafting input, World world) {
        return !armor(input).isEmpty() && super.matches(leatherInput(input), world);
    }

    @Override public ItemStack getCraftingResult(InventoryCrafting input) {
        ItemStack armor = armor(input);
        if (armor.isEmpty()) return ItemStack.EMPTY;
        ItemStack dyed = super.getCraftingResult(leatherInput(input));
        if (dyed.isEmpty()) return ItemStack.EMPTY;
        ItemStack result = armor.copy();
        result.setCount(1);
        ((FAArmorItem) result.getItem()).setColor(result, Items.LEATHER_CHESTPLATE.getColor(dyed));
        return result;
    }

    private static ItemStack armor(InventoryCrafting input) {
        ItemStack result = ItemStack.EMPTY;
        for (int slot = 0; slot < input.getSizeInventory(); slot++) {
            ItemStack stack = input.getStackInSlot(slot);
            if (stack.getItem() instanceof FAArmorItem) {
                if (!result.isEmpty()) return ItemStack.EMPTY;
                result = stack;
            }
        }
        return result;
    }

    private static InventoryCrafting leatherInput(InventoryCrafting input) {
        InventoryCrafting copy = new InventoryCrafting(new Container() {
            @Override public boolean canInteractWith(EntityPlayer player) { return true; }
        }, input.getWidth(), input.getHeight());
        for (int slot = 0; slot < input.getSizeInventory(); slot++) {
            ItemStack stack = input.getStackInSlot(slot);
            if (stack.getItem() instanceof FAArmorItem) {
                ItemStack leather = new ItemStack(Items.LEATHER_CHESTPLATE);
                if (((FAArmorItem) stack.getItem()).hasColor(stack)) Items.LEATHER_CHESTPLATE.setColor(leather, ((FAArmorItem) stack.getItem()).getColor(stack));
                stack = leather;
            }
            copy.setInventorySlotContents(slot, stack.copy());
        }
        return copy;
    }
}
