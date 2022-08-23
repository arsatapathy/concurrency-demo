package com.arsatapathy.queue;

import com.arsatapathy.queue.consumer.Consumer;
import com.arsatapathy.queue.producer.Producer;

import java.util.LinkedList;
import java.util.List;

public class QueueDemoApp {
    public static void main(String[] args) throws InterruptedException {
        List<String> myQueue = new LinkedList<>();

        Consumer consumer = new Consumer(myQueue);
        Producer producer = new Producer(myQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();

        Thread.sleep(200L);

        consumerThread.start();

        producer.stop();

        producerThread.join();
        consumerThread.join();

        System.out.println(myQueue.isEmpty());
    }
}
