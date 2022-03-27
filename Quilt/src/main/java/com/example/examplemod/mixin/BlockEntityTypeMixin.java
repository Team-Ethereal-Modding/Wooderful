package com.example.examplemod.mixin;

import com.example.examplemod.IBlockEntityType;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin implements IBlockEntityType {
    @Shadow
    @Final
    @Mutable
    private Set<Block> validBlocks;

    @Override
    public void wooderful_addBlocks(Block... newBlocks) {
        ArrayList<Block> tempList = new ArrayList<>(newBlocks.length + validBlocks.size());
        tempList.addAll(Arrays.asList(newBlocks));
        tempList.addAll(validBlocks);
        validBlocks = ImmutableSet.copyOf(tempList);
    }
}