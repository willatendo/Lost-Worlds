package lostworlds.content.datagen;

import lostworlds.content.server.ModTags.ModBlockTags;
import lostworlds.content.server.ModTags.ModItemTags;
import lostworlds.content.server.init.ItemInit;
import lostworlds.library.util.ModUtil;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagGen extends ItemTagsProvider
{
	public ItemTagGen(DataGenerator generator, BlockTagsProvider provider, ExistingFileHelper existingFileHelper) 
	{
		super(generator, provider, ModUtil.ID, existingFileHelper);
	}
	
	@Override
	protected void addTags() 
	{	
		//Minecraft
		this.tag(ItemTags.LOGS_THAT_BURN).addTag(ModItemTags.ARAUCARIA_LOGS).addTag(ModItemTags.CONIFER_LOGS).addTag(ModItemTags.GINKGO_LOGS).addTag(ModItemTags.SCORCHED_LOGS);
		
		//Mod
		this.copy(ModBlockTags.ARAUCARIA_LOGS, ModItemTags.ARAUCARIA_LOGS);
		this.tag(ModItemTags.BLOOD_SYRINGES);
		this.tag(ModItemTags.BLOOD_VILES);
		this.copy(ModBlockTags.CONIFER_LOGS, ModItemTags.CONIFER_LOGS);
		this.tag(ModItemTags.DNA_DISCS);
		this.tag(ModItemTags.DNA);
		this.tag(ModItemTags.FOOD_SEEDS).add(ItemInit.CEPHALOTAXUS_SEEDS).add(ItemInit.CYCAD_SEEDS).add(ItemInit.DILLHOFFIA_SEEDS).add(ItemInit.DUISBERGIA_SEEDS).add(ItemInit.LYCOPHYTA_SEEDS).add(ItemInit.OSMUNDA_SEEDS);
		this.copy(ModBlockTags.FOSSILS, ModItemTags.FOSSILS);
		this.copy(ModBlockTags.GINKGO_LOGS, ModItemTags.GINKGO_LOGS);
		this.copy(ModBlockTags.SCORCHED_LOGS, ModItemTags.SCORCHED_LOGS);
		this.tag(ModItemTags.SOFT_TISSUE);
		this.tag(ModItemTags.TIME_BOOKS).add(ItemInit.PERMIAN_PERIOD_TIME_BOOK); 
	}
}
