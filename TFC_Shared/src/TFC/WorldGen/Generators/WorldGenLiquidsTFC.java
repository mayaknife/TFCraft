package TFC.WorldGen.Generators;

import java.util.Random;

import TFC.*;
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
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLiquidsTFC extends WorldGenerator
{
	private int liquidBlockId;

	public WorldGenLiquidsTFC(int i)
	{
		liquidBlockId = i;
	}

	public boolean generate(World world, Random random, int i, int j, int k)
	{
		int id = world.getBlockId(i, j + 1, k);

		if (id != TFCBlocks.StoneIgIn.blockID && id != TFCBlocks.StoneSed.blockID &&
			id != TFCBlocks.StoneIgEx.blockID && id != TFCBlocks.StoneMM.blockID)
		{
			return false;
		}

		id = world.getBlockId(i, j - 1, k);

		if (id != TFCBlocks.StoneIgIn.blockID && id != TFCBlocks.StoneSed.blockID &&
			id != TFCBlocks.StoneIgEx.blockID && id != TFCBlocks.StoneMM.blockID)
		{
			return false;
		}

		id = world.getBlockId(i, j, k);

		if (id != 0 && id != TFCBlocks.StoneIgIn.blockID && id != TFCBlocks.StoneSed.blockID &&
			id != TFCBlocks.StoneIgEx.blockID && id != TFCBlocks.StoneMM.blockID)
		{
			return false;
		}

		int l = 0;
		id = world.getBlockId(i - 1, j, k);

		if (id == TFCBlocks.StoneIgIn.blockID && id == TFCBlocks.StoneSed.blockID &&
			id == TFCBlocks.StoneIgEx.blockID && id == TFCBlocks.StoneMM.blockID)
		{
			l++;
		}

		id = world.getBlockId(i + 1, j, k);
		if (id == TFCBlocks.StoneIgIn.blockID && id == TFCBlocks.StoneSed.blockID &&
			id == TFCBlocks.StoneIgEx.blockID && id == TFCBlocks.StoneMM.blockID)
		{
			l++;
		}

		id = world.getBlockId(i, j, k - 1);

		if (id == TFCBlocks.StoneIgIn.blockID && id == TFCBlocks.StoneSed.blockID &&
			id == TFCBlocks.StoneIgEx.blockID && id == TFCBlocks.StoneMM.blockID)
		{
			l++;
		}

		id = world.getBlockId(i, j, k + 1);

		if (id == TFCBlocks.StoneIgIn.blockID && id == TFCBlocks.StoneSed.blockID &&
			id == TFCBlocks.StoneIgEx.blockID && id == TFCBlocks.StoneMM.blockID)
		{
			l++;
		}

		int i1 = 0;
		if (world.isAirBlock(i - 1, j, k))
		{
			i1++;
		}
		if (world.isAirBlock(i + 1, j, k))
		{
			i1++;
		}
		if (world.isAirBlock(i, j, k - 1))
		{
			i1++;
		}
		if (world.isAirBlock(i, j, k + 1))
		{
			i1++;
		}

		if (l == 3 && i1 == 1)
		{
			world.setBlock(i, j, k, liquidBlockId, 0, 0x2);
			world.scheduledUpdatesAreImmediate = true;
			Block.blocksList[liquidBlockId].updateTick(world, i, j, k, random);
			world.scheduledUpdatesAreImmediate = false;
		}
		return true;
	}
}
