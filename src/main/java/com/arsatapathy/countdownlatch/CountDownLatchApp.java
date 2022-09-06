package com.arsatapathy.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchApp {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int i = 10; i > 0; i--) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
                countDownLatch.countDown();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

//        new Thread(() -> {
//           for (int i = 10; i > 0; i--) {
//               System.out.println(i);
//               countDownLatch.countDown();
//               try {
//                   Thread.sleep(1000L);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//           }
//        }).start();

        executorService.shutdown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("done " + System.currentTimeMillis());
    }
}
