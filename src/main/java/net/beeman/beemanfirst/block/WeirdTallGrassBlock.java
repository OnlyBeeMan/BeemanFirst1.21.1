package net.beeman.beemanfirst.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class WeirdTallGrassBlock extends TallPlantBlock {
    public WeirdTallGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND) || floor.isIn(BlockTags.SOUL_SPEED_BLOCKS);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
        double d = pos.getX() + vec3d.x;
        double e = pos.getZ() + vec3d.z;

        for (int i = 0; i < 3; i++) {
            if (random.nextBoolean()) {
                world.addParticle(
                        ParticleTypes.SMOKE, d + random.nextDouble() / 5.0, pos.getY() + (0.5 - random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0
                );
            }
        }
    }
}
