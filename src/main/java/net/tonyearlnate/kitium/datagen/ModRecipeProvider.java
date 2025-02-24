package net.tonyearlnate.kitium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.tonyearlnate.kitium.Kitium;
import net.tonyearlnate.kitium.block.ModBlocks;
import net.tonyearlnate.kitium.item.ModItems;
import net.tonyearlnate.kitium.item.ModThrowables;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipe.RecipeGenerator.getItemPath;

@SuppressWarnings("SameParameterValue")
public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_KITIUM_SMELTABLES = List.of(ModBlocks.PINK_KITIUM_ORE, ModBlocks.DEEPSLATE_PINK_KITIUM_ORE, ModItems.RAW_PINK_KITIUM);
                List<ItemConvertible> BLUE_KITIUM_SMELTABLES = List.of(ModBlocks.BLUE_KITIUM_ORE, ModItems.RAW_BLUE_KITIUM);

                offerSmelting(PINK_KITIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_KITIUM, 0.25f, 200, "pink_kitium");
                offerBlasting(PINK_KITIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_KITIUM, 0.25f, 100, "pink_kitium");
                offerSmelting(BLUE_KITIUM_SMELTABLES, RecipeCategory.MISC, ModItems.BLUE_KITIUM, 0.25f, 200, "blue_kitium");
                offerBlasting(BLUE_KITIUM_SMELTABLES, RecipeCategory.MISC, ModItems.BLUE_KITIUM, 0.25f, 100, "blue_kitium");

                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.PINK_KITIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_KITIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.BLUE_KITIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_KITIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.ENERGIZED_KITIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENERGIZED_KITIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.RAW_PINK_KITIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINK_KITIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.RAW_BLUE_KITIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_BLUE_KITIUM_BLOCK);

                createShaped(RecipeCategory.MISC, ModItems.ENERGIZED_KITIUM, 4)
                        .pattern("DPD")
                        .pattern("BLB")
                        .pattern("DPD")
                        .input('B', ModItems.BLUE_KITIUM)
                        .input('L', ModThrowables.LIGHTNING_BOTTLE)
                        .input('P', ModItems.PINK_KITIUM)
                        .input('D', Items.NETHERITE_SCRAP)
                        .criterion(hasItem(ModItems.PINK_KITIUM), conditionsFromItem(ModItems.PINK_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM), conditionsFromItem(ModItems.BLUE_KITIUM))
                        .criterion(hasItem(ModThrowables.LIGHTNING_BOTTLE), conditionsFromItem(ModThrowables.LIGHTNING_BOTTLE))
                        .offerTo(recipeExporter, "energized_kitium_from_kitium");

                createShaped(RecipeCategory.TOOLS, ModItems.THUNDERSTORM_SPAWNER)
                        .pattern("BIB")
                        .pattern(" I ")
                        .pattern("PIP")
                        .input('B', ModItems.BLUE_KITIUM)
                        .input('I', Items.IRON_INGOT)
                        .input('P', ModItems.PINK_KITIUM)
                        .criterion(hasItem(ModItems.PINK_KITIUM), conditionsFromItem(ModItems.PINK_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM), conditionsFromItem(ModItems.BLUE_KITIUM))
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModBlocks.LIGHTNING_COLLECTOR)
                        .pattern("ICI")
                        .pattern("PNB")
                        .pattern("III")
                        .input('I', Items.IRON_INGOT)
                        .input('C', Items.COPPER_INGOT)
                        .input('P', ModItems.PINK_KITIUM)
                        .input('N', Items.NETHERITE_SCRAP)
                        .input('B', ModItems.BLUE_KITIUM)
                        .criterion(hasItem(ModItems.PINK_KITIUM), conditionsFromItem(ModItems.PINK_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM), conditionsFromItem(ModItems.BLUE_KITIUM))
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .criterion(hasItem(Items.NETHERITE_SCRAP), conditionsFromItem(Items.NETHERITE_SCRAP))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.PINK_KITIUM_PANEL, 2)
                        .pattern("AA")
                        .input('A', ModItems.PINK_KITIUM)
                        .criterion(hasItem(ModItems.PINK_KITIUM), conditionsFromItem(ModItems.PINK_KITIUM))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.BLUE_KITIUM_PANEL, 2)
                        .pattern("AA")
                        .input('A', ModItems.BLUE_KITIUM)
                        .criterion(hasItem(ModItems.BLUE_KITIUM), conditionsFromItem(ModItems.BLUE_KITIUM))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.ENERGIZED_KITIUM_PANEL, 2)
                        .pattern("AA")
                        .input('A', ModItems.ENERGIZED_KITIUM)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.CORRUPT_PANEL, 2)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .input('A', Items.ECHO_SHARD)
                        .input('B', ModItems.ENERGIZED_KITIUM_PANEL)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModBlocks.PINK_KITIUM_PANELING, 16)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .input('A', ModItems.PINK_KITIUM_PANEL)
                        .input('B', Items.TUFF)
                        .criterion(hasItem(ModItems.PINK_KITIUM_PANEL), conditionsFromItem(ModItems.PINK_KITIUM_PANEL))
                        .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModBlocks.BLUE_KITIUM_PANELING, 16)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .input('A', ModItems.BLUE_KITIUM_PANEL)
                        .input('B', Items.TUFF)
                        .criterion(hasItem(ModItems.BLUE_KITIUM_PANEL), conditionsFromItem(ModItems.BLUE_KITIUM_PANEL))
                        .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModBlocks.ENERGIZED_KITIUM_PANELING, 16)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .input('A', ModItems.ENERGIZED_KITIUM_PANEL)
                        .input('B', Items.TUFF)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_PANEL), conditionsFromItem(ModItems.ENERGIZED_KITIUM_PANEL))
                        .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE, 2)
                        .pattern("BUB")
                        .pattern("PNP")
                        .pattern("BPB")
                        .input('U', ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE)
                        .input('B', ModItems.BLUE_KITIUM)
                        .input('P', ModItems.PINK_KITIUM)
                        .input('N', Items.NETHERITE_INGOT)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE))
                        .criterion(hasItem(ModItems.BLUE_KITIUM), conditionsFromItem(ModItems.BLUE_KITIUM))
                        .criterion(hasItem(ModItems.PINK_KITIUM), conditionsFromItem(ModItems.PINK_KITIUM))
                        .criterion(hasItem(Items.NETHERITE_SCRAP), conditionsFromItem(Items.NETHERITE_SCRAP))
                        .offerTo(recipeExporter);

                createShapeless(RecipeCategory.MISC, ModBlocks.WHITE_KITIUM_BLOCK)
                        .input(ModItems.ENERGIZED_KITIUM_SWORD)
                        .input(ModItems.ENERGIZED_KITIUM_PICKAXE)
                        .input(ModItems.ENERGIZED_KITIUM_AXE)
                        .input(ModItems.ENERGIZED_KITIUM_SHOVEL)
                        .input(ModItems.ENERGIZED_KITIUM_HOE)
                        .input(ModItems.ENERGIZED_KITIUM_HELMET)
                        .input(ModItems.ENERGIZED_KITIUM_CHESTPLATE)
                        .input(ModItems.ENERGIZED_KITIUM_LEGGINGS)
                        .input(ModItems.ENERGIZED_KITIUM_BOOTS)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_SWORD), conditionsFromItem(ModItems.ENERGIZED_KITIUM_SWORD))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_PICKAXE), conditionsFromItem(ModItems.ENERGIZED_KITIUM_PICKAXE))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_AXE), conditionsFromItem(ModItems.ENERGIZED_KITIUM_AXE))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_SHOVEL), conditionsFromItem(ModItems.ENERGIZED_KITIUM_SHOVEL))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_HOE), conditionsFromItem(ModItems.ENERGIZED_KITIUM_HOE))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_HELMET), conditionsFromItem(ModItems.ENERGIZED_KITIUM_HELMET))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_CHESTPLATE), conditionsFromItem(ModItems.ENERGIZED_KITIUM_CHESTPLATE))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_LEGGINGS), conditionsFromItem(ModItems.ENERGIZED_KITIUM_LEGGINGS))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_BOOTS), conditionsFromItem(ModItems.ENERGIZED_KITIUM_BOOTS))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.BLUE_KITIUM_APPLE, 1)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .input('A', net.tonyearlnate.kitium.item.ModItems.BLUE_KITIUM)
                        .input('B', Items.APPLE)
                        .criterion(hasItem(ModItems.BLUE_KITIUM), conditionsFromItem(ModItems.BLUE_KITIUM))
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, net.tonyearlnate.kitium.item.ModItems.PINK_KITIUM_APPLE, 1)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .input('A', ModItems.PINK_KITIUM)
                        .input('B', Items.APPLE)
                        .criterion(hasItem(ModItems.PINK_KITIUM), conditionsFromItem(ModItems.PINK_KITIUM))
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.ENERGIZED_KITIUM_APPLE, 1)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .input('A', ModItems.ENERGIZED_KITIUM)
                        .input('B', Items.APPLE)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, net.tonyearlnate.kitium.item.ModItems.MACE_HUSK, 1)
                        .pattern("AAA")
                        .pattern("CBC")
                        .pattern("AAA")
                        .input('A', ModItems.ENERGIZED_KITIUM)
                        .input('B', Items.HEAVY_CORE)
                        .input('C', Items.NETHERITE_INGOT)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                        .criterion(hasItem(Items.HEAVY_CORE), conditionsFromItem(Items.HEAVY_CORE))
                        .offerTo(recipeExporter);


                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_SWORD, ModItems.PINK_KITIUM_SWORD, Items.NETHERITE_SWORD, ModItems.ENERGIZED_KITIUM_SWORD_FRAME, RecipeCategory.COMBAT, this, recipeExporter);
                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_PICKAXE, ModItems.PINK_KITIUM_PICKAXE, Items.NETHERITE_PICKAXE, ModItems.ENERGIZED_KITIUM_PICKAXE_FRAME, RecipeCategory.TOOLS, this, recipeExporter);
                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_AXE, ModItems.PINK_KITIUM_AXE, Items.NETHERITE_AXE, ModItems.ENERGIZED_KITIUM_AXE_FRAME, RecipeCategory.TOOLS, this, recipeExporter);
                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_SHOVEL, ModItems.PINK_KITIUM_SHOVEL, Items.NETHERITE_SHOVEL, ModItems.ENERGIZED_KITIUM_SHOVEL_FRAME, RecipeCategory.TOOLS, this, recipeExporter);
                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_HOE, ModItems.PINK_KITIUM_HOE, Items.NETHERITE_HOE, ModItems.ENERGIZED_KITIUM_HOE_FRAME, RecipeCategory.TOOLS, this, recipeExporter);
                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_HELMET, ModItems.PINK_KITIUM_HELMET, Items.NETHERITE_HELMET, ModItems.ENERGIZED_KITIUM_HELMET_FRAME, RecipeCategory.COMBAT, this, recipeExporter);
                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_CHESTPLATE, ModItems.PINK_KITIUM_CHESTPLATE, Items.NETHERITE_CHESTPLATE, ModItems.ENERGIZED_KITIUM_CHESTPLATE_FRAME, RecipeCategory.COMBAT, this, recipeExporter);
                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_LEGGINGS, ModItems.PINK_KITIUM_LEGGINGS, Items.NETHERITE_LEGGINGS, ModItems.ENERGIZED_KITIUM_LEGGINGS_FRAME, RecipeCategory.COMBAT, this, recipeExporter);
                offerEnergizedKitiumFrameRecipe(ModItems.BLUE_KITIUM_BOOTS, ModItems.PINK_KITIUM_BOOTS, Items.NETHERITE_BOOTS, ModItems.ENERGIZED_KITIUM_BOOTS_FRAME, RecipeCategory.COMBAT, this, recipeExporter);

                offerSwordRecipe(ModItems.PINK_KITIUM_SWORD, ModItems.PINK_KITIUM, this, recipeExporter);
                offerPickaxeRecipe(ModItems.PINK_KITIUM_PICKAXE, ModItems.PINK_KITIUM, this, recipeExporter);
                offerAxeRecipe(ModItems.PINK_KITIUM_AXE, ModItems.PINK_KITIUM, this, recipeExporter);
                offerShovelRecipe(ModItems.PINK_KITIUM_SHOVEL, ModItems.PINK_KITIUM, this, recipeExporter);
                offerHoeRecipe(ModItems.PINK_KITIUM_HOE, ModItems.PINK_KITIUM, this, recipeExporter);
                offerSwordRecipe(ModItems.BLUE_KITIUM_SWORD, ModItems.BLUE_KITIUM, this, recipeExporter);
                offerPickaxeRecipe(ModItems.BLUE_KITIUM_PICKAXE, ModItems.BLUE_KITIUM, this, recipeExporter);
                offerAxeRecipe(ModItems.BLUE_KITIUM_AXE, ModItems.BLUE_KITIUM, this, recipeExporter);
                offerShovelRecipe(ModItems.BLUE_KITIUM_SHOVEL, ModItems.BLUE_KITIUM, this, recipeExporter);
                offerHoeRecipe(ModItems.BLUE_KITIUM_HOE, ModItems.BLUE_KITIUM, this, recipeExporter);

                offerHelmetRecipe(ModItems.PINK_KITIUM_HELMET, ModItems.PINK_KITIUM, this, recipeExporter);
                offerChestplateRecipe(ModItems.PINK_KITIUM_CHESTPLATE, ModItems.PINK_KITIUM, this, recipeExporter);
                offerLeggingsRecipe(ModItems.PINK_KITIUM_LEGGINGS, ModItems.PINK_KITIUM, this, recipeExporter);
                offerBootsRecipe(ModItems.PINK_KITIUM_BOOTS, ModItems.PINK_KITIUM, this, recipeExporter);
                offerHelmetRecipe(ModItems.BLUE_KITIUM_HELMET, ModItems.BLUE_KITIUM, this, recipeExporter);
                offerChestplateRecipe(ModItems.BLUE_KITIUM_CHESTPLATE, ModItems.BLUE_KITIUM, this, recipeExporter);
                offerLeggingsRecipe(ModItems.BLUE_KITIUM_LEGGINGS, ModItems.BLUE_KITIUM, this, recipeExporter);
                offerBootsRecipe(ModItems.BLUE_KITIUM_BOOTS, ModItems.BLUE_KITIUM, this, recipeExporter);

                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_SWORD_FRAME, RecipeCategory.COMBAT, ModItems.ENERGIZED_KITIUM_SWORD, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_PICKAXE_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_PICKAXE, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_AXE_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_AXE, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_SHOVEL_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_SHOVEL, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_HOE_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_HOE, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_HELMET_FRAME, RecipeCategory.COMBAT, ModItems.ENERGIZED_KITIUM_HELMET, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_CHESTPLATE_FRAME, RecipeCategory.COMBAT, ModItems.ENERGIZED_KITIUM_CHESTPLATE, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_LEGGINGS_FRAME, RecipeCategory.COMBAT, ModItems.ENERGIZED_KITIUM_LEGGINGS, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_BOOTS_FRAME, RecipeCategory.COMBAT, ModItems.ENERGIZED_KITIUM_BOOTS, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.MACE_HUSK, RecipeCategory.COMBAT, ModItems.ENERGIZED_MACE, this, recipeExporter);

                offerCorruptEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_SWORD_FRAME, RecipeCategory.COMBAT, ModItems.CORRUPT_SWORD, this, recipeExporter);
                offerCorruptEnergizedKitiumUpgradeRecipe(ModItems.MACE_HUSK, RecipeCategory.COMBAT, ModItems.CORRUPT_MACE, this, recipeExporter);
                offerCorruptEnergizedKitiumUpgradeRecipe(Items.TOTEM_OF_UNDYING, RecipeCategory.COMBAT, ModItems.CORRUPT_TOTEM, this, recipeExporter);

                offerCorruptEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_HELMET_FRAME, RecipeCategory.COMBAT, ModItems.CORRUPT_HELMET, this, recipeExporter);
                offerCorruptEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_CHESTPLATE_FRAME, RecipeCategory.COMBAT, ModItems.CORRUPT_CHESTPLATE, this, recipeExporter);
                offerCorruptEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_LEGGINGS_FRAME, RecipeCategory.COMBAT, ModItems.CORRUPT_LEGGINGS, this, recipeExporter);
                offerCorruptEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_BOOTS_FRAME, RecipeCategory.COMBAT, ModItems.CORRUPT_BOOTS, this, recipeExporter);


            }
        };
    }

    private static void offerSwordRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.COMBAT, result)
                .pattern("M")
                .pattern("M")
                .pattern("S")
                .input('M', material)
                .input('S', Items.STICK)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .criterion(RecipeGenerator.hasItem(Items.STICK), recipeGenerator.conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    }

    private static void offerPickaxeRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.TOOLS, result)
                .pattern("MMM")
                .pattern(" S ")
                .pattern(" S ")
                .input('M', material)
                .input('S', Items.STICK)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .criterion(RecipeGenerator.hasItem(Items.STICK), recipeGenerator.conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    }

    private static void offerAxeRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.TOOLS, result)
                .pattern("MM")
                .pattern("MS")
                .pattern(" S")
                .input('M', material)
                .input('S', Items.STICK)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .criterion(RecipeGenerator.hasItem(Items.STICK), recipeGenerator.conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    }

    private static void offerShovelRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.TOOLS, result)
                .pattern("M")
                .pattern("S")
                .pattern("S")
                .input('M', material)
                .input('S', Items.STICK)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .criterion(RecipeGenerator.hasItem(Items.STICK), recipeGenerator.conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    }

    private static void offerHoeRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.TOOLS, result)
                .pattern("MM")
                .pattern("S ")
                .pattern("S ")
                .input('M', material)
                .input('S', Items.STICK)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .criterion(RecipeGenerator.hasItem(Items.STICK), recipeGenerator.conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    }

    private static void offerHelmetRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.COMBAT, result)
                .pattern("MMM")
                .pattern("M M")
                .input('M', material)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .offerTo(recipeExporter);
    }

    private static void offerChestplateRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.COMBAT, result)
                .pattern("M M")
                .pattern("MMM")
                .pattern("MMM")
                .input('M', material)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .offerTo(recipeExporter);
    }

    private static void offerLeggingsRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.COMBAT, result)
                .pattern("MMM")
                .pattern("M M")
                .pattern("M M")
                .input('M', material)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .offerTo(recipeExporter);
    }

    private static void offerBootsRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.COMBAT, result)
                .pattern("M M")
                .pattern("M M")
                .input('M', material)
                .criterion(RecipeGenerator.hasItem(material), recipeGenerator.conditionsFromItem(material))
                .offerTo(recipeExporter);
    }

    private static void offerEnergizedKitiumUpgradeRecipe(Item input, RecipeCategory category, Item result, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItem(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItem(input),
                        Ingredient.ofItem(ModItems.ENERGIZED_KITIUM_PANEL),
                        category,
                        result
                )
                .criterion(RecipeGenerator.hasItem(ModItems.ENERGIZED_KITIUM_PANEL), recipeGenerator.conditionsFromItem(ModItems.ENERGIZED_KITIUM_PANEL))
                .criterion(RecipeGenerator.hasItem(input), recipeGenerator.conditionsFromItem(input))
                .offerTo(recipeExporter, getItemPath(result) + "_smithing");
    }
    private static void offerCorruptEnergizedKitiumUpgradeRecipe(Item input, RecipeCategory category, Item result, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItem(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItem(input),
                        Ingredient.ofItem(ModItems.CORRUPT_PANEL),
                        category,
                        result
                )
                .criterion(RecipeGenerator.hasItem(ModItems.CORRUPT_PANEL), recipeGenerator.conditionsFromItem(ModItems.CORRUPT_PANEL))
                .criterion(RecipeGenerator.hasItem(input), recipeGenerator.conditionsFromItem(input))
                .offerTo(recipeExporter, getItemPath(result) + "_smithing");
    }

    private static void offerEnergizedKitiumFrameRecipe(Item input1, Item input2, Item input3, Item result, RecipeCategory category, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShapeless(category, result)
                .input(input1)
                .input(input2)
                .input(input3)
                .input(ModItems.ENERGIZED_KITIUM)
                .criterion(RecipeGenerator.hasItem(ModItems.ENERGIZED_KITIUM), recipeGenerator.conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                .criterion(RecipeGenerator.hasItem(input1), recipeGenerator.conditionsFromItem(input1))
                .criterion(RecipeGenerator.hasItem(input2), recipeGenerator.conditionsFromItem(input2))
                .criterion(RecipeGenerator.hasItem(input3), recipeGenerator.conditionsFromItem(input3))
                .offerTo(recipeExporter);
    }

    @Override
    public String getName() {
        return Identifier.of(Kitium.MOD_ID, "recipe_provider").toString();
    }
}