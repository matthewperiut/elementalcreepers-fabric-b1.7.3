package com.matthewperiut.elementalcreepers.entity.behavior;

import com.matthewperiut.elementalcreepers.ElementalCreepersMod;
import com.matthewperiut.elementalcreepers.api.CreeperExplosion;
import com.matthewperiut.elementalcreepers.entity.EntityListener;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class EarthCreeper extends CreeperEntity implements MobSpawnDataProvider, CreeperExplosion
{
    public EarthCreeper(World arg)
    {
        super(arg);
        texture = "elementalcreepers:textures/earthcreeper.png";
    }

    @Override
    public Identifier getHandlerIdentifier()
    {
        return Identifier.of(EntityListener.MOD_ID, "EarthCreeper");
    }

    @Override
    public void detonate(World level, Entity creeper, double posX, double posY, double posZ, float power)
    {
        int radius = isCharged() ? (int)((float)ElementalCreepersMod.config.earthCreeperRadius * 1.5F) : ElementalCreepersMod.config.earthCreeperRadius;
        int x = -radius;

        while(true) {
            if(x > radius) {
                level.playSound(posX, posY, posZ, "random.explode", 4.0F, (1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.2F) * 0.7F);
                animateSpawn();
                break;
            }

            for(int y = -radius; y <= radius; ++y) {
                for(int z = -radius; z <= radius; ++z) {
                    if(level.canPlace(Block.DIRT.id, (int)posX + x, (int)posY + y, (int)posZ + z, false, 0)) {
                        Random rand = new Random();
                        if(rand.nextBoolean()) {
                            level.setBlockState((int)posX + x, (int)posY + y, (int)posZ + z, Block.DIRT.getDefaultState());
                        }
                    }
                }
            }

            ++x;
        }
    }
}
