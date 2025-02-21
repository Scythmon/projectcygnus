package net.scythmon.cygnus.datagen;

import com.klikli_dev.modonomicon.api.datagen.LanguageProviderCache;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.datagen.book.DemoBookProvider;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ProjectCygnus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var enUsCache = new LanguageProviderCache("en_us");
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), new ModRecipieProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new DemoBookProvider(generator.getPackOutput(), ProjectCygnus.MOD_ID, enUsCache));
        generator.addProvider(event.includeServer(), new DemoMultiblockProvider(generator.getPackOutput(), ProjectCygnus.MOD_ID));
        //Important: lang provider needs to be added after the book provider, so it can read the texts added by the book provider out of the cache
        generator.addProvider(event.includeClient(), new EnUsProvider(generator.getPackOutput(), enUsCache));


        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));


        ModblockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModblockTagGenerator(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new ModRegistrySetProvider(packOutput, lookupProvider));
    }
}
