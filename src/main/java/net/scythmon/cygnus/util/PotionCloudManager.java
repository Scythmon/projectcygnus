package net.scythmon.cygnus.util;

import net.minecraft.world.entity.AreaEffectCloud;

import java.util.HashMap;
import java.util.Map;

public class PotionCloudManager {
    private static final Map<AreaEffectCloud, Integer>
            potionEffectCloudMap = new HashMap<>();

    private static void assignPotionValue(AreaEffectCloud cloud, int value) {
        potionEffectCloudMap.put(cloud, value);
    }

    public static Integer getPotionCloudValue(AreaEffectCloud cloud) {
        return potionEffectCloudMap.get(cloud);
    }

    public static Map<AreaEffectCloud, Integer> getAllPotionClouds() {
        return potionEffectCloudMap;
    }
}
