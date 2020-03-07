package com.reliableplugins.packetapi;

import com.reliableplugins.packetapi.listeners.APacketListener;
import com.reliableplugins.packetapi.listeners.ChannelListener;
import com.reliableplugins.packetapi.listeners.IPacketListener;
import com.reliableplugins.packetapi.nms.INMSHandler;
import com.reliableplugins.packetapi.nms.NMSManager;
import com.reliableplugins.packetapi.utils.PacketManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PacketAPI
{
    private NMSManager nmsManager;
    private INMSHandler nmsHandler;
    private JavaPlugin plugin;
    private PacketManager packMan;
    private Map<Player, ChannelListener> players;
    private Set<APacketListener> listeners;

    public PacketAPI(JavaPlugin plugin)
    {
        listeners = new HashSet<>();
        players = new HashMap<>();
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

    public void setChannelListener(Player player, ChannelListener listener)
    {
        players.put(player, listener);
    }

    public ChannelListener getChannelListener(Player player)
    {
        return players.get(player);
    }

    public void unregisterPlayer(Player player)
    {
        players.remove(player);
    }

    public void addPacketListener(APacketListener listener)
    {
        listeners.add(listener);
        for(ChannelListener cListener : players.values())
        {
            cListener.addListener(listener);
        }
    }

    public Set<APacketListener> getListeners()
    {
        return listeners;
    }
}
