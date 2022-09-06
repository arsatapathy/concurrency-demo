package com.arsatapathy.executorservice.api;

import java.util.concurrent.ExecutorService;

public interface MyTask {
    void task(ExecutorService ex);
}
