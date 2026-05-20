package rs.rubies.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;
import rs.rubies.block.ModBlocks;
import rs.rubies.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                // "Tags"
                List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.RUBY_DEEPSLATE_ORE);
                List<ItemLike> LEAD_SMELTABLES = List.of(ModBlocks.LEAD_ORE, ModBlocks.LEAD_DEEPSLATE_ORE);

                // Ores
                oreSmelting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.RUBY, 1, 200, "ruby");
                oreBlasting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.RUBY, 1, 100, "ruby");
                oreSmelting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT, 1, 200, "lead");
                oreBlasting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT, 1, 100, "lead");

                // Ingot to Block
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.LEAD_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK);

                // Trinkets
                shapeless(RecipeCategory.MISC, ModItems.SHATTERED_VACANT_TRINKET)
                        .requires(ModItems.PHILOSOPHERS_CHISEL).requires(Items.HEARTBREAK_POTTERY_SHERD)
                        .unlockedBy(getHasName(ModItems.PHILOSOPHERS_CHISEL), has(ModItems.PHILOSOPHERS_CHISEL)).group(("trinkets"));

                // Miscellaneous
                shaped(RecipeCategory.MISC, ModItems.PHILOSOPHERS_CHISEL)
                        .pattern(" #@").pattern(" %#").pattern("#  ")
                        .define('#', ModItems.LEAD_INGOT).define('@', ModItems.RUBY).define('%', ModItems.BLOOD_VIAL)
                        .unlockedBy(getHasName(ModItems.BLOOD_VIAL), has(ModItems.BLOOD_VIAL)).group(("group"));


                /*

                List<ItemLike> INPUT_LIST = List.of(ModItems.INPUT1, ModItems.INPUT2);

                oreSmelting(INPUT_LIST, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.OUTPUT, 1, 200, "group");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.OUTPUT, RecipeCategory.BUILDING_BLOCKS, ModItems.INPUT);

                shaped(RecipeCategory.MISC, ModItems.OUTPUT)
                        .pattern("###").pattern("###").pattern("###")
                        .define('#', ModItems.INPUT)
                        .unlockedBy(getHasName(ModItems.INPUT), has(ModItems.INPUT)).group(("group").save(output));

                shapeless(RecipeCategory.MISC, ModItems.OUTPUT)
                        .requires(ModItems.INPUT)
                        .unlockedBy(getHasName(ModItems.INPUT), has(ModItems.INPUT)).group(("group").save(output));

                */
            }

        };
    }

    @Override
    public String getName() {
        return "Rubies' Recipes";
    }
}
