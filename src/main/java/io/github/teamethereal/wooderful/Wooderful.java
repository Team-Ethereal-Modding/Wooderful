package io.github.teamethereal.wooderful;

import com.google.common.collect.ImmutableMap;
import io.github.teamethereal.wooderful.block.*;
import io.github.teamethereal.wooderful.block.entity.IBlockEntityType;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Wooderful implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "wooderful";
    public static final String MOD_NAME = "Wooderful";
    public static final String MOD_VERSION = "v0.1.0";

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

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        Arrays.asList(WoodType.VANILLA).forEach(woodType -> {
            if (VANILLA_BLOCKS.get(Blocks.CRAFTING_TABLE) != woodType) REGISTRY_HELPER.registerBlock(new WooderfulCraftingTable(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)), woodType.getIdentifier().getPath() + "_crafting_table");
            if (VANILLA_BLOCKS.get(Blocks.LECTERN) != woodType)  {
                Block lectern = REGISTRY_HELPER.registerBlock(new WooderfulLectern(), woodType.getIdentifier().getPath() + "_lectern", ItemGroup.REDSTONE);
                ((IBlockEntityType) BlockEntityType.LECTERN).wooderful_addBlocks(lectern);
            }
            if (VANILLA_BLOCKS.get(Blocks.LOOM) != woodType) REGISTRY_HELPER.registerBlock(new WooderfulLoom(FabricBlockSettings.copyOf(Blocks.LOOM)), woodType.getIdentifier().getPath() + "_loom");
            if (VANILLA_BLOCKS.get(Blocks.SMITHING_TABLE) != woodType) REGISTRY_HELPER.registerBlock(new WooderfulSmithingTable(FabricBlockSettings.copyOf(Blocks.SMITHING_TABLE)), woodType.getIdentifier().getPath() + "_smithing_table");
            if (VANILLA_BLOCKS.get(Blocks.FLETCHING_TABLE) != woodType) REGISTRY_HELPER.registerBlock(new WooderfulFletchingTable(FabricBlockSettings.copyOf(Blocks.FLETCHING_TABLE)), woodType.getIdentifier().getPath() + "_fletching_table");
            if (VANILLA_BLOCKS.get(Blocks.CARTOGRAPHY_TABLE) != woodType) REGISTRY_HELPER.registerBlock(new WooderfulCartographyTable(FabricBlockSettings.copyOf(Blocks.CARTOGRAPHY_TABLE)), woodType.getIdentifier().getPath() + "_cartography_table");
//            if (VANILLA_BLOCKS.get(Blocks.BOOKSHELF) != woodType) REGISTRY_HELPER.registerBlock(new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)), woodType.getIdentifier().getPath() + "_bookshelf");
//            if (VANILLA_BLOCKS.get(Blocks.COMPOSTER) != woodType) REGISTRY_HELPER.registerBlock(new ComposterBlock(FabricBlockSettings.copyOf(Blocks.COMPOSTER)), woodType.getIdentifier().getPath() + "_composter");
            if (VANILLA_BLOCKS.get(Blocks.CAMPFIRE) != woodType) REGISTRY_HELPER.registerBlock(new WooderfulCampfire(false, FabricBlockSettings.copyOf(Blocks.CAMPFIRE)), woodType.getIdentifier().getPath() + "_campfire");
            if (VANILLA_BLOCKS.get(Blocks.SOUL_CAMPFIRE) != woodType) REGISTRY_HELPER.registerBlock(new WooderfulCampfire(true, FabricBlockSettings.copyOf(Blocks.SOUL_CAMPFIRE)), woodType.getIdentifier().getPath() + "_soul_campfire");
            if (VANILLA_BLOCKS.get(Blocks.BARREL) != woodType) {
                Block barrel = REGISTRY_HELPER.registerBlock(new BarrelBlock(FabricBlockSettings.copyOf(Blocks.BARREL)), woodType.getIdentifier().getPath() + "_barrel");
                ((IBlockEntityType) BlockEntityType.BARREL).wooderful_addBlocks(barrel);
            }
        });
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}