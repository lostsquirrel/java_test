package demo.java.container.map;

public class SimpleMapTest {

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        int i1 = 1000;
        for (int i = 0; i < i1; i++) {
            map.put("key" + i, "value" + i);
        }
        System.out.println("---------------------------------");
        for (int i = 0; i < i1; i++) {
            System.out.println(map.get("key" + i));
        }
    }
}
