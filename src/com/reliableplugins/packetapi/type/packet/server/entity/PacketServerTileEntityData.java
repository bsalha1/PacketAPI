package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;

public class PacketServerTileEntityData extends Packet
{
    private Vector<Integer> position;
    private int action;

    public PacketServerTileEntityData(Vector<Integer> position, int action)
    {
        this.position = position;
        this.action = action;
    }

    public Vector<Integer> getPosition()
    {
        return position;
    }

    public int getAction()
    {
        return action;
    }
}
