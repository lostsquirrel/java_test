package demo.concurrency.thread01.join;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 当 getter 线程 i < 10  元素取出速度小于放入速度， 如果队列已满则等待取出
 * 当 getter 线程 i > 10 时 元素取出速度大于放入速度，如果没有元素则等待放入
 */
public class MyBlockingListDemo {

    public static void main(String[] args) {
        MyBlockingList list = new MyBlockingList(6);
        int size = 30;
        new Thread(()->{
            for (int i = 0; i < size; i++) {
                list.add(i);
                Utils.doWork(Utils.TIMEOUT_100MS);
            }
        }, "adder").start();

        new Thread(()->{
            for (int i = 0; i < size; i++) {
                list.get();
                if (i < 10) {
                    Utils.doWork(Utils.TIMEOUT_500MS);
                }

            }
        }, "getter").start();
    }


}

class MyBlockingList {

    private static final Logger log = LoggerFactory.getLogger(MyBlockingList.class);

    private List<Integer> data;

    private int capacity;

    public MyBlockingList(int capacity) {
        this.data = new ArrayList(capacity);
        this.capacity = capacity;
    }

    public synchronized void add(int item) {
        if (data.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            data.add(item);
            log.debug("add {} to list", item);
            notifyAll();
        }
    }

    public synchronized Integer get() {
        Integer item = null;
        if (data.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            item = data.remove(0);
            log.debug("get {} from list", item);
            notifyAll();
        }
        return item;
    }
}