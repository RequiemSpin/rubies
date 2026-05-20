package rs.rubies.item.special;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import rs.rubies.block.ModBlocks;

import java.util.AbstractMap;
import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP = Map.ofEntries(

            new AbstractMap.SimpleEntry<>(Blocks.GRASS_BLOCK, Blocks.PODZOL),
            new AbstractMap.SimpleEntry<>(Blocks.PODZOL, Blocks.MYCELIUM),
            new AbstractMap.SimpleEntry<>(Blocks.MYCELIUM, Blocks.PALE_MOSS_BLOCK),
            new AbstractMap.SimpleEntry<>(Blocks.PALE_MOSS_BLOCK, Blocks.MOSS_BLOCK),
            new AbstractMap.SimpleEntry<>(Blocks.MOSS_BLOCK, Blocks.GRASS_BLOCK),

            new AbstractMap.SimpleEntry<>(Blocks.SAND, Blocks.RED_SAND),
            new AbstractMap.SimpleEntry<>(Blocks.RED_SAND, Blocks.SAND),

            new AbstractMap.SimpleEntry<>(Blocks.ANDESITE, Blocks.DIORITE),
            new AbstractMap.SimpleEntry<>(Blocks.DIORITE, Blocks.GRANITE),
            new AbstractMap.SimpleEntry<>(Blocks.GRANITE, Blocks.ANDESITE),

            //STONE TO MOSSY
            new AbstractMap.SimpleEntry<>(Blocks.COBBLESTONE, Blocks.INFESTED_COBBLESTONE),
            new AbstractMap.SimpleEntry<>(Blocks.STONE, Blocks.INFESTED_STONE),
            new AbstractMap.SimpleEntry<>(Blocks.STONE_BRICKS, Blocks.INFESTED_STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Blocks.CHISELED_STONE_BRICKS, Blocks.INFESTED_CHISELED_STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Blocks.CRACKED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Blocks.MOSSY_STONE_BRICKS, Blocks.INFESTED_MOSSY_STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Blocks.DEEPSLATE, Blocks.INFESTED_DEEPSLATE),
            //MOSSY TO STONE
            new AbstractMap.SimpleEntry<>(Blocks.INFESTED_COBBLESTONE, Blocks.COBBLESTONE),
            new AbstractMap.SimpleEntry<>(Blocks.INFESTED_STONE, Blocks.STONE),
            new AbstractMap.SimpleEntry<>(Blocks.INFESTED_STONE_BRICKS, Blocks.STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Blocks.INFESTED_CHISELED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Blocks.INFESTED_CRACKED_STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Blocks.INFESTED_DEEPSLATE, Blocks.DEEPSLATE),

            new AbstractMap.SimpleEntry<>(Blocks.SPORE_BLOSSOM, Blocks.FIREFLY_BUSH),
            new AbstractMap.SimpleEntry<>(Blocks.FIREFLY_BUSH, Blocks.SPORE_BLOSSOM),

            new AbstractMap.SimpleEntry<>(Blocks.GLOWSTONE, Blocks.SHROOMLIGHT),
            new AbstractMap.SimpleEntry<>(Blocks.SHROOMLIGHT, Blocks.GLOWSTONE),

            new AbstractMap.SimpleEntry<>(Blocks.BEDROCK, Blocks.BARRIER),
            new AbstractMap.SimpleEntry<>(Blocks.BARRIER, Blocks.BEDROCK),

            new AbstractMap.SimpleEntry<>(Blocks.DEEPSLATE_EMERALD_ORE, ModBlocks.RUBY_DEEPSLATE_ORE),
            new AbstractMap.SimpleEntry<>(ModBlocks.RUBY_DEEPSLATE_ORE, ModBlocks.RUBY_ORE),
            new AbstractMap.SimpleEntry<>(ModBlocks.RUBY_ORE, Blocks.DEEPSLATE_EMERALD_ORE),

            new AbstractMap.SimpleEntry<>(Blocks.DIAMOND_ORE, ModBlocks.RETURN_ORE),
            new AbstractMap.SimpleEntry<>(ModBlocks.RETURN_ORE, ModBlocks.RETURN_DEEPSLATE_ORE),
            new AbstractMap.SimpleEntry<>(ModBlocks.RETURN_DEEPSLATE_ORE, Blocks.DIAMOND_ORE)
    );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock) && !level.isClientSide()) {
            level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

            assert context.getPlayer() != null;
            context.getPlayer().awardStat(Stats.ITEM_USED.get(this));
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), context.getHand());
        }

        return InteractionResult.SUCCESS;
    }
}
