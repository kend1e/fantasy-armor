package net.kenddie.fantasyarmor.client.render;

import net.kenddie.fantasyarmor.shared.client.CapePhysics;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

import software.bernie.geckolib3.core.processor.IBone;

public final class FARenderUtils {
    public static void applyCapeRotation(PlayerEntity player, IBone bone, float partialTick) {
        double dx = MathHelper.lerp(partialTick, player.xCloakO, player.xCloak)
                - MathHelper.lerp(partialTick, player.xo, player.getX());
        double dy = MathHelper.lerp(partialTick, player.yCloakO, player.yCloak)
                - MathHelper.lerp(partialTick, player.yo, player.getY());
        double dz = MathHelper.lerp(partialTick, player.zCloakO, player.zCloak)
                - MathHelper.lerp(partialTick, player.zo, player.getZ());

        float bodyRot = MathHelper.rotLerp(partialTick, player.yBodyRotO, player.yBodyRot);
        float walkBob = MathHelper.lerp(partialTick, player.oBob, player.bob);
        float walkDist = MathHelper.lerp(partialTick, player.walkDistO, player.walkDist);

        float[] motion = CapePhysics.computeCapeMotion(dx, dy, dz, bodyRot, walkBob, walkDist);
        CapePhysics.CapeRotation rot = CapePhysics.computeCapeRotation(motion[0], motion[1], motion[2]);
        bone.setRotationX(rot.rotX());
        bone.setRotationY(rot.rotY());
        bone.setRotationZ(rot.rotZ());
    }

    public static void applyBraidRotation(PlayerEntity player, IBone braid, float partialTick) {
        applyCapeRotation(player, braid, partialTick);
        braid.setRotationX(CapePhysics.computeBraidAngle(braid.getRotationX(), player.xRot, player.isCrouching()));
    }

    public static <T extends LivingEntity> void setArmsVisibility(PlayerModel<T> model, boolean visible) {
        model.rightArm.visible = visible;
        model.rightSleeve.visible = visible;
        model.leftArm.visible = visible;
        model.leftSleeve.visible = visible;
    }
}
