package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;

public class PacketServerEntityVelocity extends PacketEntity
{
    private Vector<Double> velocity;

    public PacketServerEntityVelocity(int entityId, Vector<Integer> velocity)
    {
        super(entityId);
        this.velocity = new Vector<>(velocity.getX() / 8000.0D, velocity.getY() / 8000.0D, velocity.getZ() / 8000.0D);
    }

    public Vector<Double> getVelocity()
    {
        return velocity;
    }
}
