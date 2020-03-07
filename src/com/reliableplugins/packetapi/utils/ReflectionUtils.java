package com.reliableplugins.packetapi.utils;

import java.lang.reflect.Field;

public class ReflectionUtils
{
    @SuppressWarnings("unchecked")
    public static <T> T getPrivateField(String fieldName, Object instance) throws NoSuchFieldException, IllegalAccessException
    {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) getPrivateField(fieldName, instance.getClass(), instance);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getPrivateField(String fieldName, Class clazz, Object instance) throws NoSuchFieldException, IllegalAccessException
    {
        try
        {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(instance);
        }
        catch(NoSuchFieldException e)
        {
            Class superClass = clazz.getSuperclass();
            if (superClass == null)
            {
                throw e;
            }
            else
            {
                return getPrivateField(fieldName, superClass, instance);
            }
        }
    }
}
