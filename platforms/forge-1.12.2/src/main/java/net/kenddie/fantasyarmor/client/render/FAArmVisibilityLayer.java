package net.kenddie.fantasyarmor.client.render;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;

final class FAArmVisibilityLayer implements LayerRenderer<AbstractClientPlayer> {
    private static final Map<RenderPlayer, FAArmVisibilityLayer> LAYERS = new WeakHashMap<>();
    private ModelPlayer model;
    private boolean rightArm;
    private boolean leftArm;
    private boolean rightSleeve;
    private boolean leftSleeve;

    static void hideArms(RenderPlayer renderer) {
        if (!LAYERS.containsKey(renderer)) {
            FAArmVisibilityLayer layer = null;
            try {
                List<LayerRenderer<AbstractClientPlayer>> layers = ObfuscationReflectionHelper.getPrivateValue(
                        RenderLivingBase.class, renderer, "field_177097_h");
                layer = new FAArmVisibilityLayer();
                // The body has already been drawn when the first layer runs.
                layers.add(0, layer);
            } catch (RuntimeException exception) {
                layer = null;
                LogManager.getLogger(ModConstants.MOD_ID).warn(
                        "Cannot install arm visibility layer; leaving player arms visible", exception);
            }
            LAYERS.put(renderer, layer);
        }
        FAArmVisibilityLayer layer = LAYERS.get(renderer);
        if (layer == null) return;
        layer.restore();
        layer.model = renderer.getMainModel();
        layer.rightArm = layer.model.bipedRightArm.showModel;
        layer.leftArm = layer.model.bipedLeftArm.showModel;
        layer.rightSleeve = layer.model.bipedRightArmwear.showModel;
        layer.leftSleeve = layer.model.bipedLeftArmwear.showModel;
        layer.model.bipedRightArm.showModel = false;
        layer.model.bipedLeftArm.showModel = false;
        layer.model.bipedRightArmwear.showModel = false;
        layer.model.bipedLeftArmwear.showModel = false;
    }

    static void restoreArms(RenderPlayer renderer) {
        FAArmVisibilityLayer layer = LAYERS.get(renderer);
        if (layer != null) layer.restore();
    }

    private void restore() {
        if (model == null) return;
        model.bipedRightArm.showModel = rightArm;
        model.bipedLeftArm.showModel = leftArm;
        model.bipedRightArmwear.showModel = rightSleeve;
        model.bipedLeftArmwear.showModel = leftSleeve;
        model = null;
    }

    @Override
    public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                              float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
        restore();
    }

    @Override public boolean shouldCombineTextures() { return false; }
}
