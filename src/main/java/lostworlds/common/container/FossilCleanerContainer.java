package lostworlds.common.container;

import lostworlds.common.recipe.FossilGrinderRecipe;
import lostworlds.common.slot.FossilCleanerFuelSlot;
import lostworlds.common.tileentity.FossilCleanerTileEntity;
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
import net.minecraft.util.IntArray;
import net.minecraft.world.World;

public class FossilCleanerContainer extends Container
{
	private final IInventory container;
	private final IIntArray data;
	private final World level;
	private final IRecipeType<FossilGrinderRecipe> recipeType = RecipeInit.FOSSIL_GRINDER_RECIPE;
	public final FossilCleanerTileEntity tile;
	
	public FossilCleanerContainer(int windowID, PlayerInventory playerInv, FossilCleanerTileEntity tileEntity, IInventory tile, IIntArray array) 
	{
		super(ContainerInit.FOSSIL_GRINDER_CONTAINER.get(), windowID);
		this.container = tile;
		this.level = playerInv.player.level;
		this.data = array;
		this.tile = tileEntity;
		
		this.addSlot(new Slot(tile, 0, 53, 35));
		this.addSlot(new FossilCleanerFuelSlot(this, tile, 1, 56, 53));
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
		
		this.addDataSlots(array);
	}
	
	public FossilCleanerContainer(int windowID, PlayerInventory playerInv, PacketBuffer data) 
	{
		this(windowID, playerInv, new FossilCleanerTileEntity(), new Inventory(3), new IntArray(4));
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
			if(i == 1) 
			{
				if(!this.moveItemStackTo(itemstack1, 2, 38, true)) 
				{
					return ItemStack.EMPTY;
				}
				
				slot.onQuickCraft(itemstack1, itemstack);
			}
			else if(i != 0) 
			{
				if(canGrind(itemstack1)) 
				{
					if(!this.moveItemStackTo(itemstack1, 0, 1, false)) 
					{
						return ItemStack.EMPTY;
					}
				}
				else if(i >= 2 && i < 29) 
				{
					if(!this.moveItemStackTo(itemstack1, 29, 38, false)) 
					{
						return ItemStack.EMPTY;
					}
				} 
				else if(i >= 29 && i < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) 
				{
					return ItemStack.EMPTY;
				}
			}
			else if(!this.moveItemStackTo(itemstack1, 2, 38, false)) 
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
	
	protected boolean canGrind(ItemStack stack) 
	{
		return this.level.getRecipeManager().getRecipeFor((IRecipeType)this.recipeType, new Inventory(stack), this.level).isPresent();
	}
	
	public boolean isFuel(ItemStack stack) 
	{
		return FossilCleanerTileEntity.isFuel(stack);
	}
}
