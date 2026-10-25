package net.kenddie.fantasyarmor;

import net.kenddie.fantasyarmor.config.FAClientConfig;
import net.kenddie.fantasyarmor.config.*;
import net.kenddie.fantasyarmor.item.FAArmorItems;
import net.kenddie.fantasyarmor.item.FACreativeModTabs;
import net.kenddie.fantasyarmor.item.FAItems;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FantasyArmor.MOD_ID)
public class FantasyArmor {
    public static final String MOD_ID = net.kenddie.fantasyarmor.shared.ModConstants.MOD_ID;
    public static final String EPIC_FIGHT_MOD_ID = "epicfight";
    public static boolean isEpicFightLoaded;

    public FantasyArmor(FMLJavaModLoadingContext context) {
        var modBus = context.getModBusGroup();
        context.registerConfig(ModConfig.Type.SERVER, FAConfig.SPEC, "fantasy_armor-server.toml");
        context.registerConfig(ModConfig.Type.SERVER, FAArmorConfig.SPEC, "fantasy_armor-armor_attributes.toml");
        context.registerConfig(ModConfig.Type.SERVER, FAArmorEffectsConfig.SPEC, "fantasy_armor-armor_effects.toml");
        context.registerConfig(ModConfig.Type.CLIENT, FAClientConfig.SPEC, "fantasy_armor-client.toml");
        FAItems.register(modBus);
        FAArmorItems.register(modBus);
        FACreativeModTabs.register(modBus);
        isEpicFightLoaded = ModList.isLoaded(EPIC_FIGHT_MOD_ID);
    }
}
