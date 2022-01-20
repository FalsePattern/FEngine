package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class Uniform3F extends UniformF {
    public Uniform3F(int program, int location) {
        super(program, location);
    }

    public void set(FloatBuffer input) {
        GL20.glUniform3fv(location, input);
    }

    public void set(float x, float y, float z) {
        GL20.glUniform3f(location, x, y, z);
    }

    public void set(Vector3fc input) {
        set(input.x(), input.y(), input.z());
    }

    public void get(Vector3f output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_FLOAT_VEC3;
    }
}
