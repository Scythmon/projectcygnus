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
    //Naturals


    public static final RegistryObject<Item> CRYSTAL_FLOWER = ITEMS.register("crystal_flower",
            () -> new Item((new Item.Properties().food(ModFoods.CRYSTAL_FLOWER).rarity(Rarity.UNCOMMON))));

    public static final RegistryObject<Item> CRYSTAL_BERRIES = ITEMS.register("crystal_berries",
            () -> new Item((new Item.Properties().food(ModFoods.CRYSTAL_BERRIES).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> BROWNIE = ITEMS.register("brownie",
            () -> new Item((new Item.Properties().food(ModFoods.BROWNIE).rarity(Rarity.COMMON))));

    // Tier one crafting items


    public static final RegistryObject<Item> TRUE_CRYSTAL = ITEMS.register("true_crystal",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> STARFLAME = ITEMS.register("starflame",
        () -> new Item(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> BLOOD_STEEL = ITEMS.register("blood_steel",
        () -> new Item(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> ANGEL_GOLD = ITEMS.register("angel_gold",
            () -> new Item(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> ALTAR_CORE = ITEMS.register("altar_core",
            () -> new Item(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON)));


    //Tier two crafting items


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

    public static final RegistryObject<Item> CHERUB_TEAR = ITEMS.register("cherub_tear",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THRONE_TEAR = ITEMS.register("throne_tear",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> DOMINION_TEAR = ITEMS.register("dominion_tear",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> CONCENTRATED_CRYSTAL_CLUSTER = ITEMS.register("concentrated_crystal_cluster",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMPTY_CELESTIAL_TALISMAN = ITEMS.register("empty_celestial_talisman",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STAR = ITEMS.register("star",
            () -> new Item(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC)));


    //Tier three crafting items


    public static final RegistryObject<Item> EMPTY_ANGELIC_TALISMAN = ITEMS.register("empty_angelic_talisman",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FELL_STAR_PLATE = ITEMS.register("fell_star_plate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AFTERLIFE_PLATE = ITEMS.register("afterlife_plate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANGEL_PLATE = ITEMS.register("angel_plate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CARNAGE_PLATE = ITEMS.register("carnage_plate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNSTABLE_SINGULARITY = ITEMS.register("unstable_singularity",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SINGULARITY_SHARD = ITEMS.register("singularity_shard",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> SINGULARITY_STONE = ITEMS.register("singularity_stone",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));




    //Food items are below this comment


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
