package net.kenddie.fantasyarmor.client.render;

import net.kenddie.fantasyarmor.client.model.FAArmorModel;
import net.kenddie.fantasyarmor.config.FAConfig;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.kenddie.fantasyarmor.shared.client.CapePhysics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib3.core.util.Color;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import software.bernie.geckolib3.util.GeoUtils;
import java.io.IOException;

public final class FAArmorRenderer extends GeoArmorRenderer<FAArmorItem> {
    private FAArmorItem current;
    private EntityLivingBase wearer;
    private ItemStack stack;
    private EntityEquipmentSlot slot;
    private boolean overlay;

    public FAArmorRenderer() { super(new FAArmorModel()); }

    @Override public void setCurrentItem(EntityLivingBase wearer, ItemStack stack, EntityEquipmentSlot slot) {
        super.setCurrentItem(wearer, stack, slot);
        this.wearer = wearer;
        this.stack = stack;
        this.slot = slot;
        this.current = (FAArmorItem) stack.getItem();
    }
    @Override public ResourceLocation getTextureLocation(FAArmorItem item) {
        return new ResourceLocation(ModConstants.MOD_ID, overlay ? item.getArmorSet().getOverlayPath() : item.getArmorSet().getTexturePath());
    }
    @Override public Color getRenderColor(FAArmorItem item, float partialTick) {
        return overlay ? Color.ofOpaque(item.getColor(stack)) : Color.WHITE;
    }
    @Override public void render(float partialTick) {
        GlStateManager.pushMatrix();
        try {
            // ModelBiped.render applies this translation outside the individual part poses.
            if (!isChild && wearer.isSneaking()) {
                GlStateManager.translate(0, 0.2f, 0);
            }
            super.render(partialTick);
            if (current.hasColor(stack) && hasOverlay()) {
                overlay = true;
                try { super.render(partialTick); }
                finally { overlay = false; }
            }
        } finally {
            GlStateManager.popMatrix();
        }
    }
    private boolean hasOverlay() {
        try (net.minecraft.client.resources.IResource resource = Minecraft.getMinecraft().getResourceManager().getResource(
                new ResourceLocation(ModConstants.MOD_ID, current.getArmorSet().getOverlayPath()))) {
            return true;
        } catch (IOException exception) { return false; }
    }
    @Override public void renderRecursively(BufferBuilder buffer, GeoBone bone, float red, float green, float blue, float alpha) {
        prepareBone(bone, Minecraft.getMinecraft().getRenderPartialTicks());
        super.renderRecursively(buffer, bone, red, green, blue, alpha);
    }

    private void prepareBone(GeoBone bone, float partialTick) {
        String name = bone.getName();
        switch (name) {
            case "armorHead": matchPart(bone, bipedHead, 0, 0); break;
            case "armorBody": matchPart(bone, bipedBody, 0, 0); break;
            case "armorRightArm": matchPart(bone, bipedRightArm, 5, 2); break;
            case "armorLeftArm": matchPart(bone, bipedLeftArm, -5, 2); break;
            case "armorRightLeg":
            case "armorRightBoot": matchPart(bone, bipedRightLeg, 2, 12); break;
            case "armorLeftLeg":
            case "armorLeftBoot": matchPart(bone, bipedLeftLeg, -2, 12); break;
            default: break;
        }
        if (name.equals("armorCape") || name.equals("armorCapeEpicFight")) {
            bone.setHidden(slot != EntityEquipmentSlot.CHEST || !FAConfig.showCapes || name.equals("armorCapeEpicFight"));
            if (name.equals("armorCape")) {
                applyCapeRotation(bone, partialTick);
                bone.setPositionX(bipedBody.rotationPointX);
                bone.setPositionY(wearer.isSneaking() ? bipedBody.rotationPointY - 3.5f : bipedBody.rotationPointY);
                bone.setPositionZ(bipedBody.rotationPointZ);
            }
        } else if (name.equals("armorBraid")) {
            bone.setHidden(slot != EntityEquipmentSlot.HEAD);
            applyCapeRotation(bone, partialTick);
            bone.setRotationX(CapePhysics.computeBraidAngle(bone.getRotationX(), wearer.rotationPitch, wearer.isSneaking()));
        } else if (name.equals("armorFrontCape")) {
            bone.setHidden(slot != EntityEquipmentSlot.CHEST);
            bone.setRotationX(CapePhysics.computeFrontCapeAngle(-bipedLeftLeg.rotateAngleX, -bipedRightLeg.rotateAngleX));
            bone.setPositionX(bipedLeftLeg.rotationPointX - 1.95f);
            bone.setPositionY(13 - bipedLeftLeg.rotationPointY);
            bone.setPositionZ(bipedLeftLeg.rotationPointZ - 0.3f);
        } else if (name.equals("armorLeftLegCloth") || name.equals("armorRightLegCloth")) {
            bone.setHidden(slot != EntityEquipmentSlot.CHEST);
            matchPart(bone, name.equals("armorLeftLegCloth") ? bipedLeftLeg : bipedRightLeg,
                    name.equals("armorLeftLegCloth") ? -2 : 2, 12);
        }
    }

    // Replace GeckoLib 3.0.30's incremental crouch offsets and attack scaling each frame.
    private static void matchPart(GeoBone bone, ModelRenderer part, float offsetX, float offsetY) {
        GeoUtils.copyRotations(part, bone);
        bone.setPositionX(part.rotationPointX + offsetX);
        bone.setPositionY(offsetY - part.rotationPointY);
        bone.setPositionZ(part.rotationPointZ);
        bone.setScaleX(bone.getInitialSnapshot().scaleValueX);
        bone.setScaleY(bone.getInitialSnapshot().scaleValueY);
        bone.setScaleZ(bone.getInitialSnapshot().scaleValueZ);
    }

    private void applyCapeRotation(GeoBone bone, float partialTick) {
        CapePhysics.CapeRotation rotation;
        if (wearer instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) wearer;
            double dx = MathHelper.clampedLerp(player.prevChasingPosX, player.chasingPosX, partialTick) - MathHelper.clampedLerp(player.prevPosX, player.posX, partialTick);
            double dy = MathHelper.clampedLerp(player.prevChasingPosY, player.chasingPosY, partialTick) - MathHelper.clampedLerp(player.prevPosY, player.posY, partialTick);
            double dz = MathHelper.clampedLerp(player.prevChasingPosZ, player.chasingPosZ, partialTick) - MathHelper.clampedLerp(player.prevPosZ, player.posZ, partialTick);
            float[] motion = CapePhysics.computeCapeMotion(dx, dy, dz,
                    player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * partialTick,
                    player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * partialTick,
                    player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * partialTick);
            rotation = CapePhysics.computeCapeRotation(motion[0], motion[1], motion[2]);
        } else {
            rotation = new CapePhysics.CapeRotation((float) -Math.toRadians(5), 0, 0);
        }
        bone.setRotationX(rotation.rotX());
        bone.setRotationY(rotation.rotY());
        bone.setRotationZ(rotation.rotZ());
    }
}
