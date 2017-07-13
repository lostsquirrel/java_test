package demo.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * vm-args: -Xms20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    private static class OOMObject {}

    private static long counter = 0;

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            System.out.println(counter++);
        }
    }
}
// 工具 eclipse memory analyzer
//804484java.lang.OutOfMemoryError: GC overhead limit exceeded
//        Dumping heap to java_pid3332.hprof ...
//        Heap dump file created [27930967 bytes in 0.101 secs]

