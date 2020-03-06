package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerRelEntityMove extends PacketEntity
{
    private Vector<Byte> dr;
    private boolean onGround;

    public PacketServerRelEntityMove(int entityId, Vector<Byte> dr, boolean onGround)
    {
        super(entityId);
        this.dr = dr;
        this.onGround = onGround;
    }

    public Vector<Byte> getDr()
    {
        return dr;
    }

    public boolean isOnGround()
    {
        return onGround;
    }
}
