package com.falsepattern.fengine.window.keyboard;

/**
 * Represents a keyboard key press/release.
 */
public record KeyEvent(Key key, boolean press) {
    public boolean isKey(Key key) {
        return this.key == key;
    }
}
