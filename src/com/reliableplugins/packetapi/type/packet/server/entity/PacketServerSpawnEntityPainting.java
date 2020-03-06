package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;
import org.bukkit.block.BlockFace;

public class PacketServerSpawnEntityPainting extends PacketEntity
{
    private Vector<Integer> position;
    private BlockFace blockFace;
    private String painting;

    public PacketServerSpawnEntityPainting(int entityId, Vector<Integer> position, BlockFace blockFace, String painting)
    {
        super(entityId);
        this.position = position;
        this.blockFace = blockFace;
        this.painting = painting;
    }

    public Vector<Integer> getPosition()
    {
        return position;
    }

    public BlockFace getBlockFace()
    {
        return blockFace;
    }

    public String getPainting()
    {
        return painting;
    }
}
