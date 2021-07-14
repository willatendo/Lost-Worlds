package lostworlds.library.item;

import lostworlds.content.server.init.DimensionInit;
import lostworlds.library.enums.TimeEras;
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
 * Date: July 5, 2021
 */

public class TimeBookItem extends Item
{
	private static TimeEras era;
	
	protected TimeBookItem(TimeEras eras)
	{
		super(new Properties().tab(ModItemGroup.ITEMS).stacksTo(1).rarity(Rarity.RARE).fireResistant());
		era = eras;
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand)
	{
		if(!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) 
		{
			if(entity.level instanceof ServerWorld) 
			{	
                if(entity.level.dimension() == World.NETHER || entity.level.dimension() == World.END)
                {
                	entity.sendMessage(ModUtil.tTC("timeBook", "doesnt_work"), entity.getUUID());
                }
                
                if(era == TimeEras.PERMIAN_PERIOD)
                {
                	ServerWorld serverworld = (ServerWorld)entity.level;
                    MinecraftServer minecraftserver = serverworld.getServer();
                    RegistryKey<World> registrykey = entity.level.dimension() == DimensionInit.PERMIAN_WORLD ? World.OVERWORLD : DimensionInit.PERMIAN_WORLD;
                    ServerWorld serverworld1 = minecraftserver.getLevel(registrykey);
                    if(serverworld1 != null && !entity.isPassenger()) 
                    {
                        entity.changeDimension(serverworld1, new ModTeleporter(serverworld1));
                        if(registrykey.equals(DimensionInit.PERMIAN_WORLD))
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
		}
			
		return super.use(world, entity, hand);
	}
	
	@Override
	public boolean isFoil(ItemStack stack) 
	{
		return true;
	}
	
	public static Item create(TimeEras era)
	{
		Item item = new TimeBookItem(era);
		ModRegistry.register(era.toString().toLowerCase() + "_time_book", item);
		return item;
	}
}
