package lostworlds.common.villager;

import java.util.Random;

import com.google.common.base.Function;

import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;

public class ModVillagerTradesBuilder 
{
	protected Function<Random, ItemStack> price;
    protected Function<Random, ItemStack> price2;
    protected Function<Random, ItemStack> forSale;

    protected final int maxTrades;
    protected final int xp;
    protected final float priceMult;

    public ModVillagerTradesBuilder(int maxTrades, int xp, float priceMult)
    {
        this.price = null;
        this.price2 = (random) -> ItemStack.EMPTY;
        this.forSale = null;
        this.maxTrades = maxTrades;
        this.xp = xp;
        this.priceMult = priceMult;
    }

    public ModVillagerTradesBuilder setPrice(Function<Random, ItemStack> price)
    {
        this.price = price;
        return this;
    }

    public ModVillagerTradesBuilder setPrice(Item item, int min, int max)
    {
        return this.setPrice(ModVillagerTradesBuilder.createFunction(item, min, max));
    }

    public ModVillagerTradesBuilder setPrice2(Function<Random, ItemStack> price2)
    {
        this.price2 = price2;
        return this;
    }

    public ModVillagerTradesBuilder setPrice2(Item item, int min, int max)
    {
        return this.setPrice2(ModVillagerTradesBuilder.createFunction(item, min, max));
    }

    public ModVillagerTradesBuilder setForSale(Function<Random, ItemStack> forSale)
    {
        this.forSale = forSale;
        return this;
    }

    public ModVillagerTradesBuilder setForSale(Item item, int min, int max)
    {
        return this.setForSale(ModVillagerTradesBuilder.createFunction(item, min, max));
    }

    public ModVillagerTradesBuilder setEmeraldPrice(int emeralds)
    {
        return this.setPrice((random) -> new ItemStack(Items.EMERALD, emeralds));
    }

    public ModVillagerTradesBuilder setEmeraldPriceFor(int emeralds, Item item, int amt)
    {
        this.setEmeraldPrice(emeralds);
        return this.setForSale((random) -> new ItemStack(item, amt));
    }

    public ModVillagerTradesBuilder setEmeraldPriceFor(int emeralds, Item item)
    {
        return this.setEmeraldPriceFor(emeralds, item, 1);
    }

    public ModVillagerTradesBuilder setEmeraldPrice(int min, int max)
    {
        return this.setPrice(Items.EMERALD, min, max);
    }

    public ModVillagerTradesBuilder setEmeraldPriceFor(int min, int max, Item item, int amt)
    {
        this.setEmeraldPrice(min, max);
        return this.setForSale((random) -> new ItemStack(item, amt));
    }

    public ModVillagerTradesBuilder setEmeraldPriceFor(int min, int max, Item item)
    {
        return this.setEmeraldPriceFor(min, max, item, 1);
    }

    public boolean canBuild()
    {
        return this.price != null && this.forSale != null;
    }

    public ITrade build()
    {
        return (entity, random) -> !this.canBuild() ? null : new MerchantOffer(this.price.apply(random), this.price2.apply(random), this.forSale.apply(random), this.maxTrades, this.xp, this.priceMult);
    }

    public static Function<Random, ItemStack> createFunction(Item item, int min, int max)
    {
        return (random) -> new ItemStack(item, random.nextInt(max) + min);
    }
}
