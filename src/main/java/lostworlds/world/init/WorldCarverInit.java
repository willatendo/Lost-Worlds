package lostworlds.world.init;

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
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class WorldCarverInit
{
	public static final WorldCarver<ProbabilityConfig> MOD_CAVES = new ModCaveWorldCarver(ProbabilityConfig.CODEC, 256);
	public static final ConfiguredCarver<ProbabilityConfig> CONFIGURED_MOD_CAVES = MOD_CAVES.configured(new ProbabilityConfig(0.364896F));
	
	public static final WorldCarver<ProbabilityConfig> MOD_CANYONS = new ModCanyonWorldCarver(ProbabilityConfig.CODEC);
	public static final ConfiguredCarver<ProbabilityConfig> CONFIGURED_MOD_CANYONS = MOD_CANYONS.configured(new ProbabilityConfig(0.364896F));
	
	public static <T extends IForgeRegistryEntry<T>> void register(IForgeRegistry<T> registry, String name, T object)
	{
		object.setRegistryName(ModID.lostWorlds(name));
		registry.register(object);
	}
	
	private static <C extends ICarverConfig> ConfiguredCarver<C> registerCarver(String nameIn, ConfiguredCarver<C> featureIn)
	{
		return Registry.register(WorldGenRegistries.CONFIGURED_CARVER, nameIn, featureIn);
	}
	
	public static void init(Register<WorldCarver<?>> event)
	{
		register(event.getRegistry(), "mod_caves_carver", MOD_CAVES);
		register(event.getRegistry(), "mod_canyons_carver", MOD_CANYONS);

		initCarvers();
	}
	
	public static void initCarvers()
	{
		registerCarver("mod_caves", CONFIGURED_MOD_CAVES);
		registerCarver("mod_canyons", CONFIGURED_MOD_CANYONS);
	}
}
