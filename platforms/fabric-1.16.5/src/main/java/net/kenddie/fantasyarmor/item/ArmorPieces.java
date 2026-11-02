package net.kenddie.fantasyarmor.item;

import net.minecraft.world.entity.EquipmentSlot;

public final class ArmorPieces {
    public static String name(EquipmentSlot slot) {
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
