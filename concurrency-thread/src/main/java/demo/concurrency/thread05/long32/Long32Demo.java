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
        System.out.println(String.format("final %s ", longer.read()));
    }

}

class ChangeWorker implements Runnable {
    Longer longer;

    public ChangeWorker(Longer longer) {
        this.longer = longer;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s: %s", Thread.currentThread().getName(), longer.read()));
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            longer.change();
            if (i % (Integer.MAX_VALUE >> 3) == 0) {
                System.out.println(String.format("longer %s", Long.toBinaryString(longer.read())));
            }
        }
        System.out.println(String.format("%s: %s", Thread.currentThread().getName(), longer.read()));
    }
}

class Longer {
    long item = Long.MAX_VALUE;

    void change() {
        item -= Integer.MAX_VALUE;
    }

    long read() {
        return item;
    }
}
