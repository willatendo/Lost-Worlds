package lostworlds.client.entity.model;

import lostworlds.common.entities.GorgonopsEntity;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class GorgonopsModel extends AnimatedGeoModel<GorgonopsEntity> 
{
	@Override
	public ResourceLocation getModelLocation(GorgonopsEntity object) 
	{
		return new ResourceLocation(ModReference.ID, "geo/gorgonops.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(GorgonopsEntity object) 
	{
		return new ResourceLocation(ModReference.ID, "textures/model/entity/gorgonops.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(GorgonopsEntity animatable) 
	{
		return new ResourceLocation(ModReference.ID, "animations/gorgonops.animations.json");
	}
	
	@Override
	public void setLivingAnimations(GorgonopsEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
