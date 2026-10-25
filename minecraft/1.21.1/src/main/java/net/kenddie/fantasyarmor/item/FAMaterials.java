package net.kenddie.fantasyarmor.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.ChatFormatting;
import java.util.List;

public final class FAMaterials {
    public static Item create(Item.Properties properties) {
        return new Item(properties) {
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
                super.appendHoverText(stack, context, tooltip, flag);
                tooltip.add(Component.translatable(getDescriptionId() + ".tooltip")
                        .withStyle(ChatFormatting.GRAY));
            }
        };
    }

    private FAMaterials() {}
}
