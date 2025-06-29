package net.project.macrov2.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.component.ModDataComponentTypes;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block,Block> CHISEL_MAP =
            Map.of
            (
                    //keys
                    //stone
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.STONE_BRICKS, Blocks.STONE,

                    // Sandstone
                    Blocks.SANDSTONE, Blocks.CUT_SANDSTONE,
                    Blocks.CUT_SANDSTONE, Blocks.SANDSTONE,

                    // Deepslate
                    Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE,
                    Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE,

                    // Cobblestone
                    Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE,
                    Blocks.MOSSY_COBBLESTONE, Blocks.COBBLESTONE

            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();

        //gets the clicked on block corrent state position

        Block clickedblock = world.getBlockState(context.getBlockPos()).getBlock();
        if(CHISEL_MAP.containsKey(clickedblock))
        {
            if(!world.isClient())
            {
                //on server
                //change the block at his position
                world.setBlockState(context.getBlockPos(),CHISEL_MAP.get(clickedblock).getDefaultState());
                //item in hand
                //damage item
                context.getStack().damage(1,((ServerWorld) world),((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                //ender dragon hurt sound plays on block changing
                world.playSound(null,context.getBlockPos(), SoundEvents.BLOCK_COPPER_TRAPDOOR_OPEN, SoundCategory.BLOCKS);
                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown())
        {
            tooltip.add(Text.translatable("tooltip.macrov2.chisel.shift_down"));
        }
        else
        {
            tooltip.add(Text.translatable("tooltip.macrov2.chisel"));
        }
        if(stack.get(ModDataComponentTypes.COORDINATES) != null)
        {
            //if is a thing and not empty
            //add a tooltip msg + edit stack get msg to look nicer
            String textonitem = ("Last block changed is at: "+stack.get(ModDataComponentTypes.COORDINATES)).replace("BlockPos","").replace("{","(").replace("}",")");
            tooltip.add(Text.literal(textonitem));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
