package lostworlds.client.entity.model;

import lostworlds.core.util.reference.Reference;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@SuppressWarnings("rawtypes")
public class PalaeoniscumFreieslebeniModel extends AnimatedGeoModel
{
	@Override
	public ResourceLocation getModelLocation(Object object) 
	{
		return new ResourceLocation(Reference.ID, "geo/palaeoniscum_freieslebeni.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(Object object) 
	{
		return new ResourceLocation(Reference.ID, "textures/model/entity/palaeoniscum.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(Object animatable) 
	{
		return new ResourceLocation(Reference.ID, "animations/palaeoniscum.animations.json");
	}
}
