package lostworlds.client.entity.model;

import lostworlds.common.entities.NautilusEntity;
import lostworlds.core.util.ModID;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@OnlyIn(Dist.CLIENT)
public class NautilusModel extends AnimatedGeoModel<NautilusEntity>
{
	@Override
	public ResourceLocation getModelLocation(NautilusEntity object) 
	{
		return new ResourceLocation(ModID.ID, "geo/nautilus.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(NautilusEntity object) 
	{
		return new ResourceLocation(ModID.ID, "textures/model/entity/nautilus.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(NautilusEntity animatable) 
	{
		return new ResourceLocation(ModID.ID, "animations/nautilus.animations.json");
	}
}
