package com.bloodbitt.facecraft.util;

import com.bloodbitt.facecraft.FaceCraft;
import com.bloodbitt.facecraft.blocks.BlockItemBase;
import com.bloodbitt.facecraft.blocks.FaceBlock;
import com.bloodbitt.facecraft.blocks.FaceOre;
import com.bloodbitt.facecraft.items.ItemBase;
import com.bloodbitt.facecraft.tools.FaceItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegestryHandler
{

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, FaceCraft.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, FaceCraft.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //items
    public static final RegistryObject<Item> FACE = ITEMS.register("face", ItemBase::new);

    //tools
    public static final RegistryObject<SwordItem> FACE_SWORD = ITEMS.register("face_sword", () ->
            new SwordItem(FaceItemTier.FACE, 3, -2.4f, new Item.Properties().group(FaceCraft.TAB)));

    //blocks
    public static final RegistryObject<Block> FACE_BLOCK = BLOCKS.register("face_block", FaceBlock::new);
    public static final RegistryObject<Block> FACE_ORE = BLOCKS.register("face_ore", FaceOre::new);

    //block items
    public static final RegistryObject<Item> FACE_BLOCK_ITEM = ITEMS.register("face_block", () -> new BlockItemBase(FACE_BLOCK.get()));
    public static final RegistryObject<Item> FACE_ORE_ITEM = ITEMS.register("face_ore", () -> new BlockItemBase(FACE_ORE.get()));


}
