package net.scythmon.cygnus.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectCygnus.MOD_ID);

    public static final RegistryObject<Item> CONCENTRATED_CRYSTAL_CLUSTER = ITEMS.register("concentrated_crystal_cluster",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SINGULARITY_STONE = ITEMS.register("singularity_stone",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> STAR = ITEMS.register("star",
            () -> new Item(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> TRUE_CRYSTAL = ITEMS.register("true_crystal",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));


//Concentrates and related items are below this comment
    public static final RegistryObject<Item> WITHER_CONCENTRATE = ITEMS.register("wither_concentrate",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> LIFE_CONCENTRATE = ITEMS.register("life_concentrate",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> UNDEAD_CONCENTRATE = ITEMS.register("undead_concentrate",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> SPEED_CONCENTRATE = ITEMS.register("speed_concentrate",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item>  STAR_CONCENTRATE = ITEMS.register("star_concentrate",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> STRENGTH_CONCENTRATE = ITEMS.register("strength_concentrate",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
