package lostworlds.client.entity.model;

import lostworlds.common.entities.FukuivenatorEntity;
import lostworlds.core.util.ModID;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class FukuivenatorModel extends AnimatedGeoModel<FukuivenatorEntity> 
{
	@Override
	public ResourceLocation getModelLocation(FukuivenatorEntity object) 
	{
		return new ResourceLocation(ModID.ID, "geo/fukuivenator.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(FukuivenatorEntity object) 
	{
		return new ResourceLocation(ModID.ID, "textures/model/entity/fukuivenator.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(FukuivenatorEntity animatable) 
	{
		return new ResourceLocation(ModID.ID, "animations/fukuivenator.animations.json");
	}

	@Override
	public void setLivingAnimations(FukuivenatorEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");

		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}