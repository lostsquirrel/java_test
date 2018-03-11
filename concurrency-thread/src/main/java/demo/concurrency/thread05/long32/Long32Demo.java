package demo.concurrency.thread05.long32;

public class Long32Demo {

    public static void main(String[] args) {

        int limit = 3;
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
        Longer longer = new Longer();
        new Thread(new ChangeWorker(longer), "work").start();
        new Thread(()-> {
            while (longer.read() > 0) {
                System.out.println(String.format("longer %s", Long.toHexString(longer.read())));
            }
        });
        long e = Long.MAX_VALUE - Integer.MAX_VALUE * limit;
        System.out.println(String.format("expected %s, get %s ", e, longer.read()));
    }

}
class ChangeWorker implements Runnable {
    Longer longer;

    public ChangeWorker(Longer longer) {
        this.longer = longer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            longer.change();
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
