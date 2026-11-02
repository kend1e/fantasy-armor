package net.kenddie.fantasyarmor.client.render;

import net.kenddie.fantasyarmor.shared.ModConstants;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kenddie.fantasyarmor.client.model.FAArmorModel;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.util.Color;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import java.util.function.BooleanSupplier;

public final class FAArmorRenderer extends GeoArmorRenderer<FAArmorItem> {
    private final BooleanSupplier showCapes;
    private final BooleanSupplier epicCape;
    private boolean overlay;

    public FAArmorRenderer(BooleanSupplier showCapes, BooleanSupplier epicCape) {
        super(new FAArmorModel<>());
        this.showCapes = showCapes;
        this.epicCape = epicCape;
    }

    @Override
    public ResourceLocation getTextureLocation(FAArmorItem item) {
        return new ResourceLocation(ModConstants.MOD_ID, overlay ? item.getArmorSet().getOverlayPath() : item.getArmorSet().getTexturePath());
    }

    @Override
    public Color getRenderColor(FAArmorItem item, float partialTick, PoseStack poses,
                                MultiBufferSource buffers, VertexConsumer buffer, int light) {
        return overlay ? Color.ofOpaque(item.getColor(itemStack)) : Color.WHITE;
    }

    private VertexConsumer getLayerBuffer() {
        return ItemRenderer.getArmorFoilBuffer(Minecraft.getInstance().renderBuffers().bufferSource(),
                RenderType.armorCutoutNoCull(getTextureLocation(currentArmorItem)), false, itemStack.hasFoil());
    }

    private boolean hasOverlay() {
        return currentArmorItem.hasCustomColor(itemStack) && Minecraft.getInstance().getResourceManager()
                .getResource(new ResourceLocation(ModConstants.MOD_ID, currentArmorItem.getArmorSet().getOverlayPath())).isPresent();
    }

    @Override
    public void renderRecursively(GeoBone bone, PoseStack poses, VertexConsumer buffer, int light,
                                  int overlayLight, float red, float green, float blue, float alpha) {
        FARenderUtils.prepareBone(bone, entityLiving, this, armorSlot,
                showCapes.getAsBoolean(), epicCape.getAsBoolean(), Minecraft.getInstance().getFrameTime());
        super.renderRecursively(bone, poses, buffer, light, overlayLight, red, green, blue, alpha);
    }
    @Override
    public void render(float partialTick, PoseStack poses, VertexConsumer buffer, int light) {
        super.render(partialTick, poses, getLayerBuffer(), light);
        if (hasOverlay()) {
            overlay = true;
            try { super.render(partialTick, poses, getLayerBuffer(), light); }
            finally { overlay = false; }
        }
    }
}
