package demo.concurrency00.thread.create;

import demo.concurrency.Utils;

/**
 *  通过继续 Thread 类方式创建线程
 */
public class MyThreadDemo {
    public static void main(String[] args) {
        new MyThread("t1").start();
    }
}

class MyThread extends Thread {

    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        Utils.busyBoy(100);
    }
}
