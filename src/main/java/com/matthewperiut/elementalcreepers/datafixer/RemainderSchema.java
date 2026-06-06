package com.matthewperiut.elementalcreepers.datafixer;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import net.modificationstation.stationapi.api.datafixer.TypeReferences;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * A schema that registers every StationAPI type reference as a passthrough
 * (remainder). Nothing is structurally decoded, so unknown entity ids from
 * vanilla or other mods can never fail to read or get dropped — our fix
 * only touches raw Dynamic data.
 */
public class RemainderSchema extends Schema {
    public RemainderSchema(int versionKey, Schema parent) {
        super(versionKey, parent);
    }

    @Override
    public Map<String, Supplier<TypeTemplate>> registerEntities(Schema schema) {
        return new HashMap<>();
    }

    @Override
    public Map<String, Supplier<TypeTemplate>> registerBlockEntities(Schema schema) {
        return new HashMap<>();
    }

    @Override
    public void registerTypes(Schema schema, Map<String, Supplier<TypeTemplate>> entityTypes, Map<String, Supplier<TypeTemplate>> blockEntityTypes) {
        schema.registerType(false, TypeReferences.LEVEL, DSL::remainder);
        schema.registerType(false, TypeReferences.PLAYER, DSL::remainder);
        schema.registerType(false, TypeReferences.CHUNK, DSL::remainder);
        // at least one recursive type must exist for Schema.buildTypes()
        schema.registerType(true, TypeReferences.ENTITY, DSL::remainder);
        schema.registerType(true, TypeReferences.BLOCK_ENTITY, DSL::remainder);
        schema.registerType(false, TypeReferences.ITEM_STACK, DSL::remainder);
        schema.registerType(false, TypeReferences.BLOCK_STATE, DSL::remainder);
        schema.registerType(false, TypeReferences.ITEM_NAME, DSL::remainder);
    }
}
