package dev.thomasglasser.ultimacraft.ultimacraftresources;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(UltimaCraftResources.MOD_ID)
public class UltimaCraftResources {

    public static final String MOD_ID = "ultimacraftresources";
    public static final Logger LOGGER = LogUtils.getLogger();

    public UltimaCraftResources() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
