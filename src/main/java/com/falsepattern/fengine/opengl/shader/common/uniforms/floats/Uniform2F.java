package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.lwjgl.opengl.GL20C;

public class Uniform2F extends UniformF {
    public Uniform2F(int program, int location) {
        super(program, location, 2);
    }

    public void set(float x, float y) {
        buffer.put(0, x);
        buffer.put(1, y);
    }

    public void set(Vector2fc input) {
        input.get(0, buffer);
    }

    public void get(Vector2f output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniform2fv(location, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_FLOAT_VEC2;
    }
}
