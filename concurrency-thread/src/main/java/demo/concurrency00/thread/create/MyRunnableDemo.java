package demo.concurrency00.thread.create;

import demo.concurrency.Utils;

/**
 * 通过实现 Runnable 接口创建线程
 */
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