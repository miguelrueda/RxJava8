package com.example.module2.util;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class TimeTicker {

    private final BehaviorSubject<Long> tickerSubject;
    private final long interval;

    private volatile boolean paused;
    private long lastTick;
    private Thread tickerThread;

    public TimeTicker(long interval) {
        lastTick = System.currentTimeMillis();
        tickerSubject = BehaviorSubject.createDefault(lastTick);
        tickerThread = null;
        paused = false;
        this.interval = interval;
    }

    public Observable<Long> toObservable() {
        return tickerSubject;
    }

    public synchronized void start() {
        if (tickerThread != null) {
            return;
        }

        unpause();
        tickerThread = new Thread(() -> {
            try {
                while (Thread.interrupted() == false) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        break;
                    }

                    if (paused)
                        continue;

                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastTick > interval) {
                        lastTick = currentTime;
                        tickerSubject.onNext(lastTick);
                    }
                } // while
            } catch (Throwable t) {
                tickerSubject.onError(t);
            }
            tickerSubject.onComplete();
        }, "Ticker Thread");
        tickerThread.start();
    }

    public synchronized void stop() {
        if (tickerThread == null) {
            return;
        }

        tickerThread.interrupt();
        try {
            tickerThread.join();
        } catch (InterruptedException e) {

        }
        tickerThread = null;
    }

    public void pause() {
        paused = true;
    }

    public void unpause() {
        paused = false;
    }
}
