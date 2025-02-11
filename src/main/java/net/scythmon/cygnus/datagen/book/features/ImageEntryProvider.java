// SPDX-FileCopyrightText: 2024 klikli-dev
//
// SPDX-License-Identifier: MIT

package net.scythmon.cygnus.datagen.book.features;

import com.klikli_dev.modonomicon.api.datagen.CategoryProvider;
import com.klikli_dev.modonomicon.api.datagen.EntryBackground;
import com.klikli_dev.modonomicon.api.datagen.EntryProvider;
import com.klikli_dev.modonomicon.api.datagen.book.BookIconModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookImagePageModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookSpotlightPageModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

public class ImageEntryProvider extends EntryProvider {
    public ImageEntryProvider(CategoryProvider parent) {
        super(parent);
    }

    @Override
    protected void generatePages() {
        this.page("intro", () ->
                BookTextPageModel.builder()
                        .withText(this.context().pageText())
                        .withTitle(this.context().pageTitle())
                        .build()
        );
        this.pageTitle("Image Page Entry");
        this.pageText("Image pages allow to show images.");

        this.page("image", () ->
                BookImagePageModel.builder()
                        .withText(this.context().pageText())
                        .withTitle(this.context().pageTitle())
                        .withImages(
                                new ResourceLocation("modonomicon:textures/gui/default_background.png"),
                                new ResourceLocation("modonomicon:textures/gui/dark_slate_seamless.png")
                        )
                        .build()
        );
        this.pageTitle("Sample image!");
        this.pageText("A  sample text for the sample image.");


        this.page("test_spotlight", () ->
                BookSpotlightPageModel.builder()
                        .withText(this.context().pageText())
                        .withItem(Ingredient.of(Blocks.SPAWNER))
                        .build()
        );

        this.page("test_image", () ->
                BookImagePageModel.builder()
                        .withText(this.context().pageText())
                        .withTitle(this.context().pageTitle())
                        .withImages(
                                new ResourceLocation("modonomicon:textures/gui/default_background.png"),
                                new ResourceLocation("modonomicon:textures/gui/dark_slate_seamless.png")
                        )
                        .build()
        );
    }

    @Override
    protected String entryName() {
        return "Image Page Entry";
    }

    @Override
    protected String entryDescription() {
        return "An entry showcasing image pages.";
    }

    @Override
    protected Pair<Integer, Integer> entryBackground() {
        return EntryBackground.DEFAULT;
    }

    @Override
    protected BookIconModel entryIcon() {
        return BookIconModel.create(Items.ITEM_FRAME);
    }

    @Override
    protected String entryId() {
        return "image";
    }
}
