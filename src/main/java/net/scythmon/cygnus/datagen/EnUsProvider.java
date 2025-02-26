/*
 * SPDX-FileCopyrightText: 2022 klikli-dev
 *
 * SPDX-License-Identifier: MIT
 */

package net.scythmon.cygnus.datagen;

import com.klikli_dev.modonomicon.Modonomicon;
import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.ModonomiconConstants;
import com.klikli_dev.modonomicon.api.ModonomiconConstants.I18n.*;
import com.klikli_dev.modonomicon.api.datagen.AbstractModonomiconLanguageProvider;
import com.klikli_dev.modonomicon.api.datagen.BookContextHelper;
import com.klikli_dev.modonomicon.api.datagen.ModonomiconLanguageProvider;
import com.klikli_dev.modonomicon.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.scythmon.cygnus.ProjectCygnus;

public class EnUsProvider extends AbstractModonomiconLanguageProvider {
    public EnUsProvider(PackOutput packOutput, ModonomiconLanguageProvider cachedProvider) {
        super(packOutput, ProjectCygnus.MOD_ID, "en_us", cachedProvider);
    }

    private void addItems(){
        this.add("item.projectcygnus.star", "Star");
        this.add("item.projectcygnus.concentrated_crystal_cluster", "Concentrated Crystal Cluster");
        this.add("item.projectcygnus.singularity_stone", "Singularity Stone");
        this.add("item.projectcygnus.attuned_crystal", "Attuned Crystal");
        this.add("item.projectcygnus.wither_concentrate", "Wither Concentrate");
        this.add("item.projectcygnus.undead_concentrate", "Undead Concentrate");
        this.add("item.projectcygnus.life_concentrate", "Life Concentrate");
        this.add("item.projectcygnus.speed_concentrate", "Speed Concentrate");
        this.add("item.projectcygnus.strength_concentrate", "Strength Concentrate");
        this.add("item.projectcygnus.star_concentrate", "Star Concentrate");
        this.add("item.projectcygnus.starflame", "Starflame");
        this.add("item.projectcygnus.bottled_blood", "Bottle of Blood");
        this.add("item.projectcygnus.cultist_knife", "Cultist Knife");
        this.add("item.projectcygnus.holy_water", "Holy Water");
        this.add("item.projectcygnus.book_of_enoch", "The Book of Enoch");
        this.add("item.projectcygnus.prayer_book", "Prayer Book");
        this.add("item.projectcygnus.oneh_moter", "Oneh Moter");
        this.add("item.projectcygnus.crystal_buds", "Crystal Buds");
        this.add("item.projectcygnus.blood_steel", "Blood Steel");
        this.add("item.projectcygnus.angel_gold", "Angel Gold");
        this.add("item.projectcygnus.altar_core", "Altar Core");
        this.add("item.projectcygnus.cherub_tear", "Cherub Tear");
        this.add("item.projectcygnus.throne_tear", "Throne Tear");
        this.add("item.projectcygnus.dominion_tear", "Dominion Tear");
        this.add("item.projectcygnus.fell_star_plate", "Fell Star Plate");
        this.add("item.projectcygnus.empty_angelic_talisman", "Empty Angelic Talisman");
        this.add("item.projectcygnus.empty_celestial_talisman", "Empty Celestial Talisman");
        this.add("item.projectcygnus.afterlife_plate", "Afterlife Plate");
        this.add("item.projectcygnus.angel_plate", "Angel Plate");
        this.add("item.projectcygnus.carnage_plate", "Carnage Plate");
        this.add("item.projectcygnus.crystal_bloom", "Crystal Bloom");
        this.add("item.projectcygnus.coffee_seeds", "Coffee Seeds");
        this.add("item.projectcygnus.crystal_berries", "Crystal Berries");
        this.add("item.projectcygnus.brownie", "Brownie");
        this.add("item.projectcygnus.coffee", "Coffee");
        this.add("item.projectcygnus.unstable_singularity", "Unstable Singularity");
        this.add("item.projectcygnus.singularity_shard", "Singularity Shard");
        this.add("item.projectcygnus.wishing_core", "Wishing Core");
        this.add("item.projectcygnus.wishing_token", "Wishing Token");
        this.add("item.projectcygnus.empty_harbinger_talisman", "Empty Harbinger Talisman");
        this.add("item.projectcygnus.empty_watching_talisman", "Empty Watching Talisman");
        this.add("item.projectcygnus.empty_fetid_talisman", "Empty Fetid Talisman");
        this.add("item.projectcygnus.damned_conjure_talisman", "Damned Conjure Talisman");
        this.add("item.projectcygnus.vitality_conjure_talisman", "Vitality Conjure Talisman");
        this.add("item.projectcygnus.wither_conjure_talisman", "Wither Conjure Talisman");
        this.add("item.projectcygnus.lightning_conjure_talisman", "Lightning Conjure Talisman");
        this.add("item.projectcygnus.enflamed_conjure_talisman", "Enflamed Conjure Talisman");
        this.add("item.projectcygnus.star_conjure_talisman", "Star Conjure Talisman");
        this.add("item.projectcygnus.dominion_conjure_talisman", "Dominion Conjure Talisman");
        this.add("item.projectcygnus.cherub_conjure_talisman", "Cherub Conjure Talisman");
        this.add("item.projectcygnus.throne_conjure_talisman", "Throne Conjure Talisman");
        this.add("item.projectcygnus.watching_conjure_talisman", "Watching Conjure Talisman");
        this.add("item.projectcygnus.death_conjure_talisman", "Death Conjure Talisman");
        this.add("item.projectcygnus.conquest_conjure_talisman", "Conquest Conjure Talisman");
        this.add("item.projectcygnus.famine_conjure_talisman", "Famine Conjure Talisman");
        this.add("item.projectcygnus.pestilence_conjure_talisman", "Pestilence Conjure Talisman");
        this.add("item.projectcygnus.undead_essence", "Essence of the Undead");
        this.add("item.projectcygnus.vitality_essence", "Essence of Vitality");
        this.add("item.projectcygnus.wither_essence", "Essence of Withering");
        this.add("item.projectcygnus.lightning_essence", "Essence of Lightning");
        this.add("item.projectcygnus.enflamed_essence", "Essence of the Enflamed");
        this.add("item.projectcygnus.star_essence", "Essence of the Stars");
        this.add("item.projectcygnus.soul_of_flaming_choirs", "Soul of Flaming Choirs");
        this.add("item.projectcygnus.soul_of_godly_judgement", "Soul of Godly Judgement");
        this.add("item.projectcygnus.soul_of_crumbling_heavens", "Soul of Crumbling Heavens");
        this.add("item.projectcygnus.seer_soul_shard", "Seer Soul Shard");
        this.add("item.projectcygnus.metal_detector", "Metal Detector");
        this.add("item.projectcygnus.coffee_beans", "Coffee Beans");
        this.add("item.projectcygnus.first_ritual_knife", "First Ritual Knife");
        this.add("item.projectcygnus.heart_of_flames", "Heart Of Flames");
        this.add("item.projectcygnus.null_catalyst_talisman", "Null Catalyst Talisman");
        this.add("item.projectcygnus.power_booster_canister", "Power Booster Canister");
        this.add("item.projectcygnus.power_booster_needle", "Power Booster Needle");
        this.add("item.projectcygnus.shattered_relic", "Shattered Relic");
        this.add("item.projectcygnus.starman_sigil", "Starman Sigil");
        this.add("item.projectcygnus.dominion_sickle", "Dominion Sickle");
        this.add("item.projectcygnus.empowered_dominion_sickle", "Empowered Dominion Sickle");
        this.add("item.projectcygnus.throne_claw", "Claws of the Throne");
        this.add("item.projectcygnus.empowered_throne_claw", "Empowered Claws of the Throne");
        this.add("item.projectcygnus.glaive", "Glaive of Gabriel");
        this.add("item.projectcygnus.empowered_glaive", "Empowered Glaive of Gabriel");
        this.add("item.projectcygnus.conquest_halberd", "Halberd of Conquest");
        this.add("item.projectcygnus.death_scythe", "Death's Scythe");
        this.add("item.projectcygnus.pestilence_sword", "Hooked Sword of Pestilence");
        this.add("item.projectcygnus.zwei", "Zweihander of Famine");
        this.add("item.projectcygnus.shame", "Ominious Greatsword");
    }

