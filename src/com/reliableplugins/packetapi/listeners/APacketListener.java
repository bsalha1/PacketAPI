package com.reliableplugins.packetapi.listeners;

import com.reliableplugins.packetapi.type.packet.Packet;

public abstract class APacketListener<T extends Packet> implements IPacketListener<T>
{
    protected Class<T> packet;

    public APacketListener(Class<T> packet)
    {
        this.packet = packet;
    }

    public Class<T> getPacketClass()
    {
        return packet;
    }
}
