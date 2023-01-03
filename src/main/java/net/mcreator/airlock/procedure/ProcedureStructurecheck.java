package net.mcreator.airlock.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.airlock.block.BlockAirlockframe;
import net.mcreator.airlock.block.BlockAirlockcontrollerblock;
import net.mcreator.airlock.ElementsAirLockMod;

import java.util.Map;

@ElementsAirLockMod.ModElement.Tag
public class ProcedureStructurecheck extends ElementsAirLockMod.ModElement {
	public ProcedureStructurecheck(ElementsAirLockMod instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Structurecheck!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Structurecheck!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Structurecheck!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Structurecheck!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = (double) (-3);
		found = (boolean) (false);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			sy = (double) (-3);
			for (int index1 = 0; index1 < (int) (6); index1++) {
				sz = (double) (-3);
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
							.getBlock() == BlockAirlockcontrollerblock.block.getDefaultState().getBlock())) {
						found = (boolean) (true);
					}
					sz = (double) ((sz) + 1);
				}
				sy = (double) ((sy) + 1);
			}
			sx = (double) ((sx) + 1);
		}
		if (((found) == (true))) {
			sx = (double) (-3);
			found = (boolean) (false);
			for (int index3 = 0; index3 < (int) (6); index3++) {
				sy = (double) (-3);
				for (int index4 = 0; index4 < (int) (6); index4++) {
					sz = (double) (-3);
					for (int index5 = 0; index5 < (int) (6); index5++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
								.getBlock() == BlockAirlockframe.block.getDefaultState().getBlock())) {
							found = (boolean) (true);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (((found) == (true))) {
				{
					BlockPos _bp = new BlockPos((int) (sx), (int) (sy), (int) (sz));
					IBlockState _bs = Blocks.STONE_STAIRS.getDefaultState();
					IBlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
						IProperty _property = entry.getKey();
						if (_bs.getPropertyKeys().contains(_property))
							_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
	}
}
