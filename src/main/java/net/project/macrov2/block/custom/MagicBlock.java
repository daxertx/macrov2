package net.project.macrov2.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.project.macrov2.item.ModItems;
import net.project.macrov2.util.ModTags;

import java.util.List;

public class MagicBlock extends Block {

    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit)
    {
        world.playSound(player,pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS,10f,2f);

        return ActionResult.SUCCESS;
    }
 
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity)
        {
            if(isValidItem(itemEntity.getStack()))
            {
                //raw pink garnet is droped on the block then item turn to raw pink garnet
                itemEntity.setStack(new ItemStack(Items.GOLD_INGOT, itemEntity.getStack().getCount()));
            }


        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown())
        {
            tooltip.add(Text.translatable("tooltip.macrov2.magic_block.tooltip_shift_down"));
        }
        else
        {
            tooltip.add(Text.translatable("tooltip.macrov2.magic_block.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, options);

    }

}
