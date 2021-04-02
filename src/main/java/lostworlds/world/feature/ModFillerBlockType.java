package lostworlds.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;

public class ModFillerBlockType
{
	public static final RuleTest SAND = new BlockMatchRuleTest(Blocks.SAND);
	public static final RuleTest GRASS = new BlockMatchRuleTest(Blocks.GRASS_BLOCK);
	public static final RuleTest DIRT = new BlockMatchRuleTest(Blocks.DIRT);
}
