package lostworlds.client;

import lostworlds.client.entity.render.NautilusRender;
import lostworlds.client.entity.render.PalaeoniscumRender;
import lostworlds.client.entity.render.ProcompsognathusRender;
import lostworlds.client.entity.render.RhinesuchusRender;
import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ModReference.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup 
{
//	private static final ResourceLocation PERMAIN_RENDER_INFO = new ResourceLocation(ModReference.ID, "permian_time_era");
//	private static final ResourceLocation SUN_TEXTURES = new ResourceLocation("textures/environment/sun.png");
//	private static final ResourceLocation MOON_PHASES_TEXTURES = new ResourceLocation("textures/environment/moon_phases.png");
//	private static final ResourceLocation SKY_TEXTURE = new ResourceLocation("textures/environment/end_sky.png");
	
    @SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event)
	{
    	//Blocks
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_STONE_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CLEAR_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CLEAR_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.TINTED_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.TINTED_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.OUTDOOR_TOILET_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GLASS_SHOP_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.VISITOR_CENTRE_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.INNOVATION_CENTRE_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.SECURITY_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BACK_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.WHITE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.WHITE_GLASS_PANE.get(), RenderType.translucent());		
		RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_GREY_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_GREY_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.GREY_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GREY_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.BLACK_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BLACK_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.RED_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.RED_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.ORANGE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.ORANGE_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.YELLOW_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.YELLOW_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.LIME_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.LIME_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.GREEN_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GREEN_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.CYAN_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CYAN_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_BLUE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_BLUE_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.BLUE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BLUE_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.MAGENTA_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.MAGENTA_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.PINK_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PINK_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BROWN_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BROWN_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.SHADED_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.SHADED_GLASS_PANE.get(), RenderType.translucent());	
		//Entity
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), ProcompsognathusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PALAEONISCUM_ENTITY.get(), PalaeoniscumRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.NAUTILUS_ENTITY.get(), NautilusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.RHINESUCHUS_ENTITY.get(), RhinesuchusRender::new);
	}
 /*   
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void clientDimensionRender(FMLClientSetupEvent event)
    {
    	DimensionRenderInfo.EFFECTS.put(PERMAIN_RENDER_INFO, new DimensionRenderInfo(128, true, FogType.NORMAL, true, false) 
    	{
    		@Override
			public Vector3d getBrightnessDependentFogColor(Vector3d fogColor, float partialTicks) 
    		{
    			return fogColor;
			}
    		
    		@Override
    		public boolean isFoggyAt(int posX, int posY) 
    		{
    			return false;
    		}
    		
    		@Override
    		public ISkyRenderHandler getSkyRenderHandler() 
    		{
    			return new ISkyRenderHandler() 
    			{
    				@SuppressWarnings({ "deprecation" })
    				@Override
    				public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) 
    				{
    					RenderSystem.disableTexture();
    					Vector3d vector3d = world.getSkyColor(mc.gameRenderer.getMainCamera().getBlockPosition(), partialTicks);
    					float f = (float) vector3d.x;
    					float f1 = (float) vector3d.y;	
    					float f2 = (float) vector3d.z;
    					FogRenderer.levelFogColor();
    					BufferBuilder bufferbuilder = Tessellator.getInstance().getBuilder();
    					RenderSystem.depthMask(false);
    					RenderSystem.enableFog();
    					RenderSystem.color3f(f, f1, f2);
    					mc.levelRenderer.skyBuffer.bind();
    					mc.levelRenderer.skyFormat.setupBufferState(0L);
    					mc.levelRenderer.skyBuffer.draw(matrixStack.last().pose(), 7);
    					VertexBuffer.unbind();
    					mc.levelRenderer.skyFormat.clearBufferState();
    					
    					Matrix4f matrix4f1 = matrixStack.last().pose();
    					RenderSystem.enableAlphaTest();
    					RenderSystem.enableTexture();	
    					RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
    					RenderSystem.color4f(1f, 1f, 1f, 1f);
    					mc.getTextureManager().bind(SKY_TEXTURE);
    					bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
    					bufferbuilder.vertex(matrix4f1, -100, 8f, -100).uv(0.0F, 0.0F).endVertex();
    					bufferbuilder.vertex(matrix4f1, 100, 8f, -100).uv(1.0F, 0.0F).endVertex();
    					bufferbuilder.vertex(matrix4f1, 100, 8f, 100).uv(1.0F, 1.0F).endVertex();
    					bufferbuilder.vertex(matrix4f1, -100, 8f, 100).uv(0.0F, 1.0F).endVertex();
    					bufferbuilder.end();
    					WorldVertexBufferUploader.end(bufferbuilder);
    					RenderSystem.disableTexture();
    					
    					RenderSystem.disableFog();
    					RenderSystem.disableAlphaTest();
    					RenderSystem.enableBlend();
    					RenderSystem.defaultBlendFunc();
    					float[] afloat = world.effects().getSunriseColor(world.getTimeOfDay(partialTicks), partialTicks);
    					if(afloat != null) 
    					{
    						RenderSystem.disableTexture();
    						RenderSystem.shadeModel(7425);
    						matrixStack.pushPose();
    						matrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
    						float f3 = MathHelper.sin(world.getSunAngle(partialTicks)) < 0.0F ? 180.0F: 0.0F;
    						matrixStack.mulPose(Vector3f.ZP.rotationDegrees(f3));
    						matrixStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
    						float f4 = afloat[0];
    						float f5 = afloat[1];
							float f6 = afloat[2];
							Matrix4f matrix4f = matrixStack.last().pose();
							bufferbuilder.begin(6, DefaultVertexFormats.POSITION_COLOR);
							bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(f4, f5, f6, afloat[3]).endVertex();
							
							for (int j = 0; j <= 16; ++j) 
							{
								float f7 = (float) j * ((float) Math.PI * 2F) / 16.0F;
								float f8 = MathHelper.sin(f7);
								float f9 = MathHelper.cos(f7);
								bufferbuilder.vertex(matrix4f, f8 * 120.0F, f9 * 120.0F, -f9 * 40.0F * afloat[3]).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
							}
							
							bufferbuilder.end();
							WorldVertexBufferUploader.end(bufferbuilder);
							matrixStack.popPose();	
							RenderSystem.shadeModel(7424);
						}
    					
    					RenderSystem.enableTexture();
    					RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
    					matrixStack.pushPose();
    					float f11 = 1.0F - world.getRainLevel(partialTicks);
    					RenderSystem.color4f(1.0F, 1.0F, 1.0F, f11);
    					matrixStack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
    					matrixStack.mulPose(Vector3f.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360.0F));
    					matrix4f1 = matrixStack.last().pose();
    					
    					float f12 = 30.0F;
    					mc.getTextureManager().bind(SUN_TEXTURES);
    					bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
    					bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
    					bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
    					bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
    					bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
    					bufferbuilder.end();
    					WorldVertexBufferUploader.end(bufferbuilder);
    					
    					f12 = 20.0F;
    					mc.getTextureManager().bind(MOON_PHASES_TEXTURES);
    					int k = world.getMoonPhase();
    					int l = k % 4;
    					int i1 = k / 4 % 2;
    					float f13 = (float) (l + 0) / 4.0F;
    					float f14 = (float) (i1 + 0) / 2.0F;
    					float f15 = (float) (l + 1) / 4.0F;
    					float f16 = (float) (i1 + 1) / 2.0F;
    					bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
    					bufferbuilder.vertex(matrix4f1, -f12, -100.0F, f12).uv(f15, f16).endVertex();
    					bufferbuilder.vertex(matrix4f1, f12, -100.0F, f12).uv(f13, f16).endVertex();
    					bufferbuilder.vertex(matrix4f1, f12, -100.0F, -f12).uv(f13, f14).endVertex();
    					bufferbuilder.vertex(matrix4f1, -f12, -100.0F, -f12).uv(f15, f14).endVertex();
    					bufferbuilder.end();
    					
    					WorldVertexBufferUploader.end(bufferbuilder);
    					RenderSystem.disableTexture();
    					
    					float f10 = world.getStarBrightness(partialTicks) * f11;
    					if(f10 > 0.0F) 
    					{
    						RenderSystem.color4f(f10, f10, f10, f10);
    						mc.levelRenderer.starBuffer.bind();
    						mc.levelRenderer.skyFormat.setupBufferState(0L);
    						mc.levelRenderer.starBuffer.draw(matrixStack.last().pose(), 7);
    						VertexBuffer.unbind();
    						mc.levelRenderer.skyFormat.clearBufferState();
    					}
    					
    					RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    					RenderSystem.disableBlend();
    					RenderSystem.enableAlphaTest();
    					RenderSystem.enableFog();
    					matrixStack.popPose();
    					RenderSystem.disableTexture();
    					RenderSystem.color3f(0.0F, 0.0F, 0.0F);
    					double d0 = mc.player.getEyePosition(partialTicks).y - world.getLevelData().getHorizonHeight();
    					if(d0 < 0.0D) 
    					{
    						matrixStack.pushPose();
    						matrixStack.translate(0.0D, 12.0D, 0.0D);
    						mc.levelRenderer.darkBuffer.bind();
    						mc.levelRenderer.skyFormat.setupBufferState(0L);
    						mc.levelRenderer.darkBuffer.draw(matrixStack.last().pose(), 7);
    						VertexBuffer.unbind();
    						mc.levelRenderer.skyFormat.clearBufferState();
    						matrixStack.popPose();
    					}
    					if(world.effects().hasGround()) 
    					{
    						RenderSystem.color3f(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F);
    					} 
    					else 
    					{
    						RenderSystem.color3f(f, f1, f2);
    					}
    					
    					RenderSystem.enableTexture();
    					RenderSystem.depthMask(true);
    					RenderSystem.disableFog();
    				}
    			};
    		}
    	});
    }
*/
}
