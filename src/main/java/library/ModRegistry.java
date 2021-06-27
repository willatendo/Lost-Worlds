package library;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.objectweb.asm.Type;

import library.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class ModRegistry
{	
	public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ModUtil.ID);
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModUtil.ID);
	public static final DeferredRegister<SoundEvent> SOUND_REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModUtil.ID);
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ModUtil.ID);
	public static final DeferredRegister<PaintingType> PAINTING_REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, ModUtil.ID);
	public static final DeferredRegister<ContainerType<?>> CONTAINER_REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, ModUtil.ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModUtil.ID);
	public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ModUtil.ID);
	public static final DeferredRegister<BlockPlacerType<?>> BLOCK_PLACER_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_PLACER_TYPES, ModUtil.ID);
	public static final DeferredRegister<PointOfInterestType> POINTS_OF_INTEREST_REGISTRY = DeferredRegister.create(ForgeRegistries.POI_TYPES, ModUtil.ID);
	public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS_REGISTRY = DeferredRegister.create(ForgeRegistries.PROFESSIONS, ModUtil.ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ModUtil.ID);
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_REGISTRY = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, ModUtil.ID);
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDER_REGISTRY = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, ModUtil.ID);
	public static final DeferredRegister<Structure<?>> STRUCTURE_REGISTRY = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, ModUtil.ID);
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, ModUtil.ID);

	public static void register(IEventBus bus)
	{
		PARTICLE_REGISTRY.register(bus);
		RECIPE_SERIALIZERS.register(bus);
		SOUND_REGISTRY.register(bus);
		ITEM_REGISTRY.register(bus);
		PAINTING_REGISTRY.register(bus);
		CONTAINER_REGISTRY.register(bus);	
		TILE_ENTITY_REGISTRY.register(bus);
		BLOCK_REGISTRY.register(bus);
		BLOCK_PLACER_REGISTRY.register(bus);
		POINTS_OF_INTEREST_REGISTRY.register(bus);
		VILLAGER_PROFESSIONS_REGISTRY.register(bus);
		ENTITY_REGISTRY.register(bus);
		FOLIAGE_PLACER_REGISTRY.register(bus);
		SURFACE_BUILDER_REGISTRY.register(bus);
		STRUCTURE_REGISTRY.register(bus);
		BIOME_REGISTRY.register(bus);
		
		registries();
	}
	
	public static void registries() 
	{
		getInstances(Init.class, ModRegistry.class);
	}
	
	private static <T> List<T> getInstances(Class<?> annotationClass, Class<T> instanceClass) 
	{
		Type annotationType = Type.getType(annotationClass);
		List<ModFileScanData> allScanData = ModList.get().getAllScanData();
		Set<String> pluginClassNames = new LinkedHashSet<>();
		for (ModFileScanData scanData : allScanData) 
		{
			Iterable<ModFileScanData.AnnotationData> annotations = scanData.getAnnotations();
			for(ModFileScanData.AnnotationData a : annotations) 
			{
				if(Objects.equals(a.getAnnotationType(), annotationType)) 
				{
					String memberName = a.getMemberName();
					pluginClassNames.add(memberName);
				}
			}
		}
		List<T> instances = new ArrayList<>();
		for(String className : pluginClassNames) 
		{
			try 
			{
				Class<?> asmClass = Class.forName(className);
				Class<? extends T> asmInstanceClass = asmClass.asSubclass(instanceClass);
				T instance = asmInstanceClass.newInstance();
				instances.add(instance);
			} 
			catch(ClassNotFoundException | InstantiationException | IllegalAccessException | LinkageError e) 
			{
				
			}
		}
		return instances;
	}
}