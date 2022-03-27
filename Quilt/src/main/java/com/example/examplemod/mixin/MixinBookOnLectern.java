package com.example.examplemod.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({WritableBookItem.class, WrittenBookItem.class})
public abstract class MixinBookOnLectern {

    @Inject(method = "useOn", at = {@At("HEAD")}, cancellable = true)
    public void useOnBlock(UseOnContext itemUsageContext_1, CallbackInfoReturnable<InteractionResult> cir) {
        Player player = itemUsageContext_1.getPlayer();
        Level world_1 = itemUsageContext_1.getLevel();
        BlockPos blockPos_1 = itemUsageContext_1.getClickedPos();
        BlockState blockState_1 = world_1.getBlockState(blockPos_1);
        if (blockState_1.getBlock() instanceof LecternBlock) {
            cir.setReturnValue(LecternBlock.tryPlaceBook(player, world_1, blockPos_1, blockState_1, itemUsageContext_1.getItemInHand()) ? InteractionResult.SUCCESS : InteractionResult.PASS);
        }/* else if (blockState_1.getBlock() instanceof WooderfulLectern && !(blockState_1.getBlock() instanceof LecternBlock)) {
            cir.setReturnValue(WooderfulLectern.putBookIfAbsent(player, world_1, blockPos_1, blockState_1, itemUsageContext_1.getItemInHand()) ? InteractionResult.SUCCESS : InteractionResult.PASS);
        }*/ else {
            cir.setReturnValue(InteractionResult.PASS);
        }
    }

}
