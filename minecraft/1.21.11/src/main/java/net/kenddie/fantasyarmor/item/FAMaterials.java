package net.kenddie.fantasyarmor.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.ChatFormatting;
import java.util.function.Consumer;

public final class FAMaterials {
    public static Item create(Item.Properties properties) {
        return new Item(properties) {
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
                super.appendHoverText(stack, context, display, tooltip, flag);
                tooltip.accept(Component.translatable(getDescriptionId() + ".tooltip")
                        .withStyle(ChatFormatting.GRAY));
            }
        };
    }

    private FAMaterials() {}
}
