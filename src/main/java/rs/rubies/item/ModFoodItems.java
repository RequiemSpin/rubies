package rs.rubies.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.PlaySoundConsumeEffect;

public class ModFoodItems {

    public static final FoodProperties KASANE_PEARTO = new FoodProperties.Builder().nutrition(20).saturationModifier(20).alwaysEdible().build();

    public static final Consumable KASANE_PEARTO_COMSUMABLE = new Consumables().defaultFood().consumeSeconds(2f).build();
}
