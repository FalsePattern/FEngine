package com.falsepattern.fengine.util;

/**
 * A queue that drops the oldest element when it is full.
 */
public class CircularDroppingQueueChar {
    /**
     * The maximum number of elements in the queue.
     */
    private final int capacity;
    /**
     * The contents of the queue.
     */
    private final char[] data;
    /**
     * The index of the oldest element in the queue.
     */
    private int head = 0;
    /**
     * The index of the next element to be added.
     */
    private int tail = 0;

    /**
     * Constructs a new queue with the specified capacity.
     * @param capacity The capacity of the queue.
     */
    public CircularDroppingQueueChar(int capacity) {
        this.capacity = capacity;
        data = new char[capacity];
    }

    /**
     * @return <code>true</code> if the queue has elements available for polling.
     */
    public boolean available() {
        return head != tail;
    }

    /**
     * Adds an element to the queue.
     * @param value The element to add.
     */
    public void add(char value) {
        data[tail] = value;
        tail = incrementMod(tail);
        if (tail == head) {
            head = incrementMod(head);
        }
    }

    /**
     * @return The oldest element in the queue. If the queue is empty, this returns an empty optional.
     */
    public char poll() {
        if (head == tail) {
            return 0;
        }
        char value = data[head];
        head = incrementMod(head);
        return value;
    }

    /**
     * Increments the specified index modulo the capacity of the queue.
     * @param i The index to increment.
     * @return The incremented index.
     */
    private int incrementMod(int i) {
        return (i + 1) % capacity;
    }
}
