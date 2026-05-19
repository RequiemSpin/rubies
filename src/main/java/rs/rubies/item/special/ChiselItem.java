package rs.rubies.item.special;

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
            new AbstractMap.SimpleEntry<>(Blocks.EMERALD_BLOCK, ModBlocks.RUBY_ORE),
            new AbstractMap.SimpleEntry<>(ModBlocks.RUBY_ORE, Blocks.EMERALD_BLOCK),
            new AbstractMap.SimpleEntry<>(Blocks.SAND, Blocks.RED_SAND),
            new AbstractMap.SimpleEntry<>(Blocks.RED_SAND, Blocks.SAND),
            new AbstractMap.SimpleEntry<>(Blocks.COBBLESTONE, Blocks.STONE),
            new AbstractMap.SimpleEntry<>(Blocks.STONE, Blocks.COBBLED_DEEPSLATE),
            new AbstractMap.SimpleEntry<>(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE),
            new AbstractMap.SimpleEntry<>(Blocks.DEEPSLATE, Blocks.NETHERRACK),
            new AbstractMap.SimpleEntry<>(Blocks.NETHERRACK, Blocks.END_STONE),
            new AbstractMap.SimpleEntry<>(Blocks.END_STONE, Blocks.COBBLESTONE),
            new AbstractMap.SimpleEntry<>(Blocks.ANDESITE, Blocks.DIORITE),
            new AbstractMap.SimpleEntry<>(Blocks.DIORITE, Blocks.GRANITE),
            new AbstractMap.SimpleEntry<>(Blocks.GRANITE, Blocks.ANDESITE),
            new AbstractMap.SimpleEntry<>(Blocks.GLOWSTONE, Blocks.SHROOMLIGHT),
            new AbstractMap.SimpleEntry<>(Blocks.SHROOMLIGHT, Blocks.SPORE_BLOSSOM),
            new AbstractMap.SimpleEntry<>(Blocks.SPORE_BLOSSOM, Blocks.GLOWSTONE),
            new AbstractMap.SimpleEntry<>(Blocks.BEDROCK, Blocks.BARRIER),
            new AbstractMap.SimpleEntry<>(Blocks.BARRIER, Blocks.BEDROCK)
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
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), context.getHand());
        }

        return InteractionResult.SUCCESS;
    }
}
