package io.github.teamethereal.wooderful.block;

import io.github.vampirestudios.vampirelib.utils.ItemStackUtils;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class CompatBlock extends Block {

    private final String modName;
    private final Block modBlock;

    public CompatBlock(String modName, Block modBlock, Settings settings) {
        super(settings);
        this.modName = modName;
        this.modBlock = modBlock;
    }

    @Override
    public void addStacksForDisplay(ItemGroup group, DefaultedList<ItemStack> list) {
        if(ItemStackUtils.isInGroup(this.asItem(), group)) {
            if (FabricLoader.getInstance().isModLoaded(this.modName)) {
                int targetIndex = ItemStackUtils.findIndexOfItem(modBlock.asItem(), list);
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