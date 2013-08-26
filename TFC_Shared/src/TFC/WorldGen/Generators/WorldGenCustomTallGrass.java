package TFC.WorldGen.Generators;

import java.util.Random;

import TFC.*;
import TFC.Blocks.Vanilla.BlockCustomTallGrass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.crash.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.packet.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.server.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.feature.*;

public class WorldGenCustomTallGrass extends WorldGenerator
{
	/** Stores ID for WorldGenTallGrass */
	private int tallGrassID;
	private int tallGrassMetadata;

	public WorldGenCustomTallGrass(int par1, int par2)
	{
		this.tallGrassID = par1;
		this.tallGrassMetadata = par2;
	}

	public boolean generate(World world, Random random, int blockX, int blockY, int blockZ)
	{
		int id  = world.getBlockId(blockX, blockY, blockZ);

		for (boolean var6 = false; ((id = world.getBlockId(blockX, blockY, blockZ)) == 0 || id == Block.leaves.blockID) && blockY > 0; --blockY)
		{
			;
		}

		for (int y = 0; y < 128; ++y)
		{
			int var8 = blockX + random.nextInt(8) - random.nextInt(8);
			int var9 = blockY + random.nextInt(4) - random.nextInt(4);
			int var10 = blockZ + random.nextInt(8) - random.nextInt(8);

			if (world.isAirBlock(var8, var9, var10) && ((BlockCustomTallGrass)Block.blocksList[this.tallGrassID]).canBlockStay(world, var8, var9, var10))
			{
				world.setBlock(var8, var9, var10, this.tallGrassID, this.tallGrassMetadata, 0x2);
			}
		}

		return true;
	}
}
