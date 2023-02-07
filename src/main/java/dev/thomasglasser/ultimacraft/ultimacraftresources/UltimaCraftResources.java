package dev.thomasglasser.ultimacraft.ultimacraftresources;

import com.mojang.logging.LogUtils;
import dev.thomasglasser.ultimacraft.ultimacraftresources.core.UltimaCraftResourcesCoreEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(UltimaCraftResources.MOD_ID)
public class UltimaCraftResources {

    public static final String MOD_ID = "ultimacraftresources";
    public static final Logger LOGGER = LogUtils.getLogger();

    public UltimaCraftResources() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(UltimaCraftResourcesCoreEvents::onCommonSetup);
    }

    public static ResourceLocation modLoc(String path)
    {
        return new ResourceLocation(MOD_ID, path);
    }
}
