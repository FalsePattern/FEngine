package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.lwjgl.opengl.GL20C;

public class UniformMatrix3F extends UniformF {
    public UniformMatrix3F(int program, int location) {
        super(program, location, 9);
    }

    public void set(Matrix3fc input) {
        input.get(0, buffer);
    }

    public void get(Matrix3f output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniformMatrix3fv(location, false, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_FLOAT_MAT3;
    }
}
