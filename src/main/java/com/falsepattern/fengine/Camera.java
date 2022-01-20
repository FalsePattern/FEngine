package com.falsepattern.fengine;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera {
    public final Vector3f position = new Vector3f();
    public final Vector3f target = new Vector3f();
    public final Vector3f up = new Vector3f();
    public float fovRadians = (float) Math.toRadians(60);
    public float aspectRatio = 1f;
    public float nearPlane = 0.1f;
    public float farPlane = 100.0f;

    public void applyToMatrix(Matrix4f output) {
        output.setPerspective(fovRadians, aspectRatio, nearPlane, farPlane).lookAt(position, target, up);
    }

}
