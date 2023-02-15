package dev.thomasglasser.ultimacraft.ultimacraftresources.data.langs;

import dev.thomasglasser.ultimacraft.ultimacraftresources.UltimaCraftResources;
import dev.thomasglasser.ultimacraft.ultimacraftresources.world.entity.player.UltimaCraftResourcesPlayerEvents;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class UltimaCraftResourcesEnUsLanguageProvider extends LanguageProvider {
    public UltimaCraftResourcesEnUsLanguageProvider(DataGenerator gen) {
        super(gen, UltimaCraftResources.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(UltimaCraftResourcesPlayerEvents.GRAND_MASTER_KEY, "Grand Master");
        add(UltimaCraftResourcesPlayerEvents.ALCHEMY_KEY, "Alchemy");
    }
}
