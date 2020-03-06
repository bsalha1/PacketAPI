package com.reliableplugins.packetapi.nms;

import com.reliableplugins.packetapi.PacketAPI;
import org.bukkit.Bukkit;

public class NMSManager
{
    public NMSManager(PacketAPI api)
    {
        String version = api.getPlugin().getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        switch (version)
        {
            case "v1_8_R1":
                api.setNmsHandler(new Version_1_8_R1());
                break;
            case "v1_8_R2":
                api.setNmsHandler(new Version_1_8_R2());
                break;
            case "v1_8_R3":
                Bukkit.broadcastMessage("added 1.8");
                api.setNmsHandler(new Version_1_8_R3());
                break;
            case "v1_10_R1":
                api.setNmsHandler(new Version_1_10_R1());
                break;
            case "v1_11_R1":
                api.setNmsHandler(new Version_1_11_R1());
                break;
            case "v1_12_R1":
                api.setNmsHandler(new Version_1_12_R1());
                break;
            case "v1_13_R1":
                api.setNmsHandler(new Version_1_13_R1());
                break;
            case "v1_13_R2":
                api.setNmsHandler(new Version_1_13_R2());
                break;
            case "v1_14_R1":
                api.setNmsHandler(new Version_1_14_R1());
                break;
            case "v1_15_R1":
                api.setNmsHandler(new Version_1_15_R1());
                break;
            default:
                api.setNmsHandler(new Version_1_8_R3());
        }
    }
}