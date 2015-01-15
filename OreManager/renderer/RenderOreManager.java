package OreManager.renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import OreManager.block.TileEntityOreModel;
import OreManager.common.OreManager;
import OreManager.model.ModelOre;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderOreManager extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation("OreManager:textures/model/OreManager.png");
	
	private final ModelOre model = new ModelOre();
	
	public void renderAModelAt(TileEntityOreModel par1EntityOreChanger, double par2, double par4, double par6, float par8) {
		int metadata = par1EntityOreChanger.getBlockMetadata();
        int rotationAngle = 0;
        if (metadata  == 2)
        	rotationAngle = 180;
        	if (metadata  == 3)
        	rotationAngle = 0;
        	if (metadata  == 4)
        	rotationAngle = 90;
        	if (metadata  == 5)
        	rotationAngle = -90;
        	GL11.glPushMatrix();
        	GL11.glTranslated((float)par2 + 0.5F, (float)par4 + 1.5F, (float)par6 + 0.5F);
        	GL11.glScalef(1.0F, -1F, -1F);
        	GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);
        	this.bindTexture(texture);
        	this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        	GL11.glPopMatrix();
	}
	
	
    @Override
    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4,
                    double par6, float par8) {
            this.renderAModelAt((TileEntityOreModel)par1TileEntity, par2, par4, par6, par8);
           
    }
}
	
	
	
	
	
	
	

