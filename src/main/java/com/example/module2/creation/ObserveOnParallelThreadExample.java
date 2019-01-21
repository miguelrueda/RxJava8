package com.example.module2.creation;

import com.example.module2.util.DataGenerator;
import com.example.module2.util.ThreadUtils;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

// FIXME: 20/01/2019
// ref https://github.com/trankimvu/java8-reactive-programming/tree/master/demo_codes/3-reactive-programming-java-8-rxjava-m3-otco-exercise-files/m3/after/reactive-programming-java-8-rxjava-m3
public class ObserveOnParallelThreadExample {
    public static void main(String[] args) {
        Object waitMonitor = new Object();
        synchronized (waitMonitor) {
            System.out.printf("driving thread " + ThreadUtils.currentThreadName());

            List<Integer> emitList = DataGenerator.generateFibonacciList();
            Observable<Integer> observable = Observable.from(emitList);
            observable
                    .subscribeOn(Schedulers.newThread())
                    .parallel(a -> a.filter(i -> i % 2 == 0)
                                    .doOnNext(x -> {
                                        System.out.println("Parallel thread " + ThreadUtils.currentThreadName());
                                        System.out.println("parallel " + x);
                                        ThreadUtils.sleep(10);
                                        System.out.println("parallel thread out " + ThreadUtils.currentThreadName());
                                    })
                            , Schedulers.io())
                    .subscribe(
                            (i) -> {
                                System.out.println("onNext thread entr: " + ThreadUtils.currentThreadName());
                                System.out.println(i);
                                System.out.println("onNext thread exit: " + ThreadUtils.currentThreadName());
                            },
                            // onError function
                            (t) -> {
                                t.printStackTrace();
                            },
                            // onCompleted
                            () -> {
                                System.out.println("onCompleted()");

                                // Since we have completed...we sync on the waitMonitor
                                // and then call notify to wake up the "main" thread.
                                synchronized (waitMonitor) {
                                    waitMonitor.notify();
                                }
                            }
                    );
            ThreadUtils.wait(waitMonitor);
        }
        System.exit(0);
    }
}
