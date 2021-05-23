package lostworlds.core.util.registry;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.init.PaintingInit;
import lostworlds.core.init.ParticleInit;
import lostworlds.core.init.PointsOfInterestInit;
import lostworlds.core.init.RecipeSerialiserInit;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.init.VillagerProfessionInit;
import lostworlds.core.util.ModUtil;
import lostworlds.world.init.BiomeInit;
import lostworlds.world.init.FoliagePlacerInit;
import lostworlds.world.init.StructureInit;
import lostworlds.world.init.SurfaceBuilderInit;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegistry 
{
	//Deferred Registers
	public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ModUtil.ID);
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALISER_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModUtil.ID);
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ModUtil.ID);
	public static final DeferredRegister<PaintingType> PAINTING_REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, ModUtil.ID);
	public static final DeferredRegister<ContainerType<?>> CONTAINER_REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, ModUtil.ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModUtil.ID);
	public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ModUtil.ID);
	public static final DeferredRegister<PointOfInterestType> POINTS_OF_INTEREST_REGISTRY = DeferredRegister.create(ForgeRegistries.POI_TYPES, ModUtil.ID);
	public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS_REGISTRY = DeferredRegister.create(ForgeRegistries.PROFESSIONS, ModUtil.ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ModUtil.ID);
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_REGISTRY = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, ModUtil.ID);
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDER_REGISTRY = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, ModUtil.ID);
	public static final DeferredRegister<Structure<?>> STRUCTURE_REGISTRY = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, ModUtil.ID);
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, ModUtil.ID);
	
	public static void registry() 
	{
		//Bus
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		//Deferred Registers Registers
		PARTICLE_REGISTRY.register(bus);
		RECIPE_SERIALISER_REGISTRY.register(bus);
		ITEM_REGISTRY.register(bus);
		PAINTING_REGISTRY.register(bus);
		CONTAINER_REGISTRY.register(bus);	
		TILE_ENTITY_REGISTRY.register(bus);
		BLOCK_REGISTRY.register(bus);
		POINTS_OF_INTEREST_REGISTRY.register(bus);
		VILLAGER_PROFESSIONS_REGISTRY.register(bus);
		ENTITY_REGISTRY.register(bus);
		FOLIAGE_PLACER_REGISTRY.register(bus);
		SURFACE_BUILDER_REGISTRY.register(bus);
		STRUCTURE_REGISTRY.register(bus);
		BIOME_REGISTRY.register(bus);
		
		//Class Loaders
		ParticleInit.initParticles();
		RecipeSerialiserInit.initRecipeSerialisers();
		ItemInit.initItems();
		PaintingInit.initPaintings();
		TileEntityInit.initTileEntities(); 
		BlockInit.initBlocks();
		PointsOfInterestInit.initPointsOfInterest();;
		VillagerProfessionInit.initVillageProfession();
		EntityInit.initEntities();
		FoliagePlacerInit.initFoliagePlacers();
		SurfaceBuilderInit.initSurfaceBuilders();
		StructureInit.initStructures();
		BiomeInit.initBiomes();
	}
}
