package lostworlds.mixins;

import java.util.OptionalLong;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.BiomeManager.BiomeType;

@Mixin(DimensionType.class)
public interface DimensionTypeAccessor 
{
	@Invoker("<init>")
	public static DimensionType createDimensionType(OptionalLong fixedTime,  boolean hasSkylight, boolean hasCeiling, boolean ultrawarm, boolean natural, double coordinateScale, boolean hasEnderDragonFight, boolean piglinSafe, boolean bedWorks, boolean respawnAnchorWorks, boolean hasRaids, int logicalHeight, BiomeType biomeAccessType, ResourceLocation infiniburn, ResourceLocation skyProperties, float ambientLight)
	{
		throw new UnsupportedOperationException();
	}
}
