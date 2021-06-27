package api.client.entity.model;

import library.entites.PalaeoniscumEntity;
import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PalaeoniscumModel extends AnimatedGeoModel<PalaeoniscumEntity>
{
	@Override
	public ResourceLocation getModelLocation(PalaeoniscumEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/palaeoniscum.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(PalaeoniscumEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "textures/model/entity/palaeoniscum/texture.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(PalaeoniscumEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/palaeoniscum.animations.json");
	}
}