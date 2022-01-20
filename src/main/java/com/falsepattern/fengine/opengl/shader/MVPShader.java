package com.falsepattern.fengine.opengl.shader;

import com.falsepattern.fengine.opengl.shader.common.Shader;
import com.falsepattern.fengine.opengl.shader.common.uniforms.floats.UniformMatrix4F;

public class MVPShader extends Shader {
    public final UniformMatrix4F modelViewProjection = getUniform("modelViewProjection", UniformMatrix4F::new);

    public MVPShader(int program) {
        super(program);
    }
}
