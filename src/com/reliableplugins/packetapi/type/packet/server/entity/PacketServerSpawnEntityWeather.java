package com.reliableplugins.packetapi.type.packet.server.entity;

import com.reliableplugins.packetapi.type.Vector;

public class PacketServerSpawnEntityWeather extends PacketEntity
{
    private int entityId;
    private Vector<Integer> position;
    private int weatherType;

    public PacketServerSpawnEntityWeather(int entityId, Vector<Integer> position, int weatherType)
    {
        super(entityId);
        this.position = position;
        this.weatherType = weatherType;
    }

    public Vector<Integer> getPosition()
    {
        return position;
    }

    public int getWeatherType()
    {
        return weatherType;
    }
}
