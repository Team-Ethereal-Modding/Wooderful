package com.example.examplemod;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public record RegistryHelper(String modId) {
	public static RegistryHelper createRegistryHelper(String modId) {
		return new RegistryHelper(modId);
	}

	public Blocks blocks() {
		return new Blocks(modId());
	}

	public Items items() {
		return new Items(modId());
	}

	public record Blocks(String modId) {
		public Block registerBlock(Block block, String name) {
			registerBlock(block, name, CreativeModeTab.TAB_DECORATIONS);
			return block;
		}

		public Block registerBlock(Block block, String name, CreativeModeTab itemGroup) {
			Registry.register(Registry.BLOCK, new ResourceLocation(modId, name), block);
			Registry.register(Registry.ITEM, new ResourceLocation(modId, name), new BlockItem(block, new Item.Properties().tab(itemGroup)));
			return block;
		}

		public Block registerBlockWithWallBlock(Block block, Block wallBlock, String name) {
			Registry.register(Registry.BLOCK, new ResourceLocation(modId, name), block);
			Registry.register(Registry.ITEM, new ResourceLocation(modId, name), new StandingAndWallBlockItem(block, wallBlock, new Item.Properties()
					.tab(CreativeModeTab.TAB_DECORATIONS)));
			return block;
		}

		public Block registerNetherStem(String name, MaterialColor materialColor) {
			return registerBlock(new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (blockState) -> materialColor)
					.strength(1.0F).sound(SoundType.STEM)), name, CreativeModeTab.TAB_BUILDING_BLOCKS);
		}

		public Block registerLog(String name, MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
			return registerBlock(new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (blockState) ->
							blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor)
					.strength(2.0F).sound(SoundType.WOOD)), name);
		}

		public Block registerLog(String name, MaterialColor materialColor) {
			return registerBlock(new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (blockState) -> materialColor)
					.strength(2.0F).sound(SoundType.WOOD)), name);
		}

		public Block registerBlockWithoutItem(String name, Block block) {
			Registry.register(Registry.BLOCK, new ResourceLocation(modId, name), block);
			return block;
		}
	}

	public record Items(String modId) {
		public Item registerItem(String name, Item item) {
			return Registry.register(Registry.ITEM, new ResourceLocation(modId, name), item);
		}
	}

	public <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(BlockEntityType.Builder<T> builder, String name) {
		BlockEntityType<T> blockEntityType = builder.build(null);
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(modId, name), blockEntityType);
	}

	public <T extends Entity> EntityType<T> registerEntity(EntityType.Builder<T> builder, String name) {
		EntityType<T> blockEntityType = builder.build(null);
		return Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(modId, name), blockEntityType);
	}

	public SoundEvent createSoundEvent(String name) {
		return Registry.register(Registry.SOUND_EVENT, name, new SoundEvent(new ResourceLocation(modId, name)));
	}

	public SoundEvent registerSoundEvent(SoundEvent soundEvent, String name) {
		return Registry.register(Registry.SOUND_EVENT, new ResourceLocation(modId, name), soundEvent);
	}

}