package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class UniformMatrix3F extends UniformF {
    public UniformMatrix3F(int program, int location) {
        super(program, location);
    }

    public void set(FloatBuffer input) {
        GL20.glUniformMatrix3fv(location, false, input);
    }

    public void set(Matrix3fc input) {
        set(input.get(transferBuffer));
    }

    public void get(Matrix3f output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_FLOAT_MAT3;
    }
}
