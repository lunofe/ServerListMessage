package org.chimute.serverlistmessage;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class ServerListMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        ProtocolLibrary.getProtocolManager().addPacketListener(
                new PacketAdapter(this, PacketType.Status.Server.OUT_SERVER_INFO) {
                    @Override
                    public void onPacketSending(PacketEvent event) {
                        WrappedGameProfile profile1 = new WrappedGameProfile(UUID.randomUUID(), "Vampirism.co");
                        List<WrappedGameProfile> profiles = Arrays.asList(profile1);
                        event.getPacket().getServerPings().read(0).setPlayers(profiles);
                    }
                }
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
