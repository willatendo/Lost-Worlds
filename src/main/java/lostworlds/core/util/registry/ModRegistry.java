package lostworlds.core.util.registry;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.init.PaintingInit;
import lostworlds.core.init.ParticleInit;
import lostworlds.core.init.RecipeSerialiserInit;
import lostworlds.core.init.SoundInit;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.ModID;
import lostworlds.world.init.BiomeInit;
import lostworlds.world.init.FoliagePlacerInit;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegistry 
{
	//Deferred Registers
	public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ModID.ID);
	public static final DeferredRegister<SoundEvent> SOUND_REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModID.ID);
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALISER_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModID.ID);
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ModID.ID);
	public static final DeferredRegister<PaintingType> PAINTING_REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, ModID.ID);
	public static final DeferredRegister<ContainerType<?>> CONTAINER_REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, ModID.ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModID.ID);
	public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ModID.ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ModID.ID);
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_REGISTRY = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, ModID.ID);
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, ModID.ID);
	
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
		FOLIAGE_PLACER_REGISTRY.register(bus);
		BIOME_REGISTRY.register(bus);
		
		ParticleInit.initParticles();
		SoundInit.initSounds();
		RecipeSerialiserInit.initRecipeSerialisers();
		ItemInit.initItems();
		PaintingInit.initPaintings();
		TileEntityInit.initTileEntities(); 
		BlockInit.initBlocks();
		EntityInit.initEntities();
		FoliagePlacerInit.initFoliagePlacers();
		BiomeInit.initBiomes();
	}
}
