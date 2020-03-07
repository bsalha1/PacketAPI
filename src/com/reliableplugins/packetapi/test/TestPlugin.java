package com.reliableplugins.packetapi.test;

import com.reliableplugins.packetapi.PacketAPI;
import com.reliableplugins.packetapi.listeners.ListenServerBlockChange;
import com.reliableplugins.packetapi.type.packet.server.PacketServerBlockChange;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class TestPlugin extends JavaPlugin
{
    private PacketAPI api;

    @Override
    public void onEnable()
    {
        api = new PacketAPI(this);
        api.addPacketListener(new ListenServerBlockChange(PacketServerBlockChange.class));
        this.getLogger().log(Level.INFO, "TestPlugin enabled");
    }

    @Override
    public void onDisable()
    {
        api.getPackMan().unloadChannelListener();
        this.getLogger().log(Level.INFO, "TestPlugin disabled");
    }
}
