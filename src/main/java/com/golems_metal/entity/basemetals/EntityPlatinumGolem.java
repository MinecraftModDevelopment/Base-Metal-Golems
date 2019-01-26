package com.golems_metal.entity.basemetals;

import com.golems_metal.entity.MetalGolemColorized;

import net.minecraft.world.World;

public class EntityPlatinumGolem extends MetalGolemColorized {

	public EntityPlatinumGolem(World world) {
		super(world, 0xFAFAFA, true);
		this.setLootTableLoc("golem_platinum");
	}
}