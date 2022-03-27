package com.example.examplemod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class WoodType {
	public static final WoodType SPRUCE = WoodTypeRegistry.registerVanilla(new WoodType("spruce", Blocks.SPRUCE_PLANKS));
	public static final WoodType OAK = WoodTypeRegistry.registerVanilla(new WoodType("oak", Blocks.OAK_PLANKS));
	public static final WoodType BIRCH = WoodTypeRegistry.registerVanilla(new WoodType("birch", Blocks.BIRCH_PLANKS));
	public static final WoodType JUNGLE = WoodTypeRegistry.registerVanilla(new WoodType("jungle", Blocks.JUNGLE_PLANKS));
	public static final WoodType ACACIA = WoodTypeRegistry.registerVanilla(new WoodType("acacia", Blocks.ACACIA_PLANKS));
	public static final WoodType DARK_OAK = WoodTypeRegistry.registerVanilla(new WoodType("dark_oak", Blocks.DARK_OAK_PLANKS));
	public static final WoodType WARPED = WoodTypeRegistry.registerVanilla(new WoodType("warped", Blocks.WARPED_PLANKS));
	public static final WoodType CRIMSON = WoodTypeRegistry.registerVanilla(new WoodType("crimson", Blocks.CRIMSON_PLANKS));
	public static final WoodType[] VANILLA = new WoodType[]{OAK, SPRUCE, BIRCH, JUNGLE, ACACIA, DARK_OAK, WARPED, CRIMSON};

	protected ResourceLocation identifier;
	public Block baseBlock;

	public WoodType(ResourceLocation identifier) {
		this(identifier, Blocks.AIR);
	}

	public WoodType(String name, Block baseBlock) {
		this(new ResourceLocation("minecraft", name), baseBlock);
	}

	public WoodType(ResourceLocation identifier, Block baseBlock) {
		this.identifier = identifier;
		this.baseBlock = baseBlock;
	}

	public ResourceLocation getIdentifier() {
		return identifier;
	}

	public ResourceLocation getBaseBlockIdentifier() {
		return new ResourceLocation(identifier.getNamespace(), identifier.getPath() + "_planks");
	}

	public Block getBaseBlock() {
		return baseBlock;
	}
}
