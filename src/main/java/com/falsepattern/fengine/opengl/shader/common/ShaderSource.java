package com.falsepattern.fengine.opengl.shader.common;

import lombok.Builder;

import static org.lwjgl.opengl.GL32C.*;

public class ShaderSource {
    public final String source;
    public final Type type;

    @Builder
    public ShaderSource(String source, Type type) {
        this.source = source;
        this.type = type;
    }

    public enum Type {
        VERTEX, GEOMETRY, FRAGMENT;

        public int toGL() {
            return switch (this) {
                case VERTEX -> GL_VERTEX_SHADER;
                case GEOMETRY -> GL_GEOMETRY_SHADER;
                case FRAGMENT -> GL_FRAGMENT_SHADER;
            };
        }
    }
}
