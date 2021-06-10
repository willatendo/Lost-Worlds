package lostworlds.common.container;

import lostworlds.common.recipe.DNAExtractorRecipe;
import lostworlds.common.slot.SoftTissueSlot;
import lostworlds.common.slot.VileSlot;
import lostworlds.common.tileentity.DNAExtractorTileEntity;
import lostworlds.core.init.ContainerInit;
import lostworlds.core.init.ItemInit;
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

public class DNAExtractorContainer extends Container
{
	private final IInventory container;
	private final IIntArray data;
	private final World level;
	private final IRecipeType<DNAExtractorRecipe> recipeType = RecipeInit.DNA_EXTRACTOR_RECIPE;
	public final DNAExtractorTileEntity tile;
	
	public DNAExtractorContainer(int windowID, PlayerInventory playerInv, DNAExtractorTileEntity tileEntity, IInventory tile, IIntArray array) 
	{
		super(ContainerInit.DNA_EXTRACTOR_CONTAINER.get(), windowID);
		this.container = tile;
		this.level = playerInv.player.level;
		this.data = array;
		this.tile = tileEntity;
		
		this.addSlot(new SoftTissueSlot(tile, 0, 56, 25));
		this.addSlot(new VileSlot(tile, 1, 56, 45));
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
	
	public DNAExtractorContainer(int windowID, PlayerInventory playerInv, PacketBuffer data) 
	{
		this(windowID, playerInv, new DNAExtractorTileEntity(), new Inventory(3), new IntArray(4));
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
			else if(i == 1)
			{
				if(this.isVile(itemstack1)) 
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
			else if(i != 1 && i != 0) 
			{
				if(this.canClean(itemstack1)) 
				{
					if(!this.moveItemStackTo(itemstack1, 0, 1, false)) 
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
	
	protected boolean isVile(ItemStack stack) 
	{
		return stack.getItem() == ItemInit.EMPTY_SYRINGE.get();
	}
}
