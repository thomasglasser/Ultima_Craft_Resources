package dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.storage;

import dev._100media.capabilitysyncer.core.PlayerCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import dev.thomasglasser.ultimacraft.ultimacraftresources.network.UltimaCraftResourcesMainChannel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.simple.SimpleChannel;

public class SkillsCapability extends PlayerCapability
{
    private byte alchemyLevel;

    public SkillsCapability(Player player) {
        super(player);
        alchemyLevel = 0;
    }

    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(this.player.getId(), SkillsCapabilityAttacher.SKILLS_CAPABILITY_RL, this);
    }

    @Override
    public SimpleChannel getNetworkChannel() {
        return UltimaCraftResourcesMainChannel.getChannel();
    }

    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();

        tag.putByte("alchemyLevel", alchemyLevel);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        if (nbt.contains("alchemyLevel"))
            alchemyLevel = nbt.getByte("alchemyLevel");
    }

    public byte getAlchemyLevel() {
        return alchemyLevel;
    }

    public void setAlchemyLevel(byte alchemyLevel) {
        this.alchemyLevel = (byte) Math.min(alchemyLevel, 100);
    }
}
