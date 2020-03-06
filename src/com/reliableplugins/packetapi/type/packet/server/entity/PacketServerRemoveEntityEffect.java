package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.packet.Packet;
import org.bukkit.potion.PotionEffectType;

public class PacketServerRemoveEntityEffect extends PacketEntity
{
    private int potionEffectId;
    private PotionEffectType potionEffectType;

    public PacketServerRemoveEntityEffect(int entityId, int potionEffectId)
    {
        super(entityId);
        this.potionEffectId = potionEffectId;
        potionEffectType = PotionEffectType.getById(potionEffectId);
    }

    public int getPotionEffectId()
    {
        return potionEffectId;
    }

    public PotionEffectType getPotionEffectType()
    {
        return potionEffectType;
    }
}
