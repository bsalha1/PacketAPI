package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerEntityStatus extends PacketEntity
{
    private byte data;

    public PacketServerEntityStatus(int entityId, byte data)
    {
        super(entityId);
        this.data = data;
    }

    public byte getData()
    {
        return data;
    }
}
