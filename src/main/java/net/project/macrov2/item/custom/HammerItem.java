package net.project.macrov2.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends MiningToolItem
{
    public HammerItem(ToolMaterial material, Settings settings)
    {
        super(material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    //remove blocks at:
    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        //a list of block positions
        HitResult hit = player.raycast(20, 0, false);
        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;
            //block mined up or down

            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    for(int z = -range; z<= range;z++)
                    {
                        positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY()+y, initalBlockPos.getZ() + z));
                    }
                }
            }
        }

        return positions;
    }

}