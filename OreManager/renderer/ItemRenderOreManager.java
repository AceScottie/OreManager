package OreManager.renderer;

import OreManager.block.TileEntityOreModel;
import OreManager.model.ModelOre;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderOreManager implements IItemRenderer {
	
	private ModelOre model;
	
	public ItemRenderOreManager() {
		model = new ModelOre();
		
		
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityOreModel(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
	

}
