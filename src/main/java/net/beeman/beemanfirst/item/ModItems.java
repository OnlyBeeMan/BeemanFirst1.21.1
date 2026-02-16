package net.beeman.beemanfirst.item;

import net.beeman.beemanfirst.BeemanFirst;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {









    private static Item registerItem(String name,Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BeemanFirst.MOD_ID,name),item);
    }
    public static void registerModItems(){
        BeemanFirst.LOGGER.info("Registering Mod Items for my first mod");
    }
}
