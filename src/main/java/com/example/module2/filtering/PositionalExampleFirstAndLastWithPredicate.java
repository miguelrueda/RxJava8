package com.example.module2.filtering;

import com.example.module2.util.DataGenerator;
import rx.Observable;

public class PositionalExampleFirstAndLastWithPredicate {

    public static void main(String[] args) {
        Observable.from(DataGenerator.generateGreekAlphabet())
                .first(letter -> letter.equals("Beta"))
                .subscribe(System.out::println);
        System.out.println();

        Observable.from(DataGenerator.generateGreekAlphabet())
                .last(letter -> letter.equals("Gamma"))
                .subscribe(System.out::println);
        System.out.println();

        System.exit(0);
    }

}
