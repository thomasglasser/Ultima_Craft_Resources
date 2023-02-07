package dev.thomasglasser.ultimacraft.ultimacraftresources.core;

import dev.thomasglasser.ultimacraft.ultimacraftresources.network.UltimaCraftResourcesMainChannel;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class UltimaCraftResourcesCoreEvents
{
    public static void onCommonSetup(FMLCommonSetupEvent event)
    {
        UltimaCraftResourcesMainChannel.register();
    }
}
