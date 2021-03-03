package io.github.bloodbitt.facecraft.events;

import io.github.bloodbitt.facecraft.FaceCraft;
import io.github.bloodbitt.facecraft.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FaceCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void OnHitWithFlameApple(AttackEntityEvent event) {
        if(event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.FLAME_APPLE.get()) {
            if(event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity)event.getTarget();
                target.setFire(5);
            }
        }
    }
}
