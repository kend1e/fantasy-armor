package net.kenddie.fantasyarmor.client.render;

import net.kenddie.fantasyarmor.shared.ModConstants;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kenddie.fantasyarmor.client.model.FAArmorModel;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib3.core.util.Color;
import software.bernie.geckolib3.util.GeoUtils;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;
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
                .hasResource(new ResourceLocation(ModConstants.MOD_ID, currentArmorItem.getArmorSet().getOverlayPath()));
    }

    @Override
    public void renderRecursively(GeoBone bone, PoseStack poses, VertexConsumer buffer, int light,
                                  int overlayLight, float red, float green, float blue, float alpha) {
        String name = bone.getName();
        if (name.equals("armorCape") || name.equals("armorCapeEpicFight")) {
            bone.setHidden(armorSlot != EquipmentSlot.CHEST || !showCapes.getAsBoolean()
                    || name.equals("armorCapeEpicFight") != epicCape.getAsBoolean());
            if (name.equals("armorCape") && entityLiving instanceof Player) {
                FARenderUtils.applyCapeRotation((Player) entityLiving, bone, Minecraft.getInstance().getFrameTime());
            }
        } else if (name.equals("armorBraid")) {
            bone.setHidden(armorSlot != EquipmentSlot.HEAD);
            if (entityLiving instanceof Player) FARenderUtils.applyBraidRotation((Player) entityLiving, bone, Minecraft.getInstance().getFrameTime());
        } else if (name.equals("armorFrontCape") || name.equals("armorLeftLegCloth") || name.equals("armorRightLegCloth")) {
            bone.setHidden(armorSlot != EquipmentSlot.CHEST);
        }
        if (name.equals("armorCape")) {
            bone.setPositionX(baseModel.body.x);
            bone.setPositionY(entityLiving.isCrouching() ? baseModel.body.y - 3.5f : baseModel.body.y);
            bone.setPositionZ(baseModel.body.z);
        } else if (name.equals("armorFrontCape")) {
            bone.setRotationX(net.kenddie.fantasyarmor.shared.client.CapePhysics.computeFrontCapeAngle(-baseModel.leftLeg.xRot, -baseModel.rightLeg.xRot));
            bone.setPositionX(baseModel.leftLeg.x - 1.95f);
            bone.setPositionY(13 - baseModel.leftLeg.y);
            bone.setPositionZ(baseModel.leftLeg.z - 0.3f);
        } else if (name.equals("armorLeftLegCloth") || name.equals("armorRightLegCloth")) {
            net.minecraft.client.model.geom.ModelPart leg = name.equals("armorLeftLegCloth") ? baseModel.leftLeg : baseModel.rightLeg;
            GeoUtils.copyRotations(leg, bone);
            bone.setPositionX(leg.x + (name.equals("armorLeftLegCloth") ? -2 : 2));
            bone.setPositionY(12 - leg.y);
            bone.setPositionZ(leg.z);
        }
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
