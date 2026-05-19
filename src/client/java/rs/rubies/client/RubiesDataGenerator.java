package rs.rubies.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import rs.rubies.client.datagen.ModBlockLootTableProvider;
import rs.rubies.client.datagen.ModBlockTagProvider;
import rs.rubies.client.datagen.ModItemTagProvider;
import rs.rubies.client.datagen.ModModelProvider;

public class RubiesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		//pack.addProvider(ModItemTagProvider::new);
	}
}
