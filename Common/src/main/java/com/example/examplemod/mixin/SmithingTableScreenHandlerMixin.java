package com.example.examplemod.mixin;

import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SmithingMenu.class)
public class SmithingTableScreenHandlerMixin {

	/**
	 * @author OliviaTheVampire
	 */
	@Overwrite
	public boolean isValidBlock(BlockState state) {
		return state.getBlock() instanceof SmithingTableBlock;
	}

}
