package net.project.macrov2.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.project.macrov2.Macrov2;
import net.project.macrov2.entity.custom.MantisEntity;
import net.project.macrov2.entity.custom.MantisVariant;

import java.util.Map;

public class MantisRenderer extends MobEntityRenderer<MantisEntity, MantisModel<MantisEntity>>
{
    private static final Map<MantisVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(MantisVariant.class), map -> {
                map.put(MantisVariant.DEFAULT,
                        Identifier.of(Macrov2.MOD_ID, "textures/entity/mantis/mantis.png"));
                map.put(MantisVariant.ORCHID,
                        Identifier.of(Macrov2.MOD_ID, "textures/entity/mantis/mantis_orchid.png"));
            });


    public MantisRenderer(EntityRendererFactory.Context context)
    {
        super(context, new MantisModel<>(context.getPart(MantisModel.MANTIS)),0.9f);
    }

    @Override
    public Identifier getTexture(MantisEntity entity)
    {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(MantisEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i)
    {
        //size
        if(livingEntity.isBaby())
        {
            //baby
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        else
        {
            //adult
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
