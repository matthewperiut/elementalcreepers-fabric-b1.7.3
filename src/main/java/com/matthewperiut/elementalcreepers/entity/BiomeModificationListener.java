package com.matthewperiut.elementalcreepers.entity;

import com.matthewperiut.elementalcreepers.ElementalCreepersMod;
import com.matthewperiut.elementalcreepers.entity.behavior.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.world.biome.Biome;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeModificationEvent;

public class BiomeModificationListener {

    @EventListener
    public void event(BiomeModificationEvent event) {
        if (true == ElementalCreepersMod.config.biomeSpecific) {
            Biome.SHRUBLAND.addHostileEntity(ElectricCreeper.class, ElementalCreepersMod.config.electricCreeperSpawn);
            Biome.SKY.addHostileEntity(ElectricCreeper.class, ElementalCreepersMod.config.electricCreeperSpawn);
            Biome.SKY.addHostileEntity(PsychicCreeper.class, ElementalCreepersMod.config.psychicCreeperSpawn);
            Biome.SEASONAL_FOREST.addHostileEntity(PsychicCreeper.class, ElementalCreepersMod.config.psychicCreeperSpawn);
            Biome.SEASONAL_FOREST.addHostileEntity(IceCreeper.class, ElementalCreepersMod.config.iceCreeperSpawn);
            Biome.FOREST.addHostileEntity(PsychicCreeper.class, ElementalCreepersMod.config.psychicCreeperSpawn);
            Biome.RAINFOREST.addHostileEntity(ElectricCreeper.class, ElementalCreepersMod.config.psychicCreeperSpawn);
            Biome.RAINFOREST.addHostileEntity(WaterCreeper.class, ElementalCreepersMod.config.waterCreeperSpawn);
            Biome.SWAMPLAND.addHostileEntity(WaterCreeper.class, ElementalCreepersMod.config.waterCreeperSpawn);
            Biome.SAVANNA.addHostileEntity(CookieCreeper.class, ElementalCreepersMod.config.cookieCreeperSpawn);
            Biome.PLAINS.addHostileEntity(EarthCreeper.class, ElementalCreepersMod.config.earthCreeperSpawn);
            Biome.TUNDRA.addHostileEntity(EarthCreeper.class, ElementalCreepersMod.config.earthCreeperSpawn);
            Biome.TUNDRA.addHostileEntity(IceCreeper.class, ElementalCreepersMod.config.iceCreeperSpawn);
            Biome.TAIGA.addHostileEntity(PsychicCreeper.class, ElementalCreepersMod.config.psychicCreeperSpawn);
            Biome.TAIGA.addHostileEntity(IceCreeper.class, ElementalCreepersMod.config.iceCreeperSpawn);
            Biome.ICE_DESERT.addHostileEntity(IceCreeper.class, ElementalCreepersMod.config.iceCreeperSpawn);
            Biome.ICE_DESERT.addHostileEntity(GhostCreeper.class, ElementalCreepersMod.config.iceCreeperSpawn);
            Biome.DESERT.addHostileEntity(FireCreeper.class, ElementalCreepersMod.config.fireCreeperSpawn);
            Biome.HELL.addHostileEntity(FireCreeper.class, ElementalCreepersMod.config.fireCreeperSpawn);
            Biome.HELL.addHostileEntity(MagmaCreeper.class, ElementalCreepersMod.config.magmaCreeperSpawn);
        }
    }
}