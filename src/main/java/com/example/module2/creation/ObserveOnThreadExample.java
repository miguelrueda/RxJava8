package com.example.module2.creation;

import com.example.module2.util.DataGenerator;
import com.example.module2.util.ThreadUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class ObserveOnThreadExample {

    public static void main(String[] args) {
        Object waitMonitor = new Object();
        synchronized (waitMonitor) {
            System.out.println("Current thread " + ThreadUtils.currentThreadName());

            List<Integer> emitList = DataGenerator.generateFibonacciList();
            Observable<Integer> observable = Observable.fromIterable(emitList);

            observable.observeOn(Schedulers.io())
                    .subscribe(
                            integer -> {
                                System.out.println("onNext thread entr " + ThreadUtils.currentThreadName());
                                System.out.println(integer);
                                System.out.println("onNext thread exit " + ThreadUtils.currentThreadName());
                            }, throwable -> {
                                throwable.printStackTrace();
                            }, () -> {
                                System.out.println("onCompleted");

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
