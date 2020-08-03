package com.polydome.analogclock.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.polydome.analogclock.AnalogClock;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnalogClock clockView = findViewById(R.id.clock);

        Handler mainHandler = new Handler(getMainLooper());
        ClockSpinner clockSpinner = new ClockSpinner(mainHandler, clockView);

        clockSpinner.setMillisPerHour(500);
//        clockSpinner.start();
        clockView.setTime(4, 70);
    }
}
