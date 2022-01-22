package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL20C;

public class UniformMatrix4F extends UniformF {
    public UniformMatrix4F(int program, int location) {
        super(program, location, 16);
    }

    public void set(Matrix4fc input) {
        input.get(0, buffer);
    }

    public void get(Matrix4f output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniformMatrix4fv(location, false, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_FLOAT_MAT4;
    }
}
