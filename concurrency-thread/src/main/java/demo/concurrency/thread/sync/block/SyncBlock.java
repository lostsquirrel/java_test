package demo.concurrency.thread.sync.block;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用synchronized代码块减小锁的粒度，提高性能
 */
public class SyncBlock {

    private static final Logger log = LoggerFactory.getLogger(SyncBlock.class);

    public void doLongTimeTask(){
        log.info("当前线程开始：" + Thread.currentThread().getName() +
                ", 正在执行一个较长时间的业务操作，其内容不需要同步");
        Utils.doWork(Utils.TIMEOUT_2S);

        synchronized(this){
            log.info("当前线程：" + Thread.currentThread().getName() +
                    ", 执行同步代码块，对其同步变量进行操作");
            Utils.doWork(Utils.TIMEOUT_2S);
        }
        log.info("当前线程结束：" + Thread.currentThread().getName() +
                ", 执行完毕");
    }

    public static void main(String[] args) {
        final SyncBlock otz = new SyncBlock();
        Thread t1 = new Thread(() -> otz.doLongTimeTask(),"t1");
        Thread t2 = new Thread(() -> otz.doLongTimeTask(),"t2");
        t1.start();
        t2.start();

    }
}
