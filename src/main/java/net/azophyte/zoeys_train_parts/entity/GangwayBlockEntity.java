package net.azophyte.zoeys_train_parts.entity;

import net.azophyte.zoeys_train_parts.ZoeysTrainParts;
import net.azophyte.zoeys_train_parts.block.GangwayBlock;
import net.azophyte.zoeys_train_parts.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class GangwayBlockEntity extends BlockEntity {
    public GangwayBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.GANGWAY_BE.get(), pos, blockState);
    }
    private float rotation;


    public float getRenderingRotation() {
        if (!level.getBlockState(this.worldPosition).getBlock().equals(ModBlocks.GangwayBlock)){
            return 0;
        }
        Direction direction = level.getBlockState(this.worldPosition).getValue(GangwayBlock.FACING);
        int angle;
        //Why don't switch statements work with non-primitives? cringe!!
        if (direction == Direction.EAST){
            angle = 90;
        } else if (direction == Direction.SOUTH){
            angle = 180;
        } else if (direction == Direction.WEST){
            angle = 270;
        } else {
            angle = 0; //North is default
        }
        return angle;
    }

}
