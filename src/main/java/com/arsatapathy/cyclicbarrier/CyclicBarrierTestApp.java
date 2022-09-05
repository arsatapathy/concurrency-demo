package com.arsatapathy.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTestApp {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("barrier reached"));

        System.out.println("starting");

        new Thread(new MyRunner(cb, "A")).start();
        new Thread(new MyRunner(cb, "B")).start();
        new Thread(new MyRunner(cb, "C")).start();
        new Thread(new MyRunner(cb, "D")).start();
        new Thread(new MyRunner(cb, "E")).start();
        new Thread(new MyRunner(cb, "F")).start();
    }

    private static class MyRunner implements Runnable {
        private final CyclicBarrier cb;
        private final String name;

        public MyRunner(CyclicBarrier cb, String name) {
            this.cb = cb;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " running");

            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
