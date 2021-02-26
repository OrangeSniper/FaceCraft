package com.bloodbitt.facecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class FaceOre extends OreBlock
{

    public FaceOre( ) {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5f, 6f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE));
    }
}
