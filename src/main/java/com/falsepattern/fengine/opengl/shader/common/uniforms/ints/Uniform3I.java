package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.lwjgl.opengl.GL20;

import java.nio.IntBuffer;

public class Uniform3I extends UniformI {

    public Uniform3I(int program, int location) {
        super(program, location);
    }

    public void set(IntBuffer input) {
        GL20.glUniform3iv(location, input);
    }

    public void set(int x, int y, int z) {
        GL20.glUniform3i(location, x, y, z);
    }

    public void set(Vector3ic input) {
        set(input.x(), input.y(), input.z());
    }

    public void get(Vector3i output) {
        get(transferBuffer);
        output.set(transferBuffer);
    }

    @Override
    public int type() {
        return GL20.GL_INT_VEC3;
    }
}
