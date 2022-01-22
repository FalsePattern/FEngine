package com.falsepattern.fengine.opengl.shader.common.uniforms;

import com.falsepattern.fengine.util.Disposable;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

public abstract class Uniform implements Disposable {
    protected final ByteBuffer buffer;
    protected final int program;
    protected final int location;
    protected Uniform(int program, int location, int bufferSize) {
        buffer = MemoryUtil.memAlloc(bufferSize);
        this.program = program;
        this.location = location;
    }

    public abstract void upload();

    public abstract void download();

    public int type() {
        return -1;
    }

    public int size() {
        return 1;
    }

    @Override
    public void dispose() {
        MemoryUtil.memFree(buffer);
    }
}
