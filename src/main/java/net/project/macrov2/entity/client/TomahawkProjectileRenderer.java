package net.project.macrov2.entity.client;



import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.project.macrov2.Macrov2;
import net.project.macrov2.entity.custom.TomahawkProjectileEntity;

import javax.crypto.Mac;

public class TomahawkProjectileRenderer extends EntityRenderer<TomahawkProjectileEntity>
{

    protected TomahawkProjectileModel model;

    public TomahawkProjectileRenderer(EntityRendererFactory.Context ctx)
    {
        super(ctx);
        this.model = new TomahawkProjectileModel(ctx.getPart(TomahawkProjectileModel.TOMAHAWK));
    }


    @Override
    public void render(TomahawkProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light)
    {
        matrices.push();

        if(!entity.isGrounded())
        {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw())));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.getRenderingRotation() * 5f));
            matrices.translate(0, -1.0f, 0);
        }
        else
        {
            //touch ground
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.groundedOffset.y));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.groundedOffset.x));
            matrices.translate(0, -1.0f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(Macrov2.MOD_ID, "textures/entity/tomahawk/tomahawk.png")), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(TomahawkProjectileEntity entity)
    {
        return Identifier.of(Macrov2.MOD_ID, "textures/entity/tomahawk/tomahawk.png");
    }

}
