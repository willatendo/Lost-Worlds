package lostworlds.client.entity.model;

import lostworlds.common.entities.SpinosaurusEntity;
import lostworlds.core.util.ModID;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class SpinosaurusModel extends AnimatedGeoModel<SpinosaurusEntity> 
{
	@Override
	public ResourceLocation getModelLocation(SpinosaurusEntity object) 
	{
		return new ResourceLocation(ModID.ID, "geo/spinosaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(SpinosaurusEntity object) 
	{
		return new ResourceLocation(ModID.ID, "textures/model/entity/spinosaurus.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(SpinosaurusEntity animatable) 
	{
		return new ResourceLocation(ModID.ID, "animations/carnotaurus.animations.json");
	}

	@Override
	public void setLivingAnimations(SpinosaurusEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
