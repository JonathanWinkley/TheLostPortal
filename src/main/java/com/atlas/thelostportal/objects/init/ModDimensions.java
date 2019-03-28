package com.atlas.thelostportal.objects.init;

import com.atlas.thelostportal.util.Reference;
import com.atlas.thelostportal.worldgen.FelWorldProvider;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static DimensionType felDimensionType;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        felDimensionType = DimensionType.register(Reference.MOD_ID, "_test", 2, FelWorldProvider.class, false);
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(2, felDimensionType);
    }
}