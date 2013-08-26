package TFC.WorldGen.Generators;

import java.util.Random;

import TFC.*;
import TFC.Core.TFC_Core;
import TFC.WorldGen.TFCWorldChunkManager;
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

public class WorldGenCustomSand extends WorldGenerator
{
    /** Stores ID for WorldGenSand */
    private int sandID;

    /** The maximum radius used when generating a patch of blocks. */
    private int radius;

    public WorldGenCustomSand(int par1, int par2)
    {
        this.sandID = par2;
        this.radius = par1;
    }

    public boolean generate(World world, Random par2Random, int blockX, int blockY, int blockZ)
    {
        if (world.getBlockMaterial(blockX, blockY, blockZ) != Material.water)
        {
            return false;
        }
        else
        {
        	
        	int meta = sandID = ((TFCWorldChunkManager)world.provider.worldChunkMgr).getRockLayerAt(blockX, blockZ, 0).data2;
        	sandID = TFC_Core.getTypeForSand(sandID);
            int finalRadius = par2Random.nextInt(this.radius - 2) + 2;
			int radiusSquared = finalRadius * finalRadius;
            byte var7 = 2;

            for (int x = blockX - finalRadius; x <= blockX + finalRadius; ++x)
            {
                int dx = x - blockX;
				int dxSquared = dx * dx;

                for (int z = blockZ - finalRadius; z <= blockZ + finalRadius; ++z)
                {
                    int dz = z - blockZ;
					int dzSquared = dz * dz;

                    if (dxSquared + dzSquared <= radiusSquared)
                    {
                        for (int y = blockY - var7; y <= blockY + var7; ++y)
                        {
                            int id = world.getBlockId(x, y, z);

                            boolean notCorrectSoil = !TFC_Core.isSoil(id) && !TFC_Core.isSand(id) ;
                            if (!notCorrectSoil)
                            {
                                world.setBlock(x, y, z, sandID, meta, 0x2);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
