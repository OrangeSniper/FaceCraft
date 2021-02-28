package com.bloodbitt.facecraft.init;

import com.bloodbitt.facecraft.FaceCraft;
import com.bloodbitt.facecraft.util.enums.ModArmorMaterial;
import com.bloodbitt.facecraft.blocks.BlockItemBase;
import com.bloodbitt.facecraft.blocks.FaceBlock;
import com.bloodbitt.facecraft.blocks.FaceOre;
import com.bloodbitt.facecraft.blocks.Oven;
import com.bloodbitt.facecraft.items.FlameApple;
import com.bloodbitt.facecraft.items.ItemBase;
import com.bloodbitt.facecraft.util.enums.FaceItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks
{

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FaceCraft.MOD_ID);
    //blocks
    public static final RegistryObject<Block> FACE_BLOCK = BLOCKS.register("face_block", FaceBlock::new);
    public static final RegistryObject<Block> FACE_ORE = BLOCKS.register("face_ore", FaceOre::new);
    public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", Oven::new);


}
