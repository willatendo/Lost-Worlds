package lostworlds.core.init;

import lostworlds.common.container.FossilCleanerContainer;
import lostworlds.common.container.TimeMachineContainer;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ContainerInit 
{
	public static final RegistryObject<ContainerType<FossilCleanerContainer>> FOSSIL_CLEANER_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("fossil_cleaner_container", () -> IForgeContainerType.create(FossilCleanerContainer::new));
	public static final RegistryObject<ContainerType<TimeMachineContainer>> TIME_MACHINE_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("time_machine_container", () -> IForgeContainerType.create(TimeMachineContainer::new));
 	
	//Registry
	public static void initContianers() { ModUtil.LOGGER.debug("Registering: Mod Containers"); }
}
