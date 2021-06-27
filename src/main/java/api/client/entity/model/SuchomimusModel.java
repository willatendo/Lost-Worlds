package api.client.entity.model;

import library.entites.SuchomimusEntity;
import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class SuchomimusModel extends AnimatedGeoModel<SuchomimusEntity> 
{
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/suchomimus/male.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(SuchomimusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/suchomimus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(SuchomimusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(SuchomimusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/suchomimus.animations.json");
	}

	@Override
	public void setLivingAnimations(SuchomimusEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("Neck");
		
		texture = MALE;

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
