package com.falsepattern.fengine.opengl.shader.common;

import lombok.val;

import static org.lwjgl.opengl.GL20C.*;

public class ShaderHelper {
    public static int createShader(ShaderSource... sources) {
        val shaders = new int[sources.length];
        int createdShaders = 0;
        try {
            for (int i = 0; i < sources.length; i++) {
                val source = sources[i];
                val shader = compileShader(source.source, source.type.toGL());
                createdShaders++;
                shaders[i] = shader;
            }
            return createProgram(shaders);
        } finally {
            for (int i = createdShaders - 1; i >= 0; i--) {
                glDeleteShader(shaders[i]);
            }
        }
    }

    public static int createShader(String vertexSource, String fragmentSource) {
        int vertexShader = compileShader(vertexSource, GL_VERTEX_SHADER);
        try {
            int fragmentShader = compileShader(fragmentSource, GL_FRAGMENT_SHADER);
            try {
                return createProgram(vertexShader, fragmentShader);
            } finally {
                glDeleteShader(fragmentShader);
            }
        } finally {
            glDeleteShader(vertexShader);
        }
    }

    private static int compileShader(String source, int shaderType) {
        int shader = glCreateShader(shaderType);
        glShaderSource(shader, source);
        glCompileShader(shader);
        String infoString = glGetShaderInfoLog(shader, 2000);
        if (glGetError() != GL_NO_ERROR || glGetShaderi(shader, GL_COMPILE_STATUS) != GL_TRUE || !infoString.equals("")) {
            glDeleteShader(shader);
            throw new ShaderException("Error while compiling shader: \n" + infoString);
        }
        return shader;
    }

    private static int createProgram(int... shaders) {
        int program = glCreateProgram();
        for (int shader: shaders) {
            glAttachShader(program, shader);
        }
        glLinkProgram(program);
        verifyProgram(program, GL_LINK_STATUS, "Error while linking shader program");

        glValidateProgram(program);
        verifyProgram(program, GL_VALIDATE_STATUS, "Error while validating shader program");

        for (int shader: shaders) {
            glDetachShader(program, shader);
        }
        return program;
    }

    private static void verifyProgram(int program, int programI, String message) {
        String infoLog = glGetProgramInfoLog(program, 2000);
        int status = glGetProgrami(program, programI);
        if (glGetError() != GL_NO_ERROR || status != GL_TRUE || !infoLog.equals("")) {
            glDeleteProgram(program);
            throw new ShaderException(message + ": \n" + (infoLog.equals("") ? "No Details Available" : infoLog));
        }
    }

}
