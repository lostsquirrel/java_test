package demo.concurrency.thread.reentrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * synchronized的重入 第一个线程执行完后， i < 0, 第二个线程不会有打印
 */
public class ReentrantClassDemo {

    public static void main(String[] args) {
        Child sc = new Child();
        new Thread(()-> {sc.operationChild();}).start();
        new Thread(()-> {sc.operationChild();}).start();
    }
}

class Sync {
    private static final Logger log = LoggerFactory.getLogger(Parent.class);

    protected int i = 10;

    public synchronized void operationParent(){
        try {
            log.debug("Parent print i = {}", i--);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class SyncChild extends Parent {
    private static final Logger log = LoggerFactory.getLogger(Child.class);

    public synchronized void operationChild(){
        try {
            while(i > 0) {
                log.debug("Child print i = {}", i--);
                Thread.sleep(100);
                this.operationParent();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
