package rs.rubies.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import rs.rubies.Rubies;
import rs.rubies.block.ModBlocks;
import rs.rubies.item.ModItems;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;
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
                List<ItemLike> LEAD_SMELTABLES = List.of(ModBlocks.LEAD_ORE, ModBlocks.LEAD_DEEPSLATE_ORE, ModItems.RAW_LEAD);

                // Ores
                oreSmelting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.RUBY, 1, 200, "ruby");
                oreBlasting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.RUBY, 1, 100, "ruby");
                oreSmelting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT, 1, 200, "lead");
                oreBlasting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT, 1, 100, "lead");

                // Ingot/Gem to Block
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.LEAD_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_LEAD, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_LEAD_BLOCK);

                // Trinkets
                shaped(RecipeCategory.MISC, ModItems.SHATTERED_VACANT_TRINKET, 1)
                        .pattern("@#@").pattern("@%@").pattern("@@@")
                        .define('#', ModItems.PHILOSOPHERS_CHISEL).define('%', Items.HEARTBREAK_POTTERY_SHERD).define('@', ModItems.LEAD_INGOT)
                        .unlockedBy(getHasName(Items.HEARTBREAK_POTTERY_SHERD), has(Items.HEARTBREAK_POTTERY_SHERD)).group("trinkets").save(output);


                // Miscellaneous
                shaped(RecipeCategory.MISC, ModItems.PHILOSOPHERS_CHISEL, 1)
                        .pattern(" #@").pattern(" %#").pattern("#  ")
                        .define('#', ModItems.LEAD_INGOT).define('@', ModBlocks.RUBY_BLOCK).define('%', ModItems.BLOOD_VIAL)
                        .unlockedBy(getHasName(ModItems.BLOOD_VIAL), has(ModItems.BLOOD_VIAL)).group("chisel").save(output);
                shapeless(RecipeCategory.MISC, ModItems.BLOOD_VIAL)
                        .requires(ModItems.RUBY).requires(Items.GLASS_BOTTLE)
                        .unlockedBy(getHasName(Items.GLASS_BOTTLE), has(Items.GLASS_BOTTLE)).group("vial").save(output);

                /*

                List<ItemLike> INPUT_LIST = List.of(ModItems.INPUT1, ModItems.INPUT2);

                oreSmelting(INPUT_LIST, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.OUTPUT, 1, 200, "group");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.OUTPUT, RecipeCategory.BUILDING_BLOCKS, ModItems.INPUT);

                shaped(RecipeCategory.MISC, ModItems.OUTPUT)
                        .pattern("###").pattern("###").pattern("###")
                        .define('#', ModItems.INPUT)
                        .unlockedBy(getHasName(ModItems.INPUT), has(ModItems.INPUT)).group("group").save(output));

                shapeless(RecipeCategory.MISC, ModItems.OUTPUT)
                        .requires(ModItems.INPUT)
                        .unlockedBy(getHasName(ModItems.INPUT), has(ModItems.INPUT)).save(output));

                */
            }

        };
    }

    @Override
    public String getName() {
        return "Rubies' Recipes";
    }
}
