package com.falsepattern.fengine.opengl.shader.common.uniforms.sampler;

import com.falsepattern.fengine.opengl.shader.common.uniforms.ints.Uniform1I;
import org.lwjgl.opengl.GL20;

public class Sampler3D extends Uniform1I {
    public Sampler3D(int program, int location) {
        super(program, location);
    }

    @Override
    public int type() {
        return GL20.GL_SAMPLER_3D;
    }
}
