package com.reliableplugins.packetapi.type.packet.client;

import com.reliableplugins.packetapi.enums.LeftClickType;
import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;
import org.bukkit.block.BlockFace;

public class PacketClientLeftClickBlock extends Packet
{
    private Vector location;
    private BlockFace blockFace;
    private LeftClickType clickType;

    public PacketClientLeftClickBlock(Vector location, BlockFace blockFace, LeftClickType clickType)
    {
        this.location = location;
        this.blockFace = blockFace;
        this.clickType = clickType;
    }

    public LeftClickType getClickType()
    {
        return clickType;
    }

    public BlockFace getBlockFace()
    {
        return blockFace;
    }

    public Vector getLocation()
    {
        return location;
    }
}
