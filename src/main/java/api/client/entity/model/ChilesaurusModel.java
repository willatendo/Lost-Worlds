package api.client.entity.model;

import library.entites.ChilesaurusEntity;
import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class ChilesaurusModel extends AnimatedGeoModel<ChilesaurusEntity> 
{	
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/chilesaurus/male.png");
	private static final ResourceLocation FEMALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/chilesaurus/female.png");
	private static final ResourceLocation BABY = new ResourceLocation(ModUtil.ID, "textures/model/entity/chilesaurus/baby.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(ChilesaurusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/chilesaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(ChilesaurusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(ChilesaurusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/chilesaurus.animations.json");
	}

	@Override
	public void setLivingAnimations(ChilesaurusEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
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
		
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
