
package api.core.init;

import library.dimension.ModCanyonWorldCarver;
import library.dimension.ModCaveWorldCarver;
import library.dimension.VolcanoCaveWorldCarver;
import library.util.ModUtil;
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
	public static final ConfiguredCarver<ProbabilityConfig> CONFIGURED_MOD_CAVES = MOD_CAVES.configured(new ProbabilityConfig(0.14285715F));
	
	public static final WorldCarver<ProbabilityConfig> MOD_CANYONS = new ModCanyonWorldCarver(ProbabilityConfig.CODEC);
	public static final ConfiguredCarver<ProbabilityConfig> CONFIGURED_MOD_CANYONS = MOD_CANYONS.configured(new ProbabilityConfig(0.02F));
	
	public static final WorldCarver<ProbabilityConfig> MOD_WATER_CAVES = new ModCaveWorldCarver(ProbabilityConfig.CODEC, 256);
	public static final ConfiguredCarver<ProbabilityConfig> CONFIGURED_MOD_WATER_CAVES = MOD_WATER_CAVES.configured(new ProbabilityConfig(0.14285715F));
	
	public static final WorldCarver<ProbabilityConfig> MOD_WATER_CANYONS = new ModCanyonWorldCarver(ProbabilityConfig.CODEC);
	public static final ConfiguredCarver<ProbabilityConfig> CONFIGURED_MOD_WATER_CANYONS = MOD_WATER_CANYONS.configured(new ProbabilityConfig(0.02F));

	public static final WorldCarver<ProbabilityConfig> VOLCANO_CAVES = new VolcanoCaveWorldCarver(ProbabilityConfig.CODEC, 256);
	public static final ConfiguredCarver<ProbabilityConfig> CONFIGURED_VOLCANO_CAVES = VOLCANO_CAVES.configured(new ProbabilityConfig(0.14285715F));
	
	public static <T extends IForgeRegistryEntry<T>> void register(IForgeRegistry<T> registry, String name, T object)
	{
		object.setRegistryName(ModUtil.rL(name));
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
		register(event.getRegistry(), "mod_water_caves_carver", MOD_WATER_CAVES);
		register(event.getRegistry(), "mod_water_canyons_carver", MOD_WATER_CANYONS);
		register(event.getRegistry(), "volcano_caves_carver", VOLCANO_CAVES);

		initCarvers();
	}
	
	public static void initCarvers()
	{
		registerCarver("mod_caves", CONFIGURED_MOD_CAVES);
		registerCarver("mod_canyons", CONFIGURED_MOD_CANYONS);
		registerCarver("mod_water_caves", CONFIGURED_MOD_WATER_CAVES);
		registerCarver("mod_water_canyons", CONFIGURED_MOD_WATER_CANYONS);
		registerCarver("volcano_caves", CONFIGURED_VOLCANO_CAVES);
	}
}
