package com.arsatapathy.queue.consumer;

import java.util.List;

public class Consumer implements Runnable {
    private final List<String> queue;

    public Consumer(List<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
                String message = queue.remove(0);

                System.out.println(message);
        }
    }

}
