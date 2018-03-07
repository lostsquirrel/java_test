package demo.concurrency03.thread.priority;

import demo.concurrency.Utils;

/**
 * 高优先级的线程更容易再竞争中获胜
 * 优先级，分别为 高 普通 低的 依次结束
 * 使用 单核 机器运行
 *  docker run -it --rm --cpus=1 registry.cn-hangzhou.aliyuncs.com/lisong/java:8_server-jre cat /proc/cpuinfo
 *  docker run -it --rm --cpuset-cpus="0" -v $(pwd)/target:/app registry.cn-hangzhou.aliyuncs.com/lisong/java:8_server-jre java -cp /app/java_test-0.0.1-SNAPSHOT-jar-with-dependencies.jar demo.concurrency03.thread.priority.PriorityDemo
 */
public class PriorityDemo {
    public static void main(String[] args) {
        int [] ps = new int[]{Thread.MAX_PRIORITY, Thread.NORM_PRIORITY, Thread.MIN_PRIORITY};
        String[] pns = new String[]{"MAX_PRIORITY", "NORM_PRIORITY", "MIN_PRIORITY"};
        int x = 0;
        for (int p : ps) {
            Thread t = new Thread(()->{
                int y = 0;
                for (int i = 0; i < Short.MAX_VALUE; i++) {
                    y += i;
                }
                System.out.println(String.format("Thread %s finished", Thread.currentThread().getName()));
            }, pns[x]);
            x++;
            t.setPriority(p);
            t.start();
        }
    }
}
