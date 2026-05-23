package rs.rubies.item.special.trinkets;

import eu.pb4.trinkets.api.TrinketSlotAccess;
import eu.pb4.trinkets.api.callback.TrinketCallback;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import rs.rubies.Rubies;

import java.util.function.BiConsumer;

public class ConduitConducerTrinket extends Item implements TrinketCallback {
    public ConduitConducerTrinket(Properties properties) { super(properties); }

    public void forEachTrinketModifier(ItemStack stack, TrinketSlotAccess slot, LivingEntity entity, Identifier id, BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {

        // +2 Submerged Mining Speed (1.8)
        AttributeModifier subMineSpeedModifier = new AttributeModifier(id.withSuffix(Rubies.MOD_ID+"/subermed_mining_speed"), 4, AttributeModifier.Operation.ADD_VALUE);
        consumer.accept(Attributes.SUBMERGED_MINING_SPEED, subMineSpeedModifier);

        // +8 Oxygen Bonus (1/9)
        AttributeModifier oxygenModifier = new AttributeModifier(id.withSuffix(Rubies.MOD_ID+"/oxygen_bonus"), 8, AttributeModifier.Operation.ADD_VALUE);
        consumer.accept(Attributes.OXYGEN_BONUS, oxygenModifier);

        // +1 Water Movement Efficiency (1)
        AttributeModifier waterSpeedModifier = new AttributeModifier(id.withSuffix(Rubies.MOD_ID+"/water_movement_efficiency"), 1, AttributeModifier.Operation.ADD_VALUE);
        consumer.accept(Attributes.WATER_MOVEMENT_EFFICIENCY, waterSpeedModifier);

    }
}
