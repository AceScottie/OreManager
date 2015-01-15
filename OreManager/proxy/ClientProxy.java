package OreManager.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import OreManager.block.TileEntityOreModel;
import OreManager.common.OreManager;
import OreManager.renderer.ItemRenderOreManager;
import OreManager.renderer.RenderOreManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy {

	
	public void registerOreManager() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOreModel.class, new RenderOreManager());
	
	MinecraftForgeClient.registerItemRenderer(OreManager.blockOreChanger.blockID, new ItemRenderOreManager());
	
		//LanguageRegistry.instance().addStringLocalization();
	
	}
}
