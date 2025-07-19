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
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.project.macrov2.item.ModItems;

public class ShotgunItem extends Item {

    public ShotgunItem(Settings settings) {
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
                if (invStack.getItem() == ammoItem && user.getInventory().getStack(i).getCount()>9)
                {
                        EquipmentSlot slot = EquipmentSlot.MAINHAND;
                        // Consume one bullet
                        invStack.decrement(9);
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
        double maxDistance = 4.0;
        // Distance between each particle
        double step = 0.5;

        // Spawn a line of particles
        for (double d = 0; d < maxDistance; d += step)
        {
            Vec3d particlePos = startPos.add(look.multiply(d));
            Direction direction = user.getHorizontalFacing();
            int x = 0;
            int z = 0;
            if (direction == Direction.NORTH)
            {
                // player is looking north
                x--;
            }
            else if (direction == Direction.SOUTH)
            {
                // player is looking south
                x++;
            }
            else if (direction == Direction.EAST)
            {
                // player is looking east
                z++;
            }
            else if (direction == Direction.WEST)
            {
                // player is looking west
                z--;
            }

            ((ServerWorld) world).spawnParticles(
                    ParticleTypes.CRIT, // Or any particle you want
                    particlePos.x,
                    particlePos.y,
                    particlePos.z,
                    3, // count
                   x, 1, z, 0.0
            );

            for (Entity target : world.getOtherEntities(user, user.getBoundingBox().expand(4))) {
                if (target.isAlive() && target != user && target.getBoundingBox().expand(0.3).contains(particlePos)) {
                    double distance = user.getEyePos().distanceTo(particlePos);
                    float maxDamage = 8.0f;
                    float minDamage = 2.0f;
                    double maxRange = 4.0;

                    float damage = (float) Math.max(minDamage, maxDamage * (1 - distance / maxRange));
                    target.damage(user.getDamageSources().playerAttack(user), damage);

                    world.playSound(null, particlePos.x, particlePos.y, particlePos.z, SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.PLAYERS, 1.0f, 1.0f);
                    return;
                }
            }
        }
    }
}
