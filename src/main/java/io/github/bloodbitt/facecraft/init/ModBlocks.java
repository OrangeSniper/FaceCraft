package io.github.bloodbitt.facecraft.init;

import io.github.bloodbitt.facecraft.FaceCraft;
import io.github.bloodbitt.facecraft.blocks.FaceBlock;
import io.github.bloodbitt.facecraft.blocks.FaceOre;
import io.github.bloodbitt.facecraft.blocks.Oven;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
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
