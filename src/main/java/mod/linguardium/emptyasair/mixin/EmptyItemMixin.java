package mod.linguardium.emptyasair.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(ItemStack.class)
public class EmptyItemMixin {
    @Shadow @Final @Deprecated private Item item;

    @Inject(at=@At("HEAD"),cancellable = true,method="getItem")
    private void getItem(CallbackInfoReturnable<Item> cir) {
        if (item == null) {
            cir.setReturnValue(Items.AIR);
        }
    }

}
