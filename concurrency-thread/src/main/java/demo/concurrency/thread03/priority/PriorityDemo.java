package demo.concurrency.thread03.priority;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 高优先级的线程更容易再竞争中获胜
 * 优先级，分别为 高 普通 低的 依次结束
 * 使用 单核 机器运行
 */
public class PriorityDemo {
    private static final Logger log = LoggerFactory.getLogger(PriorityDemo.class);

    public static void main(String[] args) {
        int [] ps = new int[]{Thread.MAX_PRIORITY, Thread.NORM_PRIORITY, Thread.MIN_PRIORITY};
        String[] pns = new String[]{"MAX_PRIORITY", "NORM_PRIORITY", "MIN_PRIORITY"};
        int x = 0;
        for (int p : ps) {
            String name = pns[x];
            Thread t = new Thread(()->Utils.busyBoy(Short.MAX_VALUE), name);
            x++;
            t.setPriority(p);
            log.debug("thread {} run in priority {}", name, p);
            t.start();
        }
    }
}
