package com.example.module2.filtering;

import com.example.module2.util.ThreadUtils;
import com.example.module2.util.TimeTicker;

import java.util.concurrent.TimeUnit;

public class TimeBasedExampleSample {
    public static void main(String[] args) {
        TimeTicker ticker = new TimeTicker(10);
        ticker.start();

        try {
            ticker.toObservable()
                    .sample(1, TimeUnit.SECONDS)
                    .subscribe(tick -> System.out.println(tick));

            ThreadUtils.sleep(1000);
        } finally {
            ticker.stop();
        }
        System.exit(0);
    }
}
