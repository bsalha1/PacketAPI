package com.reliableplugins.packetapi.nms;

import com.reliableplugins.packetapi.enums.LeftClickType;
import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;
import com.reliableplugins.packetapi.type.packet.client.PacketClientLeftClickBlock;
import com.reliableplugins.packetapi.type.packet.server.PacketServerBlockChange;
import com.reliableplugins.packetapi.type.packet.server.chunk.PacketServerMapChunk;
import com.reliableplugins.packetapi.utils.ReflectionUtils;
import io.netty.channel.Channel;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_15_R1.util.CraftMagicNumbers;
import org.bukkit.entity.Player;

public class Version_1_15_R1 implements INMSHandler
{
    @Override
    public String getVersion()
    {
        return "v1_15_R1";
    }

    @Override
    public Channel getSocketChannel(Player player)
    {
        return ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel;
    }

    @Override
    public Packet getPacket(Object packet)
    {
        if(packet instanceof PacketPlayOutBlockChange)
        {
            PacketPlayOutBlockChange blockChange = (PacketPlayOutBlockChange) packet;
            BlockPosition bpos;
            try
            {
                bpos = ReflectionUtils.getPrivateField("a", blockChange);
            }
            catch(Exception e)
            {
                return null;
            }

            return new PacketServerBlockChange(new Vector(bpos.getX(), bpos.getY(), bpos.getZ()), CraftMagicNumbers.getMaterial(blockChange.block.getBlock()));
        }
        else if(packet instanceof PacketPlayOutMapChunk)
        {
            PacketPlayOutMapChunk mapChunk = (PacketPlayOutMapChunk) packet;
            try
            {
                int x = ReflectionUtils.getPrivateField("a", mapChunk);
                int z = ReflectionUtils.getPrivateField("b", mapChunk);
                return new PacketServerMapChunk(x, z);
            }
            catch(Exception e)
            {
                return null;
            }
        }
        else if(packet instanceof PacketPlayInBlockDig)
            {
                PacketPlayInBlockDig pack = (PacketPlayInBlockDig) packet;
                BlockPosition bpos = pack.b();
                return new PacketClientLeftClickBlock(new Vector(bpos.getX(), bpos.getY(), bpos.getZ()),
                        directionToBlockFace(pack.c()),
                        digTypeToLeftClickType(pack.c()));
            }

        return null;
    }

    @Override
    public LeftClickType digTypeToLeftClickType(Object digType)
    {
        PacketPlayInBlockDig.EnumPlayerDigType digType1 = (PacketPlayInBlockDig.EnumPlayerDigType) digType;
        switch(digType1)
        {
            case ABORT_DESTROY_BLOCK:
                return LeftClickType.ABORT_DESTROY_BLOCK;
            case DROP_ITEM:
                return LeftClickType.DROP_ITEM;
            case DROP_ALL_ITEMS:
                return LeftClickType.DROP_ALL_ITEMS;
            case RELEASE_USE_ITEM:
                return LeftClickType.RELEASE_USE_ITEM;
            case STOP_DESTROY_BLOCK:
                return LeftClickType.STOP_DESTROY_BLOCK;
            case START_DESTROY_BLOCK:
                return LeftClickType.START_DESTROY_BLOCK;
            case SWAP_HELD_ITEMS:
                return LeftClickType.SWAP_HELD_ITEMS;
            default:
                return LeftClickType.UNKNOWN;
        }
    }

    @Override
    public BlockFace directionToBlockFace(Object direction)
    {
        EnumDirection direction1 = (EnumDirection) direction;
        switch(direction1)
        {
            case UP:
                return BlockFace.UP;
            case DOWN:
                return BlockFace.DOWN;
            case NORTH:
                return BlockFace.NORTH;
            case WEST:
                return BlockFace.WEST;
            case SOUTH:
                return BlockFace.SOUTH;
            case EAST:
                return BlockFace.EAST;
            default:
                return null;
        }
    }
}
