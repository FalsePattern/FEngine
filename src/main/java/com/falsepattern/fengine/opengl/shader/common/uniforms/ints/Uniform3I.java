package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.lwjgl.opengl.GL20C;

public class Uniform3I extends UniformI {

    public Uniform3I(int program, int location) {
        super(program, location, 3);
    }

    public void set(int x, int y, int z) {
        buffer.put(0, x);
        buffer.put(1, y);
        buffer.put(2, z);
    }

    public void set(Vector3ic input) {
        input.get(0, buffer);
    }

    public void get(Vector3i output) {
        output.set(0, buffer);
    }

    @Override
    public void upload() {
        GL20C.glUniform3iv(location, buffer);
    }

    @Override
    public int type() {
        return GL20C.GL_INT_VEC3;
    }
}
