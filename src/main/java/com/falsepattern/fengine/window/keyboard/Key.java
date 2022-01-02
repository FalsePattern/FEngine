package com.falsepattern.fengine.window.keyboard;

import org.lwjgl.glfw.GLFW;

public enum Key {
    KEY_UNKNOWN,
    KEY_SPACE,
    KEY_APOSTROPHE,
    KEY_COMMA,
    KEY_MINUS,
    KEY_PERIOD,
    KEY_SLASH,
    KEY_0,KEY_1,KEY_2,KEY_3,KEY_4,KEY_5,KEY_6,KEY_7,KEY_8,KEY_9,
    KEY_SEMICOLON,
    KEY_EQUAL,
    KEY_A,KEY_B,KEY_C,KEY_D,KEY_E,KEY_F,KEY_G,KEY_H,KEY_I,KEY_J,KEY_K,KEY_L,KEY_M,
    KEY_N,KEY_O,KEY_P,KEY_Q,KEY_R,KEY_S,KEY_T,KEY_U,KEY_V,KEY_W,KEY_X,KEY_Y,KEY_Z,
    KEY_LEFT_BRACKET,
    KEY_BACKSLASH,
    KEY_RIGHT_BRACKET,
    KEY_GRAVE_ACCENT,
    KEY_WORLD_1,
    KEY_WORLD_2,
    KEY_ESCAPE,
    KEY_ENTER,
    KEY_TAB,
    KEY_BACKSPACE,
    KEY_INSERT,
    KEY_DELETE,
    KEY_RIGHT,
    KEY_LEFT,
    KEY_DOWN,
    KEY_UP,
    KEY_PAGE_UP,
    KEY_PAGE_DOWN,
    KEY_HOME,
    KEY_END,
    KEY_CAPS_LOCK,
    KEY_SCROLL_LOCK,
    KEY_NUM_LOCK,
    KEY_PRINT_SCREEN,
    KEY_PAUSE,
    KEY_F1,KEY_F2,KEY_F3,KEY_F4,KEY_F5,KEY_F6,KEY_F7,KEY_F8,KEY_F9,KEY_F10,KEY_F11,KEY_F12,
    KEY_F13,KEY_F14,KEY_F15,KEY_F16,KEY_F17,KEY_F18,KEY_F19,KEY_F20,KEY_F21,KEY_F22,KEY_F23,KEY_F24,KEY_F25,
    KEY_KP_0,KEY_KP_1,KEY_KP_2,KEY_KP_3,KEY_KP_4,KEY_KP_5,KEY_KP_6,KEY_KP_7,KEY_KP_8,KEY_KP_9,
    KEY_KP_DECIMAL,
    KEY_KP_DIVIDE,
    KEY_KP_MULTIPLY,
    KEY_KP_SUBTRACT,
    KEY_KP_ADD,
    KEY_KP_ENTER,
    KEY_KP_EQUAL,
    KEY_LEFT_SHIFT,
    KEY_LEFT_CONTROL,
    KEY_LEFT_ALT,
    KEY_LEFT_SUPER,
    KEY_RIGHT_SHIFT,
    KEY_RIGHT_CONTROL,
    KEY_RIGHT_ALT,
    KEY_RIGHT_SUPER,
    KEY_MENU;

