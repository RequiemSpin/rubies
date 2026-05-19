package rs.rubies.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import rs.rubies.Rubies;
import rs.rubies.item.special.ChiselItem;

import java.util.function.Function;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", Item::new);

    public static final Item PHILOSOPHERS_CHISEL = registerItem("philosophers_chisel", properties -> new ChiselItem(properties.durability(16)));

    //public static final Item RUBY = registerItem("ruby", properties -> new Item(properties);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Rubies.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Rubies.LOGGER.info("Registering Items - " + Rubies.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(RUBY);
        });
    }
}
