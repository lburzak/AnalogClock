package com.polydome.analogclock;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class Preferences {
    public final HandPreferences hourHand;
    public final HandPreferences minuteHand;

    private Preferences(HandPreferences hourHand, HandPreferences minuteHand) {
        this.hourHand = hourHand;
        this.minuteHand = minuteHand;
    }

    public static Preferences fromAttributes(Context context, AttributeSet attrs, DimensionConverter dimensionConverter) {
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.AnalogClock, 0, 0);

        HandPreferences.Builder hourHand = new HandPreferences.Builder(dimensionConverter);
        HandPreferences.Builder minuteHand = new HandPreferences.Builder(dimensionConverter);

        try {
            hourHand
                    .length(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_hour_hand_length, HandPreferences.DEFAULT_LENGTH))
                    .width(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_hour_hand_width, HandPreferences.DEFAULT_WIDTH))
                    .offset(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_hour_hand_offset, HandPreferences.DEFAULT_OFFSET))
                    .color(styledAttributes.getColor(R.styleable.AnalogClock_hour_hand_color, HandPreferences.DEFAULT_COLOR));

            minuteHand
                    .length(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_minute_hand_length, HandPreferences.DEFAULT_LENGTH))
                    .width(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_minute_hand_width, HandPreferences.DEFAULT_WIDTH))
                    .offset(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_minute_hand_offset, HandPreferences.DEFAULT_OFFSET))
                    .color(styledAttributes.getColor(R.styleable.AnalogClock_minute_hand_color, HandPreferences.DEFAULT_COLOR));
        } finally {
            styledAttributes.recycle();
        }

        return new Preferences(hourHand.build(), minuteHand.build());
    }
}