    static Key fromGLFW(int glfwKey) {
        return switch (glfwKey) {
            default -> KEY_UNKNOWN;
            case GLFW.GLFW_KEY_SPACE -> KEY_SPACE;
            case GLFW.GLFW_KEY_APOSTROPHE -> KEY_APOSTROPHE;
            case GLFW.GLFW_KEY_COMMA -> KEY_COMMA;
            case GLFW.GLFW_KEY_MINUS -> KEY_MINUS;
            case GLFW.GLFW_KEY_PERIOD -> KEY_PERIOD;
            case GLFW.GLFW_KEY_SLASH -> KEY_SLASH;
            case GLFW.GLFW_KEY_0 -> KEY_0;
            case GLFW.GLFW_KEY_1 -> KEY_1;
            case GLFW.GLFW_KEY_2 -> KEY_2;
            case GLFW.GLFW_KEY_3 -> KEY_3;
            case GLFW.GLFW_KEY_4 -> KEY_4;
            case GLFW.GLFW_KEY_5 -> KEY_5;
            case GLFW.GLFW_KEY_6 -> KEY_6;
            case GLFW.GLFW_KEY_7 -> KEY_7;
            case GLFW.GLFW_KEY_8 -> KEY_8;
            case GLFW.GLFW_KEY_9 -> KEY_9;
            case GLFW.GLFW_KEY_SEMICOLON -> KEY_SEMICOLON;
            case GLFW.GLFW_KEY_EQUAL -> KEY_EQUAL;
            case GLFW.GLFW_KEY_A -> KEY_A;
            case GLFW.GLFW_KEY_B -> KEY_B;
            case GLFW.GLFW_KEY_C -> KEY_C;
            case GLFW.GLFW_KEY_D -> KEY_D;
            case GLFW.GLFW_KEY_E -> KEY_E;
            case GLFW.GLFW_KEY_F -> KEY_F;
            case GLFW.GLFW_KEY_G -> KEY_G;
            case GLFW.GLFW_KEY_H -> KEY_H;
            case GLFW.GLFW_KEY_I -> KEY_I;
            case GLFW.GLFW_KEY_J -> KEY_J;
            case GLFW.GLFW_KEY_K -> KEY_K;
            case GLFW.GLFW_KEY_L -> KEY_L;
            case GLFW.GLFW_KEY_M -> KEY_M;
            case GLFW.GLFW_KEY_N -> KEY_N;
            case GLFW.GLFW_KEY_O -> KEY_O;
            case GLFW.GLFW_KEY_P -> KEY_P;
            case GLFW.GLFW_KEY_Q -> KEY_Q;
            case GLFW.GLFW_KEY_R -> KEY_R;
            case GLFW.GLFW_KEY_S -> KEY_S;
            case GLFW.GLFW_KEY_T -> KEY_T;
            case GLFW.GLFW_KEY_U -> KEY_U;
            case GLFW.GLFW_KEY_V -> KEY_V;
            case GLFW.GLFW_KEY_W -> KEY_W;
            case GLFW.GLFW_KEY_X -> KEY_X;
            case GLFW.GLFW_KEY_Y -> KEY_Y;
            case GLFW.GLFW_KEY_Z -> KEY_Z;
            case GLFW.GLFW_KEY_LEFT_BRACKET -> KEY_LEFT_BRACKET;
            case GLFW.GLFW_KEY_BACKSLASH -> KEY_BACKSLASH;
            case GLFW.GLFW_KEY_RIGHT_BRACKET -> KEY_RIGHT_BRACKET;
            case GLFW.GLFW_KEY_GRAVE_ACCENT -> KEY_GRAVE_ACCENT;
            case GLFW.GLFW_KEY_WORLD_1 -> KEY_WORLD_1;
            case GLFW.GLFW_KEY_WORLD_2 -> KEY_WORLD_2;
            case GLFW.GLFW_KEY_ESCAPE -> KEY_ESCAPE;
            case GLFW.GLFW_KEY_ENTER -> KEY_ENTER;
            case GLFW.GLFW_KEY_TAB -> KEY_TAB;
            case GLFW.GLFW_KEY_BACKSPACE -> KEY_BACKSPACE;
            case GLFW.GLFW_KEY_INSERT -> KEY_INSERT;
            case GLFW.GLFW_KEY_DELETE -> KEY_DELETE;
            case GLFW.GLFW_KEY_RIGHT -> KEY_RIGHT;
            case GLFW.GLFW_KEY_LEFT -> KEY_LEFT;
            case GLFW.GLFW_KEY_DOWN -> KEY_DOWN;
            case GLFW.GLFW_KEY_UP -> KEY_UP;
            case GLFW.GLFW_KEY_PAGE_UP -> KEY_PAGE_UP;
            case GLFW.GLFW_KEY_PAGE_DOWN -> KEY_PAGE_DOWN;
            case GLFW.GLFW_KEY_HOME -> KEY_HOME;
            case GLFW.GLFW_KEY_END -> KEY_END;
            case GLFW.GLFW_KEY_CAPS_LOCK -> KEY_CAPS_LOCK;
            case GLFW.GLFW_KEY_SCROLL_LOCK -> KEY_SCROLL_LOCK;
            case GLFW.GLFW_KEY_NUM_LOCK -> KEY_NUM_LOCK;
            case GLFW.GLFW_KEY_PRINT_SCREEN -> KEY_PRINT_SCREEN;
            case GLFW.GLFW_KEY_PAUSE -> KEY_PAUSE;
            case GLFW.GLFW_KEY_F1 -> KEY_F1;
            case GLFW.GLFW_KEY_F2 -> KEY_F2;
            case GLFW.GLFW_KEY_F3 -> KEY_F3;
            case GLFW.GLFW_KEY_F4 -> KEY_F4;
            case GLFW.GLFW_KEY_F5 -> KEY_F5;
            case GLFW.GLFW_KEY_F6 -> KEY_F6;
            case GLFW.GLFW_KEY_F7 -> KEY_F7;
            case GLFW.GLFW_KEY_F8 -> KEY_F8;
            case GLFW.GLFW_KEY_F9 -> KEY_F9;
            case GLFW.GLFW_KEY_F10 -> KEY_F10;
            case GLFW.GLFW_KEY_F11 -> KEY_F11;
            case GLFW.GLFW_KEY_F12 -> KEY_F12;
            case GLFW.GLFW_KEY_F13 -> KEY_F13;
            case GLFW.GLFW_KEY_F14 -> KEY_F14;
            case GLFW.GLFW_KEY_F15 -> KEY_F15;
            case GLFW.GLFW_KEY_F16 -> KEY_F16;
            case GLFW.GLFW_KEY_F17 -> KEY_F17;
            case GLFW.GLFW_KEY_F18 -> KEY_F18;
            case GLFW.GLFW_KEY_F19 -> KEY_F19;
            case GLFW.GLFW_KEY_F20 -> KEY_F20;
            case GLFW.GLFW_KEY_F21 -> KEY_F21;
            case GLFW.GLFW_KEY_F22 -> KEY_F22;
            case GLFW.GLFW_KEY_F23 -> KEY_F23;
            case GLFW.GLFW_KEY_F24 -> KEY_F24;
            case GLFW.GLFW_KEY_F25 -> KEY_F25;
            case GLFW.GLFW_KEY_KP_0 -> KEY_KP_0;
            case GLFW.GLFW_KEY_KP_1 -> KEY_KP_1;
            case GLFW.GLFW_KEY_KP_2 -> KEY_KP_2;
            case GLFW.GLFW_KEY_KP_3 -> KEY_KP_3;
            case GLFW.GLFW_KEY_KP_4 -> KEY_KP_4;
            case GLFW.GLFW_KEY_KP_5 -> KEY_KP_5;
            case GLFW.GLFW_KEY_KP_6 -> KEY_KP_6;
            case GLFW.GLFW_KEY_KP_7 -> KEY_KP_7;
            case GLFW.GLFW_KEY_KP_8 -> KEY_KP_8;
            case GLFW.GLFW_KEY_KP_9 -> KEY_KP_9;
            case GLFW.GLFW_KEY_KP_DECIMAL -> KEY_KP_DECIMAL;
            case GLFW.GLFW_KEY_KP_DIVIDE -> KEY_KP_DIVIDE;
            case GLFW.GLFW_KEY_KP_MULTIPLY -> KEY_KP_MULTIPLY;
            case GLFW.GLFW_KEY_KP_SUBTRACT -> KEY_KP_SUBTRACT;
            case GLFW.GLFW_KEY_KP_ADD -> KEY_KP_ADD;
            case GLFW.GLFW_KEY_KP_ENTER -> KEY_KP_ENTER;
            case GLFW.GLFW_KEY_KP_EQUAL -> KEY_KP_EQUAL;
            case GLFW.GLFW_KEY_LEFT_SHIFT -> KEY_LEFT_SHIFT;
            case GLFW.GLFW_KEY_LEFT_CONTROL -> KEY_LEFT_CONTROL;
            case GLFW.GLFW_KEY_LEFT_ALT -> KEY_LEFT_ALT;
            case GLFW.GLFW_KEY_LEFT_SUPER -> KEY_LEFT_SUPER;
            case GLFW.GLFW_KEY_RIGHT_SHIFT -> KEY_RIGHT_SHIFT;
            case GLFW.GLFW_KEY_RIGHT_CONTROL -> KEY_RIGHT_CONTROL;
            case GLFW.GLFW_KEY_RIGHT_ALT -> KEY_RIGHT_ALT;
            case GLFW.GLFW_KEY_RIGHT_SUPER -> KEY_RIGHT_SUPER;
            case GLFW.GLFW_KEY_MENU -> KEY_MENU;
        };
    }

