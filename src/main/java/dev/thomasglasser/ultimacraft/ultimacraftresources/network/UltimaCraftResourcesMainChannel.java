package dev.thomasglasser.ultimacraft.ultimacraftresources.network;

import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import dev.thomasglasser.ultimacraft.ultimacraftresources.UltimaCraftResources;
import dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.storage.SkillsCapabilityAttacher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class UltimaCraftResourcesMainChannel
{

    private static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(UltimaCraftResources.MOD_ID, "main_channel"))
            .networkProtocolVersion(() -> "1.0")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();
    private static int packetID = 0;

    private static int id() { return packetID++;}

    public static void register()
    {
        SimpleEntityCapabilityStatusPacket.register(SkillsCapabilityAttacher.SKILLS_CAPABILITY_RL, SkillsCapabilityAttacher::getSkillsCapabilityUnwrap, INSTANCE, id());
    }

    public static <MSG> void sendToServer(MSG msg)
    {
        INSTANCE.sendToServer(msg);
    }

    public static <MSG> void sendToClient(MSG msg, ServerPlayer player)
    {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }

    public static <MSG> void sendToAllClients(MSG msg, ServerPlayer player)
    {
        INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
    }

    public static SimpleChannel getChannel() {
        return INSTANCE;
    }
}
