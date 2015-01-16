package OreManager.container;

import OreManager.block.TileEntityOreModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ChangeContainer extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return ChangeContainer.isUseableByPlayer(entityplayer);
	}

	protected TileEntityOreModel ChangeContainer;
	
	
	public ChangeContainer(InventoryPlayer inventoryPlayer, TileEntityOreModel tileEntity) {
		this.ChangeContainer = tileEntity;
		
				this.addSlotToContainer(new Slot(ChangeContainer, 0, 25, 18));
				this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, ChangeContainer, 1, 76, 18));
		
		bindPlayerInventory(inventoryPlayer);
		
	}

	private void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer( new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
		
	}
	
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
	
	
	
			ItemStack itemstack = null;
		Slot slotObject = (Slot)inventorySlots.get(par2);
		if(slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			itemstack = stackInSlot.copy();
			
			if (par2 < 2) {
				if(!this.mergeItemStack(stackInSlot, 2, 35, true)) {
					return null;
			
				}
				slotObject.onSlotChange(stackInSlot, itemstack);
			}
			else if(!this.mergeItemStack(stackInSlot, 0, 2, false)){
				return null;
			}
		/*	if (!this.mergeItemStack(stackInSlot, 31, 40, false)) {
				return null;
				}
			 else if (par2 >= 31 && par2 < 40
				&& !this.mergeItemStack(stackInSlot, 4, 31, false)) {
			return null;
				}
			 else if (!this.mergeItemStack(stackInSlot, 4, 40, false)) {
				return null;
			} */   //--- REMBER THESE FUKING LINES CAUSING YOU 3 DAYS SUFFERING!!!!
			if(stackInSlot.stackSize == 0) {
				slotObject.putStack((ItemStack)null);
				
			}
			else {
				slotObject.onSlotChanged();
			}
			
			if(stackInSlot.stackSize == itemstack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return itemstack;
		
	}
}

