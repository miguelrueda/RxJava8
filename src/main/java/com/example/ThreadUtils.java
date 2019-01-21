package com.example;

public class ThreadUtils {

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void wait(Object monitor) {
        try {
            monitor.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String currentThreadName() {
        return Thread.currentThread().getName();
    }
}
