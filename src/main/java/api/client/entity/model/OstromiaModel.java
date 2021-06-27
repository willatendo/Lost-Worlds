package api.client.entity.model;

import library.entites.OstromiaEntity;
import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class OstromiaModel extends AnimatedGeoModel<OstromiaEntity> 
{	
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/ostromia/male.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(OstromiaEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/ostromia.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(OstromiaEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(OstromiaEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/ostromia.animations.json");
	}

	@Override
	public void setLivingAnimations(OstromiaEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");
		
		texture = MALE;
		
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
