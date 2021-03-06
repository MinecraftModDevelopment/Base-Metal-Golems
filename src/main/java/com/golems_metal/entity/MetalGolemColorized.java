package com.golems_metal.entity;

import com.golems.entity.GolemColorized;
import com.golems_metal.init.MetalGolems;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** COLORIZED METAL GOLEM **/
public abstract class MetalGolemColorized extends GolemColorized {
	
	public static final double METAL_GOLEM_SPEED = 0.20D;
	
	private static final ResourceLocation TEXTURE_BASE = makeTexture(MetalGolems.MODID, "golem_metal");
	private static final ResourceLocation TEXTURE_OVERLAY_LOW = makeTexture(MetalGolems.MODID, "golem_metal_grayscale_low");
	private static final ResourceLocation TEXTURE_OVERLAY_HIGH = makeTexture(MetalGolems.MODID, "golem_metal_grayscale_high");

	public MetalGolemColorized(World world, long color, boolean isHighContrast) {
		super(world, color, TEXTURE_BASE, (isHighContrast ? TEXTURE_OVERLAY_HIGH : TEXTURE_OVERLAY_LOW));
		this.setCanSwim(false);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(MetalGolemColorized.METAL_GOLEM_SPEED);
	}
	
	public MetalGolemColorized(World world, long color) {
		this(world, color, false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		final int LIGHT_ADDED = 16;
		return super.getBrightnessForRender() + LIGHT_ADDED;
	}

	@Override
	public SoundEvent getGolemSound() {
		return SoundEvents.BLOCK_METAL_STEP;
	}
}
