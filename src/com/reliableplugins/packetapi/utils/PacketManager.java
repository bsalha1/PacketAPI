package com.reliableplugins.packetapi.utils;

import com.reliableplugins.packetapi.PacketAPI;
import com.reliableplugins.packetapi.listeners.APacketListener;
import com.reliableplugins.packetapi.listeners.ChannelListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PacketManager implements Listener
{
    private PacketAPI api;
    private Map<Player, Set<String>> handlers = new LinkedHashMap<>();

    public PacketManager(PacketAPI api)
    {
        this.api = api;
        loadChannelListener();
        Bukkit.getPluginManager().registerEvents(this, api.getPlugin());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        loadChannelListener(event.getPlayer());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event)
    {
        unloadChannelListener(event.getPlayer());
    }

    public void unloadChannelListener(Player player)
    {
        if(api.getNmsHandler().getSocketChannel(player).pipeline().toMap().containsKey(ChannelListener.class.getName()))
        {

            api.getNmsHandler()
                    .getSocketChannel(player)
                    .pipeline()
                    .remove(ChannelListener.class.getName());
        }
    }

    public void unloadChannelListener()
    {
        Collection<? extends Player> onlinePlayers = api.getPlugin().getServer().getOnlinePlayers();
        for(Player player : onlinePlayers)
        {
            unloadChannelListener(player);
        }
    }

    public void loadChannelListener(Player player)
    {
        ChannelListener channelListener = new ChannelListener(api, player);
        api.getNmsHandler()
                .getSocketChannel(player)
                .pipeline()
                .addBefore("packet_handler", channelListener.getClass().getName(), channelListener);
    }

    public void loadChannelListener()
    {
        Collection<? extends Player> onlinePlayers = api.getPlugin().getServer().getOnlinePlayers();
        for(Player player : onlinePlayers)
        {
            loadChannelListener(player);
        }
    }

    public void addPacketListener(APacketListener listener)
    {

    }
}