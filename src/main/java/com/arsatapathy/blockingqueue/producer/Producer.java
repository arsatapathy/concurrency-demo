package com.arsatapathy.blockingqueue.producer;

import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
       this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                LocalTime localTime = LocalTime.now();

                queue.put(" " + localTime);
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
