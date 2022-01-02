package com.falsepattern.fengine.window.keyboard;

/**
 * Represents a keyboard key press/release.
 */
public record KeyEvent(Key key, boolean press) {}
