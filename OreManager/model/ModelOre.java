package OreManager.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOre extends ModelBase
{
  //fields
    ModelRenderer Block;
    ModelRenderer Left_Panel;
    ModelRenderer Right_Panel;
    ModelRenderer Back_Panel;
    ModelRenderer Screen;
    ModelRenderer MoterR;
    ModelRenderer MoterL;
    ModelRenderer Cube;
  
  public ModelOre()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Block = new ModelRenderer(this, 63, 0);
      Block.addBox(0F, 0F, 0F, 16, 4, 16);
      Block.setRotationPoint(-8F, 20F, -8F);
      Block.setTextureSize(128, 64);
      Block.mirror = true;
      setRotation(Block, 0F, 0F, 0F);
      Left_Panel = new ModelRenderer(this, 0, 0);
      Left_Panel.addBox(0F, 0F, 0F, 3, 12, 16);
      Left_Panel.setRotationPoint(-8F, 8F, -8F);
      Left_Panel.setTextureSize(128, 64);
      Left_Panel.mirror = true;
      setRotation(Left_Panel, 0F, 0F, 0F);
      Right_Panel = new ModelRenderer(this, 0, 0);
      Right_Panel.addBox(0F, 0F, 0F, 3, 12, 16);
      Right_Panel.setRotationPoint(5F, 8F, -8F);
      Right_Panel.setTextureSize(128, 64);
      Right_Panel.mirror = true;
      setRotation(Right_Panel, 0F, 0F, 0F);
      Back_Panel = new ModelRenderer(this, 38, 16);
      Back_Panel.addBox(0F, 0F, 0F, 10, 12, 1);
      Back_Panel.setRotationPoint(-5F, 8F, 7F);
      Back_Panel.setTextureSize(128, 64);
      Back_Panel.mirror = true;
      setRotation(Back_Panel, 0F, 0F, 0F);
      Screen = new ModelRenderer(this, 50, 6);
      Screen.addBox(0F, 0F, 0F, 6, 6, 1);
      Screen.setRotationPoint(-3F, 14F, -6F);
      Screen.setTextureSize(128, 64);
      Screen.mirror = true;
      setRotation(Screen, -0.1338086F, 0F, 0F);
      MoterR = new ModelRenderer(this, 0, 0);
      MoterR.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
      MoterR.setRotationPoint(5F, 13F, 0F);
      MoterR.setTextureSize(128, 64);
      MoterR.mirror = true;
      setRotation(MoterR, 0F, 0F, 1.570796F);
      MoterL = new ModelRenderer(this, 0, 0);
      MoterL.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
      MoterL.setRotationPoint(-5F, 13F, 0F);
      MoterL.setTextureSize(128, 64);
      MoterL.mirror = true;
      setRotation(MoterL, 0F, 0F, -1.570796F);
      Cube = new ModelRenderer(this, 60, 20);
      Cube.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
      Cube.setRotationPoint(0F, 13F, 0F);
      Cube.setTextureSize(128, 64);
      Cube.mirror = true;
      setRotation(Cube, 0F, 0.7853982F, 0.7853982F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Block.render(f5);
    Left_Panel.render(f5);
    Right_Panel.render(f5);
    Back_Panel.render(f5);
    Screen.render(f5);
    MoterR.render(f5);
    MoterL.render(f5);
    Cube.render(f5);
  }
  
  
  public void renderModel(float f){
      Block.render(f);
    Left_Panel.render(f);
    Right_Panel.render(f);
    Back_Panel.render(f);
    Screen.render(f);
    MoterR.render(f);
    MoterL.render(f);
    Cube.render(f);
	}
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderAll() {
    Block.render(0.0625F);
    Left_Panel.render(0.0625F);
    Right_Panel.render(0.0625F);
    Back_Panel.render(0.0625F);
    Screen.render(0.0625F);
    MoterR.render(0.0625F);
    MoterL.render(0.0625F);
    Cube.render(0.0625F);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
	 super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
