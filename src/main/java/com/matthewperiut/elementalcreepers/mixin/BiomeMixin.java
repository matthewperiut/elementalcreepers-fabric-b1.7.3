package com.matthewperiut.elementalcreepers.mixin;

import com.matthewperiut.elementalcreepers.ElementalCreepersMod;
import com.matthewperiut.elementalcreepers.config.ElementalCreepersConfigFields;
import com.matthewperiut.elementalcreepers.entity.behavior.*;
import net.minecraft.entity.EntityEntry;
import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Biome.class)
public class BiomeMixin
{
    @Shadow
    protected List monsters;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addElementalCreepers(CallbackInfo ci) {
        if (false == ElementalCreepersMod.config.biomeSpecific) {
            monsters.add(new EntityEntry(CookieCreeper.class, ElementalCreepersMod.config.cookieCreeperSpawn));
            monsters.add(new EntityEntry(EarthCreeper.class, ElementalCreepersMod.config.earthCreeperSpawn));
            monsters.add(new EntityEntry(ElectricCreeper.class, ElementalCreepersMod.config.electricCreeperSpawn));
            monsters.add(new EntityEntry(FireCreeper.class, ElementalCreepersMod.config.fireCreeperSpawn));
            monsters.add(new EntityEntry(IceCreeper.class, ElementalCreepersMod.config.iceCreeperSpawn));
            monsters.add(new EntityEntry(MagmaCreeper.class, ElementalCreepersMod.config.magmaCreeperSpawn));
            monsters.add(new EntityEntry(PsychicCreeper.class, ElementalCreepersMod.config.psychicCreeperSpawn));
            monsters.add(new EntityEntry(WaterCreeper.class, ElementalCreepersMod.config.waterCreeperSpawn));
        }
    }
}
