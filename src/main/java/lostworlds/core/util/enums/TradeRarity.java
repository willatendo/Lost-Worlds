package lostworlds.core.util.enums;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

import net.minecraft.entity.merchant.villager.VillagerTrades;

public enum TradeRarity 
{
	COMMON("common", (trades, random) -> trades.size(), (trades, random) -> trades.size(), true),
    UNCOMMON("uncommon", (trades, random) -> 3, (trades, random) -> random.nextInt(5) + 1, true),
    RARE("rare", (trades, random) -> 3, (trades, random) -> random.nextInt(4) + 1, true),
    EPIC("epic", (trades, random) -> 0, (trades, random) -> random.nextInt(2), true),
    LEGENDARY("legendary", (trades, random) -> 0, (trades, random) -> random.nextInt(10) == 0 ? 1 : 0, true);

    private final String key;
    private final BiFunction<List<VillagerTrades.ITrade>, Random, Integer> minimum;
    private final BiFunction<List<VillagerTrades.ITrade>, Random, Integer> maximum;
    private final boolean shuffle;

    TradeRarity(String key, BiFunction<List<VillagerTrades.ITrade>, Random, Integer> minimum, BiFunction<List<VillagerTrades.ITrade>, Random, Integer> maximum, boolean shuffle)
    {
        this.key = key;
        this.minimum = minimum;
        this.maximum = maximum;
        this.shuffle = shuffle;
    }

    public String getKey()
    {
        return this.key;
    }

    public BiFunction<List<VillagerTrades.ITrade>, Random, Integer> getMinimum()
    {
        return this.minimum;
    }

    public BiFunction<List<VillagerTrades.ITrade>, Random, Integer> getMaximum()
    {
        return this.maximum;
    }

    public boolean shouldShuffle()
    {
        return this.shuffle;
    }
}

