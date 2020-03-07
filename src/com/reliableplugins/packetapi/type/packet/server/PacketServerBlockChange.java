package com.reliableplugins.packetapi.type.packet.server;

import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;
import org.bukkit.Material;

public class PacketServerBlockChange extends Packet
{
    private Vector<Integer> position;
    private Material material;

    public PacketServerBlockChange(Vector<Integer> position, Material material)
    {
        this.position = position;
        this.material = material;
    }

    public Material getMaterial()
    {
        return material;
    }

    public Vector<Integer> getPosition()
    {
        return position;
    }
}
