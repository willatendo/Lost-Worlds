package api.client.entity.model;

import library.entites.ProtosuchusEntity;
import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ProtosuchusModel extends AnimatedGeoModel<ProtosuchusEntity> 
{	
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/protosuchus/male.png");
	private static final ResourceLocation FEMALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/protosuchus/female.png");
	private static final ResourceLocation BABY = new ResourceLocation(ModUtil.ID, "textures/model/entity/protosuchus/baby.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(ProtosuchusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/protosuchus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(ProtosuchusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(ProtosuchusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/protosuchus.animations.json");
	}

	@Override
	public void setLivingAnimations(ProtosuchusEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
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
