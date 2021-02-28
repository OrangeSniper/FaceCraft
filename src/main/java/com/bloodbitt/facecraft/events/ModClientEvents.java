package com.bloodbitt.facecraft.events;

import com.bloodbitt.facecraft.FaceCraft;
import com.bloodbitt.facecraft.init.ModBlocks;
import com.bloodbitt.facecraft.init.ModItems;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FaceCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
        LivingEntity player = event.getEntityLiving();
        if(player.getHeldItemMainhand().getItem() == Items.STICK) {
            FaceCraft.LOGGER.info("player tried to jump with stick");
            World world = player.getEntityWorld();
            world.setBlockState(player.getPosition().add(0, -1, 0), ModBlocks.FACE_BLOCK.get().getDefaultState());
        }
    }

    @SubscribeEvent
    public static void OnHitWithFlameApple(AttackEntityEvent event) {
        if(event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.FLAME_APPLE.get()) {
            if(event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity)event.getTarget();
                target.setFire(5);
            }
        }
    }

    @SubscribeEvent
    public static void OnCraftingTableOpen(GuiOpenEvent event) {
        if(event.isCancelable()) {
            if(event.getGui() instanceof CraftingScreen) {
                event.setCanceled(true);
                FaceCraft.LOGGER.info("player tried to open a crafting table. Can't have that, now can we!");
            }
        }
    }
}
