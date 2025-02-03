package net.scythmon.cygnus.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.scythmon.cygnus.ProjectCygnus;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    FAMINE("famine", 30, new int[]{ 7, 10, 12, 8 }, 9,
            SoundEvents.ARMOR_EQUIP_CHAIN, 4f, 0.3f, () -> Ingredient.of(ModItems.CARNAGE_PLATE.get())),

    DEATH("death", 30, new int[]{ 7, 10, 12, 8 }, 9,
            SoundEvents.ARMOR_EQUIP_CHAIN, 4f, 0.3f, () -> Ingredient.of(ModItems.CARNAGE_PLATE.get())),

    CONQUEST("conquest", 30, new int[]{ 7, 10, 12, 8 }, 9,
            SoundEvents.ARMOR_EQUIP_CHAIN, 4f, 0.3f, () -> Ingredient.of(ModItems.CARNAGE_PLATE.get())),

    PESTILENCE("pestilence", 30, new int[]{ 7, 10, 12, 8 }, 9,
            SoundEvents.ARMOR_EQUIP_CHAIN, 4f, 0.3f, () -> Ingredient.of(ModItems.CARNAGE_PLATE.get())),

    PMASK("pmask", 8, new int[]{ 10, 6, 5, 2 }, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 4f, 0.1f, () -> Ingredient.of(ModItems.SINGULARITY_STONE.get())),

    PCROWN("pcrown", 8, new int[]{ 12, 6, 5, 2 }, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 4f, 0.1f, () -> Ingredient.of(ModItems.SINGULARITY_STONE.get())),

    CROWN("crown", 8, new int[]{ 1, 6, 5, 2 }, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 4f, 0.1f, () -> Ingredient.of(ModItems.ANGEL_GOLD.get())),

    MASK("mask", 5, new int[]{ 2, 6, 5, 2 }, 25,
    SoundEvents.ARMOR_EQUIP_GOLD, 0f, 0f, () -> Ingredient.of(ModItems.BLOOD_STEEL.get()));

    private static final int[] BASE_DURABILITY;

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredients;





    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredients) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredients = repairIngredients;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredients.get();
    }

    @Override
    public String getName() {
        return ProjectCygnus.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
