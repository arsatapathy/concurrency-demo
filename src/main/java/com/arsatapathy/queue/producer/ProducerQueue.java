package com.arsatapathy.queue.producer;

import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;

public class ProducerQueue implements Runnable {
    private final BlockingQueue<String> queue;

    public ProducerQueue(BlockingQueue<String> queue) {
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
