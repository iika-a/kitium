package net.tonyearlnate.unbounded_unknown.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.tonyearlnate.unbounded_unknown.block.ModBlocks;
import net.tonyearlnate.unbounded_unknown.item.ModItems;
import net.tonyearlnate.unbounded_unknown.item.ModThrowables;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

                createSwordRecipe(ModItems.PINK_KITIUM_SWORD, ModItems.PINK_KITIUM, this, recipeExporter);
                createPickaxeRecipe(ModItems.PINK_KITIUM_PICKAXE, ModItems.PINK_KITIUM, this, recipeExporter);
                createAxeRecipe(ModItems.PINK_KITIUM_AXE, ModItems.PINK_KITIUM, this, recipeExporter);
                createShovelRecipe(ModItems.PINK_KITIUM_SHOVEL, ModItems.PINK_KITIUM, this, recipeExporter);
                createHoeRecipe(ModItems.PINK_KITIUM_HOE, ModItems.PINK_KITIUM, this, recipeExporter);
                createSwordRecipe(ModItems.BLUE_KITIUM_SWORD, ModItems.BLUE_KITIUM, this, recipeExporter);
                createPickaxeRecipe(ModItems.BLUE_KITIUM_PICKAXE, ModItems.BLUE_KITIUM, this, recipeExporter);
                createAxeRecipe(ModItems.BLUE_KITIUM_AXE, ModItems.BLUE_KITIUM, this, recipeExporter);
                createShovelRecipe(ModItems.BLUE_KITIUM_SHOVEL, ModItems.BLUE_KITIUM, this, recipeExporter);
                createHoeRecipe(ModItems.BLUE_KITIUM_HOE, ModItems.BLUE_KITIUM, this, recipeExporter);
                createSwordRecipe(ModItems.ENERGIZED_KITIUM_SWORD, ModItems.BLUE_KITIUM, this, recipeExporter);
                createPickaxeRecipe(ModItems.ENERGIZED_KITIUM_PICKAXE, ModItems.BLUE_KITIUM, this, recipeExporter);
                createAxeRecipe(ModItems.ENERGIZED_KITIUM_AXE, ModItems.BLUE_KITIUM, this, recipeExporter);
                createShovelRecipe(ModItems.ENERGIZED_KITIUM_SHOVEL, ModItems.BLUE_KITIUM, this, recipeExporter);
                createHoeRecipe(ModItems.ENERGIZED_KITIUM_HOE, ModItems.BLUE_KITIUM, this, recipeExporter);
            }
        };
    }

    private static void createSwordRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
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

    private static void createPickaxeRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
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

    private static void createAxeRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
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

    private static void createShovelRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
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

    private static void createHoeRecipe(Item result, Item material, RecipeGenerator recipeGenerator, RecipeExporter recipeExporter) {
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

    @Override
    public String getName() {
        return Identifier.of(UnboundedUnknown.MOD_ID, "recipe_provider").toString();
    }
}