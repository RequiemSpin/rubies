package rs.rubies.item.special;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import rs.rubies.miscellaneous.ModDamageSources;

public class BloodVialItem extends Item {

    public BloodVialItem(Properties properties) { super(properties); }

    // Item Duration
    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity user) { return 20; }

    // Stretch
    public ItemUseAnimation getUseAnimation(final ItemStack itemStack) {
        return ItemUseAnimation.BOW;
    }

    // Hurt Player & Gain Durability
    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int ticksRemaining) {
        if ((ticksRemaining==1) && (livingEntity instanceof Player player) && (player instanceof ServerPlayer serverPlayer) && (livingEntity.getItemInHand(InteractionHand.MAIN_HAND).isDamaged())) {
            float currentHealth = player.getHealth();
            player.hurtServer((ServerLevel) level, ModDamageSources.registerDamageSource(DamageTypes.STARVE, level), 1f);
            if (currentHealth>=1f) {
                player.awardStat(Stats.ITEM_USED.get(this));
                player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(-1, player, InteractionHand.MAIN_HAND);
            }
        }
    }

    // Start Using
    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        if (attacker instanceof Player player && CommonItemFunctions.checkSacrifice(mob, 2)) {
            itemStack.hurtAndBreak(-1, attacker, player.getUsedItemHand());
        }
        super.hurtEnemy(itemStack, mob, attacker);
    }
}
