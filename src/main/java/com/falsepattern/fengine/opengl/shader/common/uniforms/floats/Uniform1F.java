package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL20C;

public class Uniform1F extends UniformF {
    public Uniform1F(int program, int location) {
        super(program, location, 1);
    }

    public void set(float x) {
        buffer.put(0, x);
    }

    public float get() {
        return buffer.get(0);
    }

    @Override
    public void upload() {
        GL20C.glUniform1fv(location, buffer);
    }

    @Override
    public int type() {
        return GL11C.GL_FLOAT;
    }
}
