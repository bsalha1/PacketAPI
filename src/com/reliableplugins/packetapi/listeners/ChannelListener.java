package com.reliableplugins.packetapi.listeners;

import com.reliableplugins.packetapi.PacketAPI;
import com.reliableplugins.packetapi.nms.INMSHandler;
import com.reliableplugins.packetapi.type.packet.*;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@ChannelHandler.Sharable
public class ChannelListener extends ChannelDuplexHandler
{
    private PacketAPI api;
    private Set<Packet> packets;
    private Player player;

    public ChannelListener(PacketAPI api, Player player)
    {
        packets = new HashSet<>();
        this.api = api;
        this.player = player;
    }

    // Sent by server to client
    @Override
    public void write(ChannelHandlerContext context, Object packetO, ChannelPromise promise) throws Exception
    {
        INMSHandler nmsHandler = api.getNmsHandler();
        Packet packet = nmsHandler.getPacket(packetO);

        if(packet != null)
        {
//            Bukkit.broadcastMessage(packet.toString());
        }
        for(Packet p : packets)
        {
            if(p.getClass().isInstance(packet))
            {
                Bukkit.broadcastMessage(packet.toString());
                break;
            }
        }

        super.write(context, packetO, promise);
    }

    // Sent by client to server
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object packetO) throws Exception
    {
        INMSHandler nmsHandler = api.getNmsHandler();
        Packet packet = nmsHandler.getPacket(packetO);
        if(packet != null)
        {
            Bukkit.broadcastMessage(packet.toString());
        }
        for(Packet p : packets)
        {
            if(p.getClass().isInstance(packet))
            {
                Bukkit.broadcastMessage(packet.toString());
                break;
            }
        }

        super.channelRead(channelHandlerContext, packetO);
    }

    public Player getPlayer()
    {
        return player;
    }

    public void listenTo(Packet packet)
    {
        packets.add(packet);
    }

    public void unlistenTo(Packet packet)
    {
        packets.remove(packet);
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
