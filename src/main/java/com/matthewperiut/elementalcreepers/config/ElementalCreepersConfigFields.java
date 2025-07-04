package com.matthewperiut.elementalcreepers.config;

import net.glasslauncher.mods.gcapi3.api.*;

public class ElementalCreepersConfigFields
{
    @ConfigEntry(
            name = "Biome Spawn For Elemental Creepers",
            description = "Restart required for changes to take effect",
            multiplayerSynced = true
    )
    public BiomeSpawnEnum elementalCreepersBiomeSpawn = BiomeSpawnEnum.ALL_BIOMES;

    @ConfigEntry(name = "Water Creeper Spawn Rate", multiplayerSynced = true)
    public Integer waterCreeperSpawn = 6;

    @ConfigEntry(name = "Fire Creeper Spawn Rate", multiplayerSynced = true)
    public Integer fireCreeperSpawn = 6;

    @ConfigEntry(name = "Ice Creeper Spawn Rate", multiplayerSynced = true)
    public Integer iceCreeperSpawn = 3;

    @ConfigEntry(name = "Electric Creeper Spawn Rate", multiplayerSynced = true)
    public Integer electricCreeperSpawn = 6;

    @ConfigEntry(name = "Earth Creeper Spawn Rate", multiplayerSynced = true)
    public Integer earthCreeperSpawn = 3;

    @ConfigEntry(name = "Psychic Creeper Spawn Rate", multiplayerSynced = true)
    public Integer psychicCreeperSpawn = 6;

    @ConfigEntry(name = "Cookie Creeper Spawn Rate", multiplayerSynced = true)
    public Integer cookieCreeperSpawn = 1;

    @ConfigEntry(name = "Magma Creeper Spawn Rate", multiplayerSynced = true)
    public Integer magmaCreeperSpawn = 1;

    @ConfigEntry(name = "Water Creeper Explosion Radius", multiplayerSynced = true)
    public Integer waterCreeperRadius = 2;

    @ConfigEntry(name = "Fire Creeper Explosion Radius", multiplayerSynced = true)
    public Integer fireCreeperRadius = 6;

    @ConfigEntry(name = "Ice Creeper Explosion Radius", multiplayerSynced = true)
    public Integer iceCreeperRadius = 6;

    @ConfigEntry(name = "Electric Creeper Explosion Radius", multiplayerSynced = true)
    public Integer electricCreeperRadius = 5;

    @ConfigEntry(name = "Earth Creeper Explosion Radius", multiplayerSynced = true)
    public Integer earthCreeperRadius = 6;

    @ConfigEntry(name = "Psychic Creeper Explosion Radius", multiplayerSynced = true)
    public Integer psychicCreeperRadius = 5;

    @ConfigEntry(name = "Psychic Creeper Explosion Power", multiplayerSynced = true)
    public Integer psychicCreeperPower = 6;

    @ConfigEntry(name = "Cookie Creeper Drop Count", multiplayerSynced = true)
    public Integer cookieCreeperAmount = 25;

    @ConfigEntry(name = "Magma Creeper Explosion Radius", multiplayerSynced = true)
    public Integer magmaCreeperRadius = 2;

    @ConfigEntry(name = "Ghost Creeper Explosion Radius", multiplayerSynced = true)
    public Integer ghostCreeperRadius = 5;

    @ConfigEntry(name = "Ghost Creeper Chance %", multiplayerSynced = true)
    public Integer ghostCreeperChance = 32;
}
