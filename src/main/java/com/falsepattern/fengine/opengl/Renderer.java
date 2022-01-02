package com.falsepattern.fengine.opengl;

import com.falsepattern.fengine.util.Disposable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GLCapabilities;

public class Renderer implements Disposable {
    private final GLCapabilities caps;
    public Renderer() {
        caps = GL.createCapabilities();
    }

    public void clear() {
        GL11C.glClear(GL11C.GL_COLOR_BUFFER_BIT | GL11C.GL_DEPTH_BUFFER_BIT);
    }

    public void setClearColor(float r, float g, float b, float a) {
        GL11C.glClearColor(r, g, b, a);
    }

    @Override
    public void dispose() {

    }
}
