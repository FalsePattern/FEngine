package com.falsepattern.fengine;

import com.falsepattern.fengine.opengl.Mesh;
import com.falsepattern.fengine.opengl.shader.MVPShader;
import com.falsepattern.fengine.opengl.shader.common.Shader;
import com.falsepattern.fengine.opengl.shader.common.ShaderSource;
import com.falsepattern.fengine.window.CloseRequest;
import com.falsepattern.fengine.window.Window;
import com.falsepattern.fengine.window.keyboard.Key;
import lombok.Cleanup;
import lombok.val;

public class Test {
    public static void main(String[] args) {
        @Cleanup("dispose") val window = new Window(800, 600, "Hello, World!", false, false);
        val kbd = window.getKeyboard();
        val mouse = window.getMouse();
        @Cleanup("dispose") val renderer = new Renderer();
        renderer.setClearColor(0, 0, 0, 1);
        window.setVSync(true);
        window.show();

        @Cleanup("dispose") val mesh = new Mesh(new float[]{
                -1, 1, -1,  0, 1, 0,
                1, 1, -1,   1, 1, 0,
                1, 1, 1,    1, 1, 1,
                -1, 1, 1,   0, 1, 1,
                -1, -1, -1, 0, 0, 0,
                1, -1, -1,  1, 0, 0,
                1, -1, 1,   1, 0, 1,
                -1, -1, 1,  0, 0, 1,
        }, new int[]{
                0, 1, 2,
                0, 2, 3,
                0, 4, 5,
                0, 5, 1,
                1, 5, 6,
                1, 6, 2,
                2, 6, 7,
                2, 7, 3,
                7, 4, 0,
                7, 0, 3,
                4, 7, 6,
                4, 6, 5
        });
        val obj1 = new GameObject();
        val obj2 = new GameObject();
        obj1.mesh = mesh;
        obj2.mesh = mesh;
        obj1.position.set(1, 0, 2);
        val camera = new Camera();
        camera.position.set(3, 3, 4);
        camera.up.set(0, 1, 0);
        camera.target.set(0, 0, 0);
        camera.aspectRatio = 800 / 600f;
        camera.nearPlane = 0.1f;
        camera.farPlane = 100f;
        val vertexShader = new ShaderSource("""
                                                    #version 330 core
                                                    layout(location = 0) in vec3 vertexPosition_modelspace;
                                                    layout(location = 1) in vec3 vertexColor;
                                                    uniform mat4 modelViewProjection;
                                                    
                                                    out vec3 color;
                                                    
                                                    void main() {
                                                        gl_Position = modelViewProjection * vec4(vertexPosition_modelspace, 1);
                                                        color = vertexColor;
                                                    }""", ShaderSource.Type.VERTEX);
        val fragmentShader = new ShaderSource("""
                                                      #version 330 core
                                                      in vec3 color;
                                                      out vec3 fragColor;
                                                      
                                                      void main() {
                                                          fragColor = color;
                                                      }""", ShaderSource.Type.FRAGMENT);
        @Cleanup("dispose") val shader = Shader.builder().add(vertexShader).add(fragmentShader).build(MVPShader::new);
        long start = System.nanoTime();
        renderer.depthTest(true);
        obj2.scale.set(.1f, 2f, 1f);
        obj1.scale.set(1f, 2f, .1f);
        while (window.getCloseRequest() == CloseRequest.None) {
            long now = System.nanoTime();
            double deltaSeconds = (now - start) / 1000000000d;
            camera.position.rotateAxis(0.01f, 0, 1, 0);
            renderer.clear();
            renderer.render(obj1, shader, camera);
            renderer.render(obj2, shader, camera);
            window.swapBuffers();
            window.pollEvents();

            while (kbd.hasKey())
                kbd.getKey().ifPresent((event) -> {
                    if (event.key() == Key.KEY_ESCAPE && event.press())
                        window.close(true);
                });
        }

        switch (window.getCloseRequest()) {
            case Soft -> System.out.println("Window closed with X button");
            case Hard -> System.out.println("Window closed with Esc key");
        }
    }
}
