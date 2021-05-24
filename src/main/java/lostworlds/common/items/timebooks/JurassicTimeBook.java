package lostworlds.common.items.timebooks;

import lostworlds.core.util.ModUtil;
import lostworlds.world.dimension.jurassic.JurassicDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class JurassicTimeBook extends Item
{	
	public JurassicTimeBook(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) 
	{
		if(!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) 
		{
			if(entity.level instanceof ServerWorld) 
			{
				ServerWorld serverworld = (ServerWorld)entity.level;
                MinecraftServer minecraftserver = serverworld.getServer();
                RegistryKey<World> registrykey = entity.level.dimension() == JurassicDimension.JURASSIC_WORLD ? World.OVERWORLD : JurassicDimension.JURASSIC_WORLD;
                ServerWorld serverworld1 = minecraftserver.getLevel(registrykey);
            	if(serverworld1 != null && !entity.isPassenger()) 
                {
                    entity.changeDimension(serverworld1, new ModTeleporter(serverworld1));
                    if(registrykey.equals(JurassicDimension.JURASSIC_WORLD))
                    {
                    	entity.sendMessage(ModUtil.tTC("transport_to_jurassic"), entity.getUUID());
                    }
                    else
                    {
                    	entity.sendMessage(ModUtil.tTC("transport_to_overworld"), entity.getUUID());
                    }
                }
			}
		}
		return super.use(world, entity, hand);
	}
}
