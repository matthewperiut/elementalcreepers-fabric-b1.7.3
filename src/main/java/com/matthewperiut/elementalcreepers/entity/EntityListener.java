package com.matthewperiut.elementalcreepers.entity;

import com.matthewperiut.elementalcreepers.datafixer.EntityIdentifierFix;
import com.matthewperiut.elementalcreepers.datafixer.RemainderSchema;
import com.matthewperiut.elementalcreepers.entity.behavior.*;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.datafixer.DataFixers;
import net.modificationstation.stationapi.api.event.datafixer.DataFixerRegisterEvent;
import net.modificationstation.stationapi.api.event.entity.EntityRegisterEvent;
import net.modificationstation.stationapi.api.event.registry.MobHandlerRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class EntityListener
{
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    // bump whenever a new data fix is added
    private static final int DATA_VERSION = 1;

    @EventListener
    public void registerEntities(EntityRegisterEvent event) {
        event.register(Identifier.of(MOD_ID, "CookieCreeper"), CookieCreeper.class);
        event.register(Identifier.of(MOD_ID, "EarthCreeper"), EarthCreeper.class);
        event.register(Identifier.of(MOD_ID, "ElectricCreeper"), ElectricCreeper.class);
        event.register(Identifier.of(MOD_ID, "FireCreeper"), FireCreeper.class);
        event.register(Identifier.of(MOD_ID, "GhostCreeper"), GhostCreeper.class);
        event.register(Identifier.of(MOD_ID, "IceCreeper"), IceCreeper.class);
        event.register(Identifier.of(MOD_ID, "MagmaCreeper"), MagmaCreeper.class);
        event.register(Identifier.of(MOD_ID, "PsychicCreeper"), PsychicCreeper.class);
        event.register(Identifier.of(MOD_ID, "WaterCreeper"), WaterCreeper.class);
    }

    @EventListener
    public void registerMobHandlers(MobHandlerRegistryEvent event) {
        Registry.register(event.registry, Identifier.of(MOD_ID, "CookieCreeper"), CookieCreeper::new);
        Registry.register(event.registry, Identifier.of(MOD_ID, "EarthCreeper"), EarthCreeper::new);
        Registry.register(event.registry, Identifier.of(MOD_ID, "ElectricCreeper"), ElectricCreeper::new);
        Registry.register(event.registry, Identifier.of(MOD_ID, "FireCreeper"), FireCreeper::new);
        Registry.register(event.registry, Identifier.of(MOD_ID, "GhostCreeper"), GhostCreeper::new);
        Registry.register(event.registry, Identifier.of(MOD_ID, "IceCreeper"), IceCreeper::new);
        Registry.register(event.registry, Identifier.of(MOD_ID, "MagmaCreeper"), MagmaCreeper::new);
        Registry.register(event.registry, Identifier.of(MOD_ID, "PsychicCreeper"), PsychicCreeper::new);
        Registry.register(event.registry, Identifier.of(MOD_ID, "WaterCreeper"), WaterCreeper::new);
    }

    @EventListener
    public void registerDataFixer(DataFixerRegisterEvent event) {
        DataFixers.registerFixer(MOD_ID, executor -> {
            DataFixerBuilder builder = new DataFixerBuilder(DATA_VERSION);
            builder.addSchema(0, RemainderSchema::new);
            Schema v1 = builder.addSchema(1, Schema::new);
            builder.addFixer(new EntityIdentifierFix(v1));
            return builder.build().fixer();
        }, DATA_VERSION);
    }
}