package OreManager.common;

import OreManager.block.TileEntityOreModel;
import OreManager.block.blockOreChanger;
import OreManager.gui.OreChangerGuiHandler;
import OreManager.renderer.RenderOreManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid="OreManager", name="OreManager", version="0.1 Alpha")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class OreManager {

	@Mod.Instance("OreManager")
	public static OreManager instance;
	public static final String modid = "OreManager"; 
	
	public static Block blockOreChanger;
	public static int blockOreChangerID;
	
	
	
	   @Mod.EventHandler
	   public void preInit(FMLPreInitializationEvent event)
	   {
	     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	     config.load();
	     
	 
	 
	 
	     blockOreChangerID = config.get(Configuration.CATEGORY_BLOCK, "blockOreChanger", 4000).getInt();
	     config.save();
	     
	   }
	     @Init
	     public void load(FMLInitializationEvent event) {
	     loadBlock();
	     GameRegistry.registerBlock(blockOreChanger, ItemBlock.class, "Ore Changer");
	     LanguageRegistry.addName(blockOreChanger, "Ore Changer");
	     
	     
	     GameRegistry.registerTileEntity(TileEntityOreModel.class, "OreModelTileEntity");
	     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOreModel.class, new RenderOreManager());
	     NetworkRegistry.instance().registerGuiHandler(this, new OreChangerGuiHandler());
	     
	     
	     }

	     @PostInit
	     public static void postInit(FMLPostInitializationEvent event){

	     }

	     private void loadBlock(){
	    	 blockOreChanger = new blockOreChanger(blockOreChangerID);
	     }
	   
}
