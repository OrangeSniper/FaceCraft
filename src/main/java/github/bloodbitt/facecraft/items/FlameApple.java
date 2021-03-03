package github.bloodbitt.facecraft.items;

import github.bloodbitt.facecraft.FaceCraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FlameApple extends Item {

    public FlameApple() {
        super(new Item.Properties()
            .group(FaceCraft.TAB)
            .food(new Food.Builder()
                .hunger(2)
                .saturation(1.2f)
                .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 1), 1f)
                    .setAlwaysEdible()
                .build()
            )
        );
    }
}
