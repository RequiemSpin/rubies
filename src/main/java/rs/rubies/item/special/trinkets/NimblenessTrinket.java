package rs.rubies.item.special.trinkets;

import eu.pb4.trinkets.api.SlotAttributes;
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

public class NimblenessTrinket extends Item implements TrinketCallback {

    public NimblenessTrinket(Properties properties) {
        super(properties);
    }

    public void forEachTrinketModifier(ItemStack stack, TrinketSlotAccess slot, LivingEntity entity, Identifier id, BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {

        // +1.125 Step Height
        AttributeModifier stepHeightModifier = new AttributeModifier(id.withSuffix(Rubies.MOD_ID+"/step_height"), 1.125, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        consumer.accept(Attributes.STEP_HEIGHT, stepHeightModifier);

        // +20% Speed
        AttributeModifier speedModifier = new AttributeModifier(id.withSuffix(Rubies.MOD_ID+"/speed"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        consumer.accept(Attributes.MOVEMENT_SPEED, speedModifier);

        // +10% Attack Speed
        AttributeModifier atkSpeedModifier = new AttributeModifier(id.withSuffix(Rubies.MOD_ID+"/attack_speed"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        consumer.accept(Attributes.ATTACK_SPEED, atkSpeedModifier);

    }
}
