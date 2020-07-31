package com.polydome.analogclock.demo;

import android.os.Handler;

import com.polydome.analogclock.AnalogClockView;

public class ClockSpinner {
    private final Thread tickingThread = new TickingThread();
    private final Handler mainHandler;
    private final AnalogClockView clockView;

    private int millisPerHour = 1000;

    public ClockSpinner(Handler mainHandler, AnalogClockView clockView) {
        this.mainHandler = mainHandler;
        this.clockView = clockView;
    }

    public void setMillisPerHour(int millis) {
        millisPerHour = millis;
    }

    public void start() {
        tickingThread.start();
    }

    private class TickingThread extends Thread {
        private int tick = 0;

        @Override
        public void run() {
            while (!interrupted()) {
                updateClock(getHours(), getMinutes());

                incrementTick();

                try {
                    sleep(getTickDelay());
                } catch (InterruptedException e) {
                    break;
                }
            }

        }

        private void incrementTick() {
            tick++;
        }

        private int getHours() {
            return (tick / 60) % 12;
        }

        private int getMinutes() {
            return tick % 60;
        }

        private int getTickDelay() {
            return millisPerHour / 60;
        }

        private void updateClock(final int hour, final int minute) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    clockView.setTime(hour, minute);
                }
            });
        }
    }
}
