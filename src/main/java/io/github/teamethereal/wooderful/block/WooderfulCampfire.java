package io.github.teamethereal.wooderful.block;

import io.github.vampirestudios.vampirelib.utils.ItemStackUtils;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class WooderfulCampfire extends CampfireBlock {

	private boolean isSoulCampfire;

	public WooderfulCampfire(boolean isSoulCampfire, Settings settings) {
		super(!isSoulCampfire, isSoulCampfire ? 2 : 1, settings);
		this.isSoulCampfire = isSoulCampfire;
	}

	@Override
	public void addStacksForDisplay(ItemGroup group, DefaultedList<ItemStack> list) {
		if(ItemStackUtils.isInGroup(this.asItem(), group)) {
			if (FabricLoader.getInstance().isModLoaded("minecraft")) {
				int targetIndex = ItemStackUtils.findIndexOfItem(isSoulCampfire ? Blocks.SOUL_CAMPFIRE.asItem() : Blocks.CAMPFIRE.asItem(), list);
				if(targetIndex != -1) {
					list.add(targetIndex + 1, new ItemStack(this));
				} else {
					super.addStacksForDisplay(group, list);
				}
			} else {
				super.addStacksForDisplay(group, list);
			}
		}
	}

}
