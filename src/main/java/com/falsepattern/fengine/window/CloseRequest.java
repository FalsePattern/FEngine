package com.falsepattern.fengine.window;

/**
 * A request to close a window. Soft is used when the window is closed by the user, hard is used when the window is closed by the engine.
 */
public enum CloseRequest {
    None, Soft, Hard
}
