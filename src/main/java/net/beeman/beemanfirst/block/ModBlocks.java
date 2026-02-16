package net.beeman.beemanfirst.block;

import net.beeman.beemanfirst.BeemanFirst;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShortPlantBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //Testando nova grass igual a do jogo
    public static final Block WEIRD_GRASS = registerBlock("weird_grass",
            new ShortPlantBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).nonOpaque().noCollision()));




    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(BeemanFirst.MOD_ID,name),block);
    }
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(BeemanFirst.MOD_ID,name),
                new BlockItem(block,new Item.Settings()));
    }
    public static void registerModBlocks(){
        BeemanFirst.LOGGER.info("Registering Mod Blocks for my first mod");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> entries.add(ModBlocks.WEIRD_GRASS));
    };
}
