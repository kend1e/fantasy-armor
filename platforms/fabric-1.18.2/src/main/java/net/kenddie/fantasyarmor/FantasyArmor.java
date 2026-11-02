package net.kenddie.fantasyarmor;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.kenddie.fantasyarmor.config.FAConfigs;
import net.kenddie.fantasyarmor.item.FAArmorItems;
import net.kenddie.fantasyarmor.item.FACreativeModTabs;
import net.kenddie.fantasyarmor.item.FAItems;
import net.kenddie.fantasyarmor.item.armor.FAArmorEffectHandler;
import org.slf4j.Logger;

public class FantasyArmor implements ModInitializer {
	public static final String MOD_ID = net.kenddie.fantasyarmor.shared.ModConstants.MOD_ID;
	public static final Logger LOGGER = LogUtils.getLogger();

	@Override
	public void onInitialize() {
        FAConfigs.init();

        FAArmorItems.init();

		FAItems.register();
		FACreativeModTabs.register();
		FAArmorEffectHandler.register();
	}
}
