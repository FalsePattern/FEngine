package com.falsepattern.fengine;

import com.falsepattern.fengine.opengl.Mesh;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class GameObject {
    public Mesh mesh;
    public final Vector3f position = new Vector3f();
    public final Vector3f scale = new Vector3f(1, 1, 1);
    public final Quaternionf rotation = new Quaternionf().identity();

    public void applyWorldMatrix(Matrix4f output) {
        output.translate(position).rotate(rotation).scale(scale);
    }
}
