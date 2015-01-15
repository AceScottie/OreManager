package OreManager.gui;

import OreManager.block.TileEntityOreModel;
import OreManager.container.ChangeContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class OreChangerGuiHandler implements IGuiHandler {
	
	 @Override
     public Object getServerGuiElement(int id, EntityPlayer player, World world,
                     int x, int y, int z) {
             TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
             if(tileEntity instanceof TileEntityOreModel){
                     return new ChangeContainer(player.inventory, (TileEntityOreModel) tileEntity);
             }
             return null;
     }
     @Override
     public Object getClientGuiElement(int id, EntityPlayer player, World world,
                     int x, int y, int z) {
             TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
             if(tileEntity instanceof TileEntityOreModel){
                     return new OreChangerGUI(player.inventory, (TileEntityOreModel) tileEntity);
             }
             return null;

     }
}
