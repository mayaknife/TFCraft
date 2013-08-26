package TFC.WorldGen.Generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import TFC.TFCBlocks;
import TFC.WorldGen.DataLayer;
import TFC.WorldGen.TFCWorldChunkManager;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenOre implements IWorldGenerator
{
	int Min;
	int Max;

	//	Different types of stone where each ore can be found.
	//
	private static final int[] copperLayers = {
		TFCBlocks.StoneIgEx.blockID, -1,
		Block.sandStone.blockID, -1
	};
	private static final int[] goldLayers = {
		TFCBlocks.StoneIgEx.blockID, -1,
		TFCBlocks.StoneIgIn.blockID, -1
	};
	private static final int[] hematiteLayers = {
		TFCBlocks.StoneIgEx.blockID, -1
	};
	private static final int[] silverLayers = {
		TFCBlocks.StoneIgIn.blockID, 0,
		TFCBlocks.StoneMM.blockID, 4
	};
	private static final int[] cassiteriteLayers = {
		TFCBlocks.StoneIgIn.blockID, 0
	};
	private static final int[] cassiterite2Layers = {
		TFCBlocks.StoneIgEx.blockID, -1
	};
	private static final int[] galenaLayers = {
		TFCBlocks.StoneIgEx.blockID, -1,
		TFCBlocks.StoneMM.blockID, -1,
		TFCBlocks.StoneIgIn.blockID, 0,
		TFCBlocks.StoneSed.blockID, 5
	};
	private static final int[] bismuthiniteLayers = {
		TFCBlocks.StoneIgIn.blockID, -1,
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] garnieriteLayers = {
		TFCBlocks.StoneIgIn.blockID, 2
	};
	private static final int[] malachiteLayers = {
		TFCBlocks.StoneSed.blockID, 5,
		TFCBlocks.StoneMM.blockID, 5
	};
	private static final int[] magnetiteLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] limoniteLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] sphaleriteLayers = {
		TFCBlocks.StoneMM.blockID, -1
	};
	private static final int[] tetrahedriteLayers = {
		TFCBlocks.StoneIgEx.blockID, -1,
		TFCBlocks.StoneMM.blockID, -1,
		TFCBlocks.StoneIgIn.blockID, -1,
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] bituminousCoalLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] ligniteLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] kaoliniteLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] gypsumLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] satinsparLayers = {
		TFCBlocks.Ore2.blockID, 1
	};
	private static final int[] seleniteLayers = {
		TFCBlocks.Ore2.blockID, 1
	};
	private static final int[] graphiteLayers = {
		TFCBlocks.StoneMM.blockID, 4,
		TFCBlocks.StoneMM.blockID, 0,
		TFCBlocks.StoneMM.blockID, 5,
		TFCBlocks.StoneMM.blockID, 3
	};
	private static final int[] kimberliteLayers = {
		TFCBlocks.StoneIgIn.blockID, 2
	};
	private static final int[] petrifiedWoodLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	/*
	private static final int[] sulfurLayers = {
		TFCBlocks.StoneIgEx.blockID, -1,
		TFCBlocks.Ore2.blockID, 8
	};
	*/
	private static final int[] jetLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	/*
	private static final int[] microclineLayers = {
		TFCBlocks.StoneIgIn.blockID, 0
	};
	*/
	private static final int[] pitchblendeLayers = {
		TFCBlocks.StoneIgIn.blockID, 0
	};
	private static final int[] cinnabarLayers = {
		TFCBlocks.StoneIgEx.blockID, -1,
		TFCBlocks.StoneSed.blockID, 2,
		TFCBlocks.StoneMM.blockID, 0
	};
	private static final int[] cryoliteLayers = {
		TFCBlocks.StoneIgIn.blockID, 0
	};
	private static final int[] saltpeterLayers = {
		TFCBlocks.StoneSed.blockID, -1
	};
	private static final int[] olivineLayers = {
		TFCBlocks.StoneIgIn.blockID, 2
	};
	private static final int[] serpentineLayers = {
		TFCBlocks.Ore3.blockID, 1
	};
	private static final int[] sylviteLayers = {
		TFCBlocks.StoneSed.blockID, 4
	};
	private static final int[] boraxLayers = {
		TFCBlocks.StoneSed.blockID, 4
	};
	private static final int[] borax2Layers = {
		TFCBlocks.Ore2.blockID, 1
	};
	private static final int[] lapisLayers = {
		TFCBlocks.StoneMM.blockID, 5
	};
	private static final int[] platinumLayers = {
		TFCBlocks.Ore.blockID, 1,
		TFCBlocks.Ore3.blockID, 8
	};

	public WorldGenOre(int min, int max)
	{
		Min = min;
		Max = max;
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		chunkX *= 16;
		chunkZ *= 16;
		int height = Min-Max;
		//============Copper
		createOreVein(TFCBlocks.Ore.blockID, 0, copperLayers,//IgEx and Sandstone, veins
				/*rarity*/100,/*veinSize*/80,/*veinAmt*/55,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Native Copper");

		//============Gold
		createOreVein(TFCBlocks.Ore.blockID, 1, goldLayers,//Ig veins
				/*rarity*/130,/*veinSize*/35,/*veinAmt*/45,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/20,         world, rand, chunkX, chunkZ, Min, Max, "Native Gold");

		//============Hematite
		createOreVein(TFCBlocks.Ore.blockID, 3, hematiteLayers,//IgEx veins
				/*rarity*/100,/*veinSize*/80,/*veinAmt*/42,/*height*/height,/*diameter*/100,/*vDensity*/40,/*hDensity*/30,         world, rand, chunkX, chunkZ, Min, Max, "Hematite");

		//============Silver
		createOreVein(TFCBlocks.Ore.blockID, 4, silverLayers,//granite and gneiss, veins
				/*rarity*/100,/*veinSize*/80,/*veinAmt*/45,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/30,         world, rand, chunkX, chunkZ, Min, Max, "Native Silver");

		//============Cassiterite
		createOreVein(TFCBlocks.Ore.blockID, 5, cassiteriteLayers,//Granite Veins
				/*rarity*/100,/*veinSize*/85,/*veinAmt*/55,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/50,         world, rand, chunkX, chunkZ, Min, Max, "Cassiterite");

		//============Cassiterite2
		createOreVein(TFCBlocks.Ore.blockID, 5, cassiterite2Layers,//IgEx Veins
				/*rarity*/140,/*veinSize*/80,/*veinAmt*/45,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/60,         world, rand, chunkX, chunkZ, Min, Max, "Cassiterite");

		//============Galena
		createOreVein(TFCBlocks.Ore.blockID, 6, galenaLayers,//igex, mm, granite, limestone as veins
				/*rarity*/120,/*veinSize*/80,/*veinAmt*/55,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/60,         world, rand, chunkX, chunkZ, Min, Max, "Galena");

		//============Bismuthinite
		createOreVein(TFCBlocks.Ore.blockID, 7, bismuthiniteLayers,//Granite Veins
				/*rarity*/120,/*veinSize*/80,/*veinAmt*/45,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/60,         world, rand, chunkX, chunkZ, Min, Max, "Bismuthinite");

		//============Garnierite
		createOreVein(TFCBlocks.Ore.blockID, 8, garnieriteLayers,//Gabbro Veins
				/*rarity*/160,/*veinSize*/40,/*veinAmt*/35,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/10,         world, rand, chunkX, chunkZ, Min, Max, "Garnierite");

		//============Malachite
		createOreVein(TFCBlocks.Ore.blockID, 9, malachiteLayers,//limestone and marble veins
				/*rarity*/140,/*veinSize*/80,/*veinAmt*/45,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/20,         world, rand, chunkX, chunkZ, Min, Max, "Malachite");

		//============Magnetite
		createOreVein(TFCBlocks.Ore.blockID, 10, magnetiteLayers,//Sedimentary, Large Cluster
				/*rarity*/180,/*veinSize*/80,/*veinAmt*/36,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Magnetite");

		//============Limonite
		createOreVein(TFCBlocks.Ore.blockID, 11, limoniteLayers,//Sedimentary, Large Cluster
				/*rarity*/180,/*veinSize*/85,/*veinAmt*/40,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Limonite");

		//============Sphalerite
		createOreVein(TFCBlocks.Ore.blockID, 12, sphaleriteLayers,//mm, veins
				/*rarity*/140,/*veinSize*/80,/*veinAmt*/38,/*height*/height,/*diameter*/100,/*vDensity*/60,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Sphalerite");

		//============Tetrahedrite
		createOreVein(TFCBlocks.Ore.blockID, 13, tetrahedriteLayers,//everything, veins
				/*rarity*/120,/*veinSize*/85,/*veinAmt*/45,/*height*/height,/*diameter*/100,/*vDensity*/50,/*hDensity*/30,         world, rand, chunkX, chunkZ, Min, Max, "Tetrahedrite");

		//============Bituminous Coal
		createOre(TFCBlocks.Ore.blockID, 14, bituminousCoalLayers,//sedimentary, veins
				/*rarity*/80,/*veinSize*/80,/*veinAmt*/60,/*height*/height,/*diameter*/200,/*vDensity*/60,/*hDensity*/80,         world, rand, chunkX, chunkZ, Min, Max, "Bituminous Coal");

		//============Lignite
		createOre(TFCBlocks.Ore.blockID, 15, ligniteLayers,//sedimentary, veins
				/*rarity*/80,/*veinSize*/80,/*veinAmt*/60,/*height*/height,/*diameter*/200,/*vDensity*/10,/*hDensity*/80,         world, rand, chunkX, chunkZ, Min, Max, "Lignite");

		//============Kaolinite
		createOre(TFCBlocks.Ore2.blockID, 0, kaoliniteLayers,//sedimentary, large clusters
				/*rarity*/90,/*veinSize*/20,/*veinAmt*/2,/*height*/height,/*diameter*/40,/*vDensity*/80,/*hDensity*/90,         world, rand, chunkX, chunkZ, Min, Max, "Kaolinite");

		//============Gypsum
		createOre(TFCBlocks.Ore2.blockID, 1, gypsumLayers,//sedimentary, large clusters
				/*rarity*/110,/*veinSize*/40,/*veinAmt*/20,/*height*/height,/*diameter*/40,/*vDensity*/50,/*hDensity*/90,         world, rand, chunkX, chunkZ, Min, Max, "Gypsum");

		//============Satinspar
		createOreVein(TFCBlocks.Ore2.blockID, 2, satinsparLayers,//gypsum, small clusters
				/*rarity*/2,/*veinSize*/6,/*veinAmt*/20,/*height*/height,/*diameter*/40,/*vDensity*/40,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Satinspar");

		//============Selenite
		createOreVein(TFCBlocks.Ore2.blockID, 3, seleniteLayers,//gypsum, small clusters
				/*rarity*/2,/*veinSize*/6,/*veinAmt*/20,/*height*/height,/*diameter*/40,/*vDensity*/40,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Selenite");

		//============Graphite
		createOreVein(TFCBlocks.Ore2.blockID, 4, graphiteLayers,//gneiss, quartzite, marble, schist, small clusters
				/*rarity*/100,/*veinSize*/6,/*veinAmt*/24,/*height*/height,/*diameter*/40,/*vDensity*/40,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Graphite");

		//============Kimberlite
		createOreVein(TFCBlocks.Ore2.blockID, 5, kimberliteLayers,//Gabbro, large clusters
				/*rarity*/200,/*veinSize*/40,/*veinAmt*/20,/*height*/height,/*diameter*/40,/*vDensity*/40,/*hDensity*/90,         world, rand, chunkX, chunkZ, Min, Max, "Kimberlite");

		//============Petrified Wood
		createOre(TFCBlocks.Ore2.blockID, 6, petrifiedWoodLayers,//Sedimentary, small clusters 
				/*rarity*/200,/*veinSize*/10,/*veinAmt*/5,/*height*/height,/*diameter*/20,/*vDensity*/10,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Petrified Wood");

		//============Sulfur
		//      createOre(mod_TFCraft.terraOre.blockID, 14, sulfurLayers,//igex, gypsum small clusters
		//              /*rarity*/4,/*veinSize*/6,/*veinAmt*/10,/*height*/128,/*diameter*/40,/*vDensity*/40,/*hDensity*/40,         world, rand, chunkX, chunkZ);

		//============Jet
		createOre(TFCBlocks.Ore2.blockID, 8, jetLayers,//Sedimentary, med clusters 
				/*rarity*/100,/*veinSize*/30,/*veinAmt*/10,/*height*/height,/*diameter*/40,/*vDensity*/60,/*hDensity*/60,         world, rand, chunkX, chunkZ, Min, Max, "Jet");

		//============Microcline
		//        createOre(mod_TFC_Core.terraOre2.blockID, 9, microclineLayers,//granite, large clusters 
		//                /*rarity*/45,/*veinSize*/64,/*veinAmt*/2,/*height*/height,/*diameter*/50,/*vDensity*/10,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max);

		//============Pitchblende
		createOre(TFCBlocks.Ore2.blockID, 10, pitchblendeLayers,//granite, small clusters 
				/*rarity*/100,/*veinSize*/10,/*veinAmt*/10,/*height*/height,/*diameter*/50,/*vDensity*/10,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Pithcblende");

		//============Cinnabar
		createOreVein(TFCBlocks.Ore2.blockID, 11, cinnabarLayers,//igex, shale, quartzite small clusters
				/*rarity*/60,/*veinSize*/35,/*veinAmt*/30,/*height*/height,/*diameter*/50,/*vDensity*/40,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Cinnabar");

		//============Cryolite
		createOre(TFCBlocks.Ore2.blockID, 12, cryoliteLayers,//granite, small clusters 
				/*rarity*/100,/*veinSize*/10,/*veinAmt*/20,/*height*/height,/*diameter*/50,/*vDensity*/10,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Cryolite");

		//============Saltpeter
		createOre(TFCBlocks.Ore2.blockID, 13, saltpeterLayers,//sed, small clusters 
				/*rarity*/100,/*veinSize*/10,/*veinAmt*/20,/*height*/height,/*diameter*/50,/*vDensity*/10,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Saltpeter");

		//============Olivine(Out of Order) must come before serpentine
		createOre(TFCBlocks.Ore3.blockID, 1, olivineLayers,//gabbro, large clusters 
				/*rarity*/80,/*veinSize*/30,/*veinAmt*/14,/*height*/height,/*diameter*/50,/*vDensity*/10,/*hDensity*/60,         world, rand, chunkX, chunkZ, Min, Max, "Olivine");

		//============Serpentine
		createOre(TFCBlocks.Ore2.blockID, 14, serpentineLayers,//Olivine, small clusters 
				/*rarity*/2,/*veinSize*/10,/*veinAmt*/8,/*height*/height,/*diameter*/50,/*vDensity*/10,/*hDensity*/60,         world, rand, chunkX, chunkZ, Min, Max, "Serpentine");

		//============Sylvite
		createOre(TFCBlocks.Ore2.blockID, 15, sylviteLayers,//Rock Salt, large clusters 
				/*rarity*/80,/*veinSize*/40,/*veinAmt*/14,/*height*/height,/*diameter*/50,/*vDensity*/10,/*hDensity*/60,         world, rand, chunkX, chunkZ, Min, Max, "Sylvite");

		//============Borax
		createOre(TFCBlocks.Ore3.blockID, 0, boraxLayers,//Rock Salt, large clusters 
				/*rarity*/50,/*veinSize*/50,/*veinAmt*/24,/*height*/height,/*diameter*/200,/*vDensity*/50,/*hDensity*/60,         world, rand, chunkX, chunkZ, Min, Max, "Borax");
		createOre(TFCBlocks.Ore3.blockID, 0, borax2Layers,//Gypsum, small clusters 
				/*rarity*/3,/*veinSize*/12,/*veinAmt*/22,/*height*/height,/*diameter*/200,/*vDensity*/40,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Borax");
		//============Lapis Lazuli
		createOre(TFCBlocks.Ore3.blockID, 2, lapisLayers,//Marble, small clusters 
				/*rarity*/90,/*veinSize*/20,/*veinAmt*/26,/*height*/height,/*diameter*/60,/*vDensity*/40,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Lapis Lazuli");

		//============Platinum -- (out of order) must follow magnetite and olivine
		createOre(TFCBlocks.Ore.blockID, 2, platinumLayers,//magnetite, veins
				/*rarity*/10,/*veinSize*/8,/*veinAmt*/10,/*height*/height,/*diameter*/25,/*vDensity*/60,/*hDensity*/40,         world, rand, chunkX, chunkZ, Min, Max, "Platinum");

	}

	private static void createOre(int i, int j, int[] Layers, int rarity, int veinSize, 
			int veinAmount, int height, int diameter, int vDensity, int hDensity,World world, Random rand, int chunkX, int chunkZ, int min, int max, String name)
	{
		if(world.getWorldChunkManager() instanceof TFCWorldChunkManager)
		{
			for(int n = 0; n < Layers.length/2;)
			{
				DataLayer rockLayer1 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 0);
				DataLayer rockLayer2 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 1);
				DataLayer rockLayer3 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 2);
				if((rockLayer1.data1 == Layers[n] && (rockLayer1.data2 == Layers[n+1] || Layers[n+1] == -1)) || 
						(rockLayer2.data1 == Layers[n] && (rockLayer2.data2 == Layers[n+1] || Layers[n+1] == -1)) ||
						(rockLayer3.data1 == Layers[n] && (rockLayer3.data2 == Layers[n+1] || Layers[n+1] == -1)))
				{
					new WorldGenMinableTFC(i, j,Layers[n],Layers[n+1],rarity,veinSize,veinAmount,height,diameter,vDensity,hDensity).generate(
							world, rand, chunkX, chunkZ, min, max, name);
				}
				n+=2;
			}
		}
	}

	private static void createOreVein(int i, int j, int[] Layers, int rarity, int veinSize, 
			int veinAmount, int height, int diameter, int vDensity, int hDensity,World world, Random rand, int chunkX, int chunkZ, int min, int max, String name)
	{
		if(world.getWorldChunkManager() instanceof TFCWorldChunkManager)
		{
			for(int n = 0; n < Layers.length/2;)
			{
				DataLayer rockLayer1 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 0);
				DataLayer rockLayer2 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 1);
				DataLayer rockLayer3 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 2);
				if((rockLayer1.data1 == Layers[n] && (rockLayer1.data2 == Layers[n+1] || Layers[n+1] == -1)) || 
						(rockLayer2.data1 == Layers[n] && (rockLayer2.data2 == Layers[n+1] || Layers[n+1] == -1)) ||
						(rockLayer3.data1 == Layers[n] && (rockLayer3.data2 == Layers[n+1] || Layers[n+1] == -1)))
				{
					new WorldGenMinableTFC(i, j,Layers[n],Layers[n+1],rarity,veinSize,veinAmount,height,diameter,vDensity,hDensity).generateVein(
							world, rand, chunkX, chunkZ, min, max, name);
				}
				n+=2;
			}
		}
	}
}
