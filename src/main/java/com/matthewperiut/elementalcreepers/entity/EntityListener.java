package com.matthewperiut.elementalcreepers.entity;

import com.matthewperiut.elementalcreepers.entity.behavior.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
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

    @EventListener
    public void registerEntities(EntityRegister event) {
        event.register(CookieCreeper.class, "CookieCreeper");
        event.register(EarthCreeper.class, "EarthCreeper");
        event.register(ElectricCreeper.class, "ElectricCreeper");
        event.register(FireCreeper.class, "FireCreeper");
        event.register(GhostCreeper.class, "GhostCreeper");
        event.register(IceCreeper.class, "IceCreeper");
        event.register(MagmaCreeper.class, "MagmaCreeper");
        event.register(PsychicCreeper.class, "PsychicCreeper");
        event.register(WaterCreeper.class, "WaterCreeper");
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
}