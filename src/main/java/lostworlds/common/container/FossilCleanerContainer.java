package lostworlds.common.container;

import lostworlds.client.slot.FossilCleanerFuelSlot;
import lostworlds.common.tileentity.FossilCleanerTileEntity;
import lostworlds.core.init.ContainerInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;

public class FossilCleanerContainer extends Container
{
	private final IInventory container;
	private final World level;
	private final IRecipeType<FurnaceRecipe> recipeType = IRecipeType.SMELTING;
	
	public FossilCleanerContainer(int windowID, PlayerInventory playerInv, PacketBuffer data) 
	{
		super(ContainerInit.FOSSIL_CLEANER_CONTAINER.get(), windowID);
		this.level = null;
		this.container = null;
 	}
	
	public FossilCleanerContainer(int windowID, PlayerInventory playerInv, FossilCleanerTileEntity tile) 
	{
		super(ContainerInit.FOSSIL_CLEANER_CONTAINER.get(), windowID);
		this.container = tile;
		this.level = playerInv.player.level;
		
		this.addSlot(new Slot(tile, 0, 56, 17));
		this.addSlot(new FossilCleanerFuelSlot(this, tile, 1, 56, 54));
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
	}

	@Override
	public boolean stillValid(PlayerEntity player) 
	{
		return this.container.stillValid(player);
	}
	
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
				if(this.canSmelt(itemstack1)) 
				{
					if(!this.moveItemStackTo(itemstack1, 0, 1, false)) 
					{
						return ItemStack.EMPTY;
					}
				} 
				else if(this.isFuel(itemstack1)) 
				{
					if(!this.moveItemStackTo(itemstack1, 1, 2, false)) 
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected boolean canSmelt(ItemStack stack) 
	{
		return this.level.getRecipeManager().getRecipeFor((IRecipeType)this.recipeType, new Inventory(stack), this.level).isPresent();
	}
	
	public boolean isFuel(ItemStack stack) 
	{
		return FossilCleanerTileEntity.isFuel(stack);
	}
}
