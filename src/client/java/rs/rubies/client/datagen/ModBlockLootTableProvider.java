package rs.rubies.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import rs.rubies.block.ModBlocks;
import rs.rubies.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        // Miscellaneous
        dropSelf(ModBlocks.RUBY_BLOCK);
        dropSelf(ModBlocks.LEAD_BLOCK);
        dropSelf(ModBlocks.RAW_LEAD_BLOCK);

        // Ore Blocks
        add(ModBlocks.RUBY_ORE, createOreDrop(ModBlocks.RUBY_ORE, ModItems.RUBY));
        add(ModBlocks.RUBY_DEEPSLATE_ORE, createOreDrop(ModBlocks.RUBY_DEEPSLATE_ORE, ModItems.RUBY));
        add(ModBlocks.RETURN_ORE, createOreDrop(ModBlocks.RETURN_ORE, ModItems.RETURN_PEBBLE));
        add(ModBlocks.RETURN_DEEPSLATE_ORE, createOreDrop(ModBlocks.RETURN_DEEPSLATE_ORE, ModItems.RETURN_PEBBLE));
        add(ModBlocks.LEAD_ORE, createOreDrop(ModBlocks.LEAD_ORE, ModItems.RAW_LEAD));
        add(ModBlocks.LEAD_DEEPSLATE_ORE, createOreDrop(ModBlocks.LEAD_DEEPSLATE_ORE, ModItems.RAW_LEAD));
    }
}
