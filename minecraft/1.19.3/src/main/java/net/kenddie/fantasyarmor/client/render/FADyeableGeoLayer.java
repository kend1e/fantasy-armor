package net.kenddie.fantasyarmor.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import org.jetbrains.annotations.Nullable;
import java.util.Map;

public class FADyeableGeoLayer<T extends FAArmorItem> extends GeoRenderLayer<T> {
    protected static final Map<String, ResourceLocation> ARMOR_PATH_CACHE = new Object2ObjectOpenHashMap<>();

    public FADyeableGeoLayer(FAArmorRenderer<T> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel,
                       RenderType baseRenderType, MultiBufferSource bufferSource,
                       VertexConsumer buffer, float partialTick,
                       int packedLight, int packedOverlay) {
        if (animatable == null) return;
        ResourceLocation textureResLoc = getArmorResource(animatable);

        FAArmorRenderer<T> armorRenderer = (FAArmorRenderer<T>) this.renderer;
        ItemStack armorItemStack = armorRenderer.getCurrentStack();

        if (!animatable.hasCustomColor(armorItemStack)) return;

        int color = animatable.getColor(armorItemStack);
        float r = ((color >> 16) & 255) / 255f;
        float g = ((color >> 8) & 255) / 255f;
        float b = (color & 255) / 255f;

        VertexConsumer vertexConsumer = getArmorBuffer(bufferSource, null, textureResLoc, armorItemStack.hasFoil());
        this.renderer.reRender(
                bakedModel,
                poseStack,
                bufferSource,
                animatable,
                baseRenderType,
                vertexConsumer,
                partialTick,
                packedLight,
                packedOverlay,
                r, g, b, 1.0f
        );
    }

    public ResourceLocation getArmorResource(FAArmorItem armorItem) {
        String texture = ModConstants.MOD_ID + ":" + armorItem.getArmorSet().getOverlayPath();

        return ARMOR_PATH_CACHE.computeIfAbsent(texture, ResourceLocation::new);
    }

    protected VertexConsumer getArmorBuffer(MultiBufferSource bufferSource, @Nullable RenderType renderType, @Nullable ResourceLocation texturePath, boolean enchanted) {
        if (renderType == null)
            renderType = RenderType.armorCutoutNoCull(texturePath);

        return ItemRenderer.getArmorFoilBuffer(bufferSource, renderType, false, enchanted);
    }
}
