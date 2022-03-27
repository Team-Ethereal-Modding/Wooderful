package com.example.examplemod;

import com.example.examplemod.platform.Services;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Arrays;

import static com.example.examplemod.Constants.MOD_ID;

public class CommonClass {

    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.createRegistryHelper(MOD_ID);

    private static final ImmutableMap<Block, WoodType> VANILLA_BLOCKS = ImmutableMap.<Block, WoodType>builder()
            .put(Blocks.CRAFTING_TABLE, WoodType.OAK)
            .put(Blocks.LECTERN, WoodType.OAK)
            .put(Blocks.CARTOGRAPHY_TABLE, WoodType.DARK_OAK)
            .put(Blocks.BARREL, WoodType.SPRUCE)
            .put(Blocks.FLETCHING_TABLE, WoodType.BIRCH)
            .put(Blocks.CAMPFIRE, WoodType.OAK)
            .put(Blocks.SOUL_CAMPFIRE, WoodType.OAK)
            .put(Blocks.BOOKSHELF, WoodType.OAK)
            .put(Blocks.LOOM, WoodType.OAK)
            .put(Blocks.COMPOSTER, WoodType.SPRUCE)
            .build();

    public static void init() {
        Constants.LOG.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.isDevelopmentEnvironment() ? "development" : "production");
        Arrays.asList(WoodType.VANILLA).forEach(woodType -> {
            System.out.println(woodType.identifier.toString());
//            if (VANILLA_BLOCKS.get(Blocks.CRAFTING_TABLE) != woodType) REGISTRY_HELPER.blocks().registerBlock(new WooderfulCraftingTable(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)), woodType.getIdentifier().getPath() + "_crafting_table");
//            if (VANILLA_BLOCKS.get(Blocks.LECTERN) != woodType)  {
//                Block lectern = REGISTRY_HELPER.blocks().registerBlock(new WooderfulLectern(), woodType.getIdentifier().getPath() + "_lectern", CreativeModeTab.TAB_REDSTONE);
//                ((IBlockEntityType) BlockEntityType.LECTERN).wooderful_addBlocks(lectern);
//            }
//            if (VANILLA_BLOCKS.get(Blocks.LOOM) != woodType) REGISTRY_HELPER.blocks().registerBlock(new WooderfulLoom(BlockBehaviour.Properties.copy(Blocks.LOOM)), woodType.getIdentifier().getPath() + "_loom");
//            if (VANILLA_BLOCKS.get(Blocks.SMITHING_TABLE) != woodType) REGISTRY_HELPER.blocks().registerBlock(new WooderfulSmithingTable(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE)), woodType.getIdentifier().getPath() + "_smithing_table");
//            if (VANILLA_BLOCKS.get(Blocks.FLETCHING_TABLE) != woodType) REGISTRY_HELPER.blocks().registerBlock(new WooderfulFletchingTable(BlockBehaviour.Properties.copy(Blocks.FLETCHING_TABLE)), woodType.getIdentifier().getPath() + "_fletching_table");
//            if (VANILLA_BLOCKS.get(Blocks.CARTOGRAPHY_TABLE) != woodType) REGISTRY_HELPER.blocks().registerBlock(new WooderfulCartographyTable(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)), woodType.getIdentifier().getPath() + "_cartography_table");
////            if (VANILLA_BLOCKS.get(Blocks.BOOKSHELF) != woodType) REGISTRY_HELPER.blocks().registerBlock(new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)), woodType.getIdentifier().getPath() + "_bookshelf");
////            if (VANILLA_BLOCKS.get(Blocks.COMPOSTER) != woodType) REGISTRY_HELPER.blocks().registerBlock(new ComposterBlock(FabricBlockSettings.copyOf(Blocks.COMPOSTER)), woodType.getIdentifier().getPath() + "_composter");
//            if (VANILLA_BLOCKS.get(Blocks.CAMPFIRE) != woodType) REGISTRY_HELPER.blocks().registerBlock(new WooderfulCampfire(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE)), woodType.getIdentifier().getPath() + "_campfire");
//            if (VANILLA_BLOCKS.get(Blocks.SOUL_CAMPFIRE) != woodType) REGISTRY_HELPER.blocks().registerBlock(new WooderfulCampfire(true, BlockBehaviour.Properties.copy(Blocks.SOUL_CAMPFIRE)), woodType.getIdentifier().getPath() + "_soul_campfire");
//            if (VANILLA_BLOCKS.get(Blocks.BARREL) != woodType) {
//                Block barrel = REGISTRY_HELPER.blocks().registerBlock(new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)), woodType.getIdentifier().getPath() + "_barrel");
//                ((IBlockEntityType) BlockEntityType.BARREL).wooderful_addBlocks(barrel);
//            }
        });
    }

}