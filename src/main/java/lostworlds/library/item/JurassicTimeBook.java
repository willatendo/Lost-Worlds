package lostworlds.library.item;

import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class JurassicTimeBook extends Item
{
	protected JurassicTimeBook() 
	{
		super(new Properties().tab(ModItemGroup.ITEMS).stacksTo(1).rarity(Rarity.RARE));
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand)
	{
		return null;
		/*
		if(!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) 
		{
			if(entity.level instanceof ServerWorld) 
			{
				ServerWorld serverworld = (ServerWorld)entity.level;
                MinecraftServer minecraftserver = serverworld.getServer();
                RegistryKey<World> registrykey = entity.level.dimension() == PermianDimension.PERMIAN_WORLD ? World.OVERWORLD : PermianDimension.PERMIAN_WORLD;
                ServerWorld serverworld1 = minecraftserver.getLevel(registrykey);
                if(entity.level.dimension() == World.NETHER || entity.level.dimension() == World.END)
                {
                	entity.sendMessage(ModUtil.tTC("timebook", "doesnt_work"), entity.getUUID());
                }
                else if(serverworld1 != null && !entity.isPassenger()) 
                {
                    entity.changeDimension(serverworld1, new ModTeleporter(serverworld1));
                    if(registrykey.equals(PermianDimension.PERMIAN_WORLD))
                    {
                    	entity.sendMessage(ModUtil.tTC("timebook", "transport_to_permian"), entity.getUUID());
                    }
                    else
                    {
                    	entity.sendMessage(ModUtil.tTC("timebook", "transport_to_overworld"), entity.getUUID());
                    }
                }
			}
		}
		*/
	}
	
	public static Item create()
	{
		Item item = new JurassicTimeBook();
		ModRegistry.register("jurassic_era_time_book", item);
		return item;
	}
}
