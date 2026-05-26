package rs.rubies.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import rs.rubies.Rubies;
import rs.rubies.item.special.BloodVialItem;
import rs.rubies.item.special.ChiselItem;
import rs.rubies.item.special.ReturnItem;
import rs.rubies.item.special.trinkets.ConduitConducerTrinket;
import rs.rubies.item.special.trinkets.NimblenessTrinket;

import java.util.function.Function;

public class ModItems {

    // Ingredients
    public static final Item RUBY = registerItem("ruby", Item::new);
    public static final Item BLOOD_VIAL = registerItem("blood_vial", properties -> new BloodVialItem(properties.durability(4).stacksTo(1)));

    // Ores & Ingots
    public static final Item LEAD_INGOT = registerItem("lead_ingot", Item::new);
    public static final Item RAW_LEAD = registerItem("raw_lead", Item::new);

    // Special
    public static final Item RETURN_PEBBLE = registerItem("return_pebble", properties -> new ReturnItem(properties.stacksTo(1).durability(1)));
    public static final Item PHILOSOPHERS_CHISEL = registerItem("philosophers_chisel", properties -> new ChiselItem(properties.durability(32)));
    public static final Item KASANE_PEARTO = registerItem("kasane_pearto", properties -> new Item(properties.food(ModFoodItems.VOCALOID_FOOD, ModFoodItems.VOCALOID_FOOD_COMSUMABLE)));
    public static final Item ADOCADO = registerItem("adocado", properties -> new Item(properties.food(ModFoodItems.VOCALOID_FOOD, ModFoodItems.VOCALOID_FOOD_COMSUMABLE)));
    public static final Item LEEKU = registerItem("leeku", properties -> new Item(properties.food(ModFoodItems.VOCALOID_FOOD, ModFoodItems.VOCALOID_FOOD_COMSUMABLE)));

    //Trinkets
    public static final Item VACANT_TRINKET = registerItem("vacant_trinket", Item::new);
    //public static final Item TRINKET_ENDERS_FAMILIARITY = registerItem("trinket_enders_familiarity", properties -> new EndersFamiliarityTrinket(properties.stacksTo(1)));
    public static final Item TRINKET_NIMBLENESS = registerItem("trinket_nimbleness", properties -> new NimblenessTrinket(properties.stacksTo(1)));
    public static final Item TRINKET_CONDUIT_CONDUCER = registerItem("trinket_conduit_conducer", properties -> new ConduitConducerTrinket(properties.stacksTo(1)));
    public static final Item SHATTERED_VACANT_TRINKET = registerItem("shattered_vacant_trinket", Item::new);

    //public static final Item RUBY = registerItem("ruby", properties -> new Item(properties);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Rubies.LOGGER.info("Registering Items - " + Rubies.MOD_ID);
    }
}
