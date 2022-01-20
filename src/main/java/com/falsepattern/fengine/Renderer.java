package com.falsepattern.fengine;

import com.falsepattern.fengine.opengl.shader.MVPShader;
import com.falsepattern.fengine.util.Disposable;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GLCapabilities;

/**
 * The renderer is responsible for rendering the scene.
 */
public class Renderer implements Disposable {
    private final GLCapabilities caps;
    public Renderer() {
        caps = GL.createCapabilities();
    }

    /**
     * Clears the screen.
     */
    public void clear() {
        GL11C.glClear(GL11C.GL_COLOR_BUFFER_BIT | GL11C.GL_DEPTH_BUFFER_BIT);
    }

    public void depthTest(boolean enable) {
        if (enable) {
            GL11C.glEnable(GL11C.GL_DEPTH_TEST);
        } else {
            GL11C.glDisable(GL11C.GL_DEPTH_TEST);
        }
    }

    /**
     * Sets the clear color.
     * @param r The red component.
     * @param g The green component.
     * @param b The blue component.
     * @param a The alpha component.
     */
    public void setClearColor(float r, float g, float b, float a) {
        GL11C.glClearColor(r, g, b, a);
    }

    @Override
    public void dispose() {

    }

    private final Matrix4f modelViewProjection = new Matrix4f();
    public void render(GameObject object, MVPShader shader, Camera camera) {
        camera.applyToMatrix(modelViewProjection);
        object.applyWorldMatrix(modelViewProjection);
        shader.modelViewProjection.set(modelViewProjection);
        shader.bind();
        object.mesh.draw();
    }
}
