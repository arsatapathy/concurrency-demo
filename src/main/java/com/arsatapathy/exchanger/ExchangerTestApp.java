package com.arsatapathy.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerTestApp {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(new StringGenerator(exchanger)).start();
        new Thread(new EmptyStringGenerator(exchanger)).start();
    }

    private static class StringGenerator implements Runnable {
        private Exchanger<String> exchanger;
        private String str;

        public StringGenerator(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            this.str = new String();
        }

        @Override
        public void run() {
            char ch = 'A';
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    str += ch++;
                }
                try {
                    System.out.println("Put : " + str);
                    str = exchanger.exchange(str);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class EmptyStringGenerator implements Runnable {
        private final Exchanger<String> exchanger;
        private String str;

        public EmptyStringGenerator(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    str = exchanger.exchange("");
                    System.out.println("Got : " + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
