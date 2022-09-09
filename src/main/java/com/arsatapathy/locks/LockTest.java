package com.arsatapathy.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + ++MyCounter.counter);
            }
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + MyCounter.counter--);
            }
            lock.unlock();
        }).start();
    }

    private static class MyCounter {
        private static int counter;
    }


}
