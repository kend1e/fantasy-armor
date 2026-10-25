package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;

public final class ArmorModifiers {
    public static ItemAttributeModifiers build(ArmorType armorType, FAArmorAttributes armorAttributes) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();

        EquipmentSlotGroup slotGroup = EquipmentSlotGroup.bySlot(armorType.getSlot());
        String slotName = armorType.getName();

        add(builder, slotGroup, slotName + "_armor", Attributes.ARMOR,
                armorAttributes.armor(), AttributeModifier.Operation.ADD_VALUE);

        add(builder, slotGroup, slotName + "_armor_toughness", Attributes.ARMOR_TOUGHNESS,
                armorAttributes.armorToughness(), AttributeModifier.Operation.ADD_VALUE);

        add(builder, slotGroup, slotName + "_knockback", Attributes.KNOCKBACK_RESISTANCE,
                armorAttributes.knockbackResistance(), AttributeModifier.Operation.ADD_VALUE);

        add(builder, slotGroup, slotName + "_speed", Attributes.MOVEMENT_SPEED,
                armorAttributes.movementSpeed(), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

        add(builder, slotGroup, slotName + "_health", Attributes.MAX_HEALTH,
                armorAttributes.maxHealth(), AttributeModifier.Operation.ADD_VALUE);

        add(builder, slotGroup, slotName + "_attack_damage", Attributes.ATTACK_DAMAGE,
                armorAttributes.attackDamage(), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

        add(builder, slotGroup, slotName + "_attack_speed", Attributes.ATTACK_SPEED,
                armorAttributes.attackSpeed(), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

        add(builder, slotGroup, slotName + "_luck", Attributes.LUCK,
                armorAttributes.luck(), AttributeModifier.Operation.ADD_VALUE);

        return builder.build();
    }

    private static void add(ItemAttributeModifiers.Builder builder, EquipmentSlotGroup slot, String id,
                            Holder<Attribute> attribute, double amount, AttributeModifier.Operation operation) {
        if (amount != 0) {
            builder.add(attribute, new AttributeModifier(
                    Identifier.fromNamespaceAndPath(ModConstants.MOD_ID, id), amount, operation), slot);
        }
    }

    private ArmorModifiers() {}
}
