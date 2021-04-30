package lostworlds.world.feature.init;

import lostworlds.core.util.ModID;
import lostworlds.world.dimension.ModCanyonWorldCarver;
import lostworlds.world.dimension.ModCaveWorldCarver;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class CarverFeatures
{
	public static class Carvers
	{
		public static final WorldCarver<ProbabilityConfig> CAVES = new ModCaveWorldCarver(ProbabilityConfig.CODEC, 256);
		public static final WorldCarver<ProbabilityConfig> CANYONS = new ModCanyonWorldCarver(ProbabilityConfig.CODEC);

		public static void initWorldCarvers(Register<WorldCarver<?>> event) 
		{
			register(event.getRegistry(), "caves", CAVES);
			register(event.getRegistry(), "canyons", CANYONS);
			
			ConfiguredCarvers.initCarvers();
		}
	}
	
	public static class ConfiguredCarvers 
	{
		public static final ConfiguredCarver<?> CAVES = CarverFeatures.Carvers.CAVES.configured(new ProbabilityConfig(0.14285715F));
		public static final ConfiguredCarver<?> CANYONS = CarverFeatures.Carvers.CANYONS.configured(new ProbabilityConfig(0.02F));
	    
	    public static void initCarvers() 
	    {
	    	registerCarver("caves", CAVES);
	    	registerCarver("canyons", CANYONS);
	    }
	}
	
	public static <T extends IForgeRegistryEntry<T>> void register(IForgeRegistry<T> registry, String name, T object)
	{
		object.setRegistryName(ModID.lostWorlds(name));
		registry.register(object);
	}
	
    private static <C extends ICarverConfig> ConfiguredCarver<C> registerCarver(String nameIn, ConfiguredCarver<C> featureIn)
	{
		return Registry.register(WorldGenRegistries.CONFIGURED_CARVER, nameIn, featureIn);
	}
    
    @Mod.EventBusSubscriber(modid = ModID.ID, bus = Bus.MOD)
    public static class RegisterCarvers 
    {
    	@SubscribeEvent
    	public void onRegisterWorldCarvers(Register<WorldCarver<?>> event)
    	{
    		CarverFeatures.Carvers.initWorldCarvers(event); 
    	}   
    }
}

