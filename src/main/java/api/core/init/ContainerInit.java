package api.core.init;

import java.lang.reflect.Field;

import library.Init;
import library.ModRegistry;
import library.containers.machines.AnalyserContainer;
import library.containers.machines.DNAExtractorContainer;
import library.containers.machines.DNAInjectorContainer;
import library.containers.machines.FossilCleanerContainer;
import library.containers.machines.FossilGrinderContainer;
import library.containers.machines.TimeMachineContainer;
import library.containers.pottery.KylixContainer;
import library.util.ModUtil;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Init
@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerInit extends ModRegistry
{	
	//Machines
	public static final RegistryObject<ContainerType<FossilCleanerContainer>> FOSSIL_CLEANER_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("fossil_cleaner_container", () -> IForgeContainerType.create(FossilCleanerContainer::new));
	public static final RegistryObject<ContainerType<FossilGrinderContainer>> FOSSIL_GRINDER_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("fossil_grinder_container", () -> IForgeContainerType.create(FossilGrinderContainer::new));
	public static final RegistryObject<ContainerType<DNAExtractorContainer>> DNA_EXTRACTOR_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("dna_extractor_container", () -> IForgeContainerType.create(DNAExtractorContainer::new));
	public static final RegistryObject<ContainerType<AnalyserContainer>> ANALYSER_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("analyser_container", () -> IForgeContainerType.create(AnalyserContainer::new));
	public static final RegistryObject<ContainerType<DNAInjectorContainer>> DNA_INJECTOR_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("dna_injector_container", () -> IForgeContainerType.create(DNAInjectorContainer::new));
	
	//Time Machine
	public static final RegistryObject<ContainerType<TimeMachineContainer>> TIME_MACHINE_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("time_machine_container", () -> IForgeContainerType.create(TimeMachineContainer::new));
 	
	//Pottery
	public static final RegistryObject<ContainerType<KylixContainer>> KYLIX_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("kylix_container", () -> IForgeContainerType.create(KylixContainer::new));
	
	//Registry
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
}
