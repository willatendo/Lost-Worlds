package lostworlds.core.util.registry;

import lostworlds.common.items.ModFoodItem;
import lostworlds.common.items.ModItem;
import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.FluidInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.init.PaintingInit;
import lostworlds.core.init.ParticleInit;
import lostworlds.core.init.RecipeSerialiserInit;
import lostworlds.core.init.SoundInit;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.reference.ModReference;
import lostworlds.world.init.BiomeInit;
import lostworlds.world.init.SurfaceBuilderInit;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
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
	public static final DeferredRegister<Fluid> FLUID_REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, ModReference.ID);
	public static final DeferredRegister<ContainerType<?>> CONTAINER_REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, ModReference.ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModReference.ID);
	public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ModReference.ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ModReference.ID);
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDER_REGISTRY = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, ModReference.ID);
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, ModReference.ID);
	
	//Registers
	public static RegistryObject<Item> makeAdvancedItem(String id, Item item)
	{
		return ITEM_REGISTRY.register(id, () -> item);
	}
	
	public static RegistryObject<Item> makeSimpleItem(String id)
	{
		return makeAdvancedItem(id, new ModItem(id));
	}
	
	public static RegistryObject<Item> makeBoneItem(String id)
	{
		return makeSimpleItem(id + "_bone");
	}
	
	public static RegistryObject<Item> makeDNAItem(String id)
	{
		return makeSimpleItem(id + "_dna");
	}
		
	public static RegistryObject<Item> makeRawMeatItem(String id, Food food)
	{
		return makeAdvancedItem("raw_" + id + "_meat", new ModFoodItem("raw_" + id + "_meat", food));
	}
	
	public static RegistryObject<Item> makeCookedMeatItem(String id, Food food)
	{
		return makeAdvancedItem("cooked_" + id + "_meat", new ModFoodItem("cooked_" + id + "_meat", food));
	}
	
	public static RegistryObject<Item> makeSpawnEggItem(String id, NonNullSupplier<EntityType<?>> entityIn, int primaryColour, int secondaryColour)
	{
		return makeAdvancedItem(id + "_spawn_egg", new ModSpawnEggItem(entityIn, primaryColour, secondaryColour, id + "_spawn_egg"));
	}
	
	public static void registry() 
	{
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		PARTICLE_REGISTRY.register(bus);
		SOUND_REGISTRY.register(bus);
		RECIPE_SERIALISER_REGISTRY.register(bus);
		ITEM_REGISTRY.register(bus);
		PAINTING_REGISTRY.register(bus);
		FLUID_REGISTRY.register(bus);
		CONTAINER_REGISTRY.register(bus);
		TILE_ENTITY_REGISTRY.register(bus);
		BLOCK_REGISTRY.register(bus);
		ENTITY_REGISTRY.register(bus);
		SURFACE_BUILDER_REGISTRY.register(bus);
		BIOME_REGISTRY.register(bus);
		
		ParticleInit.initParticles();
		SoundInit.initSounds();
		RecipeSerialiserInit.initRecipeSerialisers();
		ItemInit.initItems();
		PaintingInit.initPaintings();
		FluidInit.initFluids();
		TileEntityInit.initTileEntities();
		BlockInit.initBlocks();
		EntityInit.initEntities();
		SurfaceBuilderInit.initSurfaceBuilders();
		BiomeInit.initBiomes();
	}
}
