package com.matthewperiut.elementalcreepers.entity.behavior;

import com.matthewperiut.elementalcreepers.ElementalCreepersMod;
import com.matthewperiut.elementalcreepers.api.CreeperExplosion;
import com.matthewperiut.elementalcreepers.entity.EntityListener;
import net.modificationstation.stationapi.api.util.Identifier;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;

import java.util.Random;

public class FireCreeper extends CreeperEntity implements MobSpawnDataProvider, CreeperExplosion
{
    public FireCreeper(World arg)
    {
        super(arg);
        texture = "elementalcreepers:textures/firecreeper.png";
    }

    @Override
    public Identifier getHandlerIdentifier()
    {
        return Identifier.of(EntityListener.MOD_ID, "FireCreeper");
    }

    @Override
    public void detonate(World level, Entity creeper, double posX, double posY, double posZ, float power)
    {
        int radius = isCharged() ? (int)((float)ElementalCreepersMod.config.fireCreeperRadius * 1.5F) : ElementalCreepersMod.config.fireCreeperRadius;
        int x = -radius;

        while(true) {
            if(x > radius) {
                level.playSound(posX, posY, posZ, "random.explode", 4.0F, (1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.2F) * 0.7F);
                animateSpawn();
                break;
            }

            for(int y = -radius; y <= radius; ++y) {
                for(int z = -radius; z <= radius; ++z) {
                    if(level.canPlace(Block.WATER.id, (int)posX + x, (int)posY + y, (int)posZ + z, false, 0) && !level.canPlace(Block.WATER.id, (int)posX + x, (int)posY + y - 1, (int)posZ + z, false, 0)) {
                        Random rand = new Random();
                        if(rand.nextBoolean()) {
                            level.setBlockState((int)posX + x, (int)posY + y, (int)posZ + z, Block.FIRE.getDefaultState());
                        }
                    }
                }
            }

            ++x;
        }
    }
}
