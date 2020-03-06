package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerEntityLook extends PacketEntity
{
    private byte yaw;
    private byte pitch;
    private boolean onGround;

    public PacketServerEntityLook(int entityId, byte yaw, byte pitch, boolean onGround)
    {
        super(entityId);
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    public float getYaw()
    {
        return (yaw * 360.0F) / 256.0F;
    }

    public float getPitch()
    {
        return (pitch * 360.0F) / 256.0F;
    }

    public boolean isOnGround()
    {
        return onGround;
    }
}
