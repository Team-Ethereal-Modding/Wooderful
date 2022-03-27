package com.example.examplemod.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.CraftingTableBlock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CraftingMenu.class)
public class CraftingScreenHandlerMixin {

	@Shadow @Final private ContainerLevelAccess access;

	/**
	 * @author OliviaTherVampire
	 */
	@Overwrite
	public boolean stillValid(Player player) {
		return access.evaluate((level, blockPos) -> level.getBlockState(blockPos).getBlock() instanceof CraftingTableBlock && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
	}

}
