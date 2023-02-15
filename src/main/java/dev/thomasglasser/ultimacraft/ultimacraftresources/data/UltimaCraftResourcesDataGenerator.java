package dev.thomasglasser.ultimacraft.ultimacraftresources.data;

import dev.thomasglasser.ultimacraft.ultimacraftresources.data.langs.UltimaCraftResourcesEnUsLanguageProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class UltimaCraftResourcesDataGenerator
{
    public static void onGatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();

        if (event.includeClient())
        {
            generator.addProvider(new UltimaCraftResourcesEnUsLanguageProvider(generator));
        }
    }
}
