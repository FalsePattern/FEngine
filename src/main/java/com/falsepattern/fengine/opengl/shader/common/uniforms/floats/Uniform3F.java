package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.lwjgl.opengl.GL20C;

public class Uniform3F extends UniformF {
    public Uniform3F(int program, int location) {
        super(program, location, 3);
    }

    public void set(float x, float y, float z) {
        buffer.put(0, x);
        buffer.put(1, y);
        buffer.put(2, z);
    }

    public void set(Vector3fc input) {
        input.get(0, buffer);
    }

    public void get(Vector3f output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniform3fv(location, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_FLOAT_VEC3;
    }
}
