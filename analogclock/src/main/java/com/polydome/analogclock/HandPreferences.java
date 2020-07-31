package com.polydome.analogclock;

import android.graphics.Color;

class HandPreferences {
    /**
     * Default length of a clock hand.
     * Expressed in DPs.
     */
    public final static int DEFAULT_LENGTH = 100;

    /**
     * Default stroke width of a clock hand.
     * Expressed in DPs.
     */
    public final static int DEFAULT_WIDTH = 20;

    /**
     * Default offset of a clock hand.
     * Expressed in DPs.
     */
    public final static int DEFAULT_OFFSET = 0;

    /**
     * Default color of a clock hand.
     */
    public final static int DEFAULT_COLOR = Color.BLACK;

    private final int width;
    private final int length;
    private final int offset;
    private final int color;

    public HandPreferences(int width, int length, int offset, int color) {
        this.width = width;
        this.length = length;
        this.offset = offset;
        this.color = color;
    }

    public HandPreferences() {
        this.width = DEFAULT_WIDTH;
        this.length = DEFAULT_LENGTH;
        this.offset = DEFAULT_OFFSET;
        this.color = DEFAULT_COLOR;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getOffset() {
        return offset;
    }

    public int getColor() {
        return color;
    }
}
