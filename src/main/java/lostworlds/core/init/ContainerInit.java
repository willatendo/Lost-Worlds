package lostworlds.core.init;

import lostworlds.common.container.FossilCleanerContianer;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ContainerInit 
{
	public static final RegistryObject<ContainerType<FossilCleanerContianer>> FOSSIL_CLEANER_CONTAINER = ModRegistry.CONTAINER_REGISTRY.register("fossil_cleaner_container", () -> IForgeContainerType.create(FossilCleanerContianer::new));
	
	//Registry
	public static void initContainers() { }
}
