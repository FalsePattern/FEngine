package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class UniformMatrix4F extends UniformF {
    public UniformMatrix4F(int program, int location) {
        super(program, location);
    }

    public void set(FloatBuffer input) {
        GL20.glUniformMatrix4fv(location, false, input);
    }

    public void set(Matrix4fc input) {
        set(input.get(transferBuffer));
    }

    public void get(Matrix4f output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_FLOAT_MAT4;
    }
}
