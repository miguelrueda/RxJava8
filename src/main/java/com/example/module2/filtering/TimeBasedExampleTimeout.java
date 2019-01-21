package com.example.module2.filtering;

import com.example.module2.util.ThreadUtils;
import com.example.module2.util.TimeTicker;

import java.util.concurrent.TimeUnit;

public class TimeBasedExampleTimeout {
    public static void main(String[] args) {
        TimeTicker timeTicker = new TimeTicker(100);
        timeTicker.start();

        try {
            timeTicker.toObservable()
                    .timeout(3, TimeUnit.SECONDS)
                    .subscribe(
                            aLong -> System.out.println("tick " + aLong),
                            throwable -> {
                                System.out.println("timeout");
                                throwable.printStackTrace();
                            });
            ThreadUtils.sleep(1000);

            System.out.println("Pausing ticker");
            timeTicker.pause();

            ThreadUtils.sleep(5000);
        } finally {
            timeTicker.stop();
        }
        System.exit(0);
    }
}
