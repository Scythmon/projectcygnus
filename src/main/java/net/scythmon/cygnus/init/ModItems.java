package net.scythmon.cygnus.init;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.ModFoods;
import net.scythmon.cygnus.items.custom.*;
import net.scythmon.cygnus.items.custom.armor.ConquestArmorItem;
import net.scythmon.cygnus.items.custom.armor.DeathBirdArmorItem;
import net.scythmon.cygnus.items.custom.armor.FamineArmorItem;
import net.scythmon.cygnus.items.custom.armor.PlagueLordArmorItem;
import net.scythmon.cygnus.items.custom.crowns.*;
import net.scythmon.cygnus.items.custom.masks.*;
import net.scythmon.cygnus.items.custom.tarot.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectCygnus.MOD_ID);
    //Naturals


    public static final RegistryObject<Item> CRYSTAL_BLOOM = ITEMS.register("crystal_bloom",
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
            () -> new CultistKnfie(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).durability(256)));

    public static final RegistryObject<Item> HOLY_WATER = ITEMS.register("holy_water",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> BOTTLED_BLOOD = ITEMS.register("bottled_blood",
            () -> new ModDebuffDrinkItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));


    // Tier one crafting items


    public static final RegistryObject<Item> ATTUNED_CRYSTAL = ITEMS.register("attuned_crystal",
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

    public static final RegistryObject<Item> SEER_SOUL_SHARD = ITEMS.register("seer_soul_shard",
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
            () -> new ArmorItem(ModArmorMaterials.ADAM, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> AWAKENED_MASK_OF_WITHERING = ITEMS.register("awakened_mask_of_withering",
            () -> new AWitMaskArmorItem(ModArmorMaterials.AWIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> AWAKENED_MASK_OF_VITALITY = ITEMS.register("awakened_mask_of_vitality",
            () -> new AVitMaskArmorItem(ModArmorMaterials.AVIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> EMPOWERED_CROWN_OF_STARS = ITEMS.register("empowered_star_crown",
            () -> new EStarCrownArmorItem(ModArmorMaterials.ESTA, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> EMPOWERED_CROWN_OF_STRENGTH = ITEMS.register("empowered_strength_crown",
            () -> new EStrengthCrownArmorItem(ModArmorMaterials.ESTR, ArmorItem.Type.HELMET, new Item.Properties()));


    public static final RegistryObject<Item> EMPOWERED_CROWN_OF_SPEED = ITEMS.register("empowered_speed_crown",
            () -> new ESpeedCrownArmorItem(ModArmorMaterials.ESPE, ArmorItem.Type.HELMET, new Item.Properties()));


    //Death bird


    public static final RegistryObject<Item> DEATH_BIRD_HELMET = ITEMS.register("death_bird_helmet",
            () -> new DeathBirdArmorItem(ModArmorMaterials.DEATH, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> DEATH_BIRD_CHESTPLATE = ITEMS.register("death_bird_chestplate",
            () -> new DeathBirdArmorItem(ModArmorMaterials.DEATH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> DEATH_BIRD_LEGGINGS = ITEMS.register("death_bird_leggings",
            () -> new DeathBirdArmorItem(ModArmorMaterials.DEATH, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> DEATH_BIRD_BOOTS = ITEMS.register("death_bird_boots",
            () -> new DeathBirdArmorItem(ModArmorMaterials.DEATH, ArmorItem.Type.BOOTS, new Item.Properties()));

    //Plagued Lord

    public static final RegistryObject<Item> PLAGUED_LORD_HELMET = ITEMS.register("plagued_lord_helmet",
            () -> new PlagueLordArmorItem(ModArmorMaterials.PESTILENCE, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_LORD_CHESTPLATE = ITEMS.register("plagued_lord_chestplate",
            () -> new PlagueLordArmorItem(ModArmorMaterials.PESTILENCE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_LORD_LEGGINGS = ITEMS.register("plagued_lord_leggings",
            () -> new PlagueLordArmorItem(ModArmorMaterials.PESTILENCE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_LORD_BOOTS = ITEMS.register("plagued_lord_boots",
            () -> new PlagueLordArmorItem(ModArmorMaterials.PESTILENCE, ArmorItem.Type.BOOTS, new Item.Properties()));

    //Famine

    public static final RegistryObject<Item> FAMINE_HELMET = ITEMS.register("famine_helmet",
            () -> new FamineArmorItem(ModArmorMaterials.FAMINE, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> FAMINE_CHESTPLATE = ITEMS.register("famine_chestplate",
            () -> new FamineArmorItem(ModArmorMaterials.FAMINE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> FAMINE_LEGGINGS = ITEMS.register("famine_leggings",
            () -> new FamineArmorItem(ModArmorMaterials.FAMINE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> FAMINE_BOOTS = ITEMS.register("famine_boots",
            () -> new FamineArmorItem(ModArmorMaterials.FAMINE, ArmorItem.Type.BOOTS, new Item.Properties()));
    //Conquest

    public static final RegistryObject<Item> CONQUEST_HELMET = ITEMS.register("conquest_helmet",
            () -> new ConquestArmorItem(ModArmorMaterials.CONQUEST, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> CONQUEST_CHESTPLATE = ITEMS.register("conquest_chestplate",
            () -> new ConquestArmorItem(ModArmorMaterials.CONQUEST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> CONQUEST_LEGGINGS = ITEMS.register("conquest_leggings",
            () -> new ConquestArmorItem(ModArmorMaterials.CONQUEST, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> CONQUEST_BOOTS = ITEMS.register("conquest_boots",
            () -> new ConquestArmorItem(ModArmorMaterials.CONQUEST, ArmorItem.Type.BOOTS, new Item.Properties()));

    //Weaponry

    public static final RegistryObject<Item> DOMINION_SICKLE = ITEMS.register("dominion_sickle",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> EMPOWERED_DOMINION_SICKLE = ITEMS.register("empowered_dominion_sickle",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> THRONE_CLAW = ITEMS.register("throne_claw",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> EMPOWERED_THRONE_CLAW = ITEMS.register("empowered_throne_claw",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> GLAIVE = ITEMS.register("glaive",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> EMPOWERED_GLAIVE = ITEMS.register("empowered_glaive",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> CONQUEST_HALBERD = ITEMS.register("conquest_halberd",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> DEATH_SCYTHE = ITEMS.register("death_scythe",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> PESTILENCE_SWORD = ITEMS.register("pestilence_sword",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SEER_TRIDENT = ITEMS.register("seer_trident",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> ZWEI = ITEMS.register("zwei",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 10, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SHAME = ITEMS.register("shame",
            () -> new SwordItem(ModToolTiers.BOSS_WEAPONS, 1, -3f, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    //ignore this

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100).rarity(Rarity.COMMON)));


    //Food items are below this comment

    public static final RegistryObject<Item> COFFEE_SEEDS = ITEMS.register("coffee_seeds",
            () -> new ItemNameBlockItem(ModBlocks.COFFEE_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    //Stratus' Lore Items Below
    public static final RegistryObject<Item> FIRST_RITUAL_KNIFE = ITEMS.register("first_ritual_knife",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> HEART_OF_FLAMES = ITEMS.register("heart_of_flames",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> NULL_CATALYST_TALISMAN = ITEMS.register("null_catalyst_talisman",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> POWER_BOOSTER_CANISTER = ITEMS.register("power_booster_canister",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> POWER_BOOSTER_NEEDLE = ITEMS.register("power_booster_needle",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> SHATTERED_RELIC = ITEMS.register("shattered_relic",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> STARMAN_SIGIL = ITEMS.register("starman_sigil",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    //TarotCards
    public static final RegistryObject<Item> TAROT_DECK = ITEMS.register("tarot_deck",
            () -> new TarotDeck(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).durability(256)));

    public static final RegistryObject<Item> VEILED_CARD = ITEMS.register("veiled_card",
            () -> new VeiledCard(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_FOOL = ITEMS.register("the_fool",
            () -> new A0TheFool(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_MAGICIAN = ITEMS.register("the_magician",
            () -> new A1TheMagician(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_HIGH_PRIESTESS = ITEMS.register("the_high_priestess",
            () -> new A2TheHighPreistess(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_EMPRESS = ITEMS.register("the_empress",
            () -> new A3TheEmpress(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_EMPEROR = ITEMS.register("the_emperor",
            () -> new A4TheEmperor(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_HIEROPHANT = ITEMS.register("the_hierophant",
            () -> new A5TheHierophant(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_LOVERS = ITEMS.register("the_lovers",
            () -> new A6TheLovers(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_CHARIOT = ITEMS.register("the_chariot",
            () -> new A7TheChariot(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> STRENGTH = ITEMS.register("strength",
            () -> new A8Strength(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_HERMIT = ITEMS.register("the_hermit",
            () -> new A9TheHermit(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> WHEEL_OF_FORTUNE = ITEMS.register("wheel_of_fortune",
            () -> new A10WheelOfFortune(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> JUSTICE = ITEMS.register("justice",
            () -> new A11Justice(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_HANGED_MAN = ITEMS.register("the_hanged_man",
            () -> new A12TheHangedMan(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> DEATH = ITEMS.register("death",
            () -> new A13Death(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> TEMPERANCE = ITEMS.register("temperance",
            () -> new A14Temperance(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_DEVIL = ITEMS.register("the_devil",
            () -> new A15TheDevil(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_TOWER = ITEMS.register("the_tower",
            () -> new A16TheTower(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_STARS = ITEMS.register("the_stars",
            () -> new A17TheStars(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_MOON = ITEMS.register("the_moon",
            () -> new A18TheMoon(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_SUN = ITEMS.register("the_sun",
            () -> new A19TheSun(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> JUDGEMENT = ITEMS.register("judgement",
            () -> new A20Judgement(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> THE_WORLD = ITEMS.register("the_world",
            () -> new A21TheWorld(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
