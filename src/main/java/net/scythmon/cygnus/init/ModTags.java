package net.scythmon.cygnus.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.scythmon.cygnus.ProjectCygnus;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> PLACEHOLDER = tag("placeholder");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ProjectCygnus.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> HIGH_TIER_CONCENTRATES = tag("high_tier_concentrates");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ProjectCygnus.MOD_ID, name));
        }
    }
}
