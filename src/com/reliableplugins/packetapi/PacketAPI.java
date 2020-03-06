package com.reliableplugins.packetapi;

import com.reliableplugins.packetapi.listeners.ChannelListener;
import com.reliableplugins.packetapi.nms.INMSHandler;
import com.reliableplugins.packetapi.nms.NMSManager;
import com.reliableplugins.packetapi.utils.PacketManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PacketAPI
{
    private NMSManager nmsManager;
    private INMSHandler nmsHandler;
    private JavaPlugin plugin;
    private PacketManager packMan;

    public PacketAPI(JavaPlugin plugin)
    {
        this.plugin = plugin;
        this.nmsManager = new NMSManager(this);
        this.packMan = new PacketManager(this);
    }

    public JavaPlugin getPlugin()
    {
        return plugin;
    }

    public PacketManager getPackMan()
    {
        return packMan;
    }

    public void setNmsHandler(INMSHandler nmsHandler)
    {
        this.nmsHandler = nmsHandler;
    }

    public INMSHandler getNmsHandler()
    {
        return nmsHandler;
    }
}
