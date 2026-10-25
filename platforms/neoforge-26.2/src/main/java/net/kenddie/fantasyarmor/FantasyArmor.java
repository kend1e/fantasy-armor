package net.kenddie.fantasyarmor;

import net.kenddie.fantasyarmor.config.FAArmorConfig;
import net.kenddie.fantasyarmor.config.FAArmorEffectsConfig;
import net.kenddie.fantasyarmor.config.FAConfig;
import net.kenddie.fantasyarmor.item.FAArmorItems;
import net.kenddie.fantasyarmor.item.FACreativeModTabs;
import net.kenddie.fantasyarmor.item.FAItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;

@Mod(FantasyArmor.MOD_ID)
public class FantasyArmor {

    public static final String MOD_ID = net.kenddie.fantasyarmor.shared.ModConstants.MOD_ID;
    public static final String EPIC_FIGHT_MOD_ID = "epicfight";
    public static boolean isEpicFightLoaded;

    public FantasyArmor(IEventBus modEventBus, ModContainer modContainer) {

        modContainer.registerConfig(ModConfig.Type.SERVER, FAConfig.SPEC, "fantasy_armor-server.toml");
        modContainer.registerConfig(ModConfig.Type.CLIENT, FAConfig.CLIENT_SPEC, "fantasy_armor-client.toml");
        modContainer.registerConfig(ModConfig.Type.SERVER, FAArmorConfig.SPEC, "fantasy_armor-armor_attributes.toml");
        modContainer.registerConfig(ModConfig.Type.SERVER, FAArmorEffectsConfig.SPEC, "fantasy_armor-armor_effects.toml");

        FAItems.register(modEventBus);
        FAArmorItems.register(modEventBus);
        FACreativeModTabs.register(modEventBus);

        isEpicFightLoaded = ModList.get().isLoaded(EPIC_FIGHT_MOD_ID);

        modEventBus.addListener(this::onConfigLoad);
        modEventBus.addListener(this::onConfigReload);
        modEventBus.addListener(this::onConfigUnload);
    }

    @SubscribeEvent
    public void onConfigLoad(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == FAConfig.CLIENT_SPEC) {
            FAConfig.applyClientValues();
        }
        if (event.getConfig().getSpec() == FAConfig.SPEC) {
            FAConfig.applyConfigValues();
        }
    }

    @SubscribeEvent
    public void onConfigReload(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == FAConfig.CLIENT_SPEC) {
            FAConfig.applyClientValues();
        }
        if (event.getConfig().getSpec() == FAConfig.SPEC) {
            FAConfig.applyConfigValues();
        }
    }
    private void onConfigUnload(final ModConfigEvent.Unloading event) {
        if (event.getConfig().getSpec() == FAConfig.SPEC) FAConfig.resetServerValues();
    }
}
