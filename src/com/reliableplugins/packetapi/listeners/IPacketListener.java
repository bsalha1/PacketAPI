package com.reliableplugins.packetapi.listeners;

import com.reliableplugins.packetapi.type.packet.server.PacketServerBlockChange;
import com.reliableplugins.packetapi.type.packet.server.chunk.PacketServerMapChunk;

public interface IPacketListener
{
    void onPacketServerBlockChange(PacketServerBlockChange packet);

    void onPacketServerMapChunk(PacketServerMapChunk packet);
}
