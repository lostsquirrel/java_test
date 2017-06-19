package demo.concurrency.thread.reentrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 无同步 第一个线程执行完后，第二个线程可能会交替打印
 */
public class AsyncClassDemo {

    public static void main(String[] args) {
        Child sc = new Child();
        new Thread(()-> {sc.operationChild();}).start();
        new Thread(()-> {sc.operationChild();}).start();
    }
}

class Parent {
    private static final Logger log = LoggerFactory.getLogger(Parent.class);

    protected int i = 10;

    public void operationParent(){
        try {
            log.debug("Parent print i = {}", i--);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Child extends Parent {
    private static final Logger log = LoggerFactory.getLogger(Child.class);

    public void operationChild(){
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
