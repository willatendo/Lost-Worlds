package lostworlds.client.entity.model;

import lostworlds.common.entities.EdaphosaurusEntity;
import lostworlds.core.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@OnlyIn(Dist.CLIENT)
public class EdaphosaurusModel extends AnimatedGeoModel<EdaphosaurusEntity> 
{
	@Override
	public ResourceLocation getModelLocation(EdaphosaurusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/edaphosaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(EdaphosaurusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "textures/model/entity/edaphosaurus.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(EdaphosaurusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/edaphosaurus.animations.json");
	}
}
