package com.falsepattern.fengine.window.mouse;

/**
 * Represents a mouse button press/release at a specific location.
 */
public record MouseButtonEvent(double x, double y, int button, boolean press) {}
