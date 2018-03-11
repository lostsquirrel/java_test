package demo.concurrency.thread05.long32;

public class Long32Demo {

    public static void main(String[] args) {

        int limit = 3;
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
        Longer longer = new Longer();
        for (int i = 0; i < limit; i++) {
            new Thread(new ChangeWorker(longer), "work" + 1).start();
        }
        System.out.println(String.format("expected %s, get %s ", 10000000000L - 1000 * limit, longer.read()));
    }

}
class ChangeWorker implements Runnable {
    Longer longer;

    public ChangeWorker(Longer longer) {
        this.longer = longer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            longer.change();
        }
        System.out.println(String.format("%s: %s", Thread.currentThread().getName(), longer.read()));
    }
}

class Longer {
    long item = 10000000000L;

    void change() {
        item -= 10;
    }

    long read() {
        return item;
    }
}
