package com.arsatapathy.syncrhronized;

public class DummyObj {
    private String count;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    private static String counter;
    public static void setCounter(String c) {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counter = c;
    }

    public static String getCounter() {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
