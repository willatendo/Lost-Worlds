package lostworlds.client.entity.model;

import lostworlds.common.entities.KentrosaurusEntity;
import lostworlds.core.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class KentrosaurusModel extends AnimatedGeoModel<KentrosaurusEntity> 
{	
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/kentrosaurus/male.png");
	private static final ResourceLocation FEMALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/kentrosaurus/female.png");
	private static final ResourceLocation BABY = new ResourceLocation(ModUtil.ID, "textures/model/entity/kentrosaurus/baby.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(KentrosaurusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/kentrosaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(KentrosaurusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(KentrosaurusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/kentrosaurus.animations.json");
	}

	@Override
	public void setLivingAnimations(KentrosaurusEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");

		if(entity.getSex() == 0)
		{
			texture = MALE;
		}
		if(entity.getSex() == 1)
		{
			texture = FEMALE;
		}
		
		if(entity.isBaby())
		{
			texture = BABY;
		}
		
		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
