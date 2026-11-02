package net.kenddie.fantasyarmor.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kenddie.fantasyarmor.client.render.FARenderUtils;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public class FARenderMixin {
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"))
    private void onRender(AbstractClientPlayer player, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
        Item item = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        PlayerModel<AbstractClientPlayer> playerModel = ((PlayerRenderer)(Object)this).getModel();

        if (item instanceof FAArmorItem) {
            FARenderUtils.setArmsVisibility(playerModel, false);
        }
    }
}
