package com.example.examplemod.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CartographyTableMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.CartographyTableBlock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CartographyTableMenu.class)
public class CartographyTableScreenHandlerMixin {

	@Shadow @Final private ContainerLevelAccess access;

	/**
	 * @author OliviaTherVampire
	 */
	@Overwrite
	public boolean stillValid(Player player) {
		return access.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof CartographyTableBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
	}

}
