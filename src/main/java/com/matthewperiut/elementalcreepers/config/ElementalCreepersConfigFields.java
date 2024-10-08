package com.matthewperiut.elementalcreepers.config;

import net.glasslauncher.mods.api.gcapi.api.ConfigName;
import net.glasslauncher.mods.api.gcapi.api.MultiplayerSynced;

public class ElementalCreepersConfigFields
{
    @MultiplayerSynced
    @ConfigName("Biome Specific (Restart Required)")
    public Boolean biomeSpecific = false;

    @MultiplayerSynced
    @ConfigName("Water Creeper Spawn Rate")
    public Integer waterCreeperSpawn = 6;
    @MultiplayerSynced
    @ConfigName("Fire Creeper Spawn Rate")
    public Integer fireCreeperSpawn = 6;
    @MultiplayerSynced
    @ConfigName("Ice Creeper Spawn Rate")
    public Integer iceCreeperSpawn = 3;
    @MultiplayerSynced
    @ConfigName("Electric Creeper Spawn Rate")
    public Integer electricCreeperSpawn = 6;
    @MultiplayerSynced
    @ConfigName("Earth Creeper Spawn Rate")
    public Integer earthCreeperSpawn = 3;
    @MultiplayerSynced
    @ConfigName("Psychic Creeper Spawn Rate")
    public Integer psychicCreeperSpawn = 6;
    @MultiplayerSynced
    @ConfigName("Cookie Creeper Spawn Rate")
    public Integer cookieCreeperSpawn = 1;
    @MultiplayerSynced
    @ConfigName("Magma Creeper Spawn Rate")
    public Integer magmaCreeperSpawn = 1;
    @MultiplayerSynced
    @ConfigName("Water Creeper Explosion Radius")
    public Integer waterCreeperRadius = 2;
    @MultiplayerSynced
    @ConfigName("Fire Creeper Explosion Radius")
    public Integer fireCreeperRadius = 6;
    @MultiplayerSynced
    @ConfigName("Ice Creeper Explosion Radius")
    public Integer iceCreeperRadius = 6;
    @MultiplayerSynced
    @ConfigName("Electric Creeper Explosion Radius")
    public Integer electricCreeperRadius = 5;
    @MultiplayerSynced
    @ConfigName("Earth Creeper Explosion Radius")
    public Integer earthCreeperRadius = 8;
    @MultiplayerSynced
    @ConfigName("Psychic Creeper Explosion Radius")
    public Integer psychicCreeperRadius = 5;
    @MultiplayerSynced
    @ConfigName("Psychic Creeper Explosion Power")
    public Integer psychicCreeperPower = 6;
    @MultiplayerSynced
    @ConfigName("Cookie Creeper Drop Count")
    public Integer cookieCreeperAmount = 25;
    @MultiplayerSynced
    @ConfigName("Magma Creeper Explosion Radius")
    public Integer magmaCreeperRadius = 2;
    @MultiplayerSynced
    @ConfigName("Ghost Creeper Explosion Radius")
    public Integer ghostCreeperRadius = 5;
    @MultiplayerSynced
    @ConfigName("Ghost Creeper Chance %")
    public Integer ghostCreeperChance = 32;
}
