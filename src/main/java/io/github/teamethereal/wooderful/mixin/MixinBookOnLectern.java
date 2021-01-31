package io.github.teamethereal.wooderful.mixin;

import io.github.teamethereal.wooderful.block.WooderfulLectern;
import net.minecraft.block.BlockState;
import net.minecraft.block.LecternBlock;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.WritableBookItem;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({WritableBookItem.class, WrittenBookItem.class})
public abstract class MixinBookOnLectern {

    @Inject(method = "useOnBlock", at = {@At("HEAD")}, cancellable = true)
    public void useOnBlock(ItemUsageContext itemUsageContext_1, CallbackInfoReturnable<ActionResult> cir) {
        World world_1 = itemUsageContext_1.getWorld();
        BlockPos blockPos_1 = itemUsageContext_1.getBlockPos();
        BlockState blockState_1 = world_1.getBlockState(blockPos_1);
        if (blockState_1.getBlock() instanceof LecternBlock) {
            cir.setReturnValue(LecternBlock.putBookIfAbsent(world_1, blockPos_1, blockState_1, itemUsageContext_1.getStack()) ? ActionResult.SUCCESS : ActionResult.PASS);
        } else if (blockState_1.getBlock() instanceof WooderfulLectern && !(blockState_1.getBlock() instanceof LecternBlock)) {
            cir.setReturnValue(WooderfulLectern.putBookIfAbsent(world_1, blockPos_1, blockState_1, itemUsageContext_1.getStack()) ? ActionResult.SUCCESS : ActionResult.PASS);
        } else {
            cir.setReturnValue(ActionResult.PASS);
        }
    }

}
