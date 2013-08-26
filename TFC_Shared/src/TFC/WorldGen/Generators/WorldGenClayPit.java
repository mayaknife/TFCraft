package TFC.WorldGen.Generators;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import TFC.TFCBlocks;
import TFC.Core.TFC_Climate;
import TFC.Core.TFC_Core;
import TFC.WorldGen.DataLayer;
import TFC.WorldGen.TFCWorldChunkManager;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenClayPit implements IWorldGenerator
{
	/** The block ID for clay. */
	private int clayBlockId;

	/** The number of blocks to generate. */
	private int numberOfBlocks;

	public WorldGenClayPit(int par1)
	{
		this.numberOfBlocks = par1;
	}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		int radius = rand.nextInt(this.numberOfBlocks - 2) + 2;
		byte depth = 2;

		if(rand.nextInt(30) == 0 && j <= 150)
		{
			int radiusSquared = radius * radius;

			for (int xCoord = i - radius; xCoord <= i + radius; ++xCoord)
			{
				int x = xCoord - i;
				int xSquared = x * x;

				for (int zCoord = k - radius; zCoord <= k + radius; ++zCoord)
				{
					int z = zCoord - k;
					int zSquared = z * z;

					if (xSquared + zSquared <= radiusSquared && TFC_Climate.getRainfall(xCoord, 145, zCoord) >= 500)
					{
						DataLayer rockLayer1 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(xCoord, zCoord, 0);
						int clayType = TFC_Core.getTypeForClay(rockLayer1.data2);
						int clayGrassType = TFC_Core.getTypeForClayGrass(rockLayer1.data2);
						int soilMeta = TFC_Core.getSoilMetaFromStone(rockLayer1.data1, rockLayer1.data2);

						for (int yCoord = j - depth; yCoord <= j + depth; ++yCoord)
						{
							int ID = world.getBlockId(xCoord, yCoord, zCoord);


							if (ID == TFCBlocks.Dirt.blockID || ID == TFCBlocks.Dirt2.blockID)
							{
								world.setBlock(
									xCoord, yCoord, zCoord, clayType, soilMeta, 0x2
								);
							}
							else if(ID == TFCBlocks.Grass.blockID || ID == TFCBlocks.Grass2.blockID)
							{
								world.setBlock(
									xCoord, yCoord, zCoord, clayGrassType, soilMeta, 0x2
								);
								if(rand.nextInt(9) == 0 && world.getBlockId(xCoord, yCoord+1, zCoord) == 0) {
									world.setBlock(xCoord, yCoord+1, zCoord, TFCBlocks.Flora.blockID, 0, 2);
								}
							}
						}
					}
				}
			}
		}

		return true;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		chunkX *= 16;
		chunkZ *= 16;


		int var7 = chunkX + random.nextInt(16) + 8;
		int var3 = chunkZ + random.nextInt(16) + 8;

		generate(world, random, var7, world.getTopSolidOrLiquidBlock(var7, var3)-1, var3);
	}
}
