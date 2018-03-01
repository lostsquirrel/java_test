package demo.concurrency03.thread.priority;

import demo.concurrency.LiftOff;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 高优先级的线程更容易再竞争中获胜
 * 优先级，分别为 高 普通 低的 依次结束
 */
public class PriorityDemo {
    public static void main(String[] args) {
        int [] ps = new int[]{Thread.MAX_PRIORITY, Thread.NORM_PRIORITY, Thread.MIN_PRIORITY};
        String[] pns = new String[]{"MAX_PRIORITY", "NORM_PRIORITY", "MIN_PRIORITY"};
        int x = 0;
        for (int p : ps) {
            Thread t = new Thread(new LiftOff(Short.MAX_VALUE, false), pns[x]);
            x++;
            t.setPriority(p);
            t.start();
        }
    }
}
