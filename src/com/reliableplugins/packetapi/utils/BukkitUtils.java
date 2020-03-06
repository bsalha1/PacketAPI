package com.reliableplugins.packetapi.utils;

import org.bukkit.ChatColor;

public class BukkitUtils
{
    public static String color(String text)
    {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
