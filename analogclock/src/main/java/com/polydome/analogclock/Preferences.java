package com.polydome.analogclock;

import android.content.Context;
import android.util.AttributeSet;

class Preferences {
    public final HandPreferences hourHand;
    public final HandPreferences minuteHand;

    private Preferences(HandPreferences hourHand, HandPreferences minuteHand) {
        this.hourHand = hourHand;
        this.minuteHand = minuteHand;
    }

    public static Preferences fromAttributes(Context context, AttributeSet attrs, DimensionConverter dimensionConverter) {
        HandPreferences hourHand;
        HandPreferences minuteHand;

        hourHand = new HandPreferences.Builder(dimensionConverter).build();
        minuteHand = new HandPreferences.Builder(dimensionConverter).build();

        return new Preferences(hourHand, minuteHand);
    }
}
