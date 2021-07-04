package lostworlds.library.util;

import java.util.Set;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import lostworlds.content.server.init.BiomeInit;
import lostworlds.content.server.init.BlockInit;
import lostworlds.content.server.init.ContainerInit;
import lostworlds.content.server.init.FossilInit;
import lostworlds.content.server.init.ItemInit;
import lostworlds.content.server.init.ParticleInit;
import lostworlds.content.server.init.PointOfInterestInit;
import lostworlds.content.server.init.RecipeInit;
import lostworlds.content.server.init.SurfaceBuilderInit;
import lostworlds.content.server.init.TileEntityInit;
import lostworlds.content.server.init.VillagerProfessionInit;
import lostworlds.library.villager.ModVillagerProfession;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/*
 * Author: Willatendo
 * Date: July 3, 2021
 */

public class ModRegistry 
{	
	//Int to Registry Key
	private static final Int2ObjectMap<RegistryKey<Biome>> TO_NAME = new Int2ObjectArrayMap<>();
	
	//Deferred Registers
	private static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ModUtil.ID);
	private static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModUtil.ID);
	private static final DeferredRegister<SoundEvent> SOUND_REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModUtil.ID);
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ModUtil.ID);
	private static final DeferredRegister<PaintingType> PAINTING_REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, ModUtil.ID);
	public static final DeferredRegister<ContainerType<?>> CONTAINER_REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, ModUtil.ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModUtil.ID);
	private static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ModUtil.ID);
	private static final DeferredRegister<BlockPlacerType<?>> BLOCK_PLACER_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_PLACER_TYPES, ModUtil.ID);
	private static final DeferredRegister<PointOfInterestType> POINTS_OF_INTEREST_REGISTRY = DeferredRegister.create(ForgeRegistries.POI_TYPES, ModUtil.ID);
	private static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS_REGISTRY = DeferredRegister.create(ForgeRegistries.PROFESSIONS, ModUtil.ID);
	private static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ModUtil.ID);
	private static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_REGISTRY = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, ModUtil.ID);
	private static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDER_REGISTRY = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, ModUtil.ID);
	private static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, ModUtil.ID);
	
	//Registers
	public static RegistryObject<BasicParticleType> register(String id)
	{
		return PARTICLE_REGISTRY.register(id, () -> new BasicParticleType(true));
	}
	
	public static RegistryObject<IRecipeSerializer<?>> register(String id, IRecipeSerializer<?> recipe)
	{
		return RECIPE_SERIALIZERS.register(id, () -> recipe);
	}
	
	public static RegistryObject<Item> register(String id, Item item)
	{
		return ITEM_REGISTRY.register(id, () -> item);
	}
	
	public static RegistryObject<Block> register(String id, Block block)
	{
		return BLOCK_REGISTRY.register(id, () -> block);
	}
	
	public static RegistryObject<PointOfInterestType> register(String id, Set<BlockState> state)
	{
		return POINTS_OF_INTEREST_REGISTRY.register(id, () -> new PointOfInterestType(id, state, 1, 1));
	}
	
	public static RegistryObject<ModVillagerProfession> register(String id, NonNullSupplier<PointOfInterestType> poi, @Nullable SoundEvent sounds)
	{
		return VILLAGER_PROFESSIONS_REGISTRY.register(id, () -> new ModVillagerProfession(id, poi, sounds));
	}
	
	public static RegistryObject<Biome> register(int numberId, RegistryKey<Biome> biomeKey, String id, Biome biome) 
	{
		TO_NAME.put(numberId, biomeKey);
		return BIOME_REGISTRY.register(id, () -> biome);
	}
	
	public static RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> register(String id, SurfaceBuilder<SurfaceBuilderConfig> surfaceBuilder)
	{
		return SURFACE_BUILDER_REGISTRY.register(id, () -> surfaceBuilder);
	}
	
	//Registers Deferred Registers
	public static void register(IEventBus bus)
	{
		ModUtil.LOGGER.debug("Starting: Setting Up Registries");
		
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
		BIOME_REGISTRY.register(bus);
		
		ParticleInit.init();
		RecipeInit.init();
		ItemInit.init();
		FossilInit.init();
		TileEntityInit.init();
		ContainerInit.init();
		BlockInit.init();
		PointOfInterestInit.init();
		VillagerProfessionInit.init();
		SurfaceBuilderInit.init();
		BiomeInit.init();
		
		ModUtil.LOGGER.debug("Finished: Setting Up Registries");
	}
}
