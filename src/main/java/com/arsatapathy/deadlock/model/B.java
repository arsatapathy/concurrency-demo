package com.arsatapathy.deadlock.model;

public class B {
    synchronized public void bar(A a) {
        System.out.println(Thread.currentThread().getName() + " entered B.foo(A a)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " trying to call A.last()");
        a.last();
    }


    synchronized public void last() {
        System.out.println("Inside B.last()");
    }

}
