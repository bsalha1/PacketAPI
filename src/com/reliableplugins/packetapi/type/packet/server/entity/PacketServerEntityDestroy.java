package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerEntityDestroy extends Packet
{
    private int[] entityIds;

    public PacketServerEntityDestroy(int[] entityIds)
    {
        this.entityIds = entityIds;
    }

    public int[] getEntityIds()
    {
        return entityIds;
    }
}
