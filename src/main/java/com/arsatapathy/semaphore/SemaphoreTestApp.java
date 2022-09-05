package com.arsatapathy.semaphore;

import com.arsatapathy.semaphore.api.MyCounter;
import com.arsatapathy.semaphore.impl.MyCounterImpl;

import java.util.concurrent.Semaphore;

public class SemaphoreTestApp {
    public static void main(String[] args) {
        MyCounter counter = new MyCounterImpl(new Semaphore(1), new Semaphore(0));

        new Thread(() -> counter.incrementCounter("increment thread")).start();
        new Thread(() -> counter.decrementCounter("decrement thread")).start();

    }
}
