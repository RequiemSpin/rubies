package rs.rubies.item.special;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.TeleportTransition;
import rs.rubies.Rubies;

public class ReturnItem extends Item {

    public ReturnItem(Properties properties) { super(properties); }

    // Item Duration
    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity user) { return 30; }

    // Stretch
    public ItemUseAnimation getUseAnimation(final ItemStack itemStack) {
        return ItemUseAnimation.BOW;
    }

    // Display Particles & TP
    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int ticksRemaining) {
        if ((ticksRemaining%15==0) && (!level.isClientSide())) {
            level.addParticle(ParticleTypes.PORTAL, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), .5f, .5f, .5f);
        }
        if ((ticksRemaining==1) && (livingEntity instanceof Player player) && (player instanceof ServerPlayer serverPlayer)) {
            player.teleport(serverPlayer.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING));
            level.playSound(null, player, SoundEvents.PORTAL_TRIGGER, SoundSource.PLAYERS, 0.05f, 3f);
        }
    }

    // Start Using
    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResult.SUCCESS;
    }
}
