package TFC.WorldGen.Generators;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import TFC.TFCBlocks;
import TFC.TileEntities.TileEntityPartial;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenCaveDecor implements IWorldGenerator
{
	public WorldGenCaveDecor()
	{

	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		if (world.isRemote) {
			return;
		}

		chunkX *= 16;
		chunkZ *= 16;
		for (int xCoord = 0; xCoord < 16; ++xCoord)
		{
			int x = chunkX + xCoord;

			for (int zCoord = 0; zCoord < 16; ++zCoord)
			{
				int z = chunkZ + zCoord;

				for (int y = 127; y >= 0; --y)
				{
					int id = world.getBlockId(x, y, z);
					int idAbove = world.getBlockId(x, y+1, z);
					int idBelow = world.getBlockId(x, y-1, z);

					if(y > 8 && id == 0 &&
						(idAbove == TFCBlocks.StoneIgEx.blockID || idAbove == TFCBlocks.StoneIgIn.blockID || 
						 idAbove == TFCBlocks.StoneSed.blockID || idAbove == TFCBlocks.StoneMM.blockID))
					{
						if(idBelow == 0 && world.getBlockId(x, y-2, z) == 0 && world.getBlockId(x, y-3, z) == 0)
						{

							if(rand.nextInt(25) == 0)
							{
								int type = rand.nextInt(4);
								byte md = (byte)world.getBlockMetadata(x, y+1, z);
								TileEntityPartial tep;

								switch(type)
								{
								case 0:
								{
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x101101 + 0x01000000L; 
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y-1, z);
									if(world.setBlock(x, y-1, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x202202 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y-2, z);
									if(world.setBlock(x, y-2, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x303303 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									break;
								}
								case 1:
								{

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x101101 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y-1, z);
									if(world.setBlock(x, y-1, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x303343 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									break;
								}
								case 2:
								{

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x303301 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y-1, z);
									if(world.setBlock(x, y-1, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x404443 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									break;
								}
								case 3:
								{
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x201101 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y-1, z);
									if(world.setBlock(x, y-1, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x402202 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y-2, z);
									if(world.setBlock(x, y-2, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x503203 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									break;
								}
								//	TODO:	The remaining two cases will
								//			never be reached because'type'
								//			is guaranteed to be 0-3,
								//			inclusive.
								case 4:
								{
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x303301 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y-1, z);
									if(world.setBlock(x, y-1, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x503203 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									break;
								}
								case 5:
								{
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x102102 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y-1, z);
									if(world.setBlock(x, y-1, z, TFCBlocks.stoneStalac.blockID) && tep != null)
									{
										tep.extraData = 0x303203 + 0x01000000L;
										tep.TypeID = (short) idAbove;
										tep.MetaID = md;
									}
									break;
								}
								}
							}
						}
					}
					else if(y <128 && id == 0 && world.getBlockLightValue(x, y-1, z) < 10 &&
							(idBelow == TFCBlocks.StoneIgEx.blockID || idBelow == TFCBlocks.StoneIgIn.blockID || 
							 idBelow == TFCBlocks.StoneSed.blockID || idBelow == TFCBlocks.StoneMM.blockID))
					{
						if(idAbove == 0 && world.getBlockId(x, y+2, z) == 0 && world.getBlockId(x, y+3, z) == 0)
						{
							if(rand.nextInt(25) == 0)
							{
								int type = rand.nextInt(3);
								byte md = (byte)world.getBlockMetadata(x, y-1, z);
								TileEntityPartial tep;

								switch(type)
								{
								case 0:
								{
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										//	TODO:	Why are we doing this a
										//			second time?
										world.setBlock(x, y, z, TFCBlocks.stoneSlabs.blockID);

										tep.extraData = 0x102102; 
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y+1, z);
									if(world.setBlock(x, y+1, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										tep.extraData = 0x303203;
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y+2, z);
									if(world.setBlock(x, y+2, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										tep.extraData = 0x403303;
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}
									break;
								}
								case 1:
								{
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										tep.extraData = 0x101102; 
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y+1, z);
									if(world.setBlock(x, y+1, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										tep.extraData = 0x303102;
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y+2, z);
									if(world.setBlock(x, y+2, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										tep.extraData = 0x434203;
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}
									break;
								}
								case 2:
								{
									tep = (TileEntityPartial)world.getBlockTileEntity(x, y, z);
									if(world.setBlock(x, y, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										tep.extraData = 0x101101; 
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y+1, z);
									if(world.setBlock(x, y+1, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										tep.extraData = 0x202202;
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}

									tep = (TileEntityPartial)world.getBlockTileEntity(x, y+2, z);
									if(world.setBlock(x, y+2, z, TFCBlocks.stoneSlabs.blockID) && tep != null)
									{
										tep.extraData = 0x363303;
										tep.TypeID = (short) idBelow;
										tep.MetaID = md;
									}
									break;
								}
								}
							}
						}
					}
				}
			}
		}
	}

}