    private void addToolTips(){
        this.add("tooltip.projectcygnus.metal_detector.tooltip", "Finds Valuables Underground");
        this.add("tooltip.projectcygnus.oneh_moter.tooltip", "You feel compelled to drink this...though your arent sure if you should");
    }

    private void addBlocks (){
        this.add("block.projectcygnus.concentrated_crystal_block", "Block of Concentrated Crystal");
        this.add("block.projectcygnus.attuned_crystal_ore", "Attuned Crystal Ore");
        this.add("block.projectcygnus.blood_steel_block", "Block of Blood Steel");
        this.add("block.projectcygnus.budding_attuned_amethyst", "Budding Attuned Amethyst");
        this.add("block.projectcygnus.test_block_red", "Guh");
        this.add("block.projectcygnus.angel_gold_block", "Block of Angel Gold");
        this.add("block.projectcygnus.crystal_oak_log", "Crystal Oak Log");
        this.add("block.projectcygnus.crystal_oak_wood", "Crystal Oak Wood");
        this.add("block.projectcygnus.stripped_crystal_oak_log", "Stripped Crystal Oak Log");
        this.add("block.projectcygnus.stripped_crystal_oak_wood", "Stripped Crystal Oak Wood");
        this.add("block.projectcygnus.crystal_oak_sapling", "Crystal Oak Sapling");
        this.add("block.projectcygnus.crystal_oak_stairs", "Crystal Oak Stairs");
        this.add("block.projectcygnus.crystal_oak_slab", "Crystal Oak Slab");
        this.add("block.projectcygnus.crystal_oak_button", "Crystal Oak Button");
        this.add("block.projectcygnus.crystal_oak_pressure_plate", "Crystal Oak Pressure Plate");
        this.add("block.projectcygnus.crystal_oak_fence", "Crystal Oak Fence");
        this.add("block.projectcygnus.crystal_oak_fence_gate", "Crystal Oak Fence Gate");
        this.add("block.projectcygnus.crystal_oak_door", "Crystal Oak Planks");
        this.add("block.projectcygnus.crystal_oak_trapdoor", "Crystal Oak Trapdoor");
        this.add("block.projectcygnus.star_forge", "Star Forge");
        this.add("block.projectcygnus.star_forge_pillar", "Star Forge Pillar");
        this.add("block.projectcygnus.crystal_oak_leaves", "Crystal Oak Leaves");
        this.add("block.projectcygnus.flowering_crystal_oak_leaves", "Flowering Crystal Oak Leaves");
        this.add("block.projectcygnus.budding_crystal_oak_leaves", "Budding Crystal Oak Leaves");
        this.add("block.projectcygnus.sound_block", "Sound Block");
        this.add("block.projectcygnus.attuned_crystal_block", "Block of Attuned Crystal");
        this.add("block.projectcygnus.crystal_vines", "Crystal Vines");
        this.add("block.projectcygnus.crystal_lily", "Crystal Lily");
        this.add("block.projectcygnus.blood_cardinal", "Blood Cardinal");
        this.add("block.projectcygnus.judges_lilies", "Judge's Lilies");
        this.add("block.projectcygnus.festered_pimpernel", "Festered Pimpernel");
        this.add("block.projectcygnus.choirs_gem", "Choir's Gem");
        this.add("block.projectcygnus.ferro_clovers", "Ferro Clover");
        this.add("block.projectcygnus.architect_corpse", "Architect Corpse");
        this.add("block.projectcygnus.crystal_vines_plant", "Crystal Vines");
        this.add("item.projectcygnus.death_bird_helmet", "Mask of the Death Bird");
        this.add("item.projectcygnus.death_bird_chestplate", "Ribs of the Death Bird");
        this.add("item.projectcygnus.death_bird_leggings", "Leggings of the Death Bird");
        this.add("item.projectcygnus.death_bird_boots", "Claws of the Death Bird");
        this.add("item.projectcygnus.plagued_lord_helmet", "Helm of the Plagued Lord");
        this.add("item.projectcygnus.plagued_lord_chestplate", "Chestplate of the Plagued Lord");
        this.add("item.projectcygnus.plagued_lord_leggings", "Greaves of the Plagued Lord");
        this.add("item.projectcygnus.plagued_lord_boots", "Boots of the Plagued Lord");
        this.add("item.projectcygnus.famine_helmet", "Helm of the Starved Beast");
        this.add("item.projectcygnus.famine_chestplate", "Chestplate of the Starved Beast");
        this.add("item.projectcygnus.famine_leggings", "Greaves of the Starved Beast");
        this.add("item.projectcygnus.famine_boots", "Boots of the Starved Beast");
        this.add("item.projectcygnus.conquest_helmet", "War Fangs of Conquest");
        this.add("item.projectcygnus.conquest_chestplate", "War Plate of Conquest");
        this.add("item.projectcygnus.conquest_leggings", "War Greaves of Conquest");
        this.add("item.projectcygnus.conquest_boots", "War Shackles of Conquest");
        this.add("item.projectcygnus.mask_of_the_damned", "Mask of the Damned");
        this.add("item.projectcygnus.mask_of_withering", "Mask of Withering");
        this.add("item.projectcygnus.mask_of_vitality", "Mask of Vitality");
        this.add("item.projectcygnus.awakened_mask_of_the_damned", "Awakened Mask of the Damned");
        this.add("item.projectcygnus.awakened_mask_of_withering", "Awakened Mask of Withering");
        this.add("item.projectcygnus.awakened_mask_of_vitality", "Awakened Mask of Vitality");
        this.add("item.projectcygnus.star_crown", "Crown of Stars");
        this.add("item.projectcygnus.strength_crown", "Crown of Power");
        this.add("item.projectcygnus.speed_crown", "Crown of Agility");
        this.add("item.projectcygnus.empowered_star_crown", "Empowered Crown of Stars");
        this.add("item.projectcygnus.empowered_strength_crown", "Empowered Crown of Power");
        this.add("item.projectcygnus.empowered_speed_crown", "Empowered Crown of Agility");
    }

    private void miscTrans (){
        this.add("creativetab.cygnus_items_tab", "Cygnus Items");
        this.add("creativetab.cygnus_blocks_tab", "Cygnus Blocks");
        this.add("creativetab.cygnus_arsenal_tab", "Cygnus Arsenal");
        this.add("entity.projectcygnus.withermask", "Withermask[PlaceHolder]");
        this.add("death.attack.withermask", "%1$s was doomed to decay");
    }

    private void addModTranslations(){
        this.addItems();
        this.addBlocks();
        this.addToolTips();
        this.miscTrans();
    }

    private void addDemoBook() {

        var helper = ModonomiconAPI.get().getContextHelper(ProjectCygnus.MOD_ID);
        helper.book("demo");

        this.addDemoBookFeaturesCategory(helper);
        this.addDemoBookFormattingCategory(helper);
        this.addDemoBookHiddenCategory(helper);


    }

    private void addDemoBookFeaturesCategory(BookContextHelper helper) {
        helper.category("features");

        this.addDemoBookMultiblockEntry(helper);
        this.addDemoBookRecipeEntry(helper);
        this.addDemoBookConditionEntries(helper);
        this.addDemoBookSpotlightEntry(helper);
        this.addDemoBookEmptyPageEntry(helper);
        this.addDemoBookEntityEntry(helper);
        this.addDemoBookImagePageEntry(helper);
        this.addDemoBookImageRedirectEntry(helper);
        this.add(helper.categoryName(), "Features Category");

    }

