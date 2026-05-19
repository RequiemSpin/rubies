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
                        output.accept(ModBlocks.RUBY_DEEPSLATE_ORE);
                        output.accept(ModBlocks.RUBY_BLOCK);
                        output.accept(ModItems.RUBY);

                    }).build());

    public static void registerModInvTabs() {
        Rubies.LOGGER.info("Registering InvTab - " + Rubies.MOD_ID);
    }
}
