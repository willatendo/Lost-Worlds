package lostworlds.common.recipe;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class FossilCleanerRecipe implements IRecipe<IInventory>
{
	

	@Override
	public boolean matches(IInventory p_77569_1_, World p_77569_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack assemble(IInventory p_77572_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getResultItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceLocation getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRecipeType<?> getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
