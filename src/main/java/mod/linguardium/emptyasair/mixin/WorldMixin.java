package mod.linguardium.emptyasair.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(World.class)
public class WorldMixin {
    @ModifyReturnValue(method="getBlockState",at=@At("RETURN"))
    private BlockState nullIsAir(BlockState original) {
        if (original==null) { return Blocks.BLUE_STAINED_GLASS.getDefaultState(); }
        return original;
    }
    @ModifyReturnValue(method="getFluidState",at=@At("RETURN"))
    private FluidState nullFluidIsAir(FluidState original) {
        if (original==null) return Fluids.EMPTY.getDefaultState();
        return original;
    }
}
