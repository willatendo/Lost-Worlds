package lostworlds;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;

public class LostWorldsConfig 
{
	public static class Common
	{
		public final ForgeConfigSpec.DoubleValue allosaurusHeath;
		public final ForgeConfigSpec.DoubleValue allosaurusMovementSpeed;
		public final ForgeConfigSpec.DoubleValue allosaurusAttackDamage;
		public final ForgeConfigSpec.DoubleValue carnotaurusHeath;
		public final ForgeConfigSpec.DoubleValue carnotaurusMovementSpeed;
		public final ForgeConfigSpec.DoubleValue carnotaurusAttackDamage;
		
		public final ForgeConfigSpec.BooleanValue shouldDinosaurSpawnInOverworld;
		public final ForgeConfigSpec.BooleanValue shouldForestsSpawnInOverworld;
		public final ForgeConfigSpec.BooleanValue shouldVolcanoSpawnInOverworld;
		public final ForgeConfigSpec.IntValue coniferWeight;
		public final ForgeConfigSpec.IntValue ginkgoWeight;
		public final ForgeConfigSpec.IntValue araucariaWeight;
		public final ForgeConfigSpec.IntValue volcanoWeight;
		
		public Common(ForgeConfigSpec.Builder builder) 
		{
			this.allosaurusHeath = builder.comment("Sets the Allosaurus's heath.").translation("lostworlds.config.allosaurusHeath").defineInRange("allosaurusHeath", 55.0D, 0.0D, 1000.0D);
			this.allosaurusMovementSpeed = builder.comment("Sets the Allosaurus's movement speed.").translation("lostworlds.config.allosaurusMovementSpeed").defineInRange("allosaurusMovementSpeed", 0.2D, 0.0D, 1.0D);
			this.allosaurusAttackDamage = builder.comment("Sets the Allosaurus's attack damage.").translation("lostworlds.config.allosaurusAttackDamage").defineInRange("allosaurusAttackDamage", 8.0D, 0.0D, 30.0D);
			this.carnotaurusHeath = builder.comment("Sets the Allosaurus's heath.").translation("lostworlds.config.carnotaurusHeath").defineInRange("carnotaurusHeath", 45.0D, 0.0D, 1000.0D);
			this.carnotaurusMovementSpeed = builder.comment("Sets the Allosaurus's movement speed.").translation("lostworlds.config.carnotaurusMovementSpeed").defineInRange("carnotaurusMovementSpeed", 0.2D, 0.0D, 1.0D);
			this.carnotaurusAttackDamage = builder.comment("Sets the Carnotaurus's attack damage.").translation("lostworlds.config.carnotaurusAttackDamage").defineInRange("carnotaurusAttackDamage", 8.0D, 0.0D, 30.0D);
			
			shouldDinosaurSpawnInOverworld = builder.comment("If true, dinosaurs will spawn naturally in the overworld. (WIP)").translation("lostworlds.config.shouldDinosaurSpawnInOverworld").define("shouldDinosaurSpawnInOverworld", false);
			shouldForestsSpawnInOverworld = builder.comment("If true, forests will spawn naturally in the overworld.").translation("lostworlds.config.shouldForestsSpawnInOverworld").define("shouldForestsSpawnInOverworld", true);
			shouldVolcanoSpawnInOverworld = builder.comment("If true, volcano will spawn naturally in the overworld.").translation("lostworlds.config.shouldVolcanoSpawnInOverworld").define("shouldVolcanoSpawnInOverworld", true);
			coniferWeight = builder.comment("Sets the weight of Conifer Forests overworld spawns.").translation("lostoworlds.config.coniferWeight").defineInRange("coniferWeight", 3, 1, 10);
			ginkgoWeight = builder.comment("Sets the weight of Gingko Forests overworld spawns.").translation("lostoworlds.config.ginkgoWeight").defineInRange("ginkgoWeight", 3, 1, 10);
			araucariaWeight = builder.comment("Sets the weight of Araucaria Forests overworld spawns.").translation("lostoworlds.config.araucariaWeight").defineInRange("araucariaWeight", 3, 1, 10);
			volcanoWeight = builder.comment("Sets the weight of Volcanos overworld spawns.").translation("lostoworlds.config.volcanoWeight").defineInRange("volcanoWeight", 1, 1, 10);
		}
	}

	static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

}
