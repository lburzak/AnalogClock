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
                    .lengthIfValid(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_hour_hand_length, 0))
                    .widthIfValid(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_hour_hand_width, 0))
                    .offsetIfValid(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_hour_hand_offset, 0))
                    .colorIfValid(styledAttributes.getColor(R.styleable.AnalogClock_hour_hand_color, 0));

            minuteHand
                    .lengthIfValid(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_minute_hand_length, 0))
                    .widthIfValid(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_minute_hand_width, 0))
                    .offsetIfValid(styledAttributes.getDimensionPixelSize(R.styleable.AnalogClock_minute_hand_offset, 0))
                    .colorIfValid(styledAttributes.getColor(R.styleable.AnalogClock_minute_hand_color, 0));
        } finally {
            styledAttributes.recycle();
        }

        return new Preferences(hourHand.build(), minuteHand.build());
    }
}
