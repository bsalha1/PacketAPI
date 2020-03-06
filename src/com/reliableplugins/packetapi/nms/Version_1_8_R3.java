package com.reliableplugins.packetapi.nms;

import com.google.common.reflect.Reflection;
import com.reliableplugins.packetapi.enums.LeftClickType;
import com.reliableplugins.packetapi.type.Vector;
import com.reliableplugins.packetapi.type.packet.Packet;
import com.reliableplugins.packetapi.type.packet.client.PacketClientLeftClickBlock;
import com.reliableplugins.packetapi.type.packet.server.PacketServerBlockChange;
import com.reliableplugins.packetapi.type.packet.server.chunk.PacketServerMapChunkBulk;
import com.reliableplugins.packetapi.type.packet.server.entity.*;
import com.reliableplugins.packetapi.utils.ReflectionUtils;
import io.netty.channel.Channel;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftMagicNumbers;
import org.bukkit.entity.Player;

public class Version_1_8_R3 implements INMSHandler
{
    @Override
    public String getVersion()
    {
        return "v1_8_R3";
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
            try
            {
                BlockPosition bpos = ReflectionUtils.getPrivateField("a", blockChange);
                return new PacketServerBlockChange(new Vector<>(bpos.getX(), bpos.getY(), bpos.getZ()),
                        CraftMagicNumbers.getMaterial(blockChange.block.getBlock()));
            }
            catch(Exception e)
            {
                return null;
            }
        }
        else if(packet instanceof PacketPlayOutMapChunkBulk)
        {
            PacketPlayOutMapChunkBulk mapChunkBulk = (PacketPlayOutMapChunkBulk) packet;
            try
            {
                int[] x = ReflectionUtils.getPrivateField("a", mapChunkBulk);
                int[] z = ReflectionUtils.getPrivateField("b", mapChunkBulk);
                World world = ReflectionUtils.getPrivateField("world", mapChunkBulk);
                return new PacketServerMapChunkBulk(x, z, world.getWorld());
            }
            catch(Exception e)
            {
                return null;
            }
        }
        else if(packet instanceof PacketPlayInBlockDig)
        {
            PacketPlayInBlockDig pack = (PacketPlayInBlockDig) packet;
            BlockPosition bpos = pack.a();
            return new PacketClientLeftClickBlock(
                    new Vector<>(bpos.getX(), bpos.getY(), bpos.getZ()),
                    directionToBlockFace(pack.b()),
                    digTypeToLeftClickType(pack.c()));
        }
        else if(packet instanceof PacketPlayOutEntity)
        {
            if(packet instanceof PacketPlayOutEntity.PacketPlayOutEntityLook)
            {
                try
                {
                    PacketPlayOutEntity.PacketPlayOutEntityLook pack = (PacketPlayOutEntity.PacketPlayOutEntityLook) packet;
                    int entityId = ReflectionUtils.getPrivateField("a", pack);
                    byte yaw = ReflectionUtils.getPrivateField("e", pack);
                    byte pitch = ReflectionUtils.getPrivateField("f", pack);
                    boolean onGround = ReflectionUtils.getPrivateField("g", pack);
                    return new PacketServerEntityLook(entityId, yaw, pitch, onGround);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if(packet instanceof PacketPlayOutEntity.PacketPlayOutRelEntityMove)
            {
                try
                {
                    PacketPlayOutEntity.PacketPlayOutRelEntityMove pack = (PacketPlayOutEntity.PacketPlayOutRelEntityMove) packet;
                    int entityId = ReflectionUtils.getPrivateField("a", pack);
                    byte dx = ReflectionUtils.getPrivateField("b", pack);
                    byte dy = ReflectionUtils.getPrivateField("c", pack);
                    byte dz = ReflectionUtils.getPrivateField("d", pack);
                    Vector<Byte> dr = new Vector<>(dx, dy, dz);
                    boolean onGround = ReflectionUtils.getPrivateField("g", pack);

                    return new PacketServerRelEntityMove(entityId, dr, onGround);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if(packet instanceof PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook)
            {
                try
                {
                    PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook pack = (PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook) packet;
                    int entityId = ReflectionUtils.getPrivateField("a", pack);
                    byte dx = ReflectionUtils.getPrivateField("b", pack);
                    byte dy = ReflectionUtils.getPrivateField("c", pack);
                    byte dz = ReflectionUtils.getPrivateField("d", pack);
                    Vector<Byte> dr = new Vector<>(dx, dy, dz);
                    byte yaw = ReflectionUtils.getPrivateField("e", pack);
                    byte pitch = ReflectionUtils.getPrivateField("f", pack);
                    boolean onGround = ReflectionUtils.getPrivateField("g", pack);
                    return new PacketServerRelEntityMoveLook(entityId, dr, yaw, pitch, onGround);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        else if(packet instanceof PacketPlayOutEntityDestroy)
        {
            try
            {
                PacketPlayOutEntityDestroy pack = (PacketPlayOutEntityDestroy) packet;
                int[] entityIds = ReflectionUtils.getPrivateField("a", pack);
                return new PacketServerEntityDestroy(entityIds);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutEntityEquipment)
        {
            try
            {
                PacketPlayOutEntityEquipment pack = (PacketPlayOutEntityEquipment) packet;
                int var1 = ReflectionUtils.getPrivateField("a", pack);
                int var2 = ReflectionUtils.getPrivateField("b", pack);
                ItemStack item = ReflectionUtils.getPrivateField("c", pack);
                org.bukkit.inventory.ItemStack stack = new org.bukkit.inventory.ItemStack(CraftMagicNumbers.getMaterial(item.getItem()), item.count);
                return new PacketServerEntityEquipment(var1, var2, stack);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else if(packet instanceof PacketPlayOutEntityHeadRotation)
        {
            try
            {
                PacketPlayOutEntityHeadRotation pack = (PacketPlayOutEntityHeadRotation) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                byte yaw = ReflectionUtils.getPrivateField("b", pack);
                return new PacketServerEntityHeadRotation(entityId, yaw);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutEntityMetadata)
        {
            try
            {
                PacketPlayOutEntityMetadata pack = (PacketPlayOutEntityMetadata) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                // TODO: figure out what watchable contains
                return new PacketServerEntityMetadata(entityId);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutEntityStatus)
        {
            try
            {
                PacketPlayOutEntityStatus pack = (PacketPlayOutEntityStatus) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                byte data = ReflectionUtils.getPrivateField("b", pack);
                return new PacketServerEntityStatus(entityId, data);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutEntityTeleport)
        {
            try
            {
                PacketPlayOutEntityTeleport pack = (PacketPlayOutEntityTeleport) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                int x = ReflectionUtils.getPrivateField("b", pack);
                int y = ReflectionUtils.getPrivateField("c", pack);
                int z = ReflectionUtils.getPrivateField("d", pack);
                Vector vector = new Vector(x, y, z);
                byte yaw = ReflectionUtils.getPrivateField("e", pack);
                byte pitch = ReflectionUtils.getPrivateField("f", pack);
                boolean onGround = ReflectionUtils.getPrivateField("g", pack);

                return new PacketServerEntityTeleport(entityId, vector, yaw, pitch, onGround);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutEntityVelocity)
        {
            try
            {
                PacketPlayOutEntityVelocity pack = (PacketPlayOutEntityVelocity) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                int vx = ReflectionUtils.getPrivateField("b", pack);
                int vy = ReflectionUtils.getPrivateField("c", pack);
                int vz = ReflectionUtils.getPrivateField("d", pack);
                Vector<Integer> v = new Vector<>(vx, vy, vz);

                return new PacketServerEntityVelocity(entityId, v);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutAttachEntity)
        {
            try
            {
                PacketPlayOutAttachEntity pack = (PacketPlayOutAttachEntity) packet;
                int var1 = ReflectionUtils.getPrivateField("a", pack);
                int entityId1 = ReflectionUtils.getPrivateField("b", pack);
                int entityId2 = ReflectionUtils.getPrivateField("c", pack);
                return new PacketServerAttachEntity(var1, entityId1, entityId2);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutSpawnEntity)
        {
            try
            {
                PacketPlayOutSpawnEntity pack = (PacketPlayOutSpawnEntity) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                int x = ReflectionUtils.getPrivateField("b", pack);
                int y = ReflectionUtils.getPrivateField("c", pack);
                int z = ReflectionUtils.getPrivateField("d", pack);
                Vector<Integer> r = new Vector<>(x, y, z);
                int vx = ReflectionUtils.getPrivateField("e", pack);
                int vy = ReflectionUtils.getPrivateField("f", pack);
                int vz = ReflectionUtils.getPrivateField("g", pack);
                Vector<Integer> v = new Vector<>(vx, vy, vz);
                int pitch = ReflectionUtils.getPrivateField("h", pack);
                int yaw = ReflectionUtils.getPrivateField("i", pack);
                int uuid = ReflectionUtils.getPrivateField("j", pack);
                int objectData = ReflectionUtils.getPrivateField("k", pack);
                return new PacketServerSpawnEntity(entityId, r, v, pitch, yaw, uuid, objectData);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else if(packet instanceof PacketPlayOutNamedEntitySpawn)
        {
            try
            {
                PacketPlayOutNamedEntitySpawn pack = (PacketPlayOutNamedEntitySpawn) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                int x = ReflectionUtils.getPrivateField("c", pack);
                int y = ReflectionUtils.getPrivateField("d", pack);
                int z = ReflectionUtils.getPrivateField("e", pack);
                Vector<Integer> vector = new Vector<>(x, y, z);
                byte yaw = ReflectionUtils.getPrivateField("f", pack);
                byte pitch = ReflectionUtils.getPrivateField("g", pack);
                // TODO: get meta data

                return new PacketServerNamedEntitySpawn(entityId, vector, yaw, pitch);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else if(packet instanceof PacketPlayOutRemoveEntityEffect)
        {
            try
            {
                PacketPlayOutRemoveEntityEffect pack = (PacketPlayOutRemoveEntityEffect) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                int potionEffectId = ReflectionUtils.getPrivateField("b", pack);
                return new PacketServerRemoveEntityEffect(entityId, potionEffectId);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutSpawnEntityExperienceOrb)
        {
            try
            {
                PacketPlayOutSpawnEntityExperienceOrb pack = (PacketPlayOutSpawnEntityExperienceOrb) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                int x = ReflectionUtils.getPrivateField("b", pack);
                int y = ReflectionUtils.getPrivateField("c", pack);
                int z = ReflectionUtils.getPrivateField("d", pack);
                Vector<Integer> r = new Vector<>(x, y, z);
                int count = ReflectionUtils.getPrivateField("e", pack);
                return new PacketServerSpawnEntityExperienceOrb(entityId, r, count);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(packet instanceof PacketPlayOutSpawnEntityLiving)
        {
            try
            {
                PacketPlayOutSpawnEntityLiving pack = (PacketPlayOutSpawnEntityLiving) packet;
                int entityId = ReflectionUtils.getPrivateField("a", pack);
                int uuid = ReflectionUtils.getPrivateField("b", pack);

                int x = ReflectionUtils.getPrivateField("c", pack);
                int y = ReflectionUtils.getPrivateField("d", pack);
                int z = ReflectionUtils.getPrivateField("e", pack);
                Vector<Integer> r = new Vector<>(x, y, z);

                int vx = ReflectionUtils.getPrivateField("f", pack);
                int vy = ReflectionUtils.getPrivateField("g", pack);
                int vz = ReflectionUtils.getPrivateField("h", pack);
                Vector<Integer> v = new Vector<>(vx, vy, vz);
                
                byte yaw = ReflectionUtils.getPrivateField("i", pack);
                byte pitch = ReflectionUtils.getPrivateField("j", pack);
                byte headPitch = ReflectionUtils.getPrivateField("k", pack);

                // int metadata = ReflectionUtils.getPrivateField("l", pack); TODO: handle metadata

                return new PacketServerSpawnEntityLiving(entityId, uuid, r, v, yaw, pitch, headPitch);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else if(packet instanceof PacketPlayOutSpawnEntityPainting)
        {
            PacketPlayOutSpawnEntityPainting pack = (PacketPlayOutSpawnEntityPainting) packet;

        }
        else if(packet instanceof PacketPlayOutSpawnEntityWeather)
        {

        }
        else if(packet instanceof PacketPlayOutTileEntityData)
        {

        }
        else if(packet instanceof PacketPlayOutUpdateEntityNBT)
        {

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
