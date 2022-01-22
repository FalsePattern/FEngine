package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import org.joml.Vector4i;
import org.joml.Vector4ic;
import org.lwjgl.opengl.GL20C;

public class Uniform4I extends UniformI {
    public Uniform4I(int program, int location) {
        super(program, location, 4);
    }

    public void set(int x, int y, int z, int w) {
        buffer.put(0, x);
        buffer.put(1, y);
        buffer.put(2, z);
        buffer.put(3, w);
    }

    public void set(Vector4ic input) {
        input.get(0, buffer);
    }

    public void get(Vector4i output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniform4iv(location, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_INT_VEC4;
    }
}
