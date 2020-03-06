package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.packet.Packet;
import org.bukkit.inventory.ItemStack;

public class PacketServerEntityEquipment extends PacketEntity
{
    private int slot;
    private ItemStack item;

    public PacketServerEntityEquipment(int entityId, int slot, ItemStack item)
    {
        super(entityId);
        this.slot = slot;
        this.item = item;
    }

    public int getSlot()
    {
        return slot;
    }

    public ItemStack getItem()
    {
        return item;
    }
}
