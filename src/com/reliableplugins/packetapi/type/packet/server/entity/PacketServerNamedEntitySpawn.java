package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;

public class PacketServerNamedEntitySpawn extends PacketEntity
{
    private Vector<Integer> position;
    private byte yaw, pitch;

    public PacketServerNamedEntitySpawn(int entityId, Vector<Integer> position, byte yaw, byte pitch)
    {
        super(entityId);
        this.position = position;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public byte getYaw()
    {
        return yaw;
    }

    public byte getPitch()
    {
        return pitch;
    }

    public Vector getPosition()
    {
        return position;
    }
}
