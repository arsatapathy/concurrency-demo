package com.arsatapathy.semaphore.api;

import java.util.concurrent.Semaphore;

public interface MyCounter {
    void incrementCounter(String name);
    void decrementCounter(String name);
}
