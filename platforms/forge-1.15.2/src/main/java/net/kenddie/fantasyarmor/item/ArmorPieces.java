package net.kenddie.fantasyarmor.item;

import net.minecraft.inventory.EquipmentSlotType;

public final class ArmorPieces {
    public static String name(EquipmentSlotType slot) {
        switch (slot) {
            case HEAD: return "helmet";
            case CHEST: return "chestplate";
            case LEGS: return "leggings";
            case FEET: return "boots";
            default: throw new IllegalArgumentException("Not an armor slot: " + slot);
        }
    }
    private ArmorPieces() {}
}
