package com.example.module2.creation;

import com.example.module2.util.DataGenerator;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.FutureTask;

public class FutureCreationExample {

    public static void main(String[] args) {
        Observable<List<Integer>> observableFutureList;

        FutureTask<List<Integer>> future = new FutureTask<>(DataGenerator::generateFibonacciList);

        observableFutureList = Observable.fromFuture(future);

        Schedulers.computation().scheduleDirect(future::run);

        observableFutureList.subscribe((list) ->
            list.forEach(System.out::println));
    }
}
