package lostworlds.client.entity.model;

import lostworlds.common.entities.DimetrodonEntity;
import lostworlds.core.util.ModID;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class DimetrodonModel extends AnimatedGeoModel<DimetrodonEntity> 
{
	@Override
	public ResourceLocation getModelLocation(DimetrodonEntity object) 
	{
		return new ResourceLocation(ModID.ID, "geo/dimetrodon.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(DimetrodonEntity object) 
	{
		return new ResourceLocation(ModID.ID, "textures/model/entity/dimetrodon.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(DimetrodonEntity animatable) 
	{
		return new ResourceLocation(ModID.ID, "animations/dimetrodon.animations.json");
	}
	
	@Override
	public void setLivingAnimations(DimetrodonEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
