package com.reliableplugins.packetapi.listeners;

import com.reliableplugins.packetapi.type.packet.server.PacketServerBlockChange;
import org.bukkit.Bukkit;

public class ListenServerBlockChange extends APacketListener
{
    @Override
    public void onPacketServerBlockChange(PacketServerBlockChange packet)
    {
        Bukkit.broadcastMessage("new blockchange");
    }
}