    private void addDemoBookMultiblockEntry(BookContextHelper helper) {
        helper.entry("multiblock");

        helper.page("intro");
        this.add(helper.pageTitle(), "Multiblock Page");
        this.add(helper.pageText(), "Multiblock pages allow to preview multiblocks both in the book and in the world.");

        helper.page("preview");
        this.add("multiblocks.modonomicon.blockentity", "Blockentity Multiblock."); //TODO: should probably move into another part of langgen
        this.add(helper.pageText(), "A sample multiblock.");

        this.add(helper.entryName(), "Multiblock Entry");
        this.add(helper.entryDescription(), "An entry showcasing a multiblock.");
    }

    private void addDemoBookConditionEntries(BookContextHelper helper) {

        helper.entry("condition_root");
        helper.page("info");
        this.add(helper.pageTitle(), "Condition Root");
        this.add(helper.pageText(), "Root page for our condition / unlock tests.");

        this.add(helper.entryName(), "Condition Root Entry");
        this.add(helper.entryDescription(), "Condition Root Entry");

        helper.entry("condition_advancement");
        this.add(helper.entryName(), "Advancement Condition");
        this.add(helper.entryDescription(), "Depends on an advancement being unlocked.");

        helper.entry("condition_level_1");
        helper.page("info");
        this.add(helper.pageTitle(), "Condition Level 1");
        this.add(helper.pageText(), "This entry depends on Condition Root being read.");

        this.add(helper.entryName(), "Condition Level 1 Entry");
        this.add(helper.entryDescription(), "Depends on Condition Root being read.");

        helper.entry("condition_level_2");
        helper.page("info");
        this.add(helper.pageTitle(), "Condition Level 2");
        this.add(helper.pageText(), "This entry depends on Condition Level 1 being unlocked.");

        this.add(helper.entryName(), "Condition Level 2 Entry");
        this.add(helper.entryDescription(), "Depends on Condition Level 1 being unlocked.");
    }

