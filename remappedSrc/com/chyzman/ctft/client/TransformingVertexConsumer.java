package com.chyzman.ctft.client;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Vector4f;

public record TransformingVertexConsumer(VertexConsumer parent, MatrixStack.Entry transform) implements VertexConsumer {
    @Override
    public VertexConsumer vertex(double x, double y, double z) {
        var vertex = new Vector4f((float) x, (float) y, (float) z, 1f);
        vertex.mul(this.transform.getPositionMatrix());

        this.parent.vertex(vertex.x, vertex.y, vertex.z);

        return this;
    }

    @Override
    public VertexConsumer color(int red, int green, int blue, int alpha) {
        this.parent.color(red, green, blue, alpha);
        return this;
    }

    @Override
    public VertexConsumer texture(float u, float v) {
        this.parent.texture(u, v);
        return this;
    }

    @Override
    public VertexConsumer overlay(int u, int v) {
        this.parent.overlay(u, v);
        return this;
    }

    @Override
    public VertexConsumer light(int u, int v) {
        this.parent.light(u, v);
        return this;
    }

    @Override
    public VertexConsumer normal(float x, float y, float z) {
        var vertex = new Vector4f(x, y, z, 1f);
        vertex.mul(this.transform.getPositionMatrix());

        this.parent.normal(vertex.x, vertex.y, vertex.z);

        return this;
    }

    @Override
    public void next() {
        this.parent.next();
    }

    @Override
    public void fixedColor(int red, int green, int blue, int alpha) {
        this.parent.fixedColor(red, green, blue, alpha);
    }

    @Override
    public void unfixColor() {
        this.parent.unfixColor();
    }
}
