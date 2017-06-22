package demo.concurrency.thread.volatilea;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * volatile 修饰变量在线程之间可见，所以程序会正常结束
 */
public class VolatileDemo extends Thread {

    private static final Logger log = LoggerFactory.getLogger(VolatileDemo.class);

    private volatile boolean isRunning = true;

    private void toggleRunning(){
        this.isRunning = !this.isRunning;
    }

    public void run(){
        log.info("执行run方法..");
        while(isRunning){
            //..
        }
        log.info("循环结束停止");
    }

    public static void main(String[] args) {
        VolatileDemo vd = new VolatileDemo();
        vd.start();
        Utils.doWork(Utils.TIMEOUT_1S);
        vd.toggleRunning();
        log.info("toggle done");
    }
}
