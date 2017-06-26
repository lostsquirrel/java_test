package demo.concurrency.thread.cooperate.busyboy;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 以for 循环方式，检测list容量，当等于5时结束程序
 */
public class ListTriggerDemo {

    private volatile static List list = new ArrayList();

    private static final Logger log = LoggerFactory.getLogger(ListTriggerDemo.class);

    public void add(){
        list.add("bjsxt");
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {

        final ListTriggerDemo ltd = new ListTriggerDemo();
        new Thread(() -> {
            while(true){
                if(ltd.size() == 5){
                    log.debug("list size = {} 线程停止中..", ltd.size());
                    break;
                }
            }
            log.debug("线程结束");
        }, "monitor").start();
       new Thread(() -> {
                for(int i = 0; i <10; i++){
                    ltd.add();
                    log.debug("添加了第{}个元素..", i);
                    Utils.doWork(Utils.TIMEOUT_500MS);
                }
        }, "worker").start();

    }
}
