package net.scythmon.cygnus.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.block.ModBlocks;
import net.scythmon.cygnus.block.custom.ModCropBlock;
import net.scythmon.cygnus.items.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.BLOOD_STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.ANGEL_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.TEST_BLOCK_RED.get());

        this.dropSelf(ModBlocks.CRYSTAL_OAK_LOG.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_PLANKS.get());

        this.dropSelf(ModBlocks.CRYSTAL_OAK_STAIRS.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_FENCE.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_SAPLING.get());

        this.add(ModBlocks.CRYSTAL_OAK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CRYSTAL_OAK_SLAB.get()));
        this.add(ModBlocks.CRYSTAL_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.CRYSTAL_OAK_DOOR.get()));

        this.add(ModBlocks.ATTUNED_CRYSTAL_ORE.get(),
                block -> multiOreDrops(ModBlocks.ATTUNED_CRYSTAL_ORE.get(), ModItems.ATTUNED_CRYSTAL.get()));

        this.add(ModBlocks.BUDDING_ATTUNED_AMETHYST.get(),
                block -> multiOreDrops(ModBlocks.BUDDING_ATTUNED_AMETHYST.get(), ModItems.ATTUNED_CRYSTAL.get()));

        this.add(ModBlocks.CRYSTAL_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.CRYSTAL_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to a sapling!

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.COFFEE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModCropBlock.AGE, 3));

        LootItemCondition.Builder lootitemcondition$$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.FLOWERING_CRYSTAL_OAK_LEAVES.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModCropBlock.AGE, 3));

        this.add(ModBlocks.COFFEE_CROP.get(), createCropDrops(ModBlocks.COFFEE_CROP.get(), ModItems.COFFEE_BEANS.get(),
                ModItems.COFFEE_SEEDS.get(), lootitemcondition$builder));

        this.add(ModBlocks.FLOWERING_CRYSTAL_OAK_LEAVES.get(), createCropDrops(ModBlocks.FLOWERING_CRYSTAL_OAK_LEAVES.get(), ModItems.CRYSTAL_FLOWER.get(), Items.STICK, lootitemcondition$$builder));


        this.add(ModBlocks.BUDDING_CRYSTAL_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.CRYSTAL_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder multiOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
