package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL20C;

public class Uniform1I extends UniformI {
    public Uniform1I(int program, int location) {
        super(program, location, 1);
    }

    public void set(int x) {
        buffer.put(0, x);
    }

    public int get() {
        return buffer.get(0);
    }

    @Override
    public void upload() {
        GL20C.glUniform1iv(location, buffer);
    }

    @Override
    public int type() {
        return GL11C.GL_INT;
    }
}
