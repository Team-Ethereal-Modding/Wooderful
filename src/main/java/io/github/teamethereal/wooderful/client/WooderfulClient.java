package io.github.teamethereal.wooderful.client;

import com.swordglowsblue.artifice.api.Artifice;
import io.github.teamethereal.wooderful.WoodType;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;

import java.util.Arrays;

import static io.github.teamethereal.wooderful.Wooderful.id;

public class WooderfulClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Artifice.registerAssetPack(id("assets"), clientResourcePackBuilder -> Arrays.asList(WoodType.VANILLA).forEach(woodType -> {
			clientResourcePackBuilder.addBlockState(id(String.format("%s_crafting_table", woodType.getIdentifier().getPath())), blockStateBuilder ->
					blockStateBuilder.variant("", variant -> variant.model(id(String.format("block/%s_crafting_table", woodType.getIdentifier().getPath())))));
			clientResourcePackBuilder.addBlockState(id(String.format("%s_bookshelf", woodType.getIdentifier().getPath())), blockStateBuilder ->
					blockStateBuilder.variant("", variant -> variant.model(id(String.format("block/%s_bookshelf", woodType.getIdentifier().getPath())))));
			clientResourcePackBuilder.addBlockState(id(String.format("%s_smithing_table", woodType.getIdentifier().getPath())), blockStateBuilder ->
					blockStateBuilder.variant("", variant -> variant.model(id(String.format("block/%s_smithing_table", woodType.getIdentifier().getPath())))));
			clientResourcePackBuilder.addBlockState(id(String.format("%s_fletching_table", woodType.getIdentifier().getPath())), blockStateBuilder ->
					blockStateBuilder.variant("", variant -> variant.model(id(String.format("block/%s_fletching_table", woodType.getIdentifier().getPath())))));
			clientResourcePackBuilder.addBlockState(id(String.format("%s_cartography_table", woodType.getIdentifier().getPath())), blockStateBuilder ->
					blockStateBuilder.variant("", variant -> variant.model(id(String.format("block/%s_cartography_table", woodType.getIdentifier().getPath())))));

			clientResourcePackBuilder.addBlockModel(id(String.format("%s_crafting_table", woodType.getIdentifier().getPath())), modelBuilder -> {
				modelBuilder.parent(new Identifier("block/cube"));
				modelBuilder.texture("particle", id(String.format("block/crafting_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("north", id(String.format("block/crafting_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("south", id(String.format("block/crafting_table/%s/side", woodType.getIdentifier().getPath())));
				modelBuilder.texture("east", id(String.format("block/crafting_table/%s/side", woodType.getIdentifier().getPath())));
				modelBuilder.texture("west", id(String.format("block/crafting_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("up", id(String.format("block/crafting_table/%s/top", woodType.getIdentifier().getPath())));
				modelBuilder.texture("down", new Identifier(String.format("block/%s_planks", woodType.getIdentifier().getPath())));
			});
			clientResourcePackBuilder.addItemModel(id(String.format("%s_crafting_table", woodType.getIdentifier().getPath())), modelBuilder ->
					modelBuilder.parent(id(String.format("block/%s_crafting_table", woodType.getIdentifier().getPath()))));

			clientResourcePackBuilder.addBlockModel(id(String.format("%s_smithing_table", woodType.getIdentifier().getPath())), modelBuilder -> {
				modelBuilder.parent(new Identifier("block/cube"));
				modelBuilder.texture("particle", id(String.format("block/smithing_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("north", id(String.format("block/smithing_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("south", id(String.format("block/smithing_table/%s/side", woodType.getIdentifier().getPath())));
				modelBuilder.texture("east", id(String.format("block/smithing_table/%s/side", woodType.getIdentifier().getPath())));
				modelBuilder.texture("west", id(String.format("block/smithing_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("up", id(String.format("block/smithing_table/%s/top", woodType.getIdentifier().getPath())));
				modelBuilder.texture("down", id(String.format("block/smithing_table/%s/bottom", woodType.getIdentifier().getPath())));
			});
			clientResourcePackBuilder.addItemModel(id(String.format("%s_smithing_table", woodType.getIdentifier().getPath())), modelBuilder ->
					modelBuilder.parent(id(String.format("block/%s_smithing_table", woodType.getIdentifier().getPath()))));

			clientResourcePackBuilder.addBlockModel(id(String.format("%s_fletching_table", woodType.getIdentifier().getPath())), modelBuilder -> {
				modelBuilder.parent(new Identifier("block/cube"));
				modelBuilder.texture("particle", id(String.format("block/fletching_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("north", id(String.format("block/fletching_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("south", id(String.format("block/fletching_table/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("east", id(String.format("block/fletching_table/%s/side", woodType.getIdentifier().getPath())));
				modelBuilder.texture("west", id(String.format("block/fletching_table/%s/side", woodType.getIdentifier().getPath())));
				modelBuilder.texture("up", id(String.format("block/fletching_table/%s/top", woodType.getIdentifier().getPath())));
				modelBuilder.texture("down", new Identifier(String.format("block/%s_planks", woodType.getIdentifier().getPath())));
			});
			clientResourcePackBuilder.addItemModel(id(String.format("%s_fletching_table", woodType.getIdentifier().getPath())), modelBuilder ->
					modelBuilder.parent(id(String.format("block/%s_fletching_table", woodType.getIdentifier().getPath()))));

			clientResourcePackBuilder.addBlockModel(id(String.format("%s_cartography_table", woodType.getIdentifier().getPath())), modelBuilder -> {
				modelBuilder.parent(new Identifier("block/cube"));
				modelBuilder.texture("particle", id(String.format("block/cartography_table/%s/side3", woodType.getIdentifier().getPath())));
				modelBuilder.texture("north", id(String.format("block/cartography_table/%s/side3", woodType.getIdentifier().getPath())));
				modelBuilder.texture("south", id(String.format("block/cartography_table/%s/side1", woodType.getIdentifier().getPath())));
				modelBuilder.texture("east", id(String.format("block/cartography_table/%s/side3", woodType.getIdentifier().getPath())));
				modelBuilder.texture("west", id(String.format("block/cartography_table/%s/side2", woodType.getIdentifier().getPath())));
				modelBuilder.texture("up", id(String.format("block/cartography_table/%s/top", woodType.getIdentifier().getPath())));
				modelBuilder.texture("down", new Identifier(String.format("block/%s_planks", woodType.getIdentifier().getPath())));
			});
			clientResourcePackBuilder.addItemModel(id(String.format("%s_cartography_table", woodType.getIdentifier().getPath())), modelBuilder ->
					modelBuilder.parent(id(String.format("block/%s_cartography_table", woodType.getIdentifier().getPath()))));

			clientResourcePackBuilder.addBlockState(id(String.format("%s_lectern", woodType.getIdentifier().getPath())), blockStateBuilder -> {
				blockStateBuilder.variant("facing=east", variant -> {
					variant.model(id(String.format("block/%s_lectern", woodType.getIdentifier().getPath())));
					variant.rotationY(90);
				});
				blockStateBuilder.variant("facing=north", variant ->
						variant.model(id(String.format("block/%s_lectern", woodType.getIdentifier().getPath()))));
				blockStateBuilder.variant("facing=south", variant -> {
					variant.model(id(String.format("block/%s_lectern", woodType.getIdentifier().getPath())));
					variant.rotationY(180);
				});
				blockStateBuilder.variant("facing=west", variant -> {
					variant.model(id(String.format("block/%s_lectern", woodType.getIdentifier().getPath())));
					variant.rotationY(270);
				});
			});
			clientResourcePackBuilder.addBlockModel(id(String.format("%s_lectern", woodType.getIdentifier().getPath())), modelBuilder -> {
				modelBuilder.parent(new Identifier("block/lectern"));
				modelBuilder.texture("base", id(String.format("block/lectern/%s/base", woodType.getIdentifier().getPath())));
				modelBuilder.texture("front", id(String.format("block/lectern/%s/front", woodType.getIdentifier().getPath())));
				modelBuilder.texture("sides", id(String.format("block/lectern/%s/sides", woodType.getIdentifier().getPath())));
				modelBuilder.texture("top", id(String.format("block/lectern/%s/top", woodType.getIdentifier().getPath())));
				modelBuilder.texture("down", new Identifier(String.format("block/%s_planks", woodType.getIdentifier().getPath())));
			});
			clientResourcePackBuilder.addItemModel(id(String.format("%s_lectern", woodType.getIdentifier().getPath())), modelBuilder ->
					modelBuilder.parent(id(String.format("block/%s_lectern", woodType.getIdentifier().getPath()))));

			clientResourcePackBuilder.addBlockState(id(String.format("%s_loom", woodType.getIdentifier().getPath())), blockStateBuilder -> {
				blockStateBuilder.variant("facing=east", variant -> {
					variant.model(id(String.format("block/%s_loom", woodType.getIdentifier().getPath())));
					variant.rotationY(90);
				});
				blockStateBuilder.variant("facing=north", variant ->
						variant.model(id(String.format("block/%s_loom", woodType.getIdentifier().getPath()))));
				blockStateBuilder.variant("facing=south", variant -> {
					variant.model(id(String.format("block/%s_loom", woodType.getIdentifier().getPath())));
					variant.rotationY(180);
				});
				blockStateBuilder.variant("facing=west", variant -> {
					variant.model(id(String.format("block/%s_loom", woodType.getIdentifier().getPath())));
					variant.rotationY(270);
				});
			});
			clientResourcePackBuilder.addBlockModel(id(String.format("%s_loom", woodType.getIdentifier().getPath())), modelBuilder -> {
				modelBuilder.parent(new Identifier("block/orientable_with_bottom"));
				modelBuilder.texture("top", id(String.format("block/loom/%s/top", woodType.getIdentifier().getPath())));
				modelBuilder.texture("bottom", id(String.format("block/loom/%s/bottom", woodType.getIdentifier().getPath())));
				modelBuilder.texture("side", id(String.format("block/loom/%s/side", woodType.getIdentifier().getPath())));
				modelBuilder.texture("front", id(String.format("block/loom/%s/front", woodType.getIdentifier().getPath())));
			});
			clientResourcePackBuilder.addItemModel(id(String.format("%s_loom", woodType.getIdentifier().getPath())), modelBuilder ->
					modelBuilder.parent(id(String.format("block/%s_loom", woodType.getIdentifier().getPath()))));
		}));
	}
}
