package net.kenddie.fantasyarmor.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class FAClientConfig {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.BooleanValue SHOW_DESCRIPTIONS;
    public static final ForgeConfigSpec.BooleanValue SHOW_CAPES;
    public static final ForgeConfigSpec.BooleanValue EPIC_FIGHT_NOT_STATIC_CAPES;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        SHOW_DESCRIPTIONS = builder.define("showDescriptions", true);
        SHOW_CAPES = builder.define("showCapes", true);
        EPIC_FIGHT_NOT_STATIC_CAPES = builder.define("epicFightNotStaticCapes", false);
        SPEC = builder.build();
    }

    private static boolean value(ForgeConfigSpec.BooleanValue setting) {
        return SPEC.isLoaded() ? setting.get() : (Boolean) SPEC.getSpec().<ForgeConfigSpec.ValueSpec>get(setting.getPath()).getDefault();
    }

    public static boolean showDescriptions() { return value(SHOW_DESCRIPTIONS); }
    public static boolean showCapes() { return value(SHOW_CAPES); }
    public static boolean epicFightNotStaticCapes() { return value(EPIC_FIGHT_NOT_STATIC_CAPES); }

    private FAClientConfig() {}
}
