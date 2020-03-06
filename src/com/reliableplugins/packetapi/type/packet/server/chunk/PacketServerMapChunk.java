package com.reliableplugins.packetapi.type.packet.server.chunk;

import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerMapChunk extends Packet
{
    private int x;
    private int z;

    public PacketServerMapChunk(int x, int z)
    {
        this.x = x;
        this.z = z;
    }

    public int getX()
    {
        return x;
    }

    public int getZ()
    {
        return z;
    }
}
