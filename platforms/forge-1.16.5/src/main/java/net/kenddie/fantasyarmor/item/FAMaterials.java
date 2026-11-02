package net.kenddie.fantasyarmor.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.TextFormatting;
import java.util.List;

public final class FAMaterials {
    public static Item create(Item.Properties properties) {
        return new Item(properties) {
            @Override
            public void appendHoverText(ItemStack stack, World level, List<ITextComponent> tooltip, ITooltipFlag flag) {
                super.appendHoverText(stack, level, tooltip, flag);
                tooltip.add(new net.minecraft.util.text.TranslationTextComponent(getDescriptionId() + ".tooltip")
                        .withStyle(TextFormatting.GRAY));
            }
        };
    }

    private FAMaterials() {}
}
