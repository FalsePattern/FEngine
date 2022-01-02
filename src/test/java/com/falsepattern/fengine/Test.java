package com.falsepattern.fengine;

import com.falsepattern.fengine.opengl.Renderer;
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

        while (window.getCloseRequest() == CloseRequest.None) {
            renderer.clear();
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
