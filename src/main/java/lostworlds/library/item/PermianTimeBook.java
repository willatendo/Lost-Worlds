package lostworlds.library.item;

import lostworlds.library.dimension.permian.PermianInit;
import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import lostworlds.library.util.ModTeleporter;
import lostworlds.library.util.ModUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class PermianTimeBook extends Item
{
	protected PermianTimeBook() 
	{
		super(new Properties().tab(ModItemGroup.ITEMS).stacksTo(1).rarity(Rarity.RARE));
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
                RegistryKey<World> registrykey = entity.level.dimension() == PermianInit.PERMIAN_WORLD ? World.OVERWORLD : PermianInit.PERMIAN_WORLD;
                ServerWorld serverworld1 = minecraftserver.getLevel(registrykey);
                if(entity.level.dimension() == World.NETHER || entity.level.dimension() == World.END)
                {
                	entity.sendMessage(ModUtil.tTC("timeBook", "doesnt_work"), entity.getUUID());
                }
                else if(serverworld1 != null && !entity.isPassenger()) 
                {
                    entity.changeDimension(serverworld1, new ModTeleporter(serverworld1));
                    if(registrykey.equals(PermianInit.PERMIAN_WORLD))
                    {
                    	entity.sendMessage(ModUtil.tTC("timeBook", "transport_to_permian"), entity.getUUID());
                    }
                    else
                    {
                    	entity.sendMessage(ModUtil.tTC("timeBook", "transport_to_overworld"), entity.getUUID());
                    }
                }
			}
		}
			
		return super.use(world, entity, hand);
	}
	
	public static Item create()
	{
		Item item = new PermianTimeBook();
		ModRegistry.register("permian_era_time_book", item);
		return item;
	}
}
