package lostworlds.client.entity.model;

import lostworlds.common.entities.UtahraptorEntity;
import lostworlds.core.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class UtahraptorModel extends AnimatedGeoModel<UtahraptorEntity> 
{	
	private static final ResourceLocation TEXTURE = new ResourceLocation(ModUtil.ID, "textures/model/entity/utahraptor/texture.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(UtahraptorEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/utahraptor.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(UtahraptorEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(UtahraptorEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/utahraptor.animations.json");
	}

	@Override
	public void setLivingAnimations(UtahraptorEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");

		texture = TEXTURE;
		
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
