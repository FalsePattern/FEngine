package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Vector2f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class Uniform4F extends UniformF {
    public Uniform4F(int program, int location) {
        super(program, location);
    }

    public void set(FloatBuffer input) {
        GL20.glUniform4fv(location, input);
    }

    public void set(float x, float y, float z, float w) {
        GL20.glUniform4f(location, x, y, z, w);
    }

    public void set(Vector4fc input) {
        set(input.x(), input.y(), input.z(), input.w());
    }

    public void get(Vector4f output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_FLOAT_VEC4;
    }
}
