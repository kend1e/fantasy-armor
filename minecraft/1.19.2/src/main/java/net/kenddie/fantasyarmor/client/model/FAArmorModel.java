package net.kenddie.fantasyarmor.client.model;

import net.kenddie.fantasyarmor.shared.ModConstants;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FAArmorModel <T extends FAArmorItem> extends AnimatedGeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(ModConstants.MOD_ID, "geo/" + animatable.getArmorSet().getGeoPath() + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return new ResourceLocation(ModConstants.MOD_ID, animatable.getArmorSet().getTexturePath());
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return null;
    }
}
