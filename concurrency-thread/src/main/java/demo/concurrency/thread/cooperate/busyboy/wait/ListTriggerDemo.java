package demo.concurrency.thread.cooperate.busyboy.wait;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 当等于5时结束程序, monitor 线程结束
 * 因为 notify 方法不会释放锁，所以 monitor 线程只有在worker 线程结束后才会执行
 */
public class ListTriggerDemo {

    private volatile static List list = new ArrayList();

    private static final Logger log = LoggerFactory.getLogger(ListTriggerDemo.class);

    public void add() {
        list.add("bjsxt");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {

        final ListTriggerDemo ltd = new ListTriggerDemo();


        new Thread(() -> {
            synchronized (ltd) {
//                这个地方要写成while 不然可能小概率会再次进入
                while (ltd.size() != 5) {
                    log.debug("list size = {} 线程等待..", ltd.size());
                    try {
                        ltd.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.debug("线程结束");
                    break;
                }

            }
        }, "monitor").start();

        new Thread(() -> {
            synchronized (ltd) {
                for (int i = 0; i < 10; i++) {
                    if (list.size() == 5) {
//                                ltd.wait();
                        log.debug("发出通知");
                        ltd.notify();
                        Thread.yield();
                    }
                    ltd.add();
                    log.debug("添加了第{}个元素..", i);
                    Utils.doWork(Utils.TIMEOUT_500MS);
                }
            }
        }, "worker").start();
    }
}
