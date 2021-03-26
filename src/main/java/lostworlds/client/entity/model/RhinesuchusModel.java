package lostworlds.client.entity.model;

import lostworlds.common.entities.RhinesuchusEntity;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RhinesuchusModel extends AnimatedGeoModel<RhinesuchusEntity>
{
	@Override
	public ResourceLocation getModelLocation(RhinesuchusEntity object) 
	{
		return new ResourceLocation(ModReference.ID, "geo/rhinesuchus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(RhinesuchusEntity object) 
	{
		return new ResourceLocation(ModReference.ID, "textures/model/entity/rhinesuchus.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(RhinesuchusEntity animatable) 
	{
		return new ResourceLocation(ModReference.ID, "animations/rhinesuchus.animations.json");
	}
}
