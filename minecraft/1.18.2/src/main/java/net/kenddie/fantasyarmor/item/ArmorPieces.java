package net.kenddie.fantasyarmor.item;

import net.minecraft.world.entity.EquipmentSlot;

public final class ArmorPieces {
    public static String name(EquipmentSlot slot) {
        return switch (slot) {
            case HEAD -> "helmet";
            case CHEST -> "chestplate";
            case LEGS -> "leggings";
            case FEET -> "boots";
            default -> throw new IllegalArgumentException("Not an armor slot: " + slot);
        };
    }
    private ArmorPieces() {}
}
