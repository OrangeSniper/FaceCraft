package com.bloodbitt.facecraft.init;

import com.bloodbitt.facecraft.FaceCraft;
import com.bloodbitt.facecraft.blocks.BlockItemBase;
import com.bloodbitt.facecraft.items.FlameApple;
import com.bloodbitt.facecraft.items.ItemBase;
import com.bloodbitt.facecraft.util.enums.FaceItemTier;
import com.bloodbitt.facecraft.util.enums.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FaceCraft.MOD_ID);
    //items
    public static final RegistryObject<Item> FACE = ITEMS.register("face", ItemBase::new);
    public static final RegistryObject<FlameApple> FLAME_APPLE = ITEMS.register("flame_apple", FlameApple::new);

    //tools
    public static final RegistryObject<SwordItem> FACE_SWORD = ITEMS.register("face_sword", () ->
            new SwordItem(FaceItemTier.FACE, 3, -2.4f, new Item.Properties().group(FaceCraft.TAB)));
    public static final RegistryObject<PickaxeItem> FACE_PICKAXE = ITEMS.register("face_pickaxe", () ->
            new PickaxeItem(FaceItemTier.FACE, 0, -2.8f, new Item.Properties().group(FaceCraft.TAB)));
    public static final RegistryObject<AxeItem> FACE_AXE = ITEMS.register("face_axe", () ->
            new AxeItem(FaceItemTier.FACE, 5, -3.6f, new Item.Properties().group(FaceCraft.TAB)));
    public static final RegistryObject<ShovelItem> FACE_SHOVEL = ITEMS.register("face_shovel", () ->
            new ShovelItem(FaceItemTier.FACE, 0, -2.9f, new Item.Properties().group(FaceCraft.TAB)));
    public static final RegistryObject<HoeItem> FACE_HOE = ITEMS.register("face_hoe", () ->
            new HoeItem(FaceItemTier.FACE, 0, -1f, new Item.Properties().group(FaceCraft.TAB)));

    //armor
    public static final RegistryObject<ArmorItem> FACE_HELMET = ITEMS.register("face_helmet", () -> new ArmorItem(ModArmorMaterial.FACE, EquipmentSlotType.HEAD, new Item.Properties().group(FaceCraft.TAB)));

    public static final RegistryObject<ArmorItem> FACE_CHESTPLATE = ITEMS.register("face_chestplate", () -> new ArmorItem(ModArmorMaterial.FACE, EquipmentSlotType.CHEST, new Item.Properties().group(FaceCraft.TAB)));

    public static final RegistryObject<ArmorItem> FACE_LEGGINGS = ITEMS.register("face_leggings", () -> new ArmorItem(ModArmorMaterial.FACE, EquipmentSlotType.LEGS, new Item.Properties().group(FaceCraft.TAB)));

    public static final RegistryObject<ArmorItem> FACE_BOOTS = ITEMS.register("face_boots", () -> new ArmorItem(ModArmorMaterial.FACE, EquipmentSlotType.FEET, new Item.Properties().group(FaceCraft.TAB)));

    //block items
    public static final RegistryObject<Item> FACE_BLOCK_ITEM = ITEMS.register("face_block", () -> new BlockItemBase(ModBlocks.FACE_BLOCK.get()));
    public static final RegistryObject<Item> FACE_ORE_ITEM = ITEMS.register("face_ore", () -> new BlockItemBase(ModBlocks.FACE_ORE.get()));
    public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven", () -> new BlockItemBase(ModBlocks.OVEN.get()));
}
