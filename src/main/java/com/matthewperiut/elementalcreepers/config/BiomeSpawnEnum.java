package com.matthewperiut.elementalcreepers.config;

public enum BiomeSpawnEnum {
    NO_BIOMES("No Biomes"),
    SPECIFIC_BIOMES("Specific Biomes"),
    ALL_BIOMES("All Biomes");

    final String stringValue;

    BiomeSpawnEnum() {
        this.stringValue = "All Biomes";
    }

    BiomeSpawnEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}