package com.matthewperiut.elementalcreepers.mixin;

import com.matthewperiut.elementalcreepers.ElementalCreepersMod;
import com.matthewperiut.elementalcreepers.config.BiomeSpawnEnum;
import com.matthewperiut.elementalcreepers.config.ElementalCreepersConfigFields;
import com.matthewperiut.elementalcreepers.entity.behavior.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.EntitySpawnGroup;

@Mixin(Biome.class)
public class BiomeMixin
{
    @Shadow
    protected List spawnableMonsters;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addElementalCreepers(CallbackInfo ci) {
        if (BiomeSpawnEnum.ALL_BIOMES == ElementalCreepersMod.config.elementalCreepersBiomeSpawn) {
            spawnableMonsters.add(new EntitySpawnGroup(CookieCreeper.class, ElementalCreepersMod.config.cookieCreeperSpawn));
            spawnableMonsters.add(new EntitySpawnGroup(EarthCreeper.class, ElementalCreepersMod.config.earthCreeperSpawn));
            spawnableMonsters.add(new EntitySpawnGroup(ElectricCreeper.class, ElementalCreepersMod.config.electricCreeperSpawn));
            spawnableMonsters.add(new EntitySpawnGroup(FireCreeper.class, ElementalCreepersMod.config.fireCreeperSpawn));
            spawnableMonsters.add(new EntitySpawnGroup(IceCreeper.class, ElementalCreepersMod.config.iceCreeperSpawn));
            spawnableMonsters.add(new EntitySpawnGroup(MagmaCreeper.class, ElementalCreepersMod.config.magmaCreeperSpawn));
            spawnableMonsters.add(new EntitySpawnGroup(PsychicCreeper.class, ElementalCreepersMod.config.psychicCreeperSpawn));
            spawnableMonsters.add(new EntitySpawnGroup(WaterCreeper.class, ElementalCreepersMod.config.waterCreeperSpawn));
        }
    }
}
