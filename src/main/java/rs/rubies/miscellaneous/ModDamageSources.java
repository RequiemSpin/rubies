package rs.rubies.miscellaneous;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class ModDamageSources extends DamageSources {

    public static DamageSource registerDamageSource(ResourceKey<DamageType> dmgType, Level level) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(dmgType));
    }

    public ModDamageSources(RegistryAccess registries) {
        super(registries);
    }
}
