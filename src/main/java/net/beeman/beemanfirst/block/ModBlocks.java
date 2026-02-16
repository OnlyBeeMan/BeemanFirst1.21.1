package net.beeman.beemanfirst.block;

import net.beeman.beemanfirst.BeemanFirst;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModBlocks {

    //Testando nova grass igual a do jogo
    public static final Block WEIRD_GRASS = registerBlock("weird_grass",
            new WeirdGrassBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).nonOpaque().noCollision()));

    public static final Block WEIRD_TALL_GRASS = registerBlock("weird_tall_grass",
            new TallPlantBlock(AbstractBlock.Settings.copy(Blocks.TALL_GRASS).nonOpaque().noCollision()){
                @Override
                protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
                    return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND) || floor.isIn(BlockTags.SOUL_SPEED_BLOCKS);
                }
            });


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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries->entries.add(ModBlocks.WEIRD_TALL_GRASS));
    };
}
