package net.project.macrov2.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.item.ModItems;

public class ModModelPredicates
{
    public static void registerModelPredicates()
    {

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
        //change = 1 or 0 which effects the .json file at models items chisel.json
    }
}
