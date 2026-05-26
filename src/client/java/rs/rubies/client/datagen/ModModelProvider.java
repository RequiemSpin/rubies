package rs.rubies.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import rs.rubies.block.ModBlocks;
import rs.rubies.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        blockModelGenerators.createTrivialCube(ModBlocks.RUBY_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RUBY_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RUBY_DEEPSLATE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RETURN_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RETURN_DEEPSLATE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.LEAD_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_LEAD_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.LEAD_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.LEAD_DEEPSLATE_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

        itemModelGenerators.generateFlatItem(ModItems.RUBY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEAD_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_LEAD, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.VACANT_TRINKET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TRINKET_NIMBLENESS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TRINKET_CONDUIT_CONDUCER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHATTERED_VACANT_TRINKET, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.PHILOSOPHERS_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RETURN_PEBBLE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KASANE_PEARTO, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADOCADO, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEEKU, ModelTemplates.FLAT_ITEM);

    }
}
