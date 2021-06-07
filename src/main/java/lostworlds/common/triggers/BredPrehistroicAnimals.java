package lostworlds.common.triggers;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ResourceLocation;

public class BredPrehistroicAnimals extends AbstractCriterionTrigger<BredPrehistroicAnimals.Instance> 
{
	private static final ResourceLocation ID = new ResourceLocation("bred_prehistoric_animals");
	
	@Override
	public ResourceLocation getId() 
	{
		return ID;
	}
	
	@Override
	public BredPrehistroicAnimals.Instance createInstance(JsonObject json, EntityPredicate.AndPredicate entity, ConditionArrayParser parser) 
	{
		EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.fromJson(json, "parent", parser);
		EntityPredicate.AndPredicate entitypredicate$andpredicate1 = EntityPredicate.AndPredicate.fromJson(json, "partner", parser);
		EntityPredicate.AndPredicate entitypredicate$andpredicate2 = EntityPredicate.AndPredicate.fromJson(json, "child", parser);
		return new BredPrehistroicAnimals.Instance(entity, entitypredicate$andpredicate, entitypredicate$andpredicate1, entitypredicate$andpredicate2);
	}
	
	public void trigger(ServerPlayerEntity serverEntity, AbstractPrehistoricAnimalEntity prehistoricEntity, AbstractPrehistoricAnimalEntity prehistoricEntity2, @Nullable AbstractPrehistoricAgeingEntity ageEntity) 
	{
		LootContext lootcontext = EntityPredicate.createContext(serverEntity, prehistoricEntity);
		LootContext lootcontext1 = EntityPredicate.createContext(serverEntity, prehistoricEntity2);
		LootContext lootcontext2 = ageEntity != null ? EntityPredicate.createContext(serverEntity, ageEntity) : null;
		this.trigger(serverEntity, (p_233510_3_) -> 
		{
			return p_233510_3_.matches(lootcontext, lootcontext1, lootcontext2);
		});
	}
	
	public static class Instance extends CriterionInstance 
	{
		private final EntityPredicate.AndPredicate parent;
		private final EntityPredicate.AndPredicate partner;
		private final EntityPredicate.AndPredicate child;
		
		public Instance(EntityPredicate.AndPredicate p_i231484_1_, EntityPredicate.AndPredicate p_i231484_2_, EntityPredicate.AndPredicate p_i231484_3_, EntityPredicate.AndPredicate p_i231484_4_) 
		{
			super(BredPrehistroicAnimals.ID, p_i231484_1_);
			this.parent = p_i231484_2_;
			this.partner = p_i231484_3_;
			this.child = p_i231484_4_;
		}
		
		public static BredPrehistroicAnimals.Instance bredAnimals() 
		{
			return new BredPrehistroicAnimals.Instance(EntityPredicate.AndPredicate.ANY, EntityPredicate.AndPredicate.ANY, EntityPredicate.AndPredicate.ANY, EntityPredicate.AndPredicate.ANY);
		}
		
		public static BredPrehistroicAnimals.Instance bredAnimals(EntityPredicate.Builder p_203909_0_) 
		{
			return new BredPrehistroicAnimals.Instance(EntityPredicate.AndPredicate.ANY, EntityPredicate.AndPredicate.ANY, EntityPredicate.AndPredicate.ANY, EntityPredicate.AndPredicate.wrap(p_203909_0_.build()));
		}
		
		public static BredPrehistroicAnimals.Instance bredAnimals(EntityPredicate p_241332_0_, EntityPredicate p_241332_1_, EntityPredicate p_241332_2_) 
		{
			return new BredPrehistroicAnimals.Instance(EntityPredicate.AndPredicate.ANY, EntityPredicate.AndPredicate.wrap(p_241332_0_), EntityPredicate.AndPredicate.wrap(p_241332_1_), EntityPredicate.AndPredicate.wrap(p_241332_2_));
		}
		
		public boolean matches(LootContext loot1, LootContext loot2, @Nullable LootContext loot3) 
		{
			if (this.child == EntityPredicate.AndPredicate.ANY || loot3 != null && this.child.matches(loot3)) 
			{
				return this.parent.matches(loot1) && this.partner.matches(loot2) || this.parent.matches(loot2) && this.partner.matches(loot1);
			} 
			else 
			{
				return false;
			}
		}
		
		@Override
		public JsonObject serializeToJson(ConditionArraySerializer serialiser) 
		{
			JsonObject jsonobject = super.serializeToJson(serialiser);
			jsonobject.add("parent", this.parent.toJson(serialiser));
			jsonobject.add("partner", this.partner.toJson(serialiser));
			jsonobject.add("child", this.child.toJson(serialiser));
			return jsonobject;
		}
	}
}
