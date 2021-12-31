package com.falsepattern.frender.window.mouse;

import com.falsepattern.frender.util.CircularDroppingQueue;
import lombok.Getter;
import org.lwjgl.glfw.GLFW;

public class Mouse {
    private static final int QUEUE_LENGTH = 256;

    @Getter
    private double x;
    @Getter
    private double y;

    private final boolean[] buttons = new boolean[8];

    private final CircularDroppingQueue<MouseButtonEvent> events = new CircularDroppingQueue<>(QUEUE_LENGTH);

    public Mouse(long window) {
        GLFW.glfwSetCursorPosCallback(window, this::cursorPosCallback);
        GLFW.glfwSetMouseButtonCallback(window, this::mouseButtonCallback);
    }

    public boolean isLeftButtonDown() {
        return buttons[GLFW.GLFW_MOUSE_BUTTON_LEFT];
    }

    public boolean isRightButtonDown() {
        return buttons[GLFW.GLFW_MOUSE_BUTTON_RIGHT];
    }

    public boolean isMiddleButtonDown() {
        return buttons[GLFW.GLFW_MOUSE_BUTTON_MIDDLE];
    }

    public boolean isButtonDown(int button) {
        if (button < GLFW.GLFW_MOUSE_BUTTON_1 || button > GLFW.GLFW_MOUSE_BUTTON_LAST) {
            throw new IllegalArgumentException("Invalid button: " + button);
        }
        return buttons[button];
    }

    private void cursorPosCallback(long window, double x, double y) {
        this.x = x;
        this.y = y;
    }

    private void mouseButtonCallback(long window, int button, int action, int mods) {
        events.add(new MouseButtonEvent(x, y, button, action != GLFW.GLFW_RELEASE));
        buttons[button] = action != GLFW.GLFW_RELEASE;
    }
}