    private void addDemoBookRecipeEntry(BookContextHelper helper) {
        helper.entry("recipe");

        helper.page("intro");
        this.add(helper.pageTitle(), "Recipe Entry");
        this.add(helper.pageText(), "Recipe pages allow to show recipes in the book.");

        helper.page("crafting");
        this.add(helper.pageText(), "A sample recipe page.");
        this.add("test.test.test", "Book of Binding: Afrit (Bound)"); //long title to test scaling on recipe 2


        helper.page("smoking");
        this.add(helper.pageText(), "A smoking recipe page with one recipe and some text.");

        this.add(helper.entryName(), "Recipe Entry");
        this.add(helper.entryDescription(), "An entry showcasing recipe pages.");
    }

    private void addDemoBookSpotlightEntry(BookContextHelper helper) {
        helper.entry("spotlight");

        helper.page("intro");
        this.add(helper.pageTitle(), "Spotlight Entry");
        this.add(helper.pageText(), "Spotlight pages allow to show items (actually, ingredients).");

        helper.page("spotlight1");
        this.add(helper.pageTitle(), "Custom Title");
        this.add(helper.pageText(), "A sample spotlight page with custom title.");

        helper.page("spotlight2");
        this.add(helper.pageText(), "A sample spotlight page with automatic title.");

        this.add(helper.entryName(), "Spotlight Entry");
        this.add(helper.entryDescription(), "An entry showcasing spotlight pages.");
    }

