package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.lwjgl.opengl.GL20C;

public class Uniform4F extends UniformF {
    public Uniform4F(int program, int location) {
        super(program, location, 4);
    }

    public void set(float x, float y, float z, float w) {
        buffer.put(0, x);
        buffer.put(1, y);
        buffer.put(2, z);
        buffer.put(3, w);
    }

    public void set(Vector4fc input) {
        input.get(0, buffer);
    }

    public void get(Vector4f output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniform4fv(location, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_FLOAT_VEC4;
    }
}
