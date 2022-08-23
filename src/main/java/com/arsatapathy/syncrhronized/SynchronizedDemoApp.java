package com.arsatapathy.syncrhronized;

public class SynchronizedDemoApp {
    public static void main(String[] args) throws InterruptedException {
        DummyObj obj = new DummyObj();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.setCount("" + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(obj.getCount());
            }
        });

//        thread1.start();
//        Thread.sleep(5L);
//        thread2.start();

        Thread thread3 = new Thread(
                () -> {
                    for (int i = 0; i < 1000; i++) {
                        DummyObj.setCounter("" + i);
                    }
                }
        );

        Thread thread4 = new Thread(
                () -> {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(DummyObj.getCounter());
                    }
                }
        );

        thread3.start();
        thread4.start();

    }
}
