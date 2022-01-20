package com.falsepattern.fengine.opengl.shader.common.uniforms.ints;

import com.falsepattern.fengine.opengl.shader.common.uniforms.Uniform;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

public abstract class UniformI extends Uniform {
    protected static final IntBuffer transferBuffer = MemoryUtil.memAllocInt(4); //Up to vec4i.
    public UniformI(int program, int location) {
        super(program, location);
    }

    public abstract void set(IntBuffer input);

    public void get(IntBuffer output) {
        GL20C.glGetUniformiv(program, location, output);
    }
}
