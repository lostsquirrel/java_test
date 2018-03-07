package demo.concurrency.thread04.cooperate;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证 变量在线程之间可见性
 * 如果可见，则 monitor 会在 size 为 5 时结束
 * 以for 循环方式，检测list容量，当等于5时结束程序
 */
public class ListBusyBoyTriggerDemo {

    private volatile static List list = new ArrayList();

    private static final Logger log = LoggerFactory.getLogger(ListBusyBoyTriggerDemo.class);

    public void add(){
        list.add("item");
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {

        final ListBusyBoyTriggerDemo ltd = new ListBusyBoyTriggerDemo();

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
                    log.debug("添加了第{}个元素..", i + 1);
                    Utils.doWork(Utils.TIMEOUT_500MS);
                }
        }, "worker").start();

    }
}
