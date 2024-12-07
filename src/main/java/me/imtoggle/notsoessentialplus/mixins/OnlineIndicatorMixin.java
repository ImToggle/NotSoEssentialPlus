package me.imtoggle.notsoessentialplus.mixins;

import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "gg.essential.handlers.OnlineIndicator")
public class OnlineIndicatorMixin {

    @Dynamic("Essential")
    @Inject(method = "drawNametagIndicator", at = @At("HEAD"), cancellable = true)
    private static void cancelNametagIndicator(
        @Coerce Object matrixStack,
        @Coerce Object provider,
//        #if MC >= 1.16.5
//        $$ @Coerce Object provider,
//        #endif
        @Coerce Object cState,
        String str,
        int light,
        CallbackInfo ci
    ) {
        ci.cancel();
    }

    @Dynamic("Essential")
    @Inject(method = "drawTabIndicator", at = @At("HEAD"), cancellable = true)
    private static void cancelTabIndicator(
        @Coerce Object matrixStack,
        @Coerce Object provider,
        //#if MC >= 1.16.5
        //$$ @Coerce Object provider,
        //#endif
        @Coerce Object networkPlayerInfo,
        int x,
        int y,
        CallbackInfo ci
    ) {
        ci.cancel();
    }

}
