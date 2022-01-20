package com.falsepattern.fengine.opengl.shader.common.uniforms.floats;

import com.falsepattern.fengine.opengl.shader.common.uniforms.Uniform;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

public abstract class UniformF extends Uniform {
    protected static final FloatBuffer transferBuffer = MemoryUtil.memAllocFloat(16); //Up to 4x4 matrices.
    public UniformF(int program, int location) {
        super(program, location);
    }

    public abstract void set(FloatBuffer input);

    public void get(FloatBuffer output) {
        GL20.glGetUniformfv(program, location, output);
    }
}
