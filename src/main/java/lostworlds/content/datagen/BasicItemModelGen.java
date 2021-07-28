package lostworlds.content.datagen;

import lostworlds.content.server.init.ItemInit;
import lostworlds.library.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BasicItemModelGen extends ItemModelProvider
{
	public BasicItemModelGen(DataGenerator generator, ExistingFileHelper existingFileHelper) 
	{
		super(generator, ModUtil.ID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() 
	{
		//Blocks
		//withExistingParent("copper_ore", modLoc("block/copper_ore"));
		
		//Items
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
		basicItem(itemGenerated, ItemInit.AMBER);
		basicItem(itemGenerated, ItemInit.BROKEN_CRYSTAL_SCARAB_GEM);
		basicItem(itemGenerated, ItemInit.CEPHALOTAXUS_SEEDS);
		basicItem(itemGenerated, ItemInit.CHARGED_CRYSTAL_SCARAB_GEM);
		basicItem(itemGenerated, ItemInit.COMPUTER_FAN);
		basicItem(itemGenerated, ItemInit.COMPUTER_SCREEN);
		basicItem(itemGenerated, ItemInit.COMPUTER_STORAGE_PORT);
		basicItem(itemGenerated, ItemInit.COOKED_FERN_LEAVES);
		basicItem(itemGenerated, ItemInit.COPPER_INGOT);
		basicItem(itemGenerated, ItemInit.COPPER_NUGGET);
		basicItem(itemGenerated, ItemInit.COPPER_WIRE);
		basicItem(itemGenerated, ItemInit.CPU);
		basicItem(itemGenerated, ItemInit.CRYSTAL_SCARAB_AXE);
		basicItem(itemGenerated, ItemInit.CRYSTAL_SCARAB_BRUSH);
		basicItem(itemGenerated, ItemInit.CRYSTAL_SCARAB_HOE);
		basicItem(itemGenerated, ItemInit.CRYSTAL_SCARAB_PICKAXE);
		basicItem(itemGenerated, ItemInit.CRYSTAL_SCARAB_SHOVEL);
		basicItem(itemGenerated, ItemInit.CRYSTAL_SCARAB_SWORD);
		basicItem(itemGenerated, ItemInit.CYCAD_SEEDS);
		basicItem(itemGenerated, ItemInit.DIAMOND_BRUSH);
		basicItem(itemGenerated, ItemInit.DILLHOFFIA_SEEDS);
		basicItem(itemGenerated, ItemInit.DUISBERGIA_SEEDS);
		basicItem(itemGenerated, ItemInit.EMPTY_VILE);
		basicItem(itemGenerated, ItemInit.FERN_LEAVES);
		basicItem(itemGenerated, ItemInit.FIELD_GUIDE);
		basicItem(itemGenerated, ItemInit.GOLD_BRUSH);
		basicItem(itemGenerated, ItemInit.GROUND_FOSSIL);
		basicItem(itemGenerated, ItemInit.IRON_BRUSH);
		basicItem(itemGenerated, ItemInit.LEATHER_BRUSH);
		basicItem(itemGenerated, ItemInit.LYCOPHYTA_SEEDS);
		basicItem(itemGenerated, ItemInit.MOTHERBOARD);
		basicItem(itemGenerated, ItemInit.MUD_BALL);
		basicItem(itemGenerated, ItemInit.NETHERITE_BRUSH);
		basicItem(itemGenerated, ItemInit.OSMUNDA_SEEDS);
		basicItem(itemGenerated, ItemInit.PALEO_SALAD);
		basicItem(itemGenerated, ItemInit.PERMIAN_PERIOD_TIME_BOOK);
		basicItem(itemGenerated, ItemInit.RAM);
		basicItem(itemGenerated, ItemInit.STORAGE_DISC);
		basicItem(itemGenerated, ItemInit.UNCHARGED_CRYSTAL_SCARAB_GEM);
		basicItem(itemGenerated, ItemInit.WET_PAPER);
	}	
	
	@SuppressWarnings("unused")
	private ItemModelBuilder basicBlockItem(ModelFile file, Block id)
	{
		return withExistingParent(id.toString().toLowerCase(), modLoc("block" + id.toString().toLowerCase()));
	}
	
	private ItemModelBuilder basicItem(ModelFile file, Item id)
	{
		return getBuilder(id.toString().toLowerCase()).parent(file).texture("layer0", "item/" + id.toString().toLowerCase());
	}
}
