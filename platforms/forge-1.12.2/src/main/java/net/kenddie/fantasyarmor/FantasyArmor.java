package net.kenddie.fantasyarmor;

import net.kenddie.fantasyarmor.config.FAConfig;
import net.kenddie.fantasyarmor.config.ConfigSync;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModConstants.MOD_ID, name = "Fantasy Armor", useMetadata = true,
        acceptedMinecraftVersions = "[1.12.2,1.13)")
public final class FantasyArmor {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FAConfig.load(event.getSuggestedConfigurationFile());
        ConfigSync.register();
        software.bernie.geckolib3.GeckoLib.initialize();
    }
}
