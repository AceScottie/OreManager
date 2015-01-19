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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TileEntityOreModel extends TileEntity implements ISidedInventory {
	private static final ResourceLocation texture = new ResourceLocation("OreManager:textures/model/OreManager.png");
	
	
	

	private static final int[] slots_top = new int[] {0};
	private static final int[] slots_bottom = new int[] {1};
	private static final int[] slots_sides = new int[] {2};
	
	private ItemStack[] inv = new ItemStack[3];
	
	
	@Override
	public int getSizeInventory() {
		return this.inv.length;
	}

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
		public ItemStack decrStackSize(int par1, int par2) {
			if (this.inv[par1] != null) {
        		ItemStack itemstack;

        		if (this.inv[par1].stackSize <= par2) {
            		itemstack = this.inv[par1];
            		this.inv[par1] = null;
           			return itemstack; 
           			}
        			else{        		
        				itemstack = this.inv[par1].splitStack(par2);
        				if (this.inv[par1].stackSize == 0){
                			this.inv[par1] = null;
        				}
            		return itemstack;
        		}
			}
			else {
				return null;
			}
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
	
	//-- WIP
   	public int[] getAccessibleSlotsFromSide(int par1) {
    	return par1 == 0 ? slots_top : (par1 == 1 ? slots_bottom : slots_sides);
	}


	public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
	      return this.isItemValidForSlot(par1, par2ItemStack);
	}
	public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
		return par1 != 0 || par1 != 1 || par2ItemStack.itemID == Item.bucketEmpty.itemID;
	}

		//--
}
	
	
	

