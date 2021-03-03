package io.github.bloodbitt.facecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class FaceBlock extends Block
{

    public FaceBlock( ) {
        super(Block.Properties.create(Material.ORGANIC)
                .hardnessAndResistance(1f, 3f)
                .sound(SoundType.CLOTH)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL));
    }
}
