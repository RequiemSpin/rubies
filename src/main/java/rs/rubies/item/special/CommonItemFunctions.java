package rs.rubies.item.special;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonItemFunctions {

    public static final ArrayList<EntityType> sacrificial_mobs = new ArrayList<>(Arrays.asList(
            EntityType.ALLAY,
            EntityType.ARMADILLO,
            EntityType.AXOLOTL,
            EntityType.BAT,
            EntityType.CAMEL,
            EntityType.CHICKEN,
            EntityType.COD,
            EntityType.COW,
            EntityType.DONKEY,
            EntityType.FROG,
            EntityType.GLOW_SQUID,
            EntityType.HAPPY_GHAST,
            EntityType.HORSE,
            EntityType.MOOSHROOM,
            EntityType.MULE,
            EntityType.OCELOT,
            EntityType.PARROT,
            EntityType.PIG,
            EntityType.RABBIT,
            EntityType.SALMON,
            EntityType.SHEEP,
            EntityType.SNIFFER,
            EntityType.SQUID,
            EntityType.TROPICAL_FISH,
            EntityType.TURTLE,
            EntityType.VILLAGER,
            EntityType.WANDERING_TRADER
    ));

    public static boolean checkSacrifice(LivingEntity mob, int odds) {
        return (((int) (Math.random()*odds))==1 && sacrificial_mobs.contains(mob.getType()));
    }
}