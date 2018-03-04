package demo.concurrency04.thread.cooperate;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 当等于5时结束程序, monitor 线程结束
 * 因为 notify 方法不会释放锁，所以 monitor 线程只有在worker 线程结束后才会执行
 */
public class ListWaitNotifyTriggerDemo {

    private static final Logger log = LoggerFactory.getLogger(ListWaitNotifyTriggerDemo.class);

    public static void main(String[] args) {
        ListTrigger l = new ListTrigger();
        new Thread(l::monitor, "monitor").start();
        new Thread(l::worker, "worker").start();
    }
}
