package net.kenddie.fantasyarmor.client.render;

import net.kenddie.fantasyarmor.shared.client.CapePhysics;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.util.GeoUtils;

public final class FARenderUtils {
    public static void prepareBone(IBone bone, LivingEntity entity, HumanoidModel<?> baseModel,
                                   EquipmentSlot slot, boolean showCapes, boolean epicCape, float partialTick) {
        String name = bone.getName();
        if (name.equals("armorCape") || name.equals("armorCapeEpicFight")) {
            bone.setHidden(slot != EquipmentSlot.CHEST || !showCapes
                    || name.equals("armorCapeEpicFight") != epicCape);
            if (name.equals("armorCape") && entity instanceof Player player) {
                applyCapeRotation(player, bone, partialTick);
            } else if (name.equals("armorCape")) {
                bone.setRotationX((float) -Math.toRadians(5));
                bone.setRotationY(0);
                bone.setRotationZ(0);
            }
        } else if (name.equals("armorBraid")) {
            bone.setHidden(slot != EquipmentSlot.HEAD);
            if (entity instanceof Player player) applyBraidRotation(player, bone, partialTick);
        } else if (name.equals("armorFrontCape") || name.equals("armorLeftLegCloth") || name.equals("armorRightLegCloth")) {
            bone.setHidden(slot != EquipmentSlot.CHEST);
        }
        if (name.equals("armorCape")) {
            bone.setPositionX(baseModel.body.x);
            bone.setPositionY(entity.isCrouching() ? baseModel.body.y - 3.5f : baseModel.body.y);
            bone.setPositionZ(baseModel.body.z);
        } else if (name.equals("armorFrontCape")) {
            bone.setRotationX(CapePhysics.computeFrontCapeAngle(-baseModel.leftLeg.xRot, -baseModel.rightLeg.xRot));
            bone.setPositionX(baseModel.leftLeg.x - 1.95f);
            bone.setPositionY(13 - baseModel.leftLeg.y);
            bone.setPositionZ(baseModel.leftLeg.z - 0.3f);
        } else if (name.equals("armorLeftLegCloth") || name.equals("armorRightLegCloth")) {
            var leg = name.equals("armorLeftLegCloth") ? baseModel.leftLeg : baseModel.rightLeg;
            GeoUtils.copyRotations(leg, bone);
            bone.setPositionX(leg.x + (name.equals("armorLeftLegCloth") ? -2 : 2));
            bone.setPositionY(12 - leg.y);
            bone.setPositionZ(leg.z);
        }
    }

    public static void applyCapeRotation(Player player, IBone bone, float partialTick) {
        double dx = Mth.lerp(partialTick, player.xCloakO, player.xCloak)
                - Mth.lerp(partialTick, player.xo, player.getX());
        double dy = Mth.lerp(partialTick, player.yCloakO, player.yCloak)
                - Mth.lerp(partialTick, player.yo, player.getY());
        double dz = Mth.lerp(partialTick, player.zCloakO, player.zCloak)
                - Mth.lerp(partialTick, player.zo, player.getZ());

        float bodyRot = Mth.rotLerp(partialTick, player.yBodyRotO, player.yBodyRot);
        float walkBob = Mth.lerp(partialTick, player.oBob, player.bob);
        float walkDist = Mth.lerp(partialTick, player.walkDistO, player.walkDist);

        float[] motion = CapePhysics.computeCapeMotion(dx, dy, dz, bodyRot, walkBob, walkDist);
        CapePhysics.CapeRotation rot = CapePhysics.computeCapeRotation(motion[0], motion[1], motion[2]);
        bone.setRotationX(rot.rotX());
        bone.setRotationY(rot.rotY());
        bone.setRotationZ(rot.rotZ());
    }

    public static void applyBraidRotation(Player player, IBone braid, float partialTick) {
        applyCapeRotation(player, braid, partialTick);
        braid.setRotationX(CapePhysics.computeBraidAngle(braid.getRotationX(), player.getXRot(), player.isCrouching()));
    }

    public static <T extends LivingEntity> void setArmsVisibility(PlayerModel<T> model, boolean visible) {
        model.rightArm.visible = visible;
        model.rightSleeve.visible = visible;
        model.leftArm.visible = visible;
        model.leftSleeve.visible = visible;
    }
}
