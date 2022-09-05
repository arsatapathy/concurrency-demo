package com.arsatapathy.semaphore.impl;

import com.arsatapathy.semaphore.api.MyCounter;

import java.util.concurrent.Semaphore;

public class MyCounterImpl implements MyCounter {
    private final Semaphore incrementSemaphore;
    private final Semaphore decrementSemaphore;

    public MyCounterImpl(Semaphore incrementSemaphore, Semaphore decrementSemaphore) {
        this.incrementSemaphore = incrementSemaphore;
        this.decrementSemaphore = decrementSemaphore;
    }

    @Override
    public void incrementCounter(String name) {
        System.out.println(name + " is trying to acquire");
        try {
            incrementSemaphore.acquire();
            System.out.println(name + " has acquired lock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            SharedCount.counter++;
            System.out.println(SharedCount.counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        decrementSemaphore.release();
    }

    @Override
    public void decrementCounter(String name) {
        System.out.println(name + " is trying to acquire");
        try {
            decrementSemaphore.acquire();
            System.out.println(name + " has acquired lock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0 ; i < 5; i++) {
            System.out.println(SharedCount.counter);
            SharedCount.counter--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        incrementSemaphore.release();
    }
}
