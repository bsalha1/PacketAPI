package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerSpawnEntityExperienceOrb extends PacketEntity
{
    private Vector<Integer> position;
    int count;

    public PacketServerSpawnEntityExperienceOrb(int entityId, Vector<Integer> position, int count)
    {
        super(entityId);
        this.position = position;
        this.count = count;
    }

    public Vector<Integer> getPosition()
    {
        return position;
    }

    public int getCount()
    {
        return count;
    }
}
