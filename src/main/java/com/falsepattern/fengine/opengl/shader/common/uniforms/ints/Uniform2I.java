package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.opengl.GL20;

import java.nio.IntBuffer;

public class Uniform2I extends UniformI {
    public Uniform2I(int program, int location) {
        super(program, location);
    }

    public void set(IntBuffer input) {
        GL20.glUniform2iv(location, input);
    }

    public void set(int x, int y) {
        GL20.glUniform2i(location, x, y);
    }

    public void set(Vector2ic input) {
        set(input.x(), input.y());
    }

    public void get(Vector2i output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_INT_VEC2;
    }
}
