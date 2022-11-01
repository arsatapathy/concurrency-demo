package com.arsatapathy.deadlock.model;

public class A {

    synchronized public void foo(B b) {
        System.out.println(Thread.currentThread().getName() + " entered A.foo(B b)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " trying to call B.last()");
        b.last();
    }

    synchronized public void last() {
        System.out.println("Inside A.last()");
    }

}
