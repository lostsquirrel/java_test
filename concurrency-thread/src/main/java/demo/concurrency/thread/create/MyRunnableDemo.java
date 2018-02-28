package demo.concurrency.thread.create;

import demo.concurrency.Utils;

public class MyRunnableDemo {
    public static void main(String[] args) {
        new Thread(new MyRunnable(), "r1").start();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        Utils.busyBoy(100);
    }
}