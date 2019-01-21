package com.example.module2.creation;

import com.example.DataGenerator;
import com.example.ThreadUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class SubscriptionAllOneThreadExample {

    public static void main(String[] args) {

        System.out.println(ThreadUtils.currentThreadName());

        List<Integer> intList = DataGenerator.generateFibonacciList();

        Observable<Integer> observable = Observable.fromIterable(intList);

        observable
                .subscribe(
                        integer -> {
            System.out.println("onNext thread entr " + ThreadUtils.currentThreadName());
            System.out.println(integer);
            System.out.println("onNext thread exit " + ThreadUtils.currentThreadName());
        }, throwable -> {
            throwable.printStackTrace();
        }, () -> System.out.println("onCompleted"));

        System.exit(0);
    }
}
