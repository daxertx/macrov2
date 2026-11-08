package net.project.macrov2.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.item.ModItems;

public class ModModelPredicates
{
    public static void registerModelPredicates()
    {
        //chisel
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(Macrov2.MOD_ID,"change"),
                (stack, world, entity, seed) ->
                {
                    if(entity!=null)
                    //make sure u hold something
                    {
                        StatusEffectInstance haste = entity.getStatusEffect(StatusEffects.HASTE);
                        if (haste != null && haste.getAmplifier() >= 0)
                        {
                            //got haste
                            return 1.0f;
                        }
                    }
                    return 0f;
                }

        );
        registerCustomBow(ModItems.KAUPEN_BOW);
        //change = 1 or 0 which effects the .json file at models items chisel.json
    }
    private static void registerCustomBow(Item item) {
        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                item,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }
}
