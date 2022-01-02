package com.falsepattern.fengine.window.keyboard;

import com.falsepattern.fengine.util.CircularDroppingQueue;
import com.falsepattern.fengine.util.CircularDroppingQueueChar;
import lombok.val;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Optional;

/**
 * Handles keyboard input.
 */
public class Keyboard {
    private static final int QUEUE_LENGTH = 256;

    private final BitSet keyMap = new BitSet(256);
    private final CircularDroppingQueue<KeyEvent> keyEvents = new CircularDroppingQueue<>(QUEUE_LENGTH);
    private final CircularDroppingQueueChar charEvents = new CircularDroppingQueueChar(QUEUE_LENGTH);

    /**
     * Used for ignoring long press auto-repeat.
     */
    public boolean autoRepeat = false;

    /**
     * @param window The window to register the callbacks to.
     */
    public Keyboard(long window) {
        GLFW.glfwSetKeyCallback(window, this::keyCallback);
        GLFW.glfwSetCharCallback(window, this::charCallback);
    }

    /**
     * @return True if a key event is available.
     */
    public boolean hasKey() {
        return keyEvents.available();
    }

    /**
     *
     * @return True if a char event is available.
     */
    public boolean hasChar() {
        return charEvents.available();
    }

    /**
     * @return A key event if available, otherwise an empty optional.
     */
    public Optional<KeyEvent> getKey() {
        return keyEvents.available() ? Optional.of(keyEvents.poll()) : Optional.empty();
    }

    /**
     * @return A list of key events that are in the queue. Clears the queue. Can be empty.
     */
    public List<KeyEvent> getKeys() {
        val result = new ArrayList<KeyEvent>();
        while (keyEvents.available()) {
            result.add(keyEvents.poll());
        }
        return result;
    }

    /**
     * @return The next character in the queue.
     */
    public char getChar() {
        return charEvents.poll();
    }

    /**
     * @param key The key to check.
     * @return True if the key is pressed.
     */
    public boolean isKeyPressed(Key key) {
        return keyMap.get(key.toGLFW());
    }

    private void keyCallback(long window, int key, int scancode, int action, int mods) {
        if (action == GLFW.GLFW_REPEAT && !autoRepeat) return;
        keyMap.set(key, action != GLFW.GLFW_RELEASE);
        keyEvents.add(new KeyEvent(Key.fromGLFW(key), action != GLFW.GLFW_RELEASE));
    }

    private void charCallback(long window, int codepoint) {
        charEvents.add((char) codepoint);
    }

}
