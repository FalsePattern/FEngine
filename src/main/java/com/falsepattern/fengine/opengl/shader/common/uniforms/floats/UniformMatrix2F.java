package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Matrix2f;
import org.joml.Matrix2fc;
import org.lwjgl.opengl.GL20C;

public class UniformMatrix2F extends UniformF {
    public UniformMatrix2F(int program, int location) {
        super(program, location, 4);
    }

    public void set(Matrix2fc input) {
        input.get(0, buffer);
    }

    public void get(Matrix2f output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniformMatrix2fv(location, false, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_FLOAT_MAT2;
    }
}
