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
    public final static int DEFAULT_WIDTH = 5;

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

    private HandPreferences(int width, int length, int offset, int color) {
        this.width = width;
        this.length = length;
        this.offset = offset;
        this.color = color;
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

    public static class Builder {
        private int width;
        private int length;
        private int offset;
        private int color;

        public Builder(DimensionConverter dc) {
            width = dc.px(DEFAULT_WIDTH);
            length = dc.px(DEFAULT_LENGTH);
            offset = dc.px(DEFAULT_OFFSET);
            color = dc.px(DEFAULT_COLOR);
        }

        public Builder width(int pixels) {
            this.width = pixels;
            return this;
        }

        public Builder length(int pixels) {
            this.length = pixels;
            return this;
        }

        public Builder offset(int pixels) {
            this.offset = pixels;
            return this;
        }

        public Builder color(int color) {
            this.color = color;
            return this;
        }

        public HandPreferences build() {
            return new HandPreferences(width, length, offset, color);
        }
    }
}
