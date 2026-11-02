package net.kenddie.fantasyarmor;

import net.fabricmc.api.ModInitializer;
import net.kenddie.fantasyarmor.config.FAConfigs;
import net.kenddie.fantasyarmor.item.FAArmorItems;
import net.kenddie.fantasyarmor.item.FACreativeModTabs;
import net.kenddie.fantasyarmor.item.FAItems;
import net.kenddie.fantasyarmor.item.armor.FAArmorEffectHandler;

public class FantasyArmor implements ModInitializer {
	public static final String MOD_ID = net.kenddie.fantasyarmor.shared.ModConstants.MOD_ID;

	@Override
	public void onInitialize() {
        FAConfigs.init();

        FAArmorItems.init();

		FAItems.register();
		FACreativeModTabs.register();
		FAArmorEffectHandler.register();
	}
}
