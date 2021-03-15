package lostworlds.client.entity.model;

import lostworlds.core.util.reference.Reference;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@SuppressWarnings("rawtypes")
public class ProcompsognathusTriassicusModel extends AnimatedGeoModel
{
	@Override
	public ResourceLocation getModelLocation(Object object) 
	{
		return new ResourceLocation(Reference.ID, "geo/procompsognathus_triassicus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(Object object) 
	{
		return new ResourceLocation(Reference.ID, "textures/model/entity/compy.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(Object animatable) 
	{
		return new ResourceLocation(Reference.ID, "animations/procompsognathus.animations.json");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setLivingAnimations(IAnimatable entity, Integer uniqueID, AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
