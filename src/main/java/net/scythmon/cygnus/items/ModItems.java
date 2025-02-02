package net.scythmon.cygnus.items;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.entity.ModEntities;
import net.scythmon.cygnus.items.custom.*;
import net.scythmon.cygnus.items.custom.armor.ConquestArmorItem;
import net.scythmon.cygnus.items.custom.crowns.*;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import net.scythmon.cygnus.items.custom.masks.AWitMaskArmorItem;
import net.scythmon.cygnus.items.custom.masks.VitMaskArmorItem;
import net.scythmon.cygnus.items.custom.masks.WitMaskArmorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectCygnus.MOD_ID);
    //Naturals


    public static final RegistryObject<Item> CRYSTAL_FLOWER = ITEMS.register("crystal_flower",
            () -> new Item((new Item.Properties().food(ModFoods.CRYSTAL_FLOWER).rarity(Rarity.COMMON))));

    public static final RegistryObject<Item> ONEH_MOTER = ITEMS.register("oneh_moter",
            () -> new ModDebuffDrinkItem((new Item.Properties().food(ModFoods.ONEH_MOTER).rarity(Rarity.EPIC))));

    public static final RegistryObject<Item> CRYSTAL_BERRIES = ITEMS.register("crystal_berries",
            () -> new Item((new Item.Properties().food(ModFoods.CRYSTAL_BERRIES).rarity(Rarity.COMMON))));

    public static final RegistryObject<Item> CRYSTAL_BUDS = ITEMS.register("crystal_buds",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> BROWNIE = ITEMS.register("brownie",
            () -> new Item((new Item.Properties().food(ModFoods.BROWNIE).rarity(Rarity.COMMON))));

    public static final RegistryObject<Item> COFFEE = ITEMS.register("coffee",
            () -> new ModDrinkItem((new Item.Properties().food(ModFoods.COFFEE).rarity(Rarity.COMMON))));
    //PreCrafting
    public static final RegistryObject<Item> BOOK_OF_ENOCH = ITEMS.register("book_of_enoch",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> PRAYER_BOOK = ITEMS.register("prayer_book",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> CULTIST_KNIFE = ITEMS.register("cultist_knife",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> HOLY_WATER = ITEMS.register("holy_water",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> BOTTLED_BLOOD = ITEMS.register("bottled_blood",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));


    // Tier one crafting items


    public static final RegistryObject<Item> TRUE_CRYSTAL = ITEMS.register("true_crystal",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> STARFLAME = ITEMS.register("starflame",
        () -> new FuelItem(new Item.Properties(), 12800));

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

    //Tier 4 Crafting items

    public static final RegistryObject<Item> WISHING_CORE = ITEMS.register("wishing_core",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> WISHING_TOKEN = ITEMS.register("wishing_token",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> EMPTY_WATCHING_TALISMAN = ITEMS.register("empty_watching_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> EMPTY_HARBINGER_TALISMAN = ITEMS.register("empty_harbinger_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> EMPTY_FETID_TALISMAN = ITEMS.register("empty_fetid_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    //Filled Celestial Talismans

    public static final RegistryObject<Item> DAMNED_CONJURE_TALISMAN = ITEMS.register("damned_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> VITALITY_CONJURE_TALISMAN = ITEMS.register("vitality_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> WITHER_CONJURE_TALISMAN = ITEMS.register("wither_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> LIGHTNING_CONJURE_TALISMAN = ITEMS.register("lightning_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> ENFLAMED_CONJURE_TALISMAN = ITEMS.register("enflamed_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> STAR_CONJURE_TALISMAN = ITEMS.register("star_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> DOMINION_CONJURE_TALISMAN = ITEMS.register("dominion_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> CHERUB_CONJURE_TALISMAN = ITEMS.register("cherub_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THRONE_CONJURE_TALISMAN = ITEMS.register("throne_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    //Filled Carnage Talisman

    public static final RegistryObject<Item> WATCHING_CONJURE_TALISMAN = ITEMS.register("watching_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> CONQUEST_CONJURE_TALISMAN = ITEMS.register("conquest_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> DEATH_CONJURE_TALISMAN = ITEMS.register("death_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> FAMINE_CONJURE_TALISMAN = ITEMS.register("famine_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> PESTILENCE_CONJURE_TALISMAN = ITEMS.register("pestilence_conjure_talisman",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    //Boss Drops

    public static final RegistryObject<Item> UNDEAD_ESSENCE = ITEMS.register("undead_essence",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> VITALITY_ESSENCE = ITEMS.register("vitality_essence",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> WITHER_ESSENCE = ITEMS.register("wither_essence",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> LIGHTNING_ESSENCE = ITEMS.register("lightning_essence",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> ENFLAMED_ESSENCE = ITEMS.register("enflamed_essence",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> STAR_ESSENCE = ITEMS.register("star_essence",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> SOUL_OF_FLAMING_CHOIRS = ITEMS.register("soul_of_flaming_choirs",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> SOUL_OF_GODLY_JUDGEMENT = ITEMS.register("soul_of_godly_judgement",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> SOUL_OF_CRUMBLING_HEAVENS = ITEMS.register("soul_of_crumbling_heavens",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    //Armour Sets ----------------------------------------------------------------------------------

    //Unpowered crowns/masks

    public static final RegistryObject<Item> MASK_OF_THE_DAMNED = ITEMS.register("mask_of_the_damned",
            () -> new ArmorItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> MASK_OF_WITHERING = ITEMS.register("mask_of_withering",
            () -> new WitMaskArmorItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> MASK_OF_VITALITY = ITEMS.register("mask_of_vitality",
            () -> new VitMaskArmorItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> SPEED_CROWN = ITEMS.register("speed_crown",
            () -> new SpeedCrownArmorItem(ModArmorMaterials.CROWN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> STRENGTH_CROWN = ITEMS.register("strength_crown",
            () -> new StrengthCrownArmorItem(ModArmorMaterials.CROWN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> STAR_CROWN = ITEMS.register("star_crown",
            () -> new StarCrownArmorItem(ModArmorMaterials.CROWN, ArmorItem.Type.HELMET, new Item.Properties()));

    //Powered crowns/masks

    public static final RegistryObject<Item> AWAKENED_MASK_OF_THE_DAMNED = ITEMS.register("awakened_mask_of_the_damned",
            () -> new ArmorItem(ModArmorMaterials.PMASK, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> AWAKENED_MASK_OF_WITHERING = ITEMS.register("awakened_mask_of_withering",
            () -> new AWitMaskArmorItem(ModArmorMaterials.PMASK, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> AWAKENED_MASK_OF_VITALITY = ITEMS.register("awakened_mask_of_vitality",
            () -> new AVitMaskArmorItem(ModArmorMaterials.PMASK, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> EMPOWERED_CROWN_OF_STARS = ITEMS.register("empowered_star_crown",
            () -> new EStarCrownArmorItem(ModArmorMaterials.PCROWN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> EMPOWERED_CROWN_OF_STRENGTH = ITEMS.register("empowered_strength_crown",
            () -> new EStrengthCrownArmorItem(ModArmorMaterials.PCROWN, ArmorItem.Type.HELMET, new Item.Properties()));


    public static final RegistryObject<Item> EMPOWERED_CROWN_OF_SPEED = ITEMS.register("empowered_speed_crown",
            () -> new ESpeedCrownArmorItem(ModArmorMaterials.PCROWN, ArmorItem.Type.HELMET, new Item.Properties()));


    //Death bird


    public static final RegistryObject<Item> DEATH_BIRD_HELMET = ITEMS.register("death_bird_helmet",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> DEATH_BIRD_CHESTPLATE = ITEMS.register("death_bird_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> DEATH_BIRD_LEGGINGS = ITEMS.register("death_bird_leggings",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> DEATH_BIRD_BOOTS = ITEMS.register("death_bird_boots",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.BOOTS, new Item.Properties()));

    //Plagued Lord

    public static final RegistryObject<Item> PLAGUED_LORD_HELMET = ITEMS.register("plagued_lord_helmet",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_LORD_CHESTPLATE = ITEMS.register("plagued_lord_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_LORD_LEGGINGS = ITEMS.register("plagued_lord_leggings",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_LORD_BOOTS = ITEMS.register("plagued_lord_boots",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.BOOTS, new Item.Properties()));

    //Famine

    public static final RegistryObject<Item> FAMINE_HELMET = ITEMS.register("famine_helmet",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> FAMINE_CHESTPLATE = ITEMS.register("famine_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> FAMINE_LEGGINGS = ITEMS.register("famine_leggings",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> FAMINE_BOOTS = ITEMS.register("famine_boots",
            () -> new ArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.BOOTS, new Item.Properties()));
    //Conquest

    public static final RegistryObject<Item> CONQUEST_HELMET = ITEMS.register("conquest_helmet",
            () -> new ConquestArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> CONQUEST_CHESTPLATE = ITEMS.register("conquest_chestplate",
            () -> new ConquestArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> CONQUEST_LEGGINGS = ITEMS.register("conquest_leggings",
            () -> new ConquestArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> CONQUEST_BOOTS = ITEMS.register("conquest_boots",
            () -> new ConquestArmorItem(ModArmorMaterials.HMEN, ArmorItem.Type.BOOTS, new Item.Properties()));
    //ignore this

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> TIGER_SPAWN_EGG = ITEMS.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TIGER, 0xD57E36, 0xD1D00D0,
                    new Item.Properties()));

    //Food items are below this comment




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
