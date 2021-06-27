package api.client.entity.model;

import library.entites.ZephyrosaurusEntity;
import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ZephyrosaurusModel extends AnimatedGeoModel<ZephyrosaurusEntity> 
{	
	private static final ResourceLocation FEMALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/zephyrosaurus/female.png");
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/zephyrosaurus/male.png");
	private static final ResourceLocation BABY = new ResourceLocation(ModUtil.ID, "textures/model/entity/zephyrosaurus/baby.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(ZephyrosaurusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/zephyrosaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(ZephyrosaurusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(ZephyrosaurusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/zephyrosaurus.animations.json");
	}

	@Override
	public void setLivingAnimations(ZephyrosaurusEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
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
		
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
