package com.arsatapathy.executorservice;

import com.arsatapathy.executorservice.api.MyTask;
import com.arsatapathy.executorservice.impl.MyTaskImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTestApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        MyTask myTask = new MyTaskImpl();

        myTask.task(executorService);

        System.out.println("back here");

        executorService.shutdown();
    }
}
