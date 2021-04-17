package lostworlds.common.goal.path;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.pathfinding.SwimNodeProcessor;
import net.minecraft.pathfinding.WalkNodeProcessor;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;

public class GroundAndSwimmerPathNavigator extends PathNavigator
{
	private boolean allowBreaching;
	
	public GroundAndSwimmerPathNavigator(MobEntity entity, World world) 
	{
		super(entity, world);
	}

	@Override
	protected PathFinder createPathFinder(int i) 
	{
		this.allowBreaching = this.mob instanceof DolphinEntity;
		this.nodeEvaluator = new WalkNodeProcessor();
		this.nodeEvaluator = new SwimNodeProcessor(this.allowBreaching);
		this.nodeEvaluator.setCanPassDoors(true);
		return new PathFinder(this.nodeEvaluator, i);
	}
	
	@SuppressWarnings("deprecation")
	public Path createPath(BlockPos pos, int i) 
	{
		if(this.level.getBlockState(pos).isAir()) 
		{
			BlockPos blockpos;
			for(blockpos = pos.below(); blockpos.getY() > 0 && this.level.getBlockState(blockpos).isAir(); blockpos = blockpos.below()) { }
			
			if(blockpos.getY() > 0) 
			{
				return super.createPath(blockpos.above(), i);
			}
			
			while(blockpos.getY() < this.level.getMaxBuildHeight() && this.level.getBlockState(blockpos).isAir()) 
			{
				blockpos = blockpos.above();
			}
			
			pos = blockpos;
		}
		
		if(!this.level.getBlockState(pos).getMaterial().isSolid()) 
		{
			return super.createPath(pos, i);
		} 
		else 
		{
			BlockPos blockpos1;
			for(blockpos1 = pos.above(); blockpos1.getY() < this.level.getMaxBuildHeight() && this.level.getBlockState(blockpos1).getMaterial().isSolid(); blockpos1 = blockpos1.above()) { }
			
			return super.createPath(blockpos1, i);
		}
	}
	
	public Path createPath(Entity entity, int i) 
	{
		return this.createPath(entity.blockPosition(), i);
	}

	@Override
	protected boolean canUpdatePath() 
	{
		return this.mob.isOnGround() || this.isInLiquid() || this.mob.isPassenger() || this.allowBreaching || this.isInLiquid();
	}
	
	
	
	@Override
	protected Vector3d getTempMobPos() 
	{
		return new Vector3d(this.mob.getX(), this.mob.getY(0.5D), this.mob.getZ());
	}

	public void tick() 
	{
		++this.tick;
		if(this.hasDelayedRecomputation) 
		{
			this.recomputePath();
		}
		
		if(!this.isDone()) 
		{
			if(this.canUpdatePath()) 
			{
				this.followThePath();
			} 
			else if(this.path != null && !this.path.isDone()) 
			{
				Vector3d vector3d = this.path.getNextEntityPos(this.mob);
				if (MathHelper.floor(this.mob.getX()) == MathHelper.floor(vector3d.x) && MathHelper.floor(this.mob.getY()) == MathHelper.floor(vector3d.y) && MathHelper.floor(this.mob.getZ()) == MathHelper.floor(vector3d.z)) 
				{
					this.path.advance();
				}
			}
			
			DebugPacketSender.sendPathFindingPacket(this.level, this.mob, this.path, this.maxDistanceToWaypoint);
			if(!this.isDone()) 
			{
				Vector3d vector3d1 = this.path.getNextEntityPos(this.mob);
				this.mob.getMoveControl().setWantedPosition(vector3d1.x, vector3d1.y, vector3d1.z, this.speedModifier);
			}
		}
	}

	protected void followThePath() 
	{
		if(this.path != null) 
		{
			Vector3d vector3d = this.getTempMobPos();
			float f = this.mob.getBbWidth();
			float f1 = f > 0.75F ? f / 2.0F : 0.75F - f / 2.0F;
			Vector3d vector3d1 = this.mob.getDeltaMovement();
			if (Math.abs(vector3d1.x) > 0.2D || Math.abs(vector3d1.z) > 0.2D) 
			{
				f1 = (float)((double)f1 * vector3d1.length() * 6.0D);
			}
			
			Vector3d vector3d2 = Vector3d.atBottomCenterOf(this.path.getNextNodePos());
			if (Math.abs(this.mob.getX() - vector3d2.x) < (double)f1 && Math.abs(this.mob.getZ() - vector3d2.z) < (double)f1 && Math.abs(this.mob.getY() - vector3d2.y) < (double)(f1 * 2.0F)) 
			{
				this.path.advance();
			}
			
			for(int j = Math.min(this.path.getNextNodeIndex() + 6, this.path.getNodeCount() - 1); j > this.path.getNextNodeIndex(); --j) 
			{
				vector3d2 = this.path.getEntityPosAtNode(this.mob, j);
				if(!(vector3d2.distanceToSqr(vector3d) > 36.0D) && this.canMoveDirectly(vector3d, vector3d2, 0, 0, 0)) 
				{
					this.path.setNextNodeIndex(j);
					break;
				}
			}
			this.doStuckDetection(vector3d);
		}
	}

	protected void doStuckDetection(Vector3d vec3d) 
	{
		if(this.tick - this.lastStuckCheck > 100) 
		{
			if(vec3d.distanceToSqr(this.lastStuckCheckPos) < 2.25D) 
			{
				this.stop();
			}
			
			this.lastStuckCheck = this.tick;
			this.lastStuckCheckPos = vec3d;
		}
		
		if(this.path != null && !this.path.isDone()) 
		{
			Vector3i vector3i = this.path.getNextNodePos();
			if(vector3i.equals(this.timeoutCachedNode)) 
			{
				this.timeoutTimer += Util.getMillis() - this.lastTimeoutCheck;
			}
			else 
			{
				this.timeoutCachedNode = vector3i;
				double d0 = vec3d.distanceTo(Vector3d.atCenterOf(this.timeoutCachedNode));
				this.timeoutLimit = this.mob.getSpeed() > 0.0F ? d0 / (double)this.mob.getSpeed() * 100.0D : 0.0D;
			}
			
			if(this.timeoutLimit > 0.0D && (double)this.timeoutTimer > this.timeoutLimit * 2.0D) 
			{
				this.timeoutCachedNode = Vector3i.ZERO;
				this.timeoutTimer = 0L;
				this.timeoutLimit = 0.0D;
				this.stop();
			}
			
			this.lastTimeoutCheck = Util.getMillis();
		}
	}
	
	protected boolean canMoveDirectly(Vector3d vec3d, Vector3d vec3d2, int i1, int i2, int i3) 
	{
		if(!this.isInLiquid())
		{
			int i = MathHelper.floor(vec3d.x);
			int j = MathHelper.floor(vec3d.z);
			double d0 = vec3d2.x - vec3d.x;
			double d1 = vec3d2.z - vec3d.z;
			double d2 = d0 * d0 + d1 * d1;
			if(d2 < 1.0E-8D) 
			{
				return false;
			} 
			else 
			{
				double d3 = 1.0D / Math.sqrt(d2);
				d0 = d0 * d3;
				d1 = d1 * d3;
				i1 = i1 + 2;
				i3 = i3 + 2;
				if(!this.canWalkOn(i, MathHelper.floor(vec3d.y), j, i1, i2, i3, vec3d, d0, d1)) 
				{
					return false;
				} 
				else 
				{
					i1 = i1 - 2;
					i3 = i3 - 2;
					double d4 = 1.0D / Math.abs(d0);
					double d5 = 1.0D / Math.abs(d1);
					double d6 = (double)i - vec3d.x;
					double d7 = (double)j - vec3d.z;
					if(d0 >= 0.0D) 
					{
						++d6;
					}
					
					if(d1 >= 0.0D) 
					{
						++d7;
					}
				
					d6 = d6 / d0;
					d7 = d7 / d1;
					int k = d0 < 0.0D ? -1 : 1;
					int l = d1 < 0.0D ? -1 : 1;
					int i11 = MathHelper.floor(vec3d2.x);
					int j1 = MathHelper.floor(vec3d2.z);
					int k1 = i11 - i;
					int l1 = j1 - j;
				
					while(k1 * k > 0 || l1 * l > 0) 
					{
						if(d6 < d7) 
						{
							d6 += d4;
							i += k;
							k1 = i11 - i;
						}
						else 
						{
							d7 += d5;
							j += l;
							l1 = j1 - j;
						}
					
						if(!this.canWalkOn(i, MathHelper.floor(vec3d.y), j, i11, i2, i3, vec3d, d0, d1)) 
						{
							return false;
						}
					}
					return true;
				}
			}
		}
		else 
		{
			Vector3d vector3d = new Vector3d(vec3d2.x, vec3d2.y + (double)this.mob.getBbHeight() * 0.5D, vec3d2.z);
			return this.level.clip(new RayTraceContext(vec3d, vector3d, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this.mob)).getType() == RayTraceResult.Type.MISS;
		}
	}
	
