package com.example.module2.filtering;

import com.example.module2.util.DataGenerator;
import io.reactivex.Observable;

public class PositionalExampleDistinct {

    public static void main(String[] args) {
        Observable.fromIterable(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
            .subscribe(System.out::println);
        System.out.println();

        Observable.fromIterable(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
                .distinct()
                .subscribe(System.out::println);

        System.exit(0);
    }

}
