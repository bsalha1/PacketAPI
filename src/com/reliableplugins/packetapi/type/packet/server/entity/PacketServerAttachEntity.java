package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerAttachEntity extends PacketEntity
{
    private int vehicleId;
    private int entityId2;

    public PacketServerAttachEntity(int var1, int entityId1, int entityId2)
    {
        super(entityId1);
        this.vehicleId = var1;
        this.entityId2 = entityId2;
    }

    public int getVehicleId()
    {
        return vehicleId;
    }

    public int getEntityId2()
    {
        return entityId2;
    }
}
