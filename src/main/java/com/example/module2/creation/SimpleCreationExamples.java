package com.example.module2.creation;


import com.example.DataGenerator;
import io.reactivex.Observable;

public class SimpleCreationExamples {

    public static void main(String[] args) {

        Observable<Integer> observable = null;
        System.out.println("From a single value");
        observable = Observable.just(Integer.valueOf(42));
        observable.subscribe((i) -> System.out.println(String.valueOf(i)));

        System.out.println("From an Iterable");
        observable = Observable.fromIterable(DataGenerator.generateFibonacciList());
        observable.subscribe((i) -> System.out.println(String.valueOf(i)));

        System.out.println("From an Array");
        observable = Observable.fromArray(DataGenerator.generateFibonacciArray());
        observable.subscribe((i) -> System.out.println(String.valueOf(i)));
    }
}
