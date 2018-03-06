package demo.java.container.map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyHashMap.class);

    private static final int INITIAL_CAPACITY = 16;

    private static final float DEFAULT_CAPACITY_FACTOR = 0.75F;

    private int capacity;

    private float factor;

    private int size;

    private Entry<K,V>[] table;

    public MyHashMap(int capacity, float factor) {
        this.capacity = capacity;
        this.factor = factor;
        table = new Entry[capacity];
    }

    public MyHashMap() {
        this(INITIAL_CAPACITY, DEFAULT_CAPACITY_FACTOR);
    }

    @Override
    public void put(K key, V value) {
        if (size >= capacity * factor) {
            LOGGER.debug("capacity size:{} ratio {}", size,  1.0 * size / capacity);
            resize();
        }
        Entry<K, V> newItem = new Entry<>(key, value);
        int index = getIndex(key);
        LOGGER.debug("create index: {}", index);
        Entry<K, V> item = table[index];
//        如果有元素，则找到最后一个元素，并将其作为新元素的前节点
        if (item == null) {
            table[index] = newItem;
        } else {
            while (item.next != null) {
                item = item.next;
            }
            newItem.setPrev(item);
        }
        size++;
    }

    private Entry<K, V> getHeadEntry(K key) {
        int index = getIndex(key);
        return table[index];
    }

    private int getIndex(K key) {
        return hash(key.hashCode()) & capacity - 1;
    }

    /**
     * 哈希算法
     *
     * @param source 源
     * @return hash值
     */
    private int hash(int source) {
//        TODO 假实现 
        return source;
    }

    /**
     * 将table 扩容一倍
     */
    private void resize() {
        Entry<K, V>[] oldTable = table;
        capacity = capacity * 2 + 1;
        table = new Entry[capacity];
//       将原table中的元素列个取出并重新放到新
        for (Entry<K, V> entry : oldTable) {
            transferEntry(entry);
        }
    }

    private void transferEntry(Entry<K, V> entry) {
        if (entry != null) {
            Entry<K, V> next = entry.next;
            entry.next = null;
            put(entry.getKey(), entry.getValue());
            transferEntry(next);
        }

    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = this.getHeadEntry(key);

        return getValue(entry, key);
    }

    private V getValue(MyHashMap<K, V>.Entry<K, V> entry, K key) {
        V value = null;
        if (entry != null) {
            if (key == entry.getKey() || key.equals(entry.getKey())) {
                value = entry.getValue();
                LOGGER.debug("entry depth: {}", entry.depth);
            } else {
                value = getValue(entry.next, key);
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K, V> implements MyMap.Entry<K, V> {

        private K key;

        private V value;

        private int depth = 0;

        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setPrev(Entry<K, V> prev) {
            setDepth(prev.depth++);
            prev.setNext(this);
        }

        private void setDepth(int depth) {
            this.depth = depth;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
