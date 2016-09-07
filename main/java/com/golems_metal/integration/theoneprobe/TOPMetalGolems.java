package com.golems_metal.integration.theoneprobe;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems.integration.ModIds;
import com.golems.main.ExtraGolems;
import com.golems_metal.init.MetalGolems;
import com.golems_metal.integration.MetalGolemDescriptionManager;
import com.google.common.base.Function;

import mcjty.theoneprobe.api.IProbeHitEntityData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoEntityProvider;
import mcjty.theoneprobe.api.ITheOneProbe;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

/**
 * TheOneProbe integration -- using theoneprobe-1.10-1.1.0
 **/
@Optional.Interface(iface = "mcjty.theoneprobe.api.IProbeInfoEntityProvider", modid = ModIds.TOP)
public class TOPMetalGolems extends MetalGolemDescriptionManager implements IProbeInfoEntityProvider  
{	
	public TOPMetalGolems()
	{
		super();
		this.showMultiTexture = true;
		this.showSpecial = true;
	}
	
	@Override
	@Optional.Method(modid = ModIds.TOP)
	public void addProbeEntityInfo(ProbeMode mode, IProbeInfo iprobeInfo, EntityPlayer player, World world, Entity entity, IProbeHitEntityData data) 
	{
		if(entity instanceof GolemBase)
		{
			GolemBase golem = (GolemBase)entity;
			// show attack if advanced mode
			this.showFireproof = this.showAttack = (mode == ProbeMode.EXTENDED);
			
			List<String> list = this.getEntityDescription(golem);
			for(String s : list)
			{
				iprobeInfo.text(s);
			}
		}
	}

	@Override
	@Optional.Method(modid = ModIds.TOP)
	public String getID() 
	{
		return MetalGolems.MODID;
	}

	@Optional.Interface(iface = "mcjty.theoneprobe.api.ITheOneProbe", modid = ModIds.TOP)
	public static class GetTheOneProbe implements Function<ITheOneProbe, Void>
	{		
		@Override
		public Void apply(ITheOneProbe input) 
		{
			IProbeInfoEntityProvider instance = new TOPMetalGolems();
			input.registerEntityProvider(instance);
			return null;
		}
	}
}
