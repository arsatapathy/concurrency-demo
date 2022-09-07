package com.arsatapathy.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemoApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executorService.submit(() -> 5);
        Future<Integer> future2 = executorService.submit(() -> 6);

        Future<?> future = executorService.submit(() -> System.out.println(1));

        try {
            System.out.println(future.get());
            System.out.println(future1.get());
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("here");

        executorService.shutdown();
    }
}
