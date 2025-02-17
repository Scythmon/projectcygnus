/*
 * SPDX-FileCopyrightText: 2022 klikli-dev
 *
 * SPDX-License-Identifier: MIT
 */

package net.scythmon.cygnus.datagen.book;

import com.klikli_dev.modonomicon.api.datagen.*;
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookCommandModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookEntryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookModel;
import com.klikli_dev.modonomicon.api.datagen.book.condition.BookEntryReadConditionModel;
import com.klikli_dev.modonomicon.api.datagen.book.condition.BookFalseConditionModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class DemoBookProvider extends BookProvider {

    public DemoBookProvider(PackOutput packOutput, String modid, ModonomiconLanguageProvider lang, ModonomiconLanguageProvider... translations) {
        super("demo", packOutput, modid, lang, translations);
    }

    @Override
    protected BookModel generateBook() {
        this.lang().add(this.context().bookName(), "Book of Enoch");
        this.lang().add(this.context().bookTooltip(), "Inside contains knowledge of all good and evil.");

        //if we want to handle a second language in here we can access it like this:
        //this.lang("ru_ru").add(this.context().bookName(), "Демонстрационная книга");
        //this.lang("ru_ru").add(this.context().bookTooltip(), "Книга для демонстрации и тестирования функций \"Модономикона\".");

        //for the two big categories we use the category provider
        var featuresCategory = new FeaturesCategoryProvider(this).generate();
        var formattingCategory = new FormattingCategoryProvider(this).generate();

        var hiddenCategory = this.makeHiddenCategory(this.context());
        var conditionalCategory = this.makeConditionalCategory(this.context());
        conditionalCategory.withCondition(BookEntryReadConditionModel.builder().withEntry(this.modLoc("features/condition_root")).build());

        var otherCategory = new OtherCategoryProvider(this).generate();


        var commandEntryCommand = BookCommandModel.create(this.modLoc("test_command"), "/give @s minecraft:apple 1")
                .withPermissionLevel(2)
                .withSuccessMessage("modonomicon.command.test_command.success");
        this.lang.add(commandEntryCommand.getSuccessMessage(), "You got an apple, because reading is cool!");
        var commandEntryLinkCommand = BookCommandModel.create(this.modLoc("test_command2"), "/give @s minecraft:wheat 1")
                .withPermissionLevel(2)
                .withSuccessMessage("modonomicon.command.test_command2.success");
        this.lang.add(commandEntryLinkCommand.getSuccessMessage(), "You got wheat, because clicking is cool!");

        var demoBook = BookModel.create(this.modLoc("demo"), this.context().bookName())
                .withTooltip(this.context().bookTooltip())
                .withModel(new ResourceLocation("projectcygnus:book_of_enoch"))
                .withBookTextOffsetX(5)
                .withBookTextOffsetY(0) //no top offset
                .withBookTextOffsetWidth(-5)
                .withCategory(featuresCategory)
                .withCategory(formattingCategory)
                .withCategory(hiddenCategory)
                .withCategory(conditionalCategory)
                .withCategory(otherCategory)
                .withCommand(commandEntryCommand)
                .withCommand(commandEntryLinkCommand)
                .withAllowOpenBooksWithInvalidLinks(true)
                ;
        return demoBook;
    }

    @Override
    protected void registerDefaultMacros() {
        //none currently
    }

    private BookCategoryModel makeHiddenCategory(BookContextHelper helper) {
        this.context().category("hidden");

        var entryHelper = new CategoryEntryMap();
        entryHelper.setMap(
                "_____________________",
                "_____________________",
                "__________l__________",
                "_____________________",
                "_____________________"
        );

        this.context().entry("always_locked");

        var entry = BookEntryModel.create(this.modLoc(this.context().categoryId() + "/" + this.context().entryId()), this.context().entryName())
                .withDescription(this.context().entryDescription())
                .withIcon(Items.NETHER_STAR)
                .withLocation(entryHelper.get('l'))
                .withEntryBackground(0, 1)
                .withCondition(BookFalseConditionModel.builder().build());

        return BookCategoryModel.create(this.modLoc(this.context().categoryId()), this.context().categoryName())
                .withIcon(Items.BOOK)
                .withShowCategoryButton(false)
                .withEntry(entry);
    }

    private BookCategoryModel makeConditionalCategory(BookContextHelper helper) {
        this.context().category("conditional");

        var entryHelper = new CategoryEntryMap();
        entryHelper.setMap(
                "_____________________",
                "_____________________",
                "__________l__________",
                "_____________________",
                "_____________________"
        );

        this.context().entry("always_locked");

        var entry = BookEntryModel.create(this.modLoc(this.context().categoryId() + "/" + this.context().entryId()), this.context().entryName())
                .withDescription(this.context().entryDescription())
                .withIcon(Items.NETHER_STAR)
                .withLocation(entryHelper.get('l'))
                .withEntryBackground(0, 1)
                .withCondition(BookFalseConditionModel.builder().build());

        return BookCategoryModel.create(this.modLoc(this.context().categoryId()), this.context().categoryName())
                .withIcon(Blocks.CHEST)
                .withEntry(entry);
    }
}
