package lostworlds.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderFactory 
{
	public final String modid;

	public RenderFactory(String modid) 
	{
		this.modid = modid;
	}
	
	public static <T extends Entity> void addRender(EntityType<T> clazz, IRenderFactory<T> renderer) 
	{
		RenderingRegistry.registerEntityRenderingHandler(clazz, renderer);
	}

	public static <T extends Entity & IRendersAsItem> IRenderFactory<T> sprite() 
	{
		return mgr -> new SpriteRenderer<>(mgr, Minecraft.getInstance().getItemRenderer());
	}
}
