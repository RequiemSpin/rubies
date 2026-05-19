package rs.rubies.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    /*
    public static final TagKey<Item> RUBY_ORES = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, "ruby_ores"));
    */
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, @Nullable BlockTagsProvider blockTagsProvider) {
        super(output, registryLookupFuture, blockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        /*
        valueLookupBuilder(RUBY_ORES)
                .add(ModBlocks.RUBY_ORE);*/
    }
}
