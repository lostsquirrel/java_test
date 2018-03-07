package demo.concurrency.thread04.cooperate;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ListTrigger {

    private volatile static List list = new ArrayList();

    private static final Logger log = LoggerFactory.getLogger(ListTrigger.class);


    public void monitor() {
        synchronized (list) {
//                这个地方要写成while 不然可能小概率会再次进入
            while (size() != 5) {
                log.debug("list size = {} 线程等待..", size());
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("list size = {} 线程结束", size());
                break;
            }
        }
    }

    public void worker() {
        synchronized (list) {
            for (int i = 0; i < 10; i++) {
                if (size() == 5) {
                    log.debug("发出通知");
                    list.notify();
                    Thread.yield();
                }
                add();
                log.debug("添加了第{}个元素..", i + 1);
                Utils.doWork(Utils.TIMEOUT_500MS);
            }
        }
    }

    public void worker2() {
        for (int i = 0; i < 10; i++) {
            synchronized (list) {
                if (size() == 5) {
                    log.debug("发出通知");
                    list.notify();
                    Thread.yield();
                }
                add();
                log.debug("添加了第{}个元素..", i + 1);
                Utils.doWork(Utils.TIMEOUT_500MS);
            }
        }
    }

    public void add() {
        list.add("item");
    }

    public int size() {
        return list.size();
    }

}