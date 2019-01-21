package com.example.module2.filtering;

import com.example.module2.util.DataGenerator;
import io.reactivex.Observable;

public class PredicatesExample {

    public static void main(String[] args) {
        Observable.fromIterable(DataGenerator.generateBigIntegerList())
                .filter(i -> ((i % 3 == 0) && (i < 20)))
                .subscribe(System.out::println);
        System.exit(0);
    }
}
