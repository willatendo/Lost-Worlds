package lostworlds.client.screen.fieldguides;

import lostworlds.client.screen.fieldguides.entries.AllosaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.CarnotaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.ChilesaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.CryolophosaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.DiictodonFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.DimetrodonFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.EdaphosaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.FukuivenatorFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.GiganotosaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.GorgonopsFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.GreatAukFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.KentrosaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.OstromiaFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.OuranosaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.ProcompsognathusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.ProtosuchusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.PsittacosaurusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.RhinesuchusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.SuchomimusFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.TetraceratopsFieldGuideScreen;
import lostworlds.client.screen.fieldguides.entries.TyrannosaurusFieldGuideScreen;
import net.minecraft.client.Minecraft;

public class FieldGuideScreens 
{	
	public static void procompsognathusEntry()
	{
		Minecraft.getInstance().setScreen(new ProcompsognathusFieldGuideScreen(FieldGuideLang.PROCOMPSOGNATHUS_ENTRY_NAME));
	}
	
	public static void rhinesuchusEntry()
	{
		Minecraft.getInstance().setScreen(new RhinesuchusFieldGuideScreen(FieldGuideLang.RHINESUCHUS_ENTRY_NAME));
	}
	
	public static void dimentrodonEntry()
	{
		Minecraft.getInstance().setScreen(new DimetrodonFieldGuideScreen(FieldGuideLang.DIMETRODON_ENTRY_NAME));
	}
	
	public static void edaphosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new EdaphosaurusFieldGuideScreen(FieldGuideLang.EDAPHOSAURUS_ENTRY_NAME));
	}
	
	public static void gorgonopsEntry()
	{
		Minecraft.getInstance().setScreen(new GorgonopsFieldGuideScreen(FieldGuideLang.GORGONOPS_ENTRY_NAME));
	}
	
	public static void carnotaurusEntry()
	{
		Minecraft.getInstance().setScreen(new CarnotaurusFieldGuideScreen(FieldGuideLang.CARNOTAURUS_ENTRY_NAME));
	}
	
	public static void tyrannosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new TyrannosaurusFieldGuideScreen(FieldGuideLang.TYRANNOSAURUS_ENTRY_NAME));
	}
	
	public static void allosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new AllosaurusFieldGuideScreen(FieldGuideLang.ALLOSAURUS_ENTRY_NAME));
	}
	
	public static void giganotosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new GiganotosaurusFieldGuideScreen(FieldGuideLang.GIGANOTOSAURUS_ENTRY_NAME));
	}
	
	public static void suchomimusEntry()
	{
		Minecraft.getInstance().setScreen(new SuchomimusFieldGuideScreen(FieldGuideLang.SUCHOMIMUS_ENTRY_NAME));
	}
	
	public static void tetraceratopsEntry()
	{
		Minecraft.getInstance().setScreen(new TetraceratopsFieldGuideScreen(FieldGuideLang.TETRACERATOPS_ENTRY_NAME));
	}
	
	public static void greatAukEntry()
	{
		Minecraft.getInstance().setScreen(new GreatAukFieldGuideScreen(FieldGuideLang.GREAT_AUK_ENTRY_NAME));
	}
	
	public static void ouranosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new OuranosaurusFieldGuideScreen(FieldGuideLang.OURANOSAURUS_ENTRY_NAME));
	}
	
	public static void fukuivenatorEntry()
	{
		Minecraft.getInstance().setScreen(new FukuivenatorFieldGuideScreen(FieldGuideLang.FUKUIVENATOR_ENTRY_NAME));
	}
	
	public static void psittacosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new PsittacosaurusFieldGuideScreen(FieldGuideLang.PSITTACOSAURUS_ENTRY_NAME));
	}
	
	public static void cryolophosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new CryolophosaurusFieldGuideScreen(FieldGuideLang.CRYOLOPHOSAURUS_ENTRY_NAME));
	}
	
	public static void ostromiaEntry()
	{
		Minecraft.getInstance().setScreen(new OstromiaFieldGuideScreen(FieldGuideLang.OSTROMIA_ENTRY_NAME));
	}
	
	public static void protosuchusEntry()
	{
		Minecraft.getInstance().setScreen(new ProtosuchusFieldGuideScreen(FieldGuideLang.PROTOSUCHUS_ENTRY_NAME));
	}
	
	public static void diictodonEntry()
	{
		Minecraft.getInstance().setScreen(new DiictodonFieldGuideScreen(FieldGuideLang.DIICTODON_ENTRY_NAME));
	}
	
	public static void kentrosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new KentrosaurusFieldGuideScreen(FieldGuideLang.KENTROSAURUS_ENTRY_NAME));
	}
	
	public static void chilesaurusEntry()
	{
		Minecraft.getInstance().setScreen(new ChilesaurusFieldGuideScreen(FieldGuideLang.CHILESAURUS_ENTRY_NAME));
	}
}
