package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerSpawnEntity extends PacketEntity
{
    private Vector<Integer> position;
    private Vector<Integer> velocity;
    private int pitch;
    private int yaw;
    private int uuid;
    private int objectData;
    public PacketServerSpawnEntity(int entityId, Vector<Integer> r, Vector<Integer> v, int pitch, int yaw, int uuid, int objectData)
    {
        super(entityId);
        this.position = r;
        this.velocity = v;
        this.pitch = pitch;
        this.yaw = yaw;
        this.uuid = uuid;
        this.objectData = objectData;
    }

    public Vector<Integer> getPosition()
    {
        return position;
    }

    public Vector<Integer> getVelocity()
    {
        return velocity;
    }

    public int getPitch()
    {
        return pitch;
    }

    public int getYaw()
    {
        return yaw;
    }

    public int getUuid()
    {
        return uuid;
    }

    public int getObjectData()
    {
        return objectData;
    }
}
