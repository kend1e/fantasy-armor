package net.kenddie.fantasyarmor.mixin;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerModel.class, remap = false)
public class FARenderMixin {
    @Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;)V", at = @At("TAIL"))
    private void fa_hideArmsIfArmor(AvatarRenderState state, CallbackInfo ci) {
        PlayerModel model = (PlayerModel)(Object)this;

        ItemStack chest = state.chestEquipment;
        if (chest != null && chest.getItem() instanceof FAArmorItem) {
            model.rightArm.visible = false;
            model.leftArm.visible = false;
            model.rightSleeve.visible = false;
            model.leftSleeve.visible = false;
        }
    }
}
