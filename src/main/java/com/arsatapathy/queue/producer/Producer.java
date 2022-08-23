package com.arsatapathy.queue.producer;

import java.time.LocalTime;
import java.util.List;

public class Producer implements Runnable {
    private final List<String> queue;

    private boolean stopped;

    public Producer(List<String> queue) {
        this.queue = queue;
    }

    private boolean hasStopped() {
        return stopped;
    }

    public void stop() {
        stopped = true;
    }


    @Override
    public void run() {
        int count = 0;

        while (!hasStopped()) {
            count += 1;

            LocalTime localTime = LocalTime.now();
            queue.add(count + ". Time " + localTime);

            try {
                Thread.sleep(1L);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}
