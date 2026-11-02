package net.kenddie.fantasyarmor.item.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.EnumMap;
import java.util.UUID;

public final class ArmorModifiers {
    private static final Map<EntityEquipmentSlot, UUID> ARMOR_MODIFIER_UUID_PER_TYPE = new EnumMap<>(EntityEquipmentSlot.class);
    static {
        ARMOR_MODIFIER_UUID_PER_TYPE.put(EntityEquipmentSlot.FEET, UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"));
        ARMOR_MODIFIER_UUID_PER_TYPE.put(EntityEquipmentSlot.LEGS, UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"));
        ARMOR_MODIFIER_UUID_PER_TYPE.put(EntityEquipmentSlot.CHEST, UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"));
        ARMOR_MODIFIER_UUID_PER_TYPE.put(EntityEquipmentSlot.HEAD, UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"));
    }

    public static Multimap<String, AttributeModifier> build(EntityEquipmentSlot type, FAArmorAttributes armorAttributes) {
        ImmutableMultimap.Builder<String, AttributeModifier> builder = ImmutableMultimap.builder();

        UUID uuid = ARMOR_MODIFIER_UUID_PER_TYPE.get(type);

        if (armorAttributes.armor() != 0) {
            builder.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(uuid, "Armor", armorAttributes.armor(), 0));
        }
        if (armorAttributes.armorToughness() != 0) {
            builder.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(uuid, "Armor toughness", armorAttributes.armorToughness(), 0));
        }
        if (armorAttributes.knockbackResistance() != 0) {
            builder.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(uuid, "Armor knockback resistance", armorAttributes.knockbackResistance(), 0));
        }
        if (armorAttributes.movementSpeed() != 0) {
            builder.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(uuid, "Armor movement speed", armorAttributes.movementSpeed(), 2));
        }
        if (armorAttributes.maxHealth() != 0) {
            builder.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(uuid, "Armor health gain", armorAttributes.maxHealth(), 0));
        }
        if (armorAttributes.attackDamage() != 0) {
            builder.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(uuid, "Armor attack damage", armorAttributes.attackDamage(), 2));
        }
        if (armorAttributes.attackSpeed() != 0) {
            builder.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(uuid, "Armor attack speed", armorAttributes.attackSpeed(), 2));
        }
        if (armorAttributes.luck() != 0) {
            builder.put(SharedMonsterAttributes.LUCK.getName(), new AttributeModifier(uuid, "Armor luck", armorAttributes.luck(), 0));
        }

        return builder.build();
    }

    private ArmorModifiers() {}
}
