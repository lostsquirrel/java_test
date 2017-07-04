package demo.java.v8.lambda.hello;

/**
 * java 8 lambda hello world demo
 */
public class Calculator {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Calculator.class);

    interface IntegerOperation {
        int operation(int a, int b);
    }

    public int executeOperation(int a, int b, IntegerOperation op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        log.info("{} + {} = {}", 40, 20, cal.executeOperation(40, 20, (a, b) -> a + b));
        log.info("{} - {} = {}", 20, 10, cal.executeOperation(20, 10, (a, b) -> a - b));
    }
}
