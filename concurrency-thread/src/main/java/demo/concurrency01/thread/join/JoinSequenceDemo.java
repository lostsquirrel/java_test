package demo.concurrency01.thread.join;

import demo.concurrency.Utils;

/**
 * 保证T2在T1执行完后执行，
 * T3在T2执行完后执行
 */
public class JoinSequenceDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->Utils.doWork(Utils.TIMEOUT_1S), "t1");

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utils.doWork(Utils.TIMEOUT_1S);
        } , "t2");

        new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utils.doWork(Utils.TIMEOUT_1S);
        } , "t3").start();
        t2.start();
        t1.start();
    }
}
