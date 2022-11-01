package com.arsatapathy.executorservice.impl;

import com.arsatapathy.executorservice.api.Dummy;
import com.arsatapathy.executorservice.api.MyTaskWithError;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MyTaskWithErrorImpl implements MyTaskWithError {
    private final ExecutorService ex;

    public MyTaskWithErrorImpl(ExecutorService ex) {
        this.ex = ex;
    }

    @Override
    public void task() {
        List<Future<?>> futures = new ArrayList<>();
        Dummy dummy = null;

        for (int i = 0; i < 10; i++) {
            futures.add(ex.submit(new Runner(i)));
        }

        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException("Un expected error ", e);
//                e.printStackTrace();
            }
        });
    }

    private static class Runner implements Runnable {
        private final int i;

        public Runner(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            if (i == 5) {
                throw new IllegalStateException("Error with " + i);
            }
            System.out.println("Getting  " + i);
        }
    }
}
