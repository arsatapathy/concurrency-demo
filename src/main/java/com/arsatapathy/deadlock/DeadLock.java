package com.arsatapathy.deadlock;

import com.arsatapathy.deadlock.model.A;
import com.arsatapathy.deadlock.model.B;

public class DeadLock {

    public static void main(String[] args) {
        new Thread(new MyRunner(), "Main Thread").start();
    }

    private static class MyRunner implements Runnable {
        A a = new A();
        B b = new B();

        @Override
        public void run() {
            b.bar(a);
            a.foo(b);
        }
    }
}
