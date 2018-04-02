package demo.concurrency.unsafe;

public class SecretHolder {
    private int SECRET_VALUE = 0;

    public boolean secretIsDisclosed() {
        return SECRET_VALUE == 1;
    }
}
