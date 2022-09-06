package com.arsatapathy.executorservice.impl;

import com.arsatapathy.executorservice.api.MyTask;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MyTaskImpl implements MyTask {

    public void task(ExecutorService ex) {
        List<Future<?>> futures = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(ex.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }

        for (Future<?> future :futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
