package net.kenddie.fantasyarmor.client.model;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public final class FAArmorModel extends AnimatedGeoModel<FAArmorItem> {
    @Override public ResourceLocation getModelLocation(FAArmorItem item) {
        return new ResourceLocation(ModConstants.MOD_ID, "geo/" + item.getArmorSet().getGeoPath() + ".geo.json");
    }
    @Override public ResourceLocation getTextureLocation(FAArmorItem item) {
        return new ResourceLocation(ModConstants.MOD_ID, item.getArmorSet().getTexturePath());
    }
    @Override public ResourceLocation getAnimationFileLocation(FAArmorItem item) { return null; }
}
