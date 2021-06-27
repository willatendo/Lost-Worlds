package library.items.machine;

import addon.officaladdons.ogpack.OGPack;
import api.core.init.ItemInit;
import library.entites.AllosaurusEntity;
import library.entites.CarnotaurusEntity;
import library.entites.ChilesaurusEntity;
import library.entites.CryolophosaurusEntity;
import library.entites.DiictodonEntity;
import library.entites.DimetrodonEntity;
import library.entites.EdaphosaurusEntity;
import library.entites.FukuivenatorEntity;
import library.entites.GiganotosaurusEntity;
import library.entites.GorgonopsEntity;
import library.entites.GreatAukEntity;
import library.entites.KentrosaurusEntity;
import library.entites.LiaoningosaurusEntity;
import library.entites.NautilusEntity;
import library.entites.OstromiaEntity;
import library.entites.OuranosaurusEntity;
import library.entites.PalaeoniscumEntity;
import library.entites.ProcompsognathusEntity;
import library.entites.ProtosuchusEntity;
import library.entites.PsittacosaurusEntity;
import library.entites.RhinesuchusEntity;
import library.entites.SuchomimusEntity;
import library.entites.TetraceratopsEntity;
import library.entites.TyrannosaurusEntity;
import library.entites.UtahraptorEntity;
import library.entites.ZephyrosaurusEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;

public class SyringeItem extends Item
{
	public SyringeItem(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity playerEntity, LivingEntity entity, Hand hand) 
	{	
		if(entity instanceof ProcompsognathusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.PROCOMPSOGNATHUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof PalaeoniscumEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.PALAEONISCUM_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof NautilusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.NAUTILUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof RhinesuchusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.RHINESUCHUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof DimetrodonEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.DIMETRODON_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof EdaphosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.EDAPHOSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof GorgonopsEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.GORGONOPS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof CarnotaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.CARNOTAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof TyrannosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.TYRANNOSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof AllosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.ALLOSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof GiganotosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.GIGANOTOSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof SuchomimusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.SUCHOMIMUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof TetraceratopsEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.TETRACERATOPS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof GreatAukEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.GREAT_AUK_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof OuranosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.OURANOSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof FukuivenatorEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.FUKUIVENATOR_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof PsittacosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.PSITTACOSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof CryolophosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.CRYOLOPHOSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof OstromiaEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.OSTROMIA_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof ProtosuchusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.PROTOSUCHUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof DiictodonEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.DIICTODON_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof KentrosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.KENTROSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof ChilesaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.CHILESAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof LiaoningosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.LIAONINGOSAURUS_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof UtahraptorEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.UTAHRAPTOR_BLOOD_SYRINGE.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		if(entity instanceof ZephyrosaurusEntity)
		{
			playerEntity.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);
			ItemStack blood = new ItemStack(ItemInit.ZEPHYROSAURUS_MEAT.get());
			playerEntity.setItemInHand(hand, blood);
			return ActionResultType.SUCCESS;
		}
		
		if(OGPack.hasInitilised)
		{
			
		}
		
		return super.interactLivingEntity(stack, playerEntity, entity, hand);
	}
}
