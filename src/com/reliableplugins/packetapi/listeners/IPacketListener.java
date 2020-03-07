package com.reliableplugins.packetapi.listeners;

import com.reliableplugins.packetapi.type.packet.Packet;

public interface IPacketListener<T extends Packet>
{
    void onPacket(T packet);
}
