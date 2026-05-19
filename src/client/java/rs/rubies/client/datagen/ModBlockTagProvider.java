package rs.rubies.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import rs.rubies.Rubies;
import rs.rubies.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public static final TagKey<Block> RUBY_BLOCKS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, "ruby_blocks"));
    public static final TagKey<Block> RUBY_ORES = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, "ruby_ores"));

    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        valueLookupBuilder(RUBY_ORES)
                .add(ModBlocks.RUBY_DEEPSLATE_ORE)
                .add(ModBlocks.RUBY_ORE);
        valueLookupBuilder(RUBY_BLOCKS)
                .add(ModBlocks.RUBY_BLOCK)
                .addTag(RUBY_ORES);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(RUBY_BLOCKS);
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .addTag(RUBY_BLOCKS);

        valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.RUBY_BLOCK);
    }
}
