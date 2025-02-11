// SPDX-FileCopyrightText: 2023 klikli-dev
//
// SPDX-License-Identifier: MIT

package net.scythmon.cygnus.datagen;

import com.klikli_dev.modonomicon.Modonomicon;
import com.klikli_dev.modonomicon.api.datagen.MultiblockProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

public class DemoMultiblockProvider extends MultiblockProvider {
    public DemoMultiblockProvider(PackOutput packOutput, String modid) {
        super(packOutput, modid);
    }

    @Override
    public void buildMultiblocks() {
        this.add(this.modLoc("demo_dense"), new DenseMultiblockBuilder()
                .layer(" WWW ",
                        "N   S",
                        "N 0 S",
                        "N   S",
                        " EEE "
                )
                .blockstate('N', () -> Blocks.OAK_STAIRS, "[facing=north]")
                .blockstate('S', () -> Blocks.OAK_STAIRS, "[facing=south]")
                .blockstate('W', () -> Blocks.OAK_STAIRS, "[facing=west]")
                .blockstate('E', () -> Blocks.OAK_STAIRS, "[facing=east]")
        );

        //test counts towards total blocks
        //Note that "t" and "s" will not render as red concrete / "remove block" blocks because they are not set to display air
        //  "a", however, will render the red concrete and show "remove block".
        this.add(this.modLoc("demo_predicate"), new DenseMultiblockBuilder()
                .layer(
                        " ttt ",
                        "t a t",
                        "ta0as",
                        "s a s",
                        " sss "
                )
                .block('0', () -> Blocks.DIRT)
                .predicate('t', Modonomicon.loc("non_solid"), false, () -> Blocks.TORCH)
                .predicate('s', Modonomicon.loc("non_solid"), true, () -> Blocks.GRASS)
                .predicate('a', Modonomicon.loc("non_solid"), true, () -> Blocks.AIR)
        );

        //purpose of this is to test the ground layer padding generation on non-square blocks
        this.add(this.modLoc("test_non_square"),
                new DenseMultiblockBuilder()
                        .layer(
                                "       s   ",
                                "           ",
                                "ce  0     r",
                                "           ",
                                "       s   "
                        )
                        .block('c', () -> Blocks.BAMBOO)
                        .block('e', () ->  Blocks.GRANITE)
                        .block('s', () -> Blocks.SAND)
                        .block('r', () -> Blocks.ACACIA_WOOD)
                        .block('0', () -> Blocks.BELL)
                        .build()
        );

        this.add(this.modLoc("demo_fluid"), new DenseMultiblockBuilder()
                .layer(
                        " LLL ",
                        "W   W",
                        "W 0 W",
                        "W   W",
                        " LLL "
                )
                .block('L', () -> Blocks.LAVA)
                .block('W', () -> Blocks.WATER)
        );
    }
}
