package demo.concurrency.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * 插入和移除必须同时进行
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        final SynchronousQueue<String> q = new SynchronousQueue<>();
        Thread t1 = new Thread(() -> {
            try {
                q.take();
                q.take();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> q.add("asdasd"));
        t2.start();
    }
}
