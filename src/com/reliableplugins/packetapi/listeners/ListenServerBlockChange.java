package com.reliableplugins.packetapi.listeners;

import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.server.PacketServerBlockChange;
import org.bukkit.Bukkit;

public class ListenServerBlockChange extends APacketListener<PacketServerBlockChange>
{

    public ListenServerBlockChange(Class<PacketServerBlockChange> packet)
    {
        super(packet);
    }

    @Override
    public void onPacket(PacketServerBlockChange packet)
    {
        Vector<Integer> position = packet.getPosition();
        Bukkit.broadcastMessage("Block change: " + packet.getMaterial().name() + ": " + position.getX() + ", " + position.getY() + ", " + position.getZ());
    }
}
