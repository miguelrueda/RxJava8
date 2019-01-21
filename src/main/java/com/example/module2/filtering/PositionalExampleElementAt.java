package com.example.module2.filtering;

import com.example.module2.util.DataGenerator;
import io.reactivex.Observable;

public class PositionalExampleElementAt {

    public static void main(String[] args) {
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .elementAt(2)
                .subscribe(System.out::println);
        System.out.println();

        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .elementAt(50, "Unknown")
                .subscribe(System.out::println);
        System.out.println();

        System.exit(0);
    }

}
