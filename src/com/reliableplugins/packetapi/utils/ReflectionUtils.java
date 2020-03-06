package com.reliableplugins.packetapi.utils;

import java.lang.reflect.Field;

public class ReflectionUtils
{
    public static <T> T getPrivateField(String fieldName, Object instance) throws NoSuchFieldException, IllegalAccessException
    {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) field.get(instance);
    }
}
