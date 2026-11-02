package net.kenddie.fantasyarmor.mixin;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class FAItemStackMixin {
    @Inject(method = "getMaxDamage", at = @At("HEAD"), cancellable = true)
    private void fantasyArmor$getMaxDamage(CallbackInfoReturnable<Integer> callback) {
        var stack = (ItemStack) (Object) this;
        if (stack.getItem() instanceof FAArmorItem armor) callback.setReturnValue(armor.configuredMaxDamage());
    }

    @Inject(method = "isDamageableItem", at = @At("HEAD"), cancellable = true)
    private void fantasyArmor$isDamageable(CallbackInfoReturnable<Boolean> callback) {
        var stack = (ItemStack) (Object) this;
        if (stack.getItem() instanceof FAArmorItem armor) {
            callback.setReturnValue(armor.configuredMaxDamage() > 0
                    && !(stack.hasTag() && stack.getTag().getBoolean("Unbreakable")));
        }
    }
}
