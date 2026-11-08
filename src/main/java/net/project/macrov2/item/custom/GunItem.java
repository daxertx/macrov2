package net.project.macrov2.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.project.macrov2.item.ModItems;
import net.project.macrov2.particle.ModParticles;

public class GunItem extends Item {

    public GunItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack gunStack = user.getStackInHand(hand);
        Item ammoItem = ModItems.AMMO;

        if (!world.isClient)
        {

            for (int i = 0; i < user.getInventory().size(); i++) {
                //CHECK EVERY INV SLOT
                ItemStack invStack = user.getInventory().getStack(i);
                if (invStack.getItem() == ammoItem) {
                    EquipmentSlot slot = EquipmentSlot.MAINHAND;
                    // Consume one bullet
                    invStack.decrement(1);
                    //shoot
                    shoot(world,user,hand,slot);
                    break;
                }
                if(i==user.getInventory().size()-1)
                    user.sendMessage(Text.literal("Out of ammo!"), true);
            }

        }
        return  TypedActionResult.success(gunStack, world.isClient());
    }
    public static void shoot(World world, PlayerEntity user, Hand hand,EquipmentSlot slot)
    {

        ItemStack gunStack = user.getStackInHand(hand);
        Vec3d look = user.getRotationVec(1.0F); // Direction the player is looking
        Vec3d startPos = user.getCameraPosVec(1.0F); // Eye position

        // Damage the gun
        gunStack.damage(1,user,slot);
        // Length of the line
        double maxDistance = 10.0;
        // Distance between each particle
        double step = 1;

        // Spawn a line of particles
        for (double d = 0; d < maxDistance; d += step) {
            Vec3d particlePos = startPos.add(look.multiply(d));
            ((ServerWorld) world).spawnParticles(
                    ModParticles.AMMO_PARTICLE, // Or any particle you want
                    particlePos.x,
                    particlePos.y,
                    particlePos.z,
                    1, // count
                    0, 0, 0, 0.0 // No random spread or speed
            );

            for (Entity target : world.getOtherEntities(user, user.getBoundingBox().expand(10)))
            {
                //loop tracks all entity by 10 10 blocks from user
                if (target.isAlive() && target != user && target.getBoundingBox().expand(0.3).contains(particlePos))
                {
                    target.damage(user.getDamageSources().playerAttack(user), 12.0f);
                    world.playSound(null, particlePos.x, particlePos.y, particlePos.z, SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.PLAYERS, 1.0f, 1.0f);
                    return;
                }

        }


    }


}}
