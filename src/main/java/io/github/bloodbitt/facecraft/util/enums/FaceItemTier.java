package io.github.bloodbitt.facecraft.util.enums;

import java.util.function.Supplier;

import io.github.bloodbitt.facecraft.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum FaceItemTier implements IItemTier {
    //1 + baseDamage + addedDamage
    FACE(2, 170, 4.0f, 2.0f, 7, () -> {
        return Ingredient.fromItems(ModItems.FACE.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantibillity;
    private final Supplier<Ingredient> repairMaterial;

    FaceItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantibillity, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantibillity = enchantibillity;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantibillity;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
