package net.project.macrov2.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.entity.custom.MantisEntity;

public class MantisRenderer extends MobEntityRenderer<MantisEntity, MantisModel<MantisEntity>>
{
    public MantisRenderer(EntityRendererFactory.Context context)
    {
        super(context, new MantisModel<>(context.getPart(MantisModel.MANTIS)),0.9f);
    }

    @Override
    public Identifier getTexture(MantisEntity entity)
    {
        return Identifier.of(Macrov2.MOD_ID,"textures/entity/mantis/mantis.png");
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
