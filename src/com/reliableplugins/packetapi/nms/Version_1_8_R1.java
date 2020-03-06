package com.reliableplugins.packetapi.nms;

import com.reliableplugins.packetapi.enums.LeftClickType;
import com.reliableplugins.packetapi.type.packet.Packet;
import io.netty.channel.Channel;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class Version_1_8_R1 implements INMSHandler
{
    @Override
    public String getVersion()
    {
        return "v1_8_R1";
    }

    @Override
    public Channel getSocketChannel(Player player)
    {
        return null;
    }

    @Override
    public Packet getPacket(Object packet)
    {
        return null;
    }

    @Override
    public LeftClickType digTypeToLeftClickType(Object digType)
    {
        return null;
    }

    @Override
    public BlockFace directionToBlockFace(Object direction)
    {
        return null;
    }
}
