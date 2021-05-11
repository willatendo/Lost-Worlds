package lostworlds.world.feature;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;

public class ModFillerBlockType
{
	public static final RuleTest SAND = new BlockMatchRuleTest(Blocks.SAND);
	public static final RuleTest GRASS = new BlockMatchRuleTest(Blocks.GRASS_BLOCK);
	public static final RuleTest DIRT = new BlockMatchRuleTest(Blocks.DIRT);
	public static final RuleTest TERRACOTTA = new BlockMatchRuleTest(Blocks.TERRACOTTA);
	public static final RuleTest WHITE_TERRACOTTA = new BlockMatchRuleTest(Blocks.WHITE_TERRACOTTA);
	public static final RuleTest LIGHT_GREY_TERRACOTTA = new BlockMatchRuleTest(Blocks.LIGHT_GRAY_TERRACOTTA);
	public static final RuleTest BLACK_TERRACOTTA = new BlockMatchRuleTest(Blocks.BLACK_TERRACOTTA);
	public static final RuleTest RED_TERRACOTTA = new BlockMatchRuleTest(Blocks.RED_TERRACOTTA);
	public static final RuleTest ORANGE_TERRACOTTA = new BlockMatchRuleTest(Blocks.ORANGE_TERRACOTTA);
	public static final RuleTest SANDSTONE = new BlockMatchRuleTest(Blocks.SANDSTONE);
	public static final RuleTest PERMIAN_STONE = new BlockMatchRuleTest(BlockInit.PERMIAN_STONE.get());
	public static final RuleTest JURASSIC_STONE = new BlockMatchRuleTest(BlockInit.JURASSIC_STONE.get());
}
