package rs.rubies.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import rs.rubies.Rubies;
import rs.rubies.block.special.RubyBlock;

import java.util.function.Function;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block", properties -> new RubyBlock(properties.requiresCorrectToolForDrops()
            .strength(5.0f, 6.0f).sound(SoundType.METAL).mapColor(MapColor.FIRE)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore", properties -> new DropExperienceBlock(UniformInt.of(3, 7), properties.requiresCorrectToolForDrops()
            .strength(3.0f, 3.0f).sound(SoundType.STONE).mapColor(MapColor.STONE)));
    public static final Block RUBY_DEEPSLATE_ORE = registerBlock("ruby_deepslate_ore", properties -> new DropExperienceBlock(UniformInt.of(3, 7), properties.requiresCorrectToolForDrops()
            .strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE).mapColor(MapColor.DEEPSLATE)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, name)))));
    }

    public static void registerMobBlocks() {
        Rubies.LOGGER.info("Registering Blocks" + Rubies.MOD_ID);
    }
}
