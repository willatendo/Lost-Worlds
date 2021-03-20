package lostworlds.core.util.registry;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.init.SoundInit;
import lostworlds.core.util.reference.ModReference;
import lostworlds.world.init.BiomeInit;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegistry 
{
	//Deferred Registers
	public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ModReference.ID);
	public static final DeferredRegister<SoundEvent> SOUND_REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModReference.ID);
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALISER_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModReference.ID);
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ModReference.ID);
	public static final DeferredRegister<PaintingType> PAINTING_REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, ModReference.ID);
	public static final DeferredRegister<ContainerType<?>> CONTAINER_REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, ModReference.ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModReference.ID);
	public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ModReference.ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ModReference.ID);
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDER_REGISTRY = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, ModReference.ID);
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, ModReference.ID);
	
	//Demenstions
	public static final RegistryKey<World> PLEISTOCENE_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.PLEISTOCENE);
	public static final RegistryKey<World> CRETACOUS_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.CRETACOUS);
	public static final RegistryKey<World> JURASSIC_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.JURASSIC);
	public static final RegistryKey<World> TRIASSIC_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.TRIASSIC);
	public static final RegistryKey<World> PERMIAN_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.PERMIAN);
	public static final RegistryKey<World> CARBONIFEROUS_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.CARBONIFEROUS);
	public static final RegistryKey<World> DEVONIAN_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.DEVONIAN);
	public static final RegistryKey<World> SILURIAN_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.SILURIAN);
	public static final RegistryKey<World> ORDOVICIAN_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.ORDOVICIAN);	
	public static final RegistryKey<World> CAMBRIAN_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.CAMBRIAN);	
	public static final RegistryKey<World> FROZEN_PRECAMBRIAN_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.FROZEN_PRECAMBRIAN);	
	public static final RegistryKey<World> PRECAMBRIAN_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ModReference.PRECAMBRIAN);	
	
	public static void registry() 
	{
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		PARTICLE_REGISTRY.register(bus);
		SOUND_REGISTRY.register(bus);
		RECIPE_SERIALISER_REGISTRY.register(bus);
		ITEM_REGISTRY.register(bus);
		PAINTING_REGISTRY.register(bus);
		CONTAINER_REGISTRY.register(bus);
		TILE_ENTITY_REGISTRY.register(bus);
		BLOCK_REGISTRY.register(bus);
		ENTITY_REGISTRY.register(bus);
		SURFACE_BUILDER_REGISTRY.register(bus);
		BIOME_REGISTRY.register(bus);
		
		SoundInit.initSounds();
		ItemInit.initItems();
		BlockInit.initBlocks();
		EntityInit.initEntities();
		BiomeInit.initBiomes();
	}
}
