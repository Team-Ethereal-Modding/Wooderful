/*
package com.example.examplemod.api;

import com.example.examplemod.mixin.ItemInvokerMixin;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class ItemStackUtils {

    */
/**
     * Searches for a specific item in a {@link NonNullList} of {@link ItemStack} and returns its index.
     *
     * @param item  The item to search for.
     * @param items The list of {@link ItemStack}s.
     * @return The index of the specified item in the list, or -1 if it was not in the list.
     *//*

	public static int findIndexOfItem(ItemLike item, NonNullList<ItemStack> items) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getItem() == item) {
				return i;
			}
		}
		return -1;
	}

    */
/**
     * Used in {@link Item#fillItemCategory(CreativeModeTab, NonNullList)} to fill an item after a specific item for a group.
     *
     * @param item       The item to fill.
     * @param targetItem The item to fill after.
     * @param tab        The tab to fill it in.
     * @param items      The {@link NonNullList} of item stacks to search for the target item and inject the item in.
     *//*

	public static void fillAfterItemForCategory(Item item, Item targetItem, CreativeModeTab tab, NonNullList<ItemStack> items) {
		if (isAllowedInTab(item, tab)) {
			int targetIndex = findIndexOfItem(targetItem, items);
			if (targetIndex != -1) {
				items.add(targetIndex + 1, new ItemStack(item));
			} else {
				items.add(new ItemStack(item));
			}
		}
	}

    */
/**
     * Checks if an {@link Item} is in an {@link CreativeModeTab}.
     *
     * @param item The {@link Item} to check.
     * @param tab  The {@link CreativeModeTab} to check.
     * @return Whether the item is in the {@link CreativeModeTab}.
     *//*

    public static boolean isAllowedInTab(Item item, CreativeModeTab tab) {
        return ((ItemInvokerMixin) item).callAllowedIn(tab);
    }

}*/
