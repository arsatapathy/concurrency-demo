package com.arsatapathy.queue;

import com.arsatapathy.queue.consumer.ConsumerQueue;
import com.arsatapathy.queue.producer.ProducerQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemoApp {
    public static void main(String[] args) {
        BlockingQueue<String> myQueue = new ArrayBlockingQueue<>(5);

        ProducerQueue producerQueue = new ProducerQueue(myQueue);
        ConsumerQueue consumerQueue = new ConsumerQueue(myQueue);

        Thread thread1 = new Thread(producerQueue);
        Thread thread2 = new Thread(consumerQueue);

        thread1.start();
        thread2.start();
    }
}
