package com.arsatapathy.timeunit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class TimeUnitTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        List<Future<?>> futures = integers.stream().map((i) -> es.submit(() -> {
            System.out.println(i + " " + Thread.currentThread().getName());
            if (i == 5) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })).collect(Collectors.toList());

        futures.forEach(future -> {
            try {
                future.get(1, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Complete");
        es.shutdown();
    }
}
