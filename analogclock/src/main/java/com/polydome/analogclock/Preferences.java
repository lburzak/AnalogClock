package com.polydome.analogclock;

import android.util.AttributeSet;

class Preferences {
    public final HandPreferences hourHand;
    public final HandPreferences minuteHand;

    private Preferences() {
        hourHand = new HandPreferences();
        minuteHand = new HandPreferences();
    }

    public static Preferences fromAttributes(AttributeSet attrs) {
        return new Preferences();
    }
}
