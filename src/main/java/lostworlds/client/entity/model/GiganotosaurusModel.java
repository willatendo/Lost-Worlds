package lostworlds.client.entity.model;

import lostworlds.common.entities.GiganotosauruEntity;
import lostworlds.core.util.ModID;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class GiganotosaurusModel extends AnimatedGeoModel<GiganotosauruEntity> 
{
	@Override
	public ResourceLocation getModelLocation(GiganotosauruEntity object) 
	{
		return new ResourceLocation(ModID.ID, "geo/giganotosaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(GiganotosauruEntity object) 
	{
		return new ResourceLocation(ModID.ID, "textures/model/entity/giganotosaurus.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(GiganotosauruEntity animatable) 
	{
		return new ResourceLocation(ModID.ID, "animations/giganotosaurus.animations.json");
	}

	@Override
	public void setLivingAnimations(GiganotosauruEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");

		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
