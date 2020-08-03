package com.polydome.analogclock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

class Preferences {
    public final HandPreferences hourHand;
    public final HandPreferences minuteHand;
    public final Drawable backgroundDrawable;

    private Preferences(HandPreferences hourHand, HandPreferences minuteHand, Drawable backgroundDrawable) {
        this.hourHand = hourHand;
        this.minuteHand = minuteHand;
        this.backgroundDrawable = backgroundDrawable;
    }

    public static Preferences fromAttributes(Context context, AttributeSet attrs, DimensionConverter dimensionConverter) {
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.AnalogClock, 0, 0);

        HandPreferences.Builder hourHand = new HandPreferences.Builder(dimensionConverter);
        HandPreferences.Builder minuteHand = new HandPreferences.Builder(dimensionConverter);
        Drawable backgroundDrawable;

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

            backgroundDrawable = styledAttributes.getDrawable(R.styleable.AnalogClock_face_background);
        } finally {
            styledAttributes.recycle();
        }

        return new Preferences(hourHand.build(), minuteHand.build(), backgroundDrawable);
    }
}
