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

        dropSelf(ModBlocks.RUBY_BLOCK);

        add(ModBlocks.RUBY_ORE, createOreDrop(ModBlocks.RUBY_ORE, ModItems.RUBY));
        add(ModBlocks.RUBY_DEEPSLATE_ORE, createOreDrop(ModBlocks.RUBY_DEEPSLATE_ORE, ModItems.RUBY));
    }
}
