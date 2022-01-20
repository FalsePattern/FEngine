package com.falsepattern.fengine.opengl.shader.common;

import com.falsepattern.fengine.opengl.shader.common.uniforms.Uniform;
import com.falsepattern.fengine.util.Disposable;
import lombok.val;
import org.lwjgl.system.MemoryStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.lwjgl.opengl.GL20C.*;

public class Shader implements Disposable {
    private static int currentShader = 0;
    protected final int program;

    public Shader(int program) {
        this.program = program;
    }

    public void bind() {
        if (currentShader == program) return;
        currentShader = program;
        glUseProgram(program);
    }

    public static void unbind() {
        if (currentShader == 0) return;
        currentShader = 0;
        glUseProgram(0);
    }

    public <T extends Uniform> T getUniform(String name, BiFunction<Integer, Integer, T> constructor) {
        val loc = glGetUniformLocation(program, name);
        if (loc < 0) {
            throw new ShaderException("Failed to retrieve uniform location: " + name);
        }
        var id = 0;
        final int size;
        final int type;
        try (val stack = MemoryStack.stackPush()) {
            val buf = stack.mallocInt(2);
            val maxID = glGetProgrami(program, GL_ACTIVE_UNIFORMS);
            val maxLen = glGetProgrami(program, GL_ACTIVE_UNIFORM_MAX_LENGTH);
            var success = false;
            for (; id < maxID; id++) {
                if (name.equals(glGetActiveUniform(program, id, maxLen, buf.slice(0, 1), buf.slice(1, 1)))) {
                    success = true;
                    break;
                }
            }
            if (!success) throw new ShaderException("Uniform type verification failed!");
            size = buf.get(0);
            type = buf.get(1);
        }
        val result = constructor.apply(program, loc);
        if (result.type() != type) {
            throw new ShaderException("Failed to retrieve uniform " + name + " as " + result.getClass().getCanonicalName() + ": Type mismatch!");
        }
        if (result.size() != size) {
            throw new ShaderException("Failed to retrieve uniform " + name + " as " + result.getClass().getCanonicalName() + ": Size mismatch!");
        }
        return result;
    }

    public int getAttribLocation(String name) {
        val loc = glGetAttribLocation(program, name);
        if (loc < 0) {
            throw new ShaderException("Failed to retrieve attribute location: " + name);
        }
        return loc;
    }

    @Override
    public void dispose() {
        glDeleteProgram(program);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        protected final List<ShaderSource> sources = new ArrayList<>();
        public Builder(){}

        public Builder addVertex(String source) {
            sources.add(new ShaderSource(source, ShaderSource.Type.VERTEX));
            return this;
        }

        public Builder addGeometry(String source) {
            sources.add(new ShaderSource(source, ShaderSource.Type.GEOMETRY));
            return this;
        }

        public Builder addFragment(String source) {
            sources.add(new ShaderSource(source, ShaderSource.Type.FRAGMENT));
            return this;
        }

        public Builder add(ShaderSource source) {
            sources.add(source);
            return this;
        }

        public <T extends Shader> T build(Function<Integer, T> constructor) {
            val program = ShaderHelper.createShader(sources.toArray(new ShaderSource[0]));
            return constructor.apply(program);
        }

    }
}
