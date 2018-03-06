package demo.concurrency04.thread.cooperate;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 当等于5时结束程序, monitor 线程结束
 * 因为 notify 方法不会释放锁，将同步块放入 for 循环
 * 让 monitor 尽快结束
 * TODO 未达到目标， 需要查找原因
 */
public class ListWaitNotifyTriggerDemo2 {

    private static final Logger log = LoggerFactory.getLogger(ListWaitNotifyTriggerDemo2.class);

    public static void main(String[] args) {
        ListTrigger l = new ListTrigger();
        new Thread(l::monitor, "monitor").start();
        new Thread(l::worker2, "worker").start();
    }
}
