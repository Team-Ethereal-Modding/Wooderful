package io.github.teamethereal.wooderful.mixin;

import net.minecraft.block.LoomBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.LoomScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LoomScreenHandler.class)
public class LoomScreenHandlerMixin {

	@Shadow @Final private ScreenHandlerContext context;

	/**
	 * @author OliviaTherVampire
	 */
	@Overwrite
	public boolean canUse(PlayerEntity player) {
		return this.context.run((world, blockPos) -> world.getBlockState(blockPos).getBlock() instanceof LoomBlock && player.squaredDistanceTo((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
	}

}
