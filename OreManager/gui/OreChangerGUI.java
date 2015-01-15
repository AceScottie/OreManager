package OreManager.gui;

import org.lwjgl.opengl.GL11;

import OreManager.block.TileEntityOreModel;
import OreManager.container.ChangeContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class OreChangerGUI extends GuiContainer {
	
	public static final ResourceLocation field_110421_t = new ResourceLocation("OreManager:textures/gui/OreChanger.png");


	public OreChangerGUI(InventoryPlayer inventoryPlayer, TileEntityOreModel TileEntity) {
		super(new ChangeContainer(inventoryPlayer, TileEntity));
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(field_110421_t);
	int k = (this.width - this. xSize) / 2;
	int y = (this.height - this.ySize) / 2;
	this.drawTexturedModalRect(k, y, 0, 2, xSize, ySize);
	
	}

	//@Override
	protected void drawGuiContainerForgroundLayout(int param1, int param2) {
		fontRenderer.drawString("OreChangerimput", 8, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("oremanager:/gui/OreChanger.png"), 8, ySize - 96 + 2, 4210752);
		
	}
	
	
}
