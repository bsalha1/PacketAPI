package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;

public class PacketServerSpawnEntityLiving extends PacketEntity
{
    private int uuid;
    private Vector<Integer> position;
    private Vector<Integer> velocity;
    private byte yaw;
    private byte pitch;
    private byte headPitch;

    public PacketServerSpawnEntityLiving(int entityId, int uuid, Vector<Integer> position, Vector<Integer> velocity, byte yaw, byte pitch, byte headPitch)
    {
        super(entityId);
        this.uuid = uuid;
        this.position = position;
        this.velocity = velocity;
        this.yaw = yaw;
        this.pitch = pitch;
        this.headPitch = headPitch;
    }

    public int getUuid()
    {
        return uuid;
    }

    public Vector<Integer> getPosition()
    {
        return position;
    }

    public Vector<Integer> getVelocity()
    {
        return velocity;
    }

    public byte getYaw()
    {
        return yaw;
    }

    public byte getPitch()
    {
        return pitch;
    }

    public byte getHeadPitch()
    {
        return headPitch;
    }
}
