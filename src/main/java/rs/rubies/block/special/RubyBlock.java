package rs.rubies.block.special;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import rs.rubies.item.ModItems;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class RubyBlock extends Block {

    private static final Map<Item, Item> TRANSFORM_MAP = new HashMap<>();

    public static void initializeTransformMap() {
        TRANSFORM_MAP.put(ModItems.SHATTERED_VACANT_TRINKET, ModItems.VACANT_TRINKET);
    }

    public RubyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {

        if (entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 5*20, 2));
        }

        if ((entity instanceof ItemEntity itemEntity) && (TRANSFORM_MAP.containsKey(itemEntity.getItem().getItem()))) {
            Item targetItem = TRANSFORM_MAP.get(itemEntity.getItem().getItem());
            level.addParticle(ParticleTypes.ENCHANT, pos.getX()+.65, pos.getY()+1, pos.getZ()+.5, 0, .5, 0);
            level.addParticle(ParticleTypes.ENCHANT, pos.getX()+.35, pos.getY()+1, pos.getZ()+.5, 0, .5, 0);
            level.addParticle(ParticleTypes.ENCHANT, pos.getX()+.5, pos.getY()+1, pos.getZ()+.65, 0, .5, 0);
            level.addParticle(ParticleTypes.ENCHANT, pos.getX()+.5, pos.getY()+1, pos.getZ()+.35, 0, .5, 0);
            level.playSound(entity, pos, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS, .5f, 1f);
            itemEntity.setItem(new ItemStack(targetItem, itemEntity.getItem().getCount()));
        }

        super.stepOn(level, pos, onState, entity);
    }

}
