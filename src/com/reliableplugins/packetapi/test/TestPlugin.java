package com.reliableplugins.packetapi.test;

import com.reliableplugins.packetapi.PacketAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class TestPlugin extends JavaPlugin
{
    private PacketAPI api;

    @Override
    public void onEnable()
    {
        api = new PacketAPI(this);
        this.getLogger().log(Level.INFO, "TestPlugin enabled");
    }

    @Override
    public void onDisable()
    {
        api.getPackMan().unloadChannelListener();
        this.getLogger().log(Level.INFO, "TestPlugin disabled");
    }
}