    private void addDemoBookEmptyPageEntry(BookContextHelper helper) {
        helper.entry("empty");

        helper.page("intro");
        this.add(helper.pageTitle(), "Empty Page Entry");
        this.add(helper.pageText(), "Empty pages allow to add .. empty pages.");

        this.add(helper.entryName(), "Empty Page Entry");
        this.add(helper.entryDescription(), "An entry showcasing empty pages.");
    }

    private void addDemoBookEntityEntry(BookContextHelper helper) {
        helper.entry("entity");

        helper.page("intro");
        this.add(helper.pageTitle(), "Entity Entry");
        this.add(helper.pageText(), "Entity pages allow to show entities.");

        helper.page("entity1");
        this.add(helper.pageTitle(), "Custom Name");

        helper.page("entity2");
        this.add(helper.pageText(), "A sample entity page with automatic title.");

        this.add(helper.entryName(), "Entity Entry");
        this.add(helper.entryDescription(), "An entry showcasing entity pages.");
    }

    private void addDemoBookImagePageEntry(BookContextHelper helper) {
        helper.entry("image");

        helper.page("intro");
        this.add(helper.pageTitle(), "Image Page Entry");
        this.add(helper.pageText(), "Image pages allow to show images.");

        helper.page("image");
        this.add(helper.pageTitle(), "Sample image!");
        this.add(helper.pageText(), "A sample text for the sample image.");


        this.add(helper.entryName(), "Image Page Entry");
        this.add(helper.entryDescription(), "An entry showcasing image pages.");
    }

    private void addDemoBookImageRedirectEntry(BookContextHelper helper) {
        helper.entry("redirect");
        this.add(helper.entryName(), "Category Redirect Entry");
        this.add(helper.entryDescription(), "Redirects to another category.");
    }


    private void addDemoBookFormattingCategory(BookContextHelper helper) {
        helper.category("formatting");

        this.addDemoBookBasicFormattingEntry(helper);
        this.addDemoBookAdvancedFormattingEntry(helper);
        this.addDemoBookLinkFormattingEntry(helper);

        helper.entry("always_locked");
        this.add(helper.entryName(), "Always Locked Entry");
        this.add(helper.entryDescription(), "Used to demonstrate linking to locked entries");

        this.add(helper.categoryName(), "Formatting Category");
    }

    private void addDemoBookBasicFormattingEntry(BookContextHelper helper) {
        helper.entry("basic");

        helper.page("page1"); //bold, italics, underlines,
        this.add(helper.pageTitle(), "Basic Formatting");
        this.add(helper.pageText(),
                """
                        **This is bold**    \s
                        *This is italics*    \s
                        ++This is underlined++
                             """);

        helper.page("page2"); ////strikethrough, color

        //this.add(helper.pageTitle(), "");
        this.add(helper.pageText(),
                """
                        ~~This is stricken through~~   \s
                        [#](55FF55)Colorful Text![#]()
                             """);

        this.add(helper.entryName(), "Basic Formatting Entry");
        this.add(helper.entryDescription(), "An entry showcasing basic formatting.");
    }

    private void addDemoBookAdvancedFormattingEntry(BookContextHelper helper) {
        helper.entry("advanced");

        helper.page("page1");  //translatable texts, mixed formatting
        this.add(helper.pageTitle(), "Advanced Formatting");
        this.add(helper.pageText(),
                """
                        <t>this.could.be.a.translation.key<t>    \s
                        ***This is bold italics***    \s
                        *++This is italics underlined++*
                        [](item://minecraft:diamond)
                        [TestText](item://minecraft:emerald)
                             """);

        helper.page("page2"); //lists

        //this.add(helper.pageTitle(), "");
        this.add(helper.pageText(),
                """
                        Unordered List:
                        - List item 
                        - List item 2
                        - List item 3

                        Ordered List:
                        1. Entry 1
                        2. Entry 2
                             """);

        helper.page("page3"); //lists
        this.add(helper.pageTitle(), "Ridiculously superlong title that should be scaled!");
        this.add(helper.pageText(),
                """
                        This page is to test title scaling!""");

        this.add(helper.entryName(), "Advanced Formatting Entry");
        this.add(helper.entryDescription(), "An entry showcasing advanced formatting.");
    }

