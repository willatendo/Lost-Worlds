package lostworlds.client.entity.model;

import lostworlds.common.entities.CryolophosaurusEntity;
import lostworlds.core.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class CryolophosaurusModel extends AnimatedGeoModel<CryolophosaurusEntity> 
{	
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/cryolophosaurus/male.png");
	private static final ResourceLocation FEMALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/cryolophosaurus/female.png");
	private static final ResourceLocation BABY = new ResourceLocation(ModUtil.ID, "textures/model/entity/cryolophosaurus/baby.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(CryolophosaurusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/cryolophosaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(CryolophosaurusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(CryolophosaurusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/cryolophosaurus.animations.json");
	}

	@Override
	public void setLivingAnimations(CryolophosaurusEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");
		
		if(entity.getSex() == 0)
		{
			texture = MALE;
		}
		if(entity.getSex() == 1)
		{
			texture = FEMALE;
		}
		
		if(entity.isBaby())
		{
			texture = BABY;
		}
		
		@SuppressWarnings("unchecked")
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
