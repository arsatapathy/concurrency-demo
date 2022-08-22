package com.arsatapathy.queue.consumer;

import java.util.concurrent.BlockingQueue;

public class ConsumerQueue implements Runnable {
    private final BlockingQueue<String> queue;

    public ConsumerQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = queue.take();

                System.out.println("consumed " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
