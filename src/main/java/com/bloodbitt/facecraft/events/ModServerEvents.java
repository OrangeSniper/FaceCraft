package com.bloodbitt.facecraft.events;

import com.bloodbitt.facecraft.FaceCraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FaceCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {
}
