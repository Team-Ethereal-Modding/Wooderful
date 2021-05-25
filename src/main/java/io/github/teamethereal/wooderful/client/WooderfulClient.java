package io.github.teamethereal.wooderful.client;

import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.resource.StringResource;
import io.github.teamethereal.wooderful.WoodType;
import io.github.vampirestudios.vampirelib.utils.ArtificeGenerationHelper;
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

			String template = "{\n" +
					"  \"variants\": {\n" +
					"    \"facing=down,open=false\": {\n" +
					"      \"x\": 180,\n" +
					"      \"model\": \"wooderful:block/%s_barrel\"\n" +
					"    },\n" +
					"    \"facing=down,open=true\": {\n" +
					"      \"x\": 180,\n" +
					"      \"model\": \"wooderful:block/%s_barrel_open\"\n" +
					"    },\n" +
					"    \"facing=east,open=false\": {\n" +
					"      \"x\": 90,\n" +
					"      \"y\": 90,\n" +
					"      \"model\": \"wooderful:block/%s_barrel\"\n" +
					"    },\n" +
					"    \"facing=east,open=true\": {\n" +
					"      \"x\": 90,\n" +
					"      \"y\": 90,\n" +
					"      \"model\": \"wooderful:block/%s_barrel_open\"\n" +
					"    },\n" +
					"    \"facing=north,open=false\": {\n" +
					"      \"x\": 90,\n" +
					"      \"model\": \"wooderful:block/%s_barrel\"\n" +
					"    },\n" +
					"    \"facing=north,open=true\": {\n" +
					"      \"x\": 90,\n" +
					"      \"model\": \"wooderful:block/%s_barrel_open\"\n" +
					"    },\n" +
					"    \"facing=south,open=false\": {\n" +
					"      \"x\": 90,\n" +
					"      \"y\": 180,\n" +
					"      \"model\": \"wooderful:block/%s_barrel\"\n" +
					"    },\n" +
					"    \"facing=south,open=true\": {\n" +
					"      \"x\": 90,\n" +
					"      \"y\": 180,\n" +
					"      \"model\": \"wooderful:block/%s_barrel_open\"\n" +
					"    },\n" +
					"    \"facing=up,open=false\": {\n" +
					"      \"model\": \"wooderful:block/%s_barrel\"\n" +
					"    },\n" +
					"    \"facing=up,open=true\": {\n" +
					"      \"model\": \"wooderful:block/%s_barrel_open\"\n" +
					"    },\n" +
					"    \"facing=west,open=false\": {\n" +
					"      \"x\": 90,\n" +
					"      \"y\": 270,\n" +
					"      \"model\": \"wooderful:block/%s_barrel\"\n" +
					"    },\n" +
					"    \"facing=west,open=true\": {\n" +
					"      \"x\": 90,\n" +
					"      \"y\": 270,\n" +
					"      \"model\": \"wooderful:block/%s_barrel_open\"\n" +
					"    }\n" +
					"  }\n" +
					"}";

			clientResourcePackBuilder.add(id(String.format("blockstates/%s_barrel", woodType.getIdentifier().getPath())), new StringResource(template.replace("%s", woodType.getIdentifier().getPath())));

			ArtificeGenerationHelper.generateTopBottomBlockModel(clientResourcePackBuilder,
					id(String.format("%s_barrel", woodType.getIdentifier().getPath())),
					id(String.format("block/barrel/%s/top_closed", woodType.getIdentifier().getPath())),
					id(String.format("block/barrel/%s/bottom", woodType.getIdentifier().getPath())),
					id(String.format("block/barrel/%s/side", woodType.getIdentifier().getPath())));

			ArtificeGenerationHelper.generateTopBottomBlockModel(clientResourcePackBuilder,
					id(String.format("%s_barrel_open", woodType.getIdentifier().getPath())),
					id(String.format("block/barrel/%s/top_open", woodType.getIdentifier().getPath())),
					id(String.format("block/barrel/%s/bottom", woodType.getIdentifier().getPath())),
					id(String.format("block/barrel/%s/side", woodType.getIdentifier().getPath())));
		}));
	}
}
