package net.kenddie.fantasyarmor.item.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.util.Util;
import java.util.Map;
import java.util.EnumMap;
import java.util.UUID;

public final class ArmorModifiers {
    private static final Map<EquipmentSlotType, UUID> ARMOR_MODIFIER_UUID_PER_TYPE = Util.make(new EnumMap<>(EquipmentSlotType.class), (map) -> {
        map.put(EquipmentSlotType.FEET, UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"));
        map.put(EquipmentSlotType.LEGS, UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"));
        map.put(EquipmentSlotType.CHEST, UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"));
        map.put(EquipmentSlotType.HEAD, UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"));
    });

    public static Multimap<Attribute, AttributeModifier> build(EquipmentSlotType type, FAArmorAttributes armorAttributes) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        UUID uuid = ARMOR_MODIFIER_UUID_PER_TYPE.get(type);

        if (armorAttributes.armor() != 0) {
            builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor", armorAttributes.armor(), AttributeModifier.Operation.ADDITION));
        }
        if (armorAttributes.armorToughness() != 0) {
            builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", armorAttributes.armorToughness(), AttributeModifier.Operation.ADDITION));
        }
        if (armorAttributes.knockbackResistance() != 0) {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", armorAttributes.knockbackResistance(), AttributeModifier.Operation.ADDITION));
        }
        if (armorAttributes.movementSpeed() != 0) {
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Armor movement speed", armorAttributes.movementSpeed(), AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        if (armorAttributes.maxHealth() != 0) {
            builder.put(Attributes.MAX_HEALTH, new AttributeModifier(uuid, "Armor health gain", armorAttributes.maxHealth(), AttributeModifier.Operation.ADDITION));
        }
        if (armorAttributes.attackDamage() != 0) {
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, "Armor attack damage", armorAttributes.attackDamage(), AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        if (armorAttributes.attackSpeed() != 0) {
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, "Armor attack speed", armorAttributes.attackSpeed(), AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        if (armorAttributes.luck() != 0) {
            builder.put(Attributes.LUCK, new AttributeModifier(uuid, "Armor luck", armorAttributes.luck(), AttributeModifier.Operation.ADDITION));
        }

        return builder.build();
    }

    private ArmorModifiers() {}
}
