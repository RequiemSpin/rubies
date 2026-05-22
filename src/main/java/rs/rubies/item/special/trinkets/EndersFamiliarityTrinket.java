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

public class EndersFamiliarityTrinket extends Item implements TrinketCallback {
    private final Holder<Attribute> elytraSlotModifier;

    public EndersFamiliarityTrinket(Properties properties) {
        super(properties);
        // Grants Elytra Slot
        this.elytraSlotModifier = SlotAttributes.createAttributeForSlot("chest/elytra");
    }

    public void forEachTrinketModifier(ItemStack stack, TrinketSlotAccess slot, LivingEntity entity, Identifier id, BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {

        // +10% Resistance
        AttributeModifier resistanceModifier = new AttributeModifier(id.withSuffix(Rubies.MOD_ID+"/resistance"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        //consumer.accept(Attributes., resistanceModifier);

        // Grant Elytra Slot
        consumer.accept(this.elytraSlotModifier, new AttributeModifier(id.withSuffix(Rubies.MOD_ID+"/elytra_slot"), 1, AttributeModifier.Operation.ADD_VALUE));
    }
}
