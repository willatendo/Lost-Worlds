package lostworlds.client.entity.model;

import lostworlds.common.entities.CarnotaurusEntity;
import lostworlds.core.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class CarnotaurusModel extends AnimatedGeoModel<CarnotaurusEntity> 
{
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/carnotaurus/male.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(CarnotaurusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/carnotaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(CarnotaurusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(CarnotaurusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/carnotaurus.animations.json");
	}

	@Override
	public void setLivingAnimations(CarnotaurusEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");

		texture = MALE;
		
		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
