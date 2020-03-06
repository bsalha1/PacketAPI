package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerEntityHeadRotation extends PacketEntity
{
    private byte yaw;

    public PacketServerEntityHeadRotation(int entityId, byte yaw)
    {
        super(entityId);
        this.yaw = yaw;
    }

    public float getYaw()
    {
        return (yaw * 360.F) / 256.0F;
    }
}
