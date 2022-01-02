package com.falsepattern.fengine.window;

import com.falsepattern.fengine.opengl.GLConstants;
import com.falsepattern.fengine.util.Disposable;
import com.falsepattern.fengine.window.keyboard.Keyboard;
import com.falsepattern.fengine.window.mouse.Mouse;
import lombok.Builder;
import lombok.Getter;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

public class Window implements Disposable {
    /**
     * The window's width.
     */
    @Getter
    private int width;

    /**
     * The window's height.
     */
    @Getter
    private int height;

    /**
     * The window's title.
     */
    @Getter
    private String title;

    /**
     * Whether the window is in fullscreen mode.
     */
    @Getter
    private boolean fullScreen;

    /**
     * Whether the window can be resized.
     */
    @Getter
    private boolean resizable;

    /**
     * Whether vertical synchronization is enabled.
     */
    @Getter
    private boolean vSync;

    /**
     * Keyboard input.
     */
    @Getter
    private final Keyboard keyboard;

    /**
     * Mouse input.
     */
    @Getter
    private final Mouse mouse;

    /**
     * The state of the window (minimize, maximize, normal).
     */
    @Getter
    private WindowState state = WindowState.NORMAL;

    /**
     * Whether the window is currently open.
     */
    @Getter
    private boolean visible = false;

    /**
     * Whether the user has requested the window to close.
     * Set to <code>Soft</code> when the user clicks the close button.
     * Set to <code>Hard</code> when the close request was initiated by code.
     */
    @Getter
    private CloseRequest closeRequest = CloseRequest.None;

    /**
     * The window's native handle.
     */
    private final long addr;

    /**
     * Creates a new window.
     * @param width The window's width.
     * @param height The window's height.
     * @param title The window's title.
     * @param fullScreen Whether the window is in fullscreen mode.
     * @param resizable Whether the window can be resized.
     */
    @Builder
    public Window(int width, int height, String title, boolean fullScreen, boolean resizable) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.fullScreen = fullScreen;
        this.resizable = resizable;
        if (!GLFW.glfwInit()) {
            throw new Error("Failed to initialize GLFW");
        }
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, resizable ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_CLIENT_API, GLFW.GLFW_OPENGL_API);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, GLConstants.MAJOR_VERSION);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, GLConstants.MINOR_VERSION);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);

        addr = GLFW.glfwCreateWindow(width, height, title, fullScreen ? GLFW.glfwGetPrimaryMonitor() : 0, 0);
        if (addr == 0) {
            throw new Error("Failed to create window");
        }
        keyboard = new Keyboard(addr);
        mouse = new Mouse(addr);
        GLFW.glfwSetWindowIconifyCallback(addr, this::minimizeCallback);
        GLFW.glfwSetWindowMaximizeCallback(addr, this::maximizeCallback);
        GLFW.glfwSetWindowSizeCallback(addr, this::sizeCallback);
        GLFW.glfwSetWindowFocusCallback(addr, this::focusCallback);
        GLFW.glfwSetWindowCloseCallback(addr, this::closeCallback);
        GLFW.glfwMakeContextCurrent(addr);
        GLFW.glfwSwapInterval(0);
    }

    public void pollEvents() {
        GLFW.glfwPollEvents();
    }

    public void swapBuffers() {
        GLFW.glfwSwapBuffers(addr);
    }

    /**
     * Makes the window visible.
     */
    public void show() {
        if (!visible) {
            GLFW.glfwShowWindow(addr);
            visible = true;
        }
    }

    /**
     * Hides the window.
     */
    public void hide() {
        if (visible) {
            GLFW.glfwHideWindow(addr);
            visible = false;
        }
    }

    /**
     * Minimizes the window.
     */
    public void minimize() {
        GLFW.glfwIconifyWindow(addr);
    }

    /**
     * Maximizes the window.
     */
    public void maximize() {
        GLFW.glfwMaximizeWindow(addr);
    }

    /**
     * Restores the window to the default state.
     */
    public void restore() {
        GLFW.glfwRestoreWindow(addr);
    }

    public void close(boolean close) {
        closeRequest = close ? CloseRequest.Hard : CloseRequest.None;
    }

    public void setTitle(String title) {
        GLFW.glfwSetWindowTitle(addr, title);
        this.title = title;
    }

    public void setSize(int width, int height) {
        GLFW.glfwSetWindowSize(addr, width, height);
    }

    public void setVSync(boolean state) {
        vSync = state;
        GLFW.glfwSwapInterval(state ? 1 : 0);
    }

    /**
     * Destroys the window. This method should be called when the window is no longer needed.
     */
    @Override
    public void dispose() {
        GLFW.glfwDestroyWindow(addr);
        GLFW.glfwTerminate();
    }

    private void minimizeCallback(long window, boolean minimized) {
        if (minimized) {
            state = WindowState.MINIMIZED;
        } else if (state == WindowState.MINIMIZED) {
            state = WindowState.NORMAL;
        }
    }

    private void maximizeCallback(long window, boolean maximized) {
        if (maximized) {
            state = WindowState.MAXIMIZED;
        } else if (state == WindowState.MAXIMIZED) {
            state = WindowState.NORMAL;
        }
    }

    private void sizeCallback(long window, int width, int height) {
        this.width = width;
        this.height = height;
    }

    private void focusCallback(long window, boolean focused) {
        this.visible = focused;
    }

    private void closeCallback(long window) {
        closeRequest = CloseRequest.Soft;
    }

    static {
        GLFW.glfwSetErrorCallback(Window::errorCallback);
    }

    private static void errorCallback(int error, long description) {
        System.err.println("GLFW error: " + error + ": " + MemoryUtil.memUTF8(description));
    }
}
