package net.glad0s.bobberdetector.content;

import com.simibubi.create.foundation.block.IBE;
import net.glad0s.bobberdetector.content.entity.BobberDetectorBlockEntity;
import net.glad0s.bobberdetector.register.BDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class BobberDetectorBlock extends Block implements IBE<BobberDetectorBlockEntity> {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public BobberDetectorBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(POWERED, false)
                .setValue(LIT, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED, LIT, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        return this.defaultBlockState().setValue(FACING, context.getPlayer().isCrouching() ? context.getHorizontalDirection().getOpposite() : context.getHorizontalDirection());
    }

    public static void setPowered(BlockState state, Level level, BlockPos pos, boolean powered) {
        if (!level.isClientSide) {
            level.setBlock(pos, state.setValue(POWERED, powered), 3);
        }
    }

    public static void setLit(BlockState state, Level level, BlockPos pos, boolean lit) {
        if (!level.isClientSide) {
            level.setBlock(pos, state.setValue(LIT, lit), 3);
        }
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public int getSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
        return blockState.getValue(POWERED) ? 15 : 0;
    }

    public static Direction getFacingDirection(BlockState state) {
        return state.getValue(FACING);
    }

    @Override
    public Class<BobberDetectorBlockEntity> getBlockEntityClass() {
        return BobberDetectorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends BobberDetectorBlockEntity> getBlockEntityType() {
        return BDBlockEntities.BOBBER_BLOCK_ENTITY.get();
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BDBlockEntities.BOBBER_BLOCK_ENTITY.create(pos, state);
    }
}
