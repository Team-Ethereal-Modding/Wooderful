package io.github.teamethereal.wooderful.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SmithingTableBlock;
import net.minecraft.screen.SmithingScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SmithingScreenHandler.class)
public class SmithingTableScreenHandlerMixin {

	/**
	 * @author OliviaTheVampire
	 */
	@Overwrite
	public boolean canUse(BlockState state) {
		return state.getBlock() instanceof SmithingTableBlock;
	}

}
