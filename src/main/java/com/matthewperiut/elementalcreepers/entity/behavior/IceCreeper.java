package com.matthewperiut.elementalcreepers.entity.behavior;

import com.matthewperiut.elementalcreepers.ElementalCreepersMod;
import com.matthewperiut.elementalcreepers.api.CreeperExplosion;
import com.matthewperiut.elementalcreepers.entity.EntityListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;

public class IceCreeper extends CreeperEntity implements MobSpawnDataProvider, CreeperExplosion
{
    public IceCreeper(World arg)
    {
        super(arg);
        texture = "elementalcreepers:textures/icecreeper.png";
    }

    @Override
    public Identifier getHandlerIdentifier()
    {
        return Identifier.of(EntityListener.MOD_ID, "IceCreeper");
    }

    @Override
    public void detonate(World level, Entity creeper, double posX, double posY, double posZ, float power)
    {
        int radius = isCharged() ? (int)((float)ElementalCreepersMod.config.iceCreeperRadius * 1.5F) : ElementalCreepersMod.config.iceCreeperRadius;
        int x = -radius;

        while(true) {
            if(x > radius) {
                level.playSound(posX, posY, posZ, "random.explode", 4.0F, (1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.2F) * 0.7F);
                animateSpawn();
                return;
            }

            for(int y = -radius; y <= radius; ++y) {
                for(int z = -radius; z <= radius; ++z) {
                    if(level.getMaterial((int)posX + x, (int)posY + y, (int)posZ + z) == Material.WATER && level.getBlockMeta((int)posX + x, (int)posY + y, (int)posZ + z) == 0) {
                        level.setBlockState((int)posX + x, (int)posY + y, (int)posZ + z, Block.ICE.getDefaultState());
                    } else if(level.getMaterial((int)posX + x, (int)posY + y, (int)posZ + z) == Material.LAVA && level.getBlockMeta((int)posX + x, (int)posY + y, (int)posZ + z) == 0) {
                        level.setBlockState((int)posX + x, (int)posY + y, (int)posZ + z, Block.OBSIDIAN.getDefaultState());
                    } else if(level.canPlace(Block.SNOW.id, (int)posX + x, (int)posY + y, (int)posZ + z, false, 0) && !level.canPlace(Block.SNOW.id, (int)posX + x, (int)posY + y - 1, (int)posZ + z, false, 0)) {
                        level.setBlockState((int)posX + x, (int)posY + y, (int)posZ + z, Block.SNOW.getDefaultState());
                    }
                }
            }

            ++x;
        }
    }
}
