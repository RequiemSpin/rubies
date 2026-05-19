package rs.rubies.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
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
                List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.RUBY_DEEPSLATE_ORE);

                oreSmelting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.RUBY, 1, 200, "ruby");
                oreBlasting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.RUBY, 1, 100, "ruby");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);


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
