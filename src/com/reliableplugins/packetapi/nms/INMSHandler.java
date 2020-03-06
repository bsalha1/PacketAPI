package com.reliableplugins.packetapi.nms;

import com.reliableplugins.packetapi.enums.LeftClickType;
import com.reliableplugins.packetapi.type.packet.Packet;
import io.netty.channel.Channel;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public interface INMSHandler
{
    String getVersion();

    Channel getSocketChannel(Player player);

    Packet getPacket(Object packet);

    LeftClickType digTypeToLeftClickType(Object digType);

    BlockFace directionToBlockFace(Object direction);
}