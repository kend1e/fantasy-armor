package net.kenddie.fantasyarmor.test;

import net.minecraft.resources.Identifier;

final class MinecraftAccess extends ComponentAccess {
    static Identifier id(String value) { return Identifier.parse(value); }
    private MinecraftAccess() {}
}
