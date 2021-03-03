package io.github.bloodbitt.facecraft.biomes;

import io.github.bloodbitt.facecraft.biomebuilder.TerraformBiomeBuilder;

public class BiomeTemplate {
    private final TerraformBiomeBuilder builder;

    public BiomeTemplate(TerraformBiomeBuilder builder) {
        this.builder = builder;
        builder.markTemplate();
    }

    public TerraformBiomeBuilder builder() {
        return new TerraformBiomeBuilder(this.builder);
    }
}
