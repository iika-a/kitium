package net.tonyearlnate.unbounded_unknown.datagen;

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
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.tonyearlnate.unbounded_unknown.block.ModBlocks;
import net.tonyearlnate.unbounded_unknown.item.ModItems;
import net.tonyearlnate.unbounded_unknown.item.ModThrowables;

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
                        .pattern("BEB")
                        .pattern(" E ")
                        .pattern("PEP")
                        .input('B', ModItems.BLUE_KITIUM)
                        .input('E', ModItems.ENERGIZED_KITIUM)
                        .input('P', ModItems.PINK_KITIUM)
                        .criterion(hasItem(ModItems.PINK_KITIUM), conditionsFromItem(ModItems.PINK_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM), conditionsFromItem(ModItems.BLUE_KITIUM))
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
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

                createShaped(RecipeCategory.MISC, ModBlocks.PINK_KITIUM_PANELING, 8)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .input('A', ModItems.PINK_KITIUM_PANEL)
                        .input('B', Items.TUFF)
                        .criterion(hasItem(ModItems.PINK_KITIUM_PANEL), conditionsFromItem(ModItems.PINK_KITIUM_PANEL))
                        .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModBlocks.BLUE_KITIUM_PANELING, 8)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .input('A', ModItems.BLUE_KITIUM_PANEL)
                        .input('B', Items.TUFF)
                        .criterion(hasItem(ModItems.BLUE_KITIUM_PANEL), conditionsFromItem(ModItems.BLUE_KITIUM_PANEL))
                        .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModBlocks.ENERGIZED_KITIUM_PANELING, 8)
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
                        .input('N', Items.NETHERITE_SCRAP)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE))
                        .criterion(hasItem(ModItems.BLUE_KITIUM), conditionsFromItem(ModItems.BLUE_KITIUM))
                        .criterion(hasItem(ModItems.PINK_KITIUM), conditionsFromItem(ModItems.PINK_KITIUM))
                        .criterion(hasItem(Items.NETHERITE_SCRAP), conditionsFromItem(Items.NETHERITE_SCRAP))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_SWORD_FRAME)
                        .pattern("BEP")
                        .input('B', ModItems.BLUE_KITIUM_SWORD)
                        .input('E', ModItems.ENERGIZED_KITIUM)
                        .input('P', ModItems.PINK_KITIUM_SWORD)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM_SWORD), conditionsFromItem(ModItems.BLUE_KITIUM_SWORD))
                        .criterion(hasItem(ModItems.PINK_KITIUM_SWORD), conditionsFromItem(ModItems.PINK_KITIUM_SWORD))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_PICKAXE_FRAME)
                        .pattern("BEP")
                        .input('B', ModItems.BLUE_KITIUM_PICKAXE)
                        .input('E', ModItems.ENERGIZED_KITIUM)
                        .input('P', ModItems.PINK_KITIUM_PICKAXE)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM_PICKAXE), conditionsFromItem(ModItems.BLUE_KITIUM_PICKAXE))
                        .criterion(hasItem(ModItems.PINK_KITIUM_PICKAXE), conditionsFromItem(ModItems.PINK_KITIUM_PICKAXE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_AXE_FRAME)
                        .pattern("BEP")
                        .input('B', ModItems.BLUE_KITIUM_AXE)
                        .input('E', ModItems.ENERGIZED_KITIUM)
                        .input('P', ModItems.PINK_KITIUM_AXE)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM_AXE), conditionsFromItem(ModItems.BLUE_KITIUM_AXE))
                        .criterion(hasItem(ModItems.PINK_KITIUM_AXE), conditionsFromItem(ModItems.PINK_KITIUM_AXE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_SHOVEL_FRAME)
                        .pattern("BEP")
                        .input('B', ModItems.BLUE_KITIUM_SHOVEL)
                        .input('E', ModItems.ENERGIZED_KITIUM)
                        .input('P', ModItems.PINK_KITIUM_SHOVEL)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM_SHOVEL), conditionsFromItem(ModItems.BLUE_KITIUM_SHOVEL))
                        .criterion(hasItem(ModItems.PINK_KITIUM_SHOVEL), conditionsFromItem(ModItems.PINK_KITIUM_SHOVEL))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_HOE_FRAME)
                        .pattern("BEP")
                        .input('B', ModItems.BLUE_KITIUM_HOE)
                        .input('E', ModItems.ENERGIZED_KITIUM)
                        .input('P', ModItems.PINK_KITIUM_HOE)
                        .criterion(hasItem(ModItems.ENERGIZED_KITIUM), conditionsFromItem(ModItems.ENERGIZED_KITIUM))
                        .criterion(hasItem(ModItems.BLUE_KITIUM_HOE), conditionsFromItem(ModItems.BLUE_KITIUM_HOE))
                        .criterion(hasItem(ModItems.PINK_KITIUM_HOE), conditionsFromItem(ModItems.PINK_KITIUM_HOE))
                        .offerTo(recipeExporter);

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

                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_SWORD_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_SWORD, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_PICKAXE_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_PICKAXE, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_AXE_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_AXE, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_SHOVEL_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_SHOVEL, this, recipeExporter);
                offerEnergizedKitiumUpgradeRecipe(ModItems.ENERGIZED_KITIUM_HOE_FRAME, RecipeCategory.TOOLS, ModItems.ENERGIZED_KITIUM_HOE, this, recipeExporter);
            }
        };
    }

    private static void offerSwordRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        recipeGenerator.createShaped(RecipeCategory.TOOLS, result)
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
                .pattern("SM")
                .pattern("S ")
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

    private static void offerEnergizedKitiumUpgradeRecipe(Item input, RecipeCategory category, Item result, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItem(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItem(input),
                        Ingredient.ofItem(ModItems.ENERGIZED_KITIUM_PANEL),
                        category,
                        result
                )
                .criterion(RecipeGenerator.hasItem(ModItems.ENERGIZED_KITIUM_PANEL), recipeGenerator.conditionsFromItem(ModItems.ENERGIZED_KITIUM_PANEL))
                .offerTo(recipeExporter, getItemPath(result) + "_smithing");
    }

    @Override
    public String getName() {
        return Identifier.of(UnboundedUnknown.MOD_ID, "recipe_provider").toString();
    }
}