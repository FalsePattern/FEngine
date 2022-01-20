package com.falsepattern.fengine.opengl;

import com.falsepattern.fengine.util.Disposable;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL30C.*;

/**
 * A mesh is a collection of vertices and indices.
 */
public class Mesh implements Disposable {
    private static int boundVAO = 0;
    private final int vao;
    private final int vbo;
    private final int ebo;
    private final int indices;

    //Allocation and pre-binding
    private Mesh(int indexCount) {
        indices = indexCount;
        vao = glGenVertexArrays();
        vbo = glGenBuffers();
        ebo = glGenBuffers();
        bind();

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
    }

    public Mesh(ByteBuffer vertexBuffer, IntBuffer indexBuffer) {
        this(indexBuffer.capacity());
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL_STATIC_DRAW);

        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 24, 0);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 24, 12);

        unbind();
    }

    public Mesh(FloatBuffer vertexBuffer, IntBuffer indexBuffer) {
        this(MemoryUtil.memByteBuffer(vertexBuffer), indexBuffer);
    }

    public Mesh(float[] vertices, int[] indices) {
        this(indices.length);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 24, 0);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 24, 12);

        unbind();
    }

    public void bind() {
        if (boundVAO == vao) return;
        glBindVertexArray(vao);
        boundVAO = vao;
    }

    public static void unbind() {
        glBindVertexArray(0);
        boundVAO = 0;
    }

    public void draw() {
        bind();
        glDrawElements(GL_TRIANGLES, indices, GL_UNSIGNED_INT, 0);
    }

    @Override
    public void dispose() {
        glDeleteVertexArrays(vao);
        glDeleteBuffers(vbo);
        glDeleteBuffers(ebo);
    }
}
