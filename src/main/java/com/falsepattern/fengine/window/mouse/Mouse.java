package com.falsepattern.fengine.window.mouse;

import com.falsepattern.fengine.util.CircularDroppingQueue;
import lombok.Getter;
import org.lwjgl.glfw.GLFW;

/**
 * Handles mouse input.
 */
public class Mouse {
    private static final int QUEUE_LENGTH = 256;

    @Getter
    private double x;
    @Getter
    private double y;

    private final boolean[] buttons = new boolean[8];

    private final CircularDroppingQueue<MouseButtonEvent> events = new CircularDroppingQueue<>(QUEUE_LENGTH);

    /**
     * @param window The window to register the callbacks to.
     */
    public Mouse(long window) {
        GLFW.glfwSetCursorPosCallback(window, this::cursorPosCallback);
        GLFW.glfwSetMouseButtonCallback(window, this::mouseButtonCallback);
    }

    /**
     * @return True if the left mouse button is pressed.
     */
    public boolean isLeftButtonDown() {
        return buttons[GLFW.GLFW_MOUSE_BUTTON_LEFT];
    }

    /**
     * @return True if the right mouse button is pressed.
     */
    public boolean isRightButtonDown() {
        return buttons[GLFW.GLFW_MOUSE_BUTTON_RIGHT];
    }

    /**
     * @return True if the middle mouse button is pressed.
     */
    public boolean isMiddleButtonDown() {
        return buttons[GLFW.GLFW_MOUSE_BUTTON_MIDDLE];
    }

    /**
     * @param button The button to check.
     * @return True if the button is pressed.
     * @throws IllegalArgumentException If the button is not a valid button.
     */
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
