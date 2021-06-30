package api.client.entity.model;

import library.entites.TyrannosaurusEntity;
import library.util.CalendarUtil.Holidays;
import library.util.CalendarUtil;
import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@OnlyIn(Dist.CLIENT)
public class TyrannosaurusModel extends AnimatedGeoModel<TyrannosaurusEntity> 
{
	private static final ResourceLocation MALE = new ResourceLocation(ModUtil.ID, "textures/model/entity/tyrannosaurus/male.png");
	private static final ResourceLocation CHRISTMAS = new ResourceLocation(ModUtil.ID, "textures/model/entity/tyrannosaurus/christmas.png");
	private ResourceLocation texture;
	
	@Override
	public ResourceLocation getModelLocation(TyrannosaurusEntity object) 
	{
		return new ResourceLocation(ModUtil.ID, "geo/tyrannosaurus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(TyrannosaurusEntity object) 
	{
		return texture;
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(TyrannosaurusEntity animatable) 
	{
		return new ResourceLocation(ModUtil.ID, "animations/tyrannosaurus.animations.json");
	}

	@Override
	public void setLivingAnimations(TyrannosaurusEntity entity, Integer uniqueID, AnimationEvent customPredicate) 
	{
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");
		
		if(CalendarUtil.HOLIDAYS == Holidays.CHRISTMAS)
		{
			texture = CHRISTMAS;
		}
		else
		{
			texture = MALE;
		}

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}	
}
