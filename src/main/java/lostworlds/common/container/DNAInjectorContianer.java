package lostworlds.common.container;

import lostworlds.common.recipe.DNAInjectorRecipe;
import lostworlds.common.slot.DNADiscSlot;
import lostworlds.common.slot.EggSlot;
import lostworlds.common.tileentity.DNAInjectorTileEntity;
import lostworlds.core.init.ContainerInit;
import lostworlds.core.init.RecipeInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DNAInjectorContianer extends Container
{
	private final IInventory container;
	private final IIntArray data;
	private final World level;
	private final IRecipeType<DNAInjectorRecipe> recipeType = RecipeInit.DNA_INJECTOR_RECIPE;
	public final DNAInjectorTileEntity tile;
	
	public DNAInjectorContianer(int windowID, PlayerInventory playerInv, DNAInjectorTileEntity tileEntity, IInventory tile) 
	{
		super(ContainerInit.DNA_INJECTOR_CONTAINER.get(), windowID);
		this.container = tile;
		this.level = playerInv.player.level;
		this.data = tileEntity.getInjectorData();
		this.tile = tileEntity;
		
		this.addSlot(new DNADiscSlot(tile, 0, 56, 17));
		this.addSlot(new EggSlot(tile, 1, 56, 53));
		this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 2, 116, 35));
		
		for(int i = 0; i < 3; ++i) 
		{
			for(int j = 0; j < 9; ++j) 
			{
				this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int k = 0; k < 9; ++k) 
		{
			this.addSlot(new Slot(playerInv, k, 8 + k * 18, 142));
		}
		
		this.addDataSlots(this.data);
	}
	
	public DNAInjectorContianer(int windowID, PlayerInventory playerInv, PacketBuffer data) 
	{
		this(windowID, playerInv, new DNAInjectorTileEntity(), new Inventory(3));
 	}

	@Override
	public boolean stillValid(PlayerEntity player) 
	{
		return this.container.stillValid(player);
	}
	
	@Override
	public ItemStack quickMoveStack(PlayerEntity player, int i) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(i);
		if(slot != null && slot.hasItem()) 
		{
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if(i == 2) 
			{
				if(!this.moveItemStackTo(itemstack1, 3, 39, true)) 
				{
					return ItemStack.EMPTY;
				}
				
				slot.onQuickCraft(itemstack1, itemstack);
			}
			else if(i != 1 && i != 0) 
			{
				if(canClean(itemstack1)) 
				{
					if(!this.moveItemStackTo(itemstack1, 0, 2, true)) 
					{
						return ItemStack.EMPTY;
					}
				}
				else if(i >= 3 && i < 30) 
				{
					if(!this.moveItemStackTo(itemstack1, 30, 39, false)) 
					{
						return ItemStack.EMPTY;
					}
				} 
				else if(i >= 30 && i < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) 
				{
					return ItemStack.EMPTY;
				}
			}
			else if(!this.moveItemStackTo(itemstack1, 3, 39, false)) 
			{
				return ItemStack.EMPTY;
			}
			
			if(itemstack1.isEmpty()) 
			{
				slot.set(ItemStack.EMPTY);
			}
			else 
			{
				slot.setChanged();
			}
			
			if (itemstack1.getCount() == itemstack.getCount()) 
			{
				return ItemStack.EMPTY;
			}
			
			slot.onTake(player, itemstack1);
		}
		
		return itemstack;
	}
	
	protected boolean canClean(ItemStack stack) 
	{
		return this.level.getRecipeManager().getRecipeFor((IRecipeType)this.recipeType, new Inventory(stack), this.level).isPresent();
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getProgress()
	{
		int injectingProgress = this.data.get(2);
        int injectingTotalTime = this.data.get(3);
        return injectingTotalTime != 0 && injectingProgress != 0 ? injectingProgress * 16 / injectingTotalTime : 0;
    }
}
