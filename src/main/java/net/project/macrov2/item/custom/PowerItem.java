package net.project.macrov2.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.project.macrov2.component.ModDataComponentTypes;
import net.project.macrov2.particle.ModParticles;
import net.project.macrov2.sounds.ModSounds;

import java.util.List;
import java.util.Map;

public class PowerItem extends Item {


    public PowerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient)
        {
            Vec3d look = user.getRotationVec(1.0F); // Direction the player is looking

            // How far to teleport
            double distance = 10;

            // Calculate destination
            Vec3d targetPos = user.getPos().add(look.multiply(distance));

            // Teleport
            user.teleport(targetPos.x, targetPos.y, targetPos.z, false);

            user.getItemCooldownManager().set(this, 100); // 100 ticks = 5 seconds
        }
        user.sendMessage(Text.literal("Up we go!"), true);
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }
}