    int toGLFW() {
        return switch (this) {
            default -> GLFW.GLFW_KEY_UNKNOWN;
            case KEY_SPACE -> GLFW.GLFW_KEY_SPACE;
            case KEY_APOSTROPHE -> GLFW.GLFW_KEY_APOSTROPHE;
            case KEY_COMMA -> GLFW.GLFW_KEY_COMMA;
            case KEY_MINUS -> GLFW.GLFW_KEY_MINUS;
            case KEY_PERIOD -> GLFW.GLFW_KEY_PERIOD;
            case KEY_SLASH -> GLFW.GLFW_KEY_SLASH;
            case KEY_0 -> GLFW.GLFW_KEY_0;
            case KEY_1 -> GLFW.GLFW_KEY_1;
            case KEY_2 -> GLFW.GLFW_KEY_2;
            case KEY_3 -> GLFW.GLFW_KEY_3;
            case KEY_4 -> GLFW.GLFW_KEY_4;
            case KEY_5 -> GLFW.GLFW_KEY_5;
            case KEY_6 -> GLFW.GLFW_KEY_6;
            case KEY_7 -> GLFW.GLFW_KEY_7;
            case KEY_8 -> GLFW.GLFW_KEY_8;
            case KEY_9 -> GLFW.GLFW_KEY_9;
            case KEY_SEMICOLON -> GLFW.GLFW_KEY_SEMICOLON;
            case KEY_EQUAL -> GLFW.GLFW_KEY_EQUAL;
            case KEY_A -> GLFW.GLFW_KEY_A;
            case KEY_B -> GLFW.GLFW_KEY_B;
            case KEY_C -> GLFW.GLFW_KEY_C;
            case KEY_D -> GLFW.GLFW_KEY_D;
            case KEY_E -> GLFW.GLFW_KEY_E;
            case KEY_F -> GLFW.GLFW_KEY_F;
            case KEY_G -> GLFW.GLFW_KEY_G;
            case KEY_H -> GLFW.GLFW_KEY_H;
            case KEY_I -> GLFW.GLFW_KEY_I;
            case KEY_J -> GLFW.GLFW_KEY_J;
            case KEY_K -> GLFW.GLFW_KEY_K;
            case KEY_L -> GLFW.GLFW_KEY_L;
            case KEY_M -> GLFW.GLFW_KEY_M;
            case KEY_N -> GLFW.GLFW_KEY_N;
            case KEY_O -> GLFW.GLFW_KEY_O;
            case KEY_P -> GLFW.GLFW_KEY_P;
            case KEY_Q -> GLFW.GLFW_KEY_Q;
            case KEY_R -> GLFW.GLFW_KEY_R;
            case KEY_S -> GLFW.GLFW_KEY_S;
            case KEY_T -> GLFW.GLFW_KEY_T;
            case KEY_U -> GLFW.GLFW_KEY_U;
            case KEY_V -> GLFW.GLFW_KEY_V;
            case KEY_W -> GLFW.GLFW_KEY_W;
            case KEY_X -> GLFW.GLFW_KEY_X;
            case KEY_Y -> GLFW.GLFW_KEY_Y;
            case KEY_Z -> GLFW.GLFW_KEY_Z;
            case KEY_LEFT_BRACKET -> GLFW.GLFW_KEY_LEFT_BRACKET;
            case KEY_BACKSLASH -> GLFW.GLFW_KEY_BACKSLASH;
            case KEY_RIGHT_BRACKET -> GLFW.GLFW_KEY_RIGHT_BRACKET;
            case KEY_GRAVE_ACCENT -> GLFW.GLFW_KEY_GRAVE_ACCENT;
            case KEY_WORLD_1 -> GLFW.GLFW_KEY_WORLD_1;
            case KEY_WORLD_2 -> GLFW.GLFW_KEY_WORLD_2;
            case KEY_ESCAPE -> GLFW.GLFW_KEY_ESCAPE;
            case KEY_ENTER -> GLFW.GLFW_KEY_ENTER;
            case KEY_TAB -> GLFW.GLFW_KEY_TAB;
            case KEY_BACKSPACE -> GLFW.GLFW_KEY_BACKSPACE;
            case KEY_INSERT -> GLFW.GLFW_KEY_INSERT;
            case KEY_DELETE -> GLFW.GLFW_KEY_DELETE;
            case KEY_RIGHT -> GLFW.GLFW_KEY_RIGHT;
            case KEY_LEFT -> GLFW.GLFW_KEY_LEFT;
            case KEY_DOWN -> GLFW.GLFW_KEY_DOWN;
            case KEY_UP -> GLFW.GLFW_KEY_UP;
            case KEY_PAGE_UP -> GLFW.GLFW_KEY_PAGE_UP;
            case KEY_PAGE_DOWN -> GLFW.GLFW_KEY_PAGE_DOWN;
            case KEY_HOME -> GLFW.GLFW_KEY_HOME;
            case KEY_END -> GLFW.GLFW_KEY_END;
            case KEY_CAPS_LOCK -> GLFW.GLFW_KEY_CAPS_LOCK;
            case KEY_SCROLL_LOCK -> GLFW.GLFW_KEY_SCROLL_LOCK;
            case KEY_NUM_LOCK -> GLFW.GLFW_KEY_NUM_LOCK;
            case KEY_PRINT_SCREEN -> GLFW.GLFW_KEY_PRINT_SCREEN;
            case KEY_PAUSE -> GLFW.GLFW_KEY_PAUSE;
            case KEY_F1 -> GLFW.GLFW_KEY_F1;
            case KEY_F2 -> GLFW.GLFW_KEY_F2;
            case KEY_F3 -> GLFW.GLFW_KEY_F3;
            case KEY_F4 -> GLFW.GLFW_KEY_F4;
            case KEY_F5 -> GLFW.GLFW_KEY_F5;
            case KEY_F6 -> GLFW.GLFW_KEY_F6;
            case KEY_F7 -> GLFW.GLFW_KEY_F7;
            case KEY_F8 -> GLFW.GLFW_KEY_F8;
            case KEY_F9 -> GLFW.GLFW_KEY_F9;
            case KEY_F10 -> GLFW.GLFW_KEY_F10;
            case KEY_F11 -> GLFW.GLFW_KEY_F11;
            case KEY_F12 -> GLFW.GLFW_KEY_F12;
            case KEY_F13 -> GLFW.GLFW_KEY_F13;
            case KEY_F14 -> GLFW.GLFW_KEY_F14;
            case KEY_F15 -> GLFW.GLFW_KEY_F15;
            case KEY_F16 -> GLFW.GLFW_KEY_F16;
            case KEY_F17 -> GLFW.GLFW_KEY_F17;
            case KEY_F18 -> GLFW.GLFW_KEY_F18;
            case KEY_F19 -> GLFW.GLFW_KEY_F19;
            case KEY_F20 -> GLFW.GLFW_KEY_F20;
            case KEY_F21 -> GLFW.GLFW_KEY_F21;
            case KEY_F22 -> GLFW.GLFW_KEY_F22;
            case KEY_F23 -> GLFW.GLFW_KEY_F23;
            case KEY_F24 -> GLFW.GLFW_KEY_F24;
            case KEY_F25 -> GLFW.GLFW_KEY_F25;
            case KEY_KP_0 -> GLFW.GLFW_KEY_KP_0;
            case KEY_KP_1 -> GLFW.GLFW_KEY_KP_1;
            case KEY_KP_2 -> GLFW.GLFW_KEY_KP_2;
            case KEY_KP_3 -> GLFW.GLFW_KEY_KP_3;
            case KEY_KP_4 -> GLFW.GLFW_KEY_KP_4;
            case KEY_KP_5 -> GLFW.GLFW_KEY_KP_5;
            case KEY_KP_6 -> GLFW.GLFW_KEY_KP_6;
            case KEY_KP_7 -> GLFW.GLFW_KEY_KP_7;
            case KEY_KP_8 -> GLFW.GLFW_KEY_KP_8;
            case KEY_KP_9 -> GLFW.GLFW_KEY_KP_9;
            case KEY_KP_DECIMAL -> GLFW.GLFW_KEY_KP_DECIMAL;
            case KEY_KP_DIVIDE -> GLFW.GLFW_KEY_KP_DIVIDE;
            case KEY_KP_MULTIPLY -> GLFW.GLFW_KEY_KP_MULTIPLY;
            case KEY_KP_SUBTRACT -> GLFW.GLFW_KEY_KP_SUBTRACT;
            case KEY_KP_ADD -> GLFW.GLFW_KEY_KP_ADD;
            case KEY_KP_ENTER -> GLFW.GLFW_KEY_KP_ENTER;
            case KEY_KP_EQUAL -> GLFW.GLFW_KEY_KP_EQUAL;
            case KEY_LEFT_SHIFT -> GLFW.GLFW_KEY_LEFT_SHIFT;
            case KEY_LEFT_CONTROL -> GLFW.GLFW_KEY_LEFT_CONTROL;
            case KEY_LEFT_ALT -> GLFW.GLFW_KEY_LEFT_ALT;
            case KEY_LEFT_SUPER -> GLFW.GLFW_KEY_LEFT_SUPER;
            case KEY_RIGHT_SHIFT -> GLFW.GLFW_KEY_RIGHT_SHIFT;
            case KEY_RIGHT_CONTROL -> GLFW.GLFW_KEY_RIGHT_CONTROL;
            case KEY_RIGHT_ALT -> GLFW.GLFW_KEY_RIGHT_ALT;
            case KEY_RIGHT_SUPER -> GLFW.GLFW_KEY_RIGHT_SUPER;
            case KEY_MENU -> GLFW.GLFW_KEY_MENU;
        };
    }
}
