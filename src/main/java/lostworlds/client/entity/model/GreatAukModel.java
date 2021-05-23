package lostworlds.client.entity.model;

import lostworlds.common.entities.GreatAukEntity;
import lostworlds.core.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class GreatAukModel extends AnimatedGeoModel<GreatAukEntity> 
{
	@Override
	public ResourceLocation getModelLocation(GreatAukEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/great_auk.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(GreatAukEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "textures/model/entity/great_auk.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(GreatAukEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/great_auk.animations.json");
	}

	@Override
	public void setLivingAnimations(GreatAukEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");

		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
