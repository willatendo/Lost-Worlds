package lostworlds;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

import addon.officaladdons.ogpack.OGPack;
import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.core.init.BiomeInit;
import lostworlds.core.init.BlockInit;
import lostworlds.core.init.ConfiguredFeatureInit;
import lostworlds.core.init.FeatureInit;
import lostworlds.core.init.ModOreFeatures;
import lostworlds.core.init.WorldCarverInit;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.dimension.jurassic.JurassicDimension;
import lostworlds.world.dimension.jurassic.JurassicDimensionRenderInfo;
import lostworlds.world.dimension.permian.PermianDimension;
import lostworlds.world.dimension.permian.PermianDimensionRenderInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.entity.EntityType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(ModUtil.ID)
@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Bus.MOD)
public class LostWorlds
{
	public static boolean hasInitilised;
	
	public LostWorlds() 
	{
		ModUtil.LOGGER.debug("Loading: The Lost Worlds");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		ModRegistry.registry(); 

		//Lib - V. 3.0.30
		GeckoLib.initialize();
				
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModOreFeatures::generateOre);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeInit::addBiomesToOverworld);
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LostWorldsConfig.commonSpec);
				
		OGPack.init();
		
		hasInitilised = true;
		
		ModUtil.LOGGER.debug("Finished: The Lost Worlds");
	}

	
	@SuppressWarnings("deprecation")
	private void setup(final FMLCommonSetupEvent event)
	{
		DeferredWorkQueue.runLater(() -> 
		{
			ModUtil.LOGGER.debug("Loading: Adding Things to Maps");
			
			ComposterBlock.add(0.3F, BlockInit.CONIFER_LEAVES.get());
			ComposterBlock.add(0.3F, BlockInit.ARAUCARIA_LEAVES.get());
			ComposterBlock.add(0.3F, BlockInit.GINKGO_LEAVES.get());
			ComposterBlock.add(0.3F, BlockInit.SMALL_PERMIAN_DESERT_PLANT.get());
			ComposterBlock.add(0.4F, BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get());
			ComposterBlock.add(0.5F, BlockInit.LARGE_PERMIAN_DESERT_PLANT.get());
			ComposterBlock.add(0.3F, BlockInit.GROUND_FERNS.get());
			ComposterBlock.add(0.3F, BlockInit.CONIFER_SAPLING.get());
			ComposterBlock.add(0.3F, BlockInit.ARAUCARIA_SAPLING.get());
			ComposterBlock.add(0.3F, BlockInit.GINKGO_SAPLING.get());
			
			add(BlockInit.CONIFER_BUTTON.get(), 5, 5);
			add(BlockInit.CONIFER_DOOR.get(), 5, 5);
			add(BlockInit.CONIFER_FENCE.get(), 5, 5);
			add(BlockInit.CONIFER_FENCE_GATE.get(), 5, 5);
			add(BlockInit.CONIFER_LEAVES.get(), 5, 5);
			add(BlockInit.CONIFER_LOG.get(), 5, 5);
			add(BlockInit.CONIFER_PLANKS.get(), 5, 5);
			add(BlockInit.CONIFER_PRESSURE_PLATE.get(), 5, 5);
			add(BlockInit.CONIFER_SIGN.get(), 5, 5);
			add(BlockInit.CONIFER_SLAB.get(), 5, 5);
			add(BlockInit.CONIFER_STAIRS.get(), 5, 5);
			add(BlockInit.CONIFER_TRAPDOOR.get(), 5, 5);
			add(BlockInit.CONIFER_WALL_SIGN.get(), 5, 5);
			add(BlockInit.CONIFER_WOOD.get(), 5, 5);
			add(BlockInit.STRIPPED_CONIFER_LOG.get(), 5, 5);
			add(BlockInit.STRIPPED_CONIFER_WOOD.get(), 5, 5);
			
			add(BlockInit.GINKGO_BUTTON.get(), 5, 5);
			add(BlockInit.GINKGO_DOOR.get(), 5, 5);
			add(BlockInit.GINKGO_FENCE.get(), 5, 5);
			add(BlockInit.GINKGO_FENCE_GATE.get(), 5, 5);
			add(BlockInit.GINKGO_LEAVES.get(), 5, 5);
			add(BlockInit.GINKGO_LOG.get(), 5, 5);
			add(BlockInit.GINKGO_PLANKS.get(), 5, 5);
			add(BlockInit.GINKGO_PRESSURE_PLATE.get(), 5, 5);
			add(BlockInit.GINKGO_SIGN.get(), 5, 5);
			add(BlockInit.GINKGO_SLAB.get(), 5, 5);
			add(BlockInit.GINKGO_STAIRS.get(), 5, 5);
			add(BlockInit.GINKGO_TRAPDOOR.get(), 5, 5);
			add(BlockInit.GINKGO_WALL_SIGN.get(), 5, 5);
			add(BlockInit.GINKGO_WOOD.get(), 5, 5);
			add(BlockInit.STRIPPED_GINKGO_LOG.get(), 5, 5);
			add(BlockInit.STRIPPED_GINKGO_WOOD.get(), 5, 5);
			
			add(BlockInit.ARAUCARIA_BUTTON.get(), 5, 5);
			add(BlockInit.ARAUCARIA_DOOR.get(), 5, 5);
			add(BlockInit.ARAUCARIA_FENCE.get(), 5, 5);
			add(BlockInit.ARAUCARIA_FENCE_GATE.get(), 5, 5);
			add(BlockInit.ARAUCARIA_LEAVES.get(), 5, 5);
			add(BlockInit.ARAUCARIA_LOG.get(), 5, 5);
			add(BlockInit.ARAUCARIA_PLANKS.get(), 5, 5);
			add(BlockInit.ARAUCARIA_PRESSURE_PLATE.get(), 5, 5);
			add(BlockInit.ARAUCARIA_SIGN.get(), 5, 5);
			add(BlockInit.ARAUCARIA_SLAB.get(), 5, 5);
			add(BlockInit.ARAUCARIA_STAIRS.get(), 5, 5);
			add(BlockInit.ARAUCARIA_TRAPDOOR.get(), 5, 5);
			add(BlockInit.ARAUCARIA_WALL_SIGN.get(), 5, 5);
			add(BlockInit.ARAUCARIA_WOOD.get(), 5, 5);
			add(BlockInit.STRIPPED_ARAUCARIA_LOG.get(), 5, 5);
			add(BlockInit.STRIPPED_ARAUCARIA_WOOD.get(), 5, 5);
			
			add(BlockInit.CONIFER_LOG.get(), BlockInit.STRIPPED_CONIFER_LOG.get());
			add(BlockInit.CONIFER_WOOD.get(), BlockInit.STRIPPED_CONIFER_WOOD.get());
			add(BlockInit.GINKGO_LOG.get(), BlockInit.STRIPPED_GINKGO_LOG.get());
			add(BlockInit.GINKGO_WOOD.get(), BlockInit.STRIPPED_GINKGO_WOOD.get());
			add(BlockInit.ARAUCARIA_LOG.get(), BlockInit.STRIPPED_ARAUCARIA_LOG.get());
			add(BlockInit.ARAUCARIA_WOOD.get(), BlockInit.STRIPPED_ARAUCARIA_WOOD.get());
			
			add(BlockInit.MOSSY_DIRT.get());

			farm(BlockInit.MOSSY_DIRT.get());

			ModUtil.LOGGER.debug("Finished: Adding Things to Maps");
		});
		
		event.enqueueWork(() -> 
		{
			ModUtil.LOGGER.debug("Loading: Making Dimension Pieces");

			PermianDimension.init();
			JurassicDimension.init();

			ModUtil.LOGGER.debug("Finished: Making Dimension Pieces");
		});	
	}
	
	@SubscribeEvent
	public static void onRegisterWorldCarvers(Register<WorldCarver<?>> event)
	{
		ModUtil.LOGGER.debug("Loading: Making World Carvers");

		WorldCarverInit.init(event);

		ModUtil.LOGGER.debug("Finished: Making World Carvers");
	}
	
	@SubscribeEvent
	public static void onRegisterFeatures(Register<Feature<?>> event)
	{
		ModUtil.LOGGER.debug("Loading: Making Features");

		FeatureInit.init(event);
		ConfiguredFeatureInit.init();

		ModUtil.LOGGER.debug("Finished: Making Features");
	}

	public void clientSetup(FMLClientSetupEvent event) 
	{
		ModUtil.LOGGER.debug("Loading: Dimension Renders");

		DimensionRenderInfo permian = new PermianDimensionRenderInfo();
		DimensionRenderInfo.EFFECTS.put(new ResourceLocation(ModUtil.ID, "permian_render"), permian);
		
		DimensionRenderInfo jurassic = new JurassicDimensionRenderInfo();
		DimensionRenderInfo.EFFECTS.put(new ResourceLocation(ModUtil.ID, "jurassic_render"), jurassic);

		ModUtil.LOGGER.debug("Finished: Dimension Renders");
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
	{
		ModUtil.LOGGER.debug("Loading: Spawn Eggs");
		
		ModSpawnEggItem.initSpawnEggs();
		
		ModUtil.LOGGER.debug("Finished: Spawn Eggs");
	}
	
	public static void add(Block logBlock, Block strippedLogBlock)
	{
		AxeItem.STRIPABLES = Maps.newHashMap(AxeItem.STRIPABLES);
		AxeItem.STRIPABLES.put(logBlock, strippedLogBlock);
	}
	
	public static void add(Block block, int encouragement, int flammability) 
	{
		FireBlock fire = (FireBlock) Blocks.FIRE;
		fire.setFlammable(block, encouragement, flammability);
	}
	
	public static void add(Block grass)
	{
		Map<Block, BlockState> FLATTENABLES = new HashMap<>(ShovelItem.FLATTENABLES);
		FLATTENABLES.put(grass, Blocks.GRASS_PATH.defaultBlockState());
		ShovelItem.FLATTENABLES = FLATTENABLES;
	}
	
	public static void farm(Block grass)
	{
		HoeItem.TILLABLES = Maps.newHashMap(HoeItem.TILLABLES);
		HoeItem.TILLABLES.put(grass, Blocks.FARMLAND.defaultBlockState());
	}
}
