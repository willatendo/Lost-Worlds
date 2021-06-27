package api.client.entity.model;

import library.entites.DimetrodonEntity;
import library.util.ModUtil;
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
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/dimetrodon/male.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(DimetrodonEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/dimetrodon.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(DimetrodonEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(DimetrodonEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/dimetrodon.animations.json");
	}
	
	@Override
	public void setLivingAnimations(DimetrodonEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");
		
		texture = MALE;

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
