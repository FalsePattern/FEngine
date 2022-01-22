package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import com.falsepattern.fengine.opengl.shader.common.uniforms.Uniform;
import org.lwjgl.opengl.GL20C;

import java.nio.IntBuffer;

public abstract class UniformI extends Uniform {
    protected final IntBuffer buffer = super.buffer.asIntBuffer(); //Up to vec4i.
    protected UniformI(int program, int location, int intCount) {
        super(program, location, intCount * 4);
    }

    public void set(IntBuffer input) {
        buffer.put(0, input, 0, buffer.limit());
    }

    public void get(IntBuffer output) {
        output.put(0, buffer, 0, buffer.limit());
    }

    @Override
    public void download() {
        GL20C.glGetUniformiv(program, location, buffer);
    }
}
