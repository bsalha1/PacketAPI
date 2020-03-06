package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerEntityTeleport extends PacketEntity
{
    private Vector<Integer> position;
    private byte yaw;
    private byte pitch;
    private boolean onGround;

    public PacketServerEntityTeleport(int entityId, Vector<Integer> position, byte yaw, byte pitch, boolean onGround)
    {
        super(entityId);
        this.position = position;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    public Vector<Integer> getPosition()
    {
        return position;
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
