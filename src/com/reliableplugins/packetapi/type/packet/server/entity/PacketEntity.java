package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.packet.Packet;

public abstract class PacketEntity extends Packet
{
    protected int entityId;

    public PacketEntity(int entityId)
    {
        this.entityId = entityId;
    }

    public int getEntityId()
    {
        return entityId;
    }
}
