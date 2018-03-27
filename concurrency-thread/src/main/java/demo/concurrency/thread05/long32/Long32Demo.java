package demo.concurrency.thread05.long32;

/**
 * TODO 未完成
 */
public class Long32Demo {

    public static void main(String[] args) {

        Longer longer = new Longer();
        new Thread(new ChangeWorker(longer), "work").start();
        new Thread(()-> {
            for (int i = 0; i < Integer.MAX_VALUE >> 3; i++) {
                if (longer.read() <= Integer.MAX_VALUE) {
                    System.out.println(String.format("longer broken %s", Long.toBinaryString(longer.read())));
                    System.exit(0);
                }
            }
        }).start();
        System.out.println(String.format("final %s ", longer));
    }

}

class ChangeWorker implements Runnable {
    Longer longer;

    public ChangeWorker(Longer longer) {
        this.longer = longer;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s start : %s", Thread.currentThread().getName(), longer));
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ;
            if (i % (Integer.MAX_VALUE >> 3) == 0) {
                System.out.println(String.format("longer changing %s", Long.toBinaryString(longer.change())));
            }
        }
        System.out.println(String.format("%s finished: %s", Thread.currentThread().getName(), longer));
    }
}

class Longer {
    long item = Long.MAX_VALUE;

    long change() {
        item -= Integer.MAX_VALUE;
        return item;
    }
    long read() {
        return item;
    }
    @Override
    public String toString() {
        return "" + item;
    }
}
