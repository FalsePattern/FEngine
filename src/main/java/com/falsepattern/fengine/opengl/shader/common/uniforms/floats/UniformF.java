package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import com.falsepattern.fengine.opengl.shader.common.uniforms.Uniform;
import org.lwjgl.opengl.GL20C;

import java.nio.FloatBuffer;

public abstract class UniformF extends Uniform {
    protected final FloatBuffer buffer = super.buffer.asFloatBuffer();
    public UniformF(int program, int location, int floatCount) {
        super(program, location, floatCount * 4);
    }

    public void set(FloatBuffer input) {
        buffer.put(0, input, 0, buffer.limit());
    }

    public void get(FloatBuffer output) {
        output.put(0, buffer, 0, buffer.limit());
    }

    @Override
    public void download() {
        GL20C.glGetUniformfv(program, location, buffer);
    }
}