	private boolean canWalkOn(int i1, int i2, int i3, int i4, int i5, int i6, Vector3d vec3d, double d1, double d2) 
	{
		int i = i1 - i4 / 2;
		int j = i3 - i6 / 2;
		if(!this.canWalkAbove(i, i2, j, i4, i5, i6, vec3d, d1, d2)) 
		{
			return false;
		} 
		else 
		{
			for(int k = i; k < i + i4; ++k) 
			{
				for(int l = j; l < j + i6; ++l) 
				{
					double d0 = (double)k + 0.5D - vec3d.x;
					double d11 = (double)l + 0.5D - vec3d.z;
					if(!(d0 * d11 + d11 * d2 < 0.0D)) 
					{
						PathNodeType pathnodetype = this.nodeEvaluator.getBlockPathType(this.level, k, i2 - 1, l, this.mob, i4, i5, i6, true, true);
						if(!this.hasValidPathType(pathnodetype)) 
						{
							return false;
						}
						
						pathnodetype = this.nodeEvaluator.getBlockPathType(this.level, k, i2, l, this.mob, i4, i5, i6, true, true);
						float f = this.mob.getPathfindingMalus(pathnodetype);
						if(f < 0.0F || f >= 8.0F) 
						{
							return false;
						}
						
						if(pathnodetype == PathNodeType.DAMAGE_FIRE || pathnodetype == PathNodeType.DANGER_FIRE || pathnodetype == PathNodeType.DAMAGE_OTHER) 
						{
							return false;
						}
					}
				}
			}
			return true;
		}
	}
	
	protected boolean hasValidPathType(PathNodeType type) 
	{
		if(type == PathNodeType.WATER) 
		{
			return true;
		} 
		else if(type == PathNodeType.LAVA) 
		{
			return false;
		} 
		else 
		{
			return type != PathNodeType.OPEN;
		}
	}
	
	private boolean canWalkAbove(int i1, int i2, int i3, int i4, int i5, int i6, Vector3d vec3d, double d1, double d2) 
	{
		for(BlockPos blockpos : BlockPos.betweenClosed(new BlockPos(i1, i2, i3), new BlockPos(i1 + i4 - 1, i2 + i5 - 1, i3 + i6 - 1))) 
		{
			double d0 = (double)blockpos.getX() + 0.5D - vec3d.x;
			double d11 = (double)blockpos.getZ() + 0.5D - vec3d.z;
			if (!(d0 * d11 + d11 * d2 < 0.0D) && !this.level.getBlockState(blockpos).isPathfindable(this.level, blockpos, PathType.LAND)) 
			{
				return false;
			}
		}
		return true;
	}
	
	public void setCanOpenDoors(boolean p_179688_1_) 
	{
		this.nodeEvaluator.setCanOpenDoors(p_179688_1_);
	}
	
	public boolean canOpenDoors() 
	{
		return this.nodeEvaluator.canPassDoors();
	}
	
	public boolean isStableDestination(BlockPos pos) 
	{
		return !this.level.getBlockState(pos).isSolidRender(this.level, pos);
	}
	
	public void setCanFloat(boolean b) { }
}
