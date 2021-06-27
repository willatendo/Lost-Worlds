package api.client.entity.model;

import library.entites.NautilusEntity;
import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@OnlyIn(Dist.CLIENT)
public class NautilusModel extends AnimatedGeoModel<NautilusEntity>
{
	@Override
	public ResourceLocation getModelLocation(NautilusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/nautilus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(NautilusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "textures/model/entity/nautilus/texture.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(NautilusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/nautilus.animations.json");
	}
}
