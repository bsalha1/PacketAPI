package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerRelEntityMoveLook extends PacketEntity
{
    private Vector<Byte> dr;
    private byte yaw;
    private byte pitch;
    private boolean onGround;

    public PacketServerRelEntityMoveLook(int entityId, Vector<Byte> dr, byte yaw, byte pitch, boolean onGround)
    {
        super(entityId);
        this.dr = dr;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    public Vector<Byte> getDr()
    {
        return dr;
    }

    public float getYaw()
    {
        return (yaw * 360.0F) / 256.0F;
    }

    public float getPitch()
    {
        return (pitch * 360.0F) / 256.0F;
    }
}
