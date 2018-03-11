package demo.concurrency.thread05.long32;

public class Long32Demo {

    public static void main(String[] args) {

        int limit = 100;
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
        Longer longer = new Longer();
        Thread writer = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {
                longer.change();
            }
        }, "writer");
        writer.start();

        new Thread(new ReaderWorker(limit, longer, writer), "reader").start();
    }

}
class ReaderWorker implements Runnable {
    private int limit;
    Longer longer;
    Thread writer;

    public ReaderWorker(int limit, Longer longer, Thread writer) {
        this.limit = limit;
        this.longer = longer;
        this.writer = writer;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            System.out.println(String.format("current value is %s", Long.toHexString(longer.read())));
        }
        writer.interrupt();
    }
}

class Longer {
    long item = Long.MAX_VALUE >> 1;

    void change() {
        item -= 1;
    }

    long read() {
        return item;
    }
}
