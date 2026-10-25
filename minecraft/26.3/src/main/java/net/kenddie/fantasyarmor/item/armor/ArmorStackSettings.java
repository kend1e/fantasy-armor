package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

/** Applies server settings without resetting accumulated damage. */
public final class ArmorStackSettings {
    public static void apply(ItemStack stack, FAArmorAttributes attributes,
                             ItemAttributeModifiers modifiers, boolean durabilityEnabled) {
        if (!modifiers.equals(stack.get(DataComponents.ATTRIBUTE_MODIFIERS))) {
            stack.set(DataComponents.ATTRIBUTE_MODIFIERS, modifiers);
        }
        int durability = (int) attributes.durability();
        int maximum = Math.max(1, durability);
        if (stack.getOrDefault(DataComponents.MAX_DAMAGE, 0) != maximum) {
            stack.set(DataComponents.MAX_DAMAGE, maximum);
        }
        if (!stack.has(DataComponents.DAMAGE)) stack.set(DataComponents.DAMAGE, 0);
        if (durabilityEnabled && durability > 0) {
            stack.remove(DataComponents.UNBREAKABLE);
        } else if (!stack.has(DataComponents.UNBREAKABLE)) {
            stack.set(DataComponents.UNBREAKABLE, net.minecraft.util.Unit.INSTANCE);
        }
    }

    private ArmorStackSettings() {}
}
