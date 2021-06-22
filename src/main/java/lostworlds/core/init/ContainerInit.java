package lostworlds.core.init;

import java.lang.reflect.Field;

import lostworlds.common.container.AnalyserContainer;
import lostworlds.common.container.DNAExtractorContainer;
import lostworlds.common.container.DNAInjectorContainer;
import lostworlds.common.container.FossilCleanerContainer;
import lostworlds.common.container.FossilGrinderContainer;
import lostworlds.common.container.TimeMachineContainer;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerInit 
{	
	public static final RegistryObject<ContainerType<FossilCleanerContainer>> FOSSIL_CLEANER_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("fossil_cleaner_container", () -> IForgeContainerType.create(FossilCleanerContainer::new));
	public static final RegistryObject<ContainerType<FossilGrinderContainer>> FOSSIL_GRINDER_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("fossil_grinder_container", () -> IForgeContainerType.create(FossilGrinderContainer::new));
	public static final RegistryObject<ContainerType<DNAExtractorContainer>> DNA_EXTRACTOR_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("dna_extractor_container", () -> IForgeContainerType.create(DNAExtractorContainer::new));
	public static final RegistryObject<ContainerType<AnalyserContainer>> ANALYSER_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("analyser_container", () -> IForgeContainerType.create(AnalyserContainer::new));
	public static final RegistryObject<ContainerType<DNAInjectorContainer>> DNA_INJECTOR_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("dna_injector_container", () -> IForgeContainerType.create(DNAInjectorContainer::new));

	public static final RegistryObject<ContainerType<TimeMachineContainer>> TIME_MACHINE_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("time_machine_container", () -> IForgeContainerType.create(TimeMachineContainer::new));
 	
	//Registry
	public static ContainerType register(ContainerType type, String name) 
	{
		type.setRegistryName(name);
		return type;
	}
	
	@SubscribeEvent
	public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) 
	{
		try 
		{
			for(Field f : ContainerInit.class.getDeclaredFields()) 
			{
				Object obj = f.get(null);
				if(obj instanceof ContainerType) 
				{
					event.getRegistry().register((ContainerType) obj);
				} 
				else if(obj instanceof ContainerType[]) 
				{
					for(ContainerType container : (ContainerType[]) obj) 
					{
						event.getRegistry().register(container);
					}
				}
			}
		} 
		catch(IllegalAccessException e) 
		{
			throw new RuntimeException(e);
		}
	}
	
	public static void initContianers() { ModUtil.LOGGER.debug("Registering: Mod Containers"); }
}
