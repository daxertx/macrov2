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
import net.project.macrov2.particle.ModParticles;

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
    }public static void shoot(World world, PlayerEntity user, Hand hand, EquipmentSlot slot) {
        ItemStack gunStack = user.getStackInHand(hand);
        Vec3d look = user.getRotationVec(1.0F); // forward
        Vec3d startPos = user.getCameraPosVec(1.0F); // eye level

        // Damage the gun
        gunStack.damage(1, user, slot);

        double maxDistance = 4.0;
        double step = 1;

        // Rotate look vector 90° to the left (on horizontal plane)
        Vec3d leftVec = new Vec3d(look.z, 0, -look.x).normalize();

        // Spray: create multiple lines slightly offset around the leftVec
        int sprayLines = 5; // total spread lines
        double spreadRange = 0.6; // total spread width

        for (int i = 0; i < sprayLines; i++) {
            double offsetAmount = ((double) i / (sprayLines - 1)) - 0.5;
            Vec3d offsetVec = leftVec.multiply(offsetAmount * spreadRange);

            for (double d = 0; d < maxDistance; d += step) {
                Vec3d particlePos = startPos.add(look.multiply(d)).add(offsetVec);

                ((ServerWorld) world).spawnParticles(
                        ModParticles.AMMO_PARTICLE,
                        particlePos.x,
                        particlePos.y,
                        particlePos.z,
                        1,
                        0, 0, 0, 0
                );

                for (Entity target : world.getOtherEntities(user, user.getBoundingBox().expand(4))) {
                    if (target.isAlive() && target != user && target.getBoundingBox().expand(0.3).contains(particlePos)) {
                        double distance = user.getEyePos().distanceTo(particlePos);
                        float maxDamage = 20.0f;
                        float minDamage = 6.0f;
                        double maxRange = 4.0;
                        if(Math.max(minDamage, maxDamage * (1 - distance / maxRange))>0)
                        {
                            target.damage(user.getDamageSources().playerAttack(user), (float) Math.max(minDamage, maxDamage * (1 - distance / maxRange)));
                        }
                        world.playSound(null, particlePos.x, particlePos.y, particlePos.z,
                                SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.PLAYERS, 1.0f, 1.0f);
                        return;
                    }
                }
            }
        }
    }


}
