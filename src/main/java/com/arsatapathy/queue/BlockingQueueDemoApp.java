package com.arsatapathy.queue;

import com.arsatapathy.queue.consumer.Consumer;
import com.arsatapathy.queue.producer.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemoApp {
    public static void main(String[] args) {
        BlockingQueue<String> myQueue = new ArrayBlockingQueue<>(5);

        Producer producer = new Producer(myQueue);
        Consumer consumer = new Consumer(myQueue);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}
