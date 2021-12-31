package com.falsepattern.frender.window.keyboard;

import com.falsepattern.frender.util.CircularDroppingQueue;
import com.falsepattern.frender.util.CircularDroppingQueueChar;
import org.lwjgl.glfw.GLFW;

import java.util.BitSet;
import java.util.Optional;

/**
 * Handles keyboard input.
 */
public class Keyboard {
    private static final int QUEUE_LENGTH = 256;

    private final BitSet keyMap = new BitSet(256);
    private final CircularDroppingQueue<KeyEvent> keyEvents = new CircularDroppingQueue<>(QUEUE_LENGTH);
    private final CircularDroppingQueueChar charEvents = new CircularDroppingQueueChar(QUEUE_LENGTH);

    public boolean autoRepeat = false;
    public Keyboard(long window) {
        GLFW.glfwSetKeyCallback(window, this::keyCallback);
        GLFW.glfwSetCharCallback(window, this::charCallback);
    }

    private void keyCallback(long window, int key, int scancode, int action, int mods) {
        if (action == GLFW.GLFW_REPEAT && !autoRepeat) return;
        keyMap.set(key, action != GLFW.GLFW_RELEASE);
        keyEvents.add(new KeyEvent(key, action != GLFW.GLFW_RELEASE));
    }

    private void charCallback(long window, int codepoint) {
        charEvents.add((char) codepoint);
    }

    public boolean hasKey() {
        return keyEvents.available();
    }

    public boolean hasChar() {
        return charEvents.available();
    }

    public Optional<KeyEvent> getKey() {
        return keyEvents.available() ? Optional.of(keyEvents.poll()) : Optional.empty();
    }

    public char getChar() {
        return charEvents.poll();
    }

    public boolean isKeyPressed(int key) {
        return keyMap.get(key);
    }

}
