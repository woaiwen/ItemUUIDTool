package woaiwen.IUUIDT.api;

import java.util.UUID;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagString;

import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUUIDAPI {
	private static ItemStack addNBTdata(ItemStack is,String k,String v){
		net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(is);
		NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		compound.set(k, new NBTTagString(v));
		nmsItem.setTag(compound);
		return CraftItemStack.asBukkitCopy(nmsItem);
	}
	private static String getNBTdata(ItemStack is,String str){
		net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(is);
		NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		return compound.getString(str);
	}
	public static ItemStack addUUID(ItemStack is){
		String uuid = UUID.randomUUID().toString();
		ItemMeta im = addNBTdata(is, "ItemUUID", uuid).getItemMeta();
		is.setItemMeta(im);
		return is;
	}
	public static String getUUID(ItemStack is){
		String nbt = getNBTdata(is, "ItemUUID");
		if(nbt != null){
			return nbt;
		}
		return null;
	}
}
