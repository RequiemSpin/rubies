package rs.rubies.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import rs.rubies.Rubies;
import rs.rubies.block.ModBlocks;

public class ModInvTabs {

    public static final CreativeModeTab RUBIES_ITEMS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Rubies.MOD_ID, "rubies_items"), FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack((ModItems.RUBY))).title(Component.translatable("invtab.rubies.rubies_items")).displayItems((parameters, output) -> {

                        output.accept(ModBlocks.RUBY_ORE);
                        output.accept(ModItems.RUBY);
                        output.accept(ModBlocks.RUBY_DEEPSLATE_ORE);
                        output.accept(ModBlocks.RUBY_BLOCK);

                        output.accept(ModItems.PHILOSOPHERS_CHISEL);
                        output.accept(ModItems.BLOOD_VIAL);

                        output.accept(ModBlocks.LEAD_BLOCK);
                        output.accept(ModItems.LEAD_INGOT);
                        output.accept(ModBlocks.LEAD_DEEPSLATE_ORE);
                        output.accept(ModBlocks.LEAD_ORE);
                        output.accept(ModBlocks.RAW_LEAD_BLOCK);
                        output.accept(ModItems.RAW_LEAD);

                        output.accept(ModItems.RETURN_PEBBLE);
                        output.accept(ModBlocks.RETURN_DEEPSLATE_ORE);
                        output.accept(ModBlocks.RETURN_ORE);

                    }).build());

    public static final CreativeModeTab TRINKETS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Rubies.MOD_ID, "trinkets"), FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack((ModItems.VACANT_TRINKET))).title(Component.translatable("invtab.rubies.trinkets")).displayItems((parameters, output) -> {

                        output.accept((ModItems.VACANT_TRINKET));

                        //Trinkets
                        output.accept(ModItems.TRINKET_NIMBLENESS);
                        output.accept(ModItems.TRINKET_CONDUIT_CONDUCER);

                        output.accept(ModItems.SHATTERED_VACANT_TRINKET);

                    }).build());

    public static void registerModInvTabs() {
        Rubies.LOGGER.info("Registering InvTab - " + Rubies.MOD_ID);
    }
}
