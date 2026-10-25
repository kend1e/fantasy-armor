package net.kenddie.fantasyarmor.test;

import net.minecraftforge.fml.config.ConfigTracker;
import net.minecraftforge.fml.config.ModConfig;
import java.util.Set;

final class ConfigRegistry {
    static Set<ModConfig> serverConfigs() { return ConfigTracker.configSets().get(ModConfig.Type.SERVER); }
    private ConfigRegistry() {}
}
