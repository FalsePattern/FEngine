package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Matrix2f;
import org.joml.Matrix2fc;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class UniformMatrix2F extends UniformF {
    public UniformMatrix2F(int program, int location) {
        super(program, location);
    }

    public void set(FloatBuffer input) {
        GL20.glUniformMatrix2fv(location, false, input);
    }

    public void set(Matrix2fc input) {
        set(input.get(transferBuffer));
    }

    public void get(Matrix2f output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_FLOAT_MAT2;
    }
}
