package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.opengl.GL20C;

public class Uniform2I extends UniformI {
    public Uniform2I(int program, int location) {
        super(program, location, 2);
    }

    public void set(int x, int y) {
        buffer.put(0, x);
        buffer.put(1, y);
    }

    public void set(Vector2ic input) {
        input.get(0, buffer);
    }

    public void get(Vector2i output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniform2iv(location, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_INT_VEC2;
    }
}
