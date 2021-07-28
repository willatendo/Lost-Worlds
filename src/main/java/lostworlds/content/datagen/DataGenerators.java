package lostworlds.content.datagen;

import lostworlds.library.util.ModUtil;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = ModUtil.ID, bus = Bus.MOD)
public class DataGenerators 
{
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event)
	{
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		gen.addProvider(new BasicItemModelGen(gen, fileHelper));

		BlockTagGen blockTags = new BlockTagGen(gen, fileHelper);
        gen.addProvider(blockTags);
		
		gen.addProvider(new ItemTagGen(gen, blockTags, fileHelper));
		
		gen.addProvider(new GenRecipes(gen));
	}
}
