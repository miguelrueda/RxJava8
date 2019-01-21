package com.example.module2.filtering;

import com.example.module2.util.DataGenerator;
import io.reactivex.Observable;

public class PositionalExampleFirstAndLast {
    public static void main(String[] args) {
        // Emit the greek alphabet, but only the first letter
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .first("List is empty!")
                .subscribe(System.out::println);
        System.out.println();

        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .take(4)
                .subscribe(System.out::println);
        System.out.println();

        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .last("List is empty")
                .subscribe(System.out::println);
        System.out.println();

        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .takeLast(4)
                .subscribe(System.out::println);
        System.out.println();

        Observable.empty().first("List is empty")
                .subscribe(System.out::println);

        Observable.empty().last("List is empty")
                .subscribe(System.out::println);

    }
}
