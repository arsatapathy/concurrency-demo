package com.arsatapathy.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchApp {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        new Thread(() -> {
           for (int i = 10; i > 0; i--) {
               System.out.println(i);
               countDownLatch.countDown();
               try {
                   Thread.sleep(1000L);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("done " + System.currentTimeMillis());
    }
}
