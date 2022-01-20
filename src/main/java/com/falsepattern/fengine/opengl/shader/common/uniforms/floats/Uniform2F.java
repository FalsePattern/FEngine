package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class Uniform2F extends UniformF {
    public Uniform2F(int program, int location) {
        super(program, location);
    }

    public void set(FloatBuffer input) {
        GL20.glUniform2fv(location, input);
    }

    public void set(float x, float y) {
        GL20.glUniform2f(location, x, y);
    }

    public void set(Vector2fc input) {
        set(input.x(), input.y());
    }

    public void get(Vector2f output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_FLOAT_VEC2;
    }
}