    private void addDemoBookLinkFormattingEntry(BookContextHelper helper) {
        helper.entry("link");

        helper.page("page1"); //http links
        this.add(helper.pageTitle(), "Http Links");
        this.add(helper.pageText(),
                """
                        [Click me!](https://klikli-dev.github.io/modonomicon/) \\
                        [Or me!](https://github.com/klikli-dev/modonomicon)
                             """);

        helper.page("page2"); //book entry links
        this.add(helper.pageTitle(), "Book Links");
        this.add(helper.pageText(),
                """
                        [View a Multiblock](entry://features/multiblock) \\
                        [Link without book id](entry://formatting/basic) \\
                        [Always locked](entry://formatting/always_locked) \\
                        [Category Link without book id](category://formatting/)
                             """);

        helper.page("page3"); //patchouli links
        this.add(helper.pageTitle(), "Patchouli Links");
        this.add(helper.pageText(),
                """
                        [Link to a Patchouli Entry](patchouli://occultism:dictionary_of_spirits//misc/books_of_calling)
                             """);
        this.add("patchouli.occultism.dictionary_of_spirits.misc.books_of_calling.name", "Books of Calling"); //patchouli entry name

        this.add(helper.entryName(), "Link Formatting Entry");
        this.add(helper.entryDescription(), "An entry showcasing link formatting.");
    }

    private void addDemoBookHiddenCategory(BookContextHelper helper) {
        helper.category("hidden");

        helper.entry("always_locked");
        this.add(helper.entryName(), "Always Locked Entry");
        this.add(helper.entryDescription(), "Placeholder because I could not be bothered to create sample content here");

        this.add(helper.categoryName(), "Hidden Category");
    }

    private void addBooks() {
        this.addDemoBook();

        this.add("modonomicon.test_book.title", "Test Book");

        this.add("modonomicon.test.entries.test_category.test_entry.description", "Test Description");
        this.add("modonomicon.test.sections.test_category.test_entry.page0.title", "[**Bold Link**](book://modonomicon:test)");
        this.add("modonomicon.test.sections.test_category.test_entry.page0.text",
                """
                        [This is a **link** text](https://www.google.com).  \s
                        We have a newline here.
                        - List item 
                        - List item 2
                        - List item 3
                                            
                        And this is a super long line where we hope it will be automatically wrapped into a new line otherwise that is super-bad.      
                        """);
        this.add("modonomicon.test.sections.test_category.test_entry.page1.title", "*[#](55FF55)Colorful Italics*[#]()");
        this.add("modonomicon.test.sections.test_category.test_entry.page1.text",
                """
                        And this is our page two.
                         """);
        this.add("modonomicon.test.sections.test_category.test_entry.page2.title", "Page 3");
        this.add("modonomicon.test.sections.test_category.test_entry.page2.text",
                """
                        And this is our page three.
                         """);


        this.add("modonomicon.test.sections.test_category.test_entry_child.page2.text",
                """
                        And this is our page three.  \s
                        [With link](entry://modonomicon:test/test_category/test_entry@test_anchor)
                         """);

        this.add("modonomicon.test.sections.test_category.test_entry_child.page_with_error.text",
                """
                        Page with invalid link!  \s
                        [With link](entry://modonomicon:test/test_category/test_entry2@test_anchor)
                         """);

        this.add("modonomicon.test.sections.test_category.test_entry_child.condition.tooltip",
                "This page cannot be unlocked!");

        this.add("modonomicon.test.sections.test_category.multiblock.page0.text",
                """
                        This is a sample multiblock.  \s
                        We have a **second** line too.
                        """);
        this.add("modonomicon.test.sections.test_category.multiblock.page0.multiblock_name", "Sample Multiblock");
    }

    protected void addTranslations() {
        this.addBooks();
        this.addModTranslations();
    }
}
