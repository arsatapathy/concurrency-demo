package com.arsatapathy.executorservice;

import com.arsatapathy.executorservice.api.MyTask;
import com.arsatapathy.executorservice.api.MyTaskWithError;
import com.arsatapathy.executorservice.impl.MyTaskImpl;
import com.arsatapathy.executorservice.impl.MyTaskWithErrorImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTestApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        MyTask myTask = new MyTaskImpl();
//
//        myTask.task(executorService);
//
//        System.out.println("back here");

        MyTaskWithError myTaskWithError = new MyTaskWithErrorImpl(executorService);

        try {
            myTaskWithError.task();
        } catch (Exception e) {
            executorService.shutdown();
            throw new IllegalStateException("error caught in main thread ", e);
        }

        executorService.shutdown();
    }
}
