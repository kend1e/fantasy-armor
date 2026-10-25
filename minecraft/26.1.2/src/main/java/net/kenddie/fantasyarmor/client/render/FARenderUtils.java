package net.kenddie.fantasyarmor.client.render;

import net.kenddie.fantasyarmor.shared.client.CapePhysics;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.jetbrains.annotations.Nullable;
import com.geckolib.animation.state.BoneSnapshot;

public final class FARenderUtils {

    /** Reuses vanilla cape motion captured in the avatar render state. */
    public static void applyCapeRotation(AvatarRenderState state, BoneSnapshot bone) {
        CapePhysics.CapeRotation rot = CapePhysics.computeCapeRotation(
                state.capeFlap, state.capeLean, state.capeLean2);
        bone.setRotation(rot.rotX(), rot.rotY(), rot.rotZ());
    }

    public static void setFrontLegCapeAngle(@Nullable BoneSnapshot leftLeg, @Nullable BoneSnapshot rightLeg, BoneSnapshot frontCape) {
        if (leftLeg == null || rightLeg == null) return;

        frontCape.setRotX(CapePhysics.computeFrontCapeAngle(leftLeg.getRotX(), rightLeg.getRotX()));
    }

    public static void applyBraidRotation(AvatarRenderState state, BoneSnapshot braid) {
        applyCapeRotation(state, braid);

        braid.setRotX(CapePhysics.computeBraidAngle(braid.getRotX(), state.xRot, state.isCrouching));
    }

    public static void setArmsVisibility(PlayerModel model, boolean visible) {
        model.rightArm.visible = visible;
        model.rightSleeve.visible = visible;
        model.leftArm.visible = visible;
        model.leftSleeve.visible = visible;
    }

    public static void matchModelPartRot(net.minecraft.client.model.geom.ModelPart part, BoneSnapshot snapshot) {
        snapshot.setRotation(-part.xRot, -part.yRot, part.zRot);
    }

    private FARenderUtils() {}
}
