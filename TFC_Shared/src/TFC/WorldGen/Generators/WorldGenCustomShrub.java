package TFC.WorldGen.Generators;

import java.util.Random;
import TFC.*;
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

public class WorldGenCustomShrub extends WorldGenerator
{
	private int field_48197_a;
	private int field_48196_b;

	public WorldGenCustomShrub(int par1, int par2)
	{
		this.field_48196_b = par1;
		this.field_48197_a = par2;
	}

	public boolean generate(World world, Random random, int blockX, int blockY, int blockZ)
	{
		int id;

		for (boolean var6 = false; ((id = world.getBlockId(blockX, blockY, blockZ)) == 0 || id == Block.leaves.blockID) && blockY > 0; --blockY)
		{
			;
		}

		if (id == TFCBlocks.Dirt.blockID || id == TFCBlocks.Dirt2.blockID ||id == TFCBlocks.Grass.blockID ||id == TFCBlocks.Grass2.blockID ||
				id == TFCBlocks.ClayGrass.blockID ||id == TFCBlocks.ClayGrass2.blockID)
		{
			++blockY;
			world.setBlock(blockX, blockY, blockZ, Block.wood.blockID, this.field_48196_b, 0x2);

			for (int y = blockY; y <= blockY + 2; ++y)
			{
				int dy = y - blockY;
				int var10 = 2 - dy;

				for (int x = blockX - var10; x <= blockX + var10; ++x)
				{
					int dx = x - blockX;

					for (int z = blockZ - var10; z <= blockZ + var10; ++z)
					{
						int dz = z - blockZ;

						if ((Math.abs(dx) != var10 || Math.abs(dz) != var10 || random.nextInt(2) != 0) && !Block.opaqueCubeLookup[world.getBlockId(x, y, z)])
						{
							this.setBlockAndMetadata(world, x, y, z, Block.leaves.blockID, this.field_48196_b);
						}
					}
				}
			}
		}

		return true;
	}
}
