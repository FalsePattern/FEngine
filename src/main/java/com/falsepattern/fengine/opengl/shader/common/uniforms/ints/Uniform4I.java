package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import org.joml.Vector4i;
import org.joml.Vector4ic;
import org.lwjgl.opengl.GL20;

import java.nio.IntBuffer;

public class Uniform4I extends UniformI {
    public Uniform4I(int program, int location) {
        super(program, location);
    }

    public void set(IntBuffer input) {
        GL20.glUniform4iv(location, input);
    }

    public void set(int x, int y, int z, int w) {
        GL20.glUniform4i(location, x, y, z, w);
    }

    public void set(Vector4ic input) {
        set(input.x(), input.y(), input.z(), input.w());
    }

    public void get(Vector4i output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_INT_VEC4;
    }
}
