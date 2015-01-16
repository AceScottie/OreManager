package OreManager.block;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import OreManager.container.ChangeContainer;
import OreManager.gui.OreChangerGUI;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TileEntityOreModel extends TileEntity implements IInventory {
	private static final ResourceLocation texture = new ResourceLocation("OreManager:textures/model/OreManager.png");
	
	
	private ItemStack[] inv = new ItemStack[2];

	private static final int[] inv_bottom = new int[]{0};
	private static final int[] inv_side = new int[]{1};
	private static final int[] inv_back = new int[]{2};

	
	
	@Override
	public int getSizeInventory() {
		return this.inv.length;
	}
	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
		
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemstack = getStackInSlot(slot);
		if(itemstack != null) {
			if(itemstack.stackSize <= count) {
				setInventorySlotContents(slot, null);
			}
			else {
				itemstack = itemstack.splitStack(count);
				setInventorySlotContents(slot, null);
				if(itemstack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return itemstack;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if(stack != null) {
			setInventorySlotContents(slot, null);
			
		}
		return stack;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
		
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64; 
	}
	
	@Override
	public void openChest() {}
	@Override
	public void closeChest() {}
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
			NBTTagList tagList = tagCompound.getTagList("Inventory");
			for(int i = 0; i < tagList.tagCount(); i++) {
				NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
				byte slot = tag.getByte("Slot");
				if(slot >= 0 && slot < inv.length) {
					inv[slot] = ItemStack.loadItemStackFromNBT(tag);
				}
			}
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);;
		NBTTagList itemList = new NBTTagList();
		for(int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if(stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
		
	}
	
	@Override
	public String getInvName() {
		return "Ore Changer";
		
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	//put ore dictiany items here
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 2 ? false : i == 1 ? isItemOre(itemstack) : true;
	}

	public static boolean isItemOre(ItemStack itemstack) {
		return validItem(itemstack);
	}
	private static boolean validItem(ItemStack itemstack) {
		return null != null;
	}
	private void bindTexture(ResourceLocation texture2) {
		
	}

		
}
	
	
	

