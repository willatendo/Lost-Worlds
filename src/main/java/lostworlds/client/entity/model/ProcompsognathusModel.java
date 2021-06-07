package lostworlds.client.entity.model;

import lostworlds.common.entities.ProcompsognathusEntity;
import lostworlds.core.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ProcompsognathusModel extends AnimatedGeoModel<ProcompsognathusEntity>
{
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/procompsognathus/male.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(ProcompsognathusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/procompsognathus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(ProcompsognathusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(ProcompsognathusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/procompsognathus.animations.json");
	}
	
	@Override
	public void setLivingAnimations(ProcompsognathusEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");
		
		texture = MALE;

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
