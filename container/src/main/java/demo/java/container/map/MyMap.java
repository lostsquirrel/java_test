package demo.java.container.map;


/**
 * 简化map接口
 * @param <K> key 类型
 * @param <V> value 值类型
 */
public interface MyMap<K, V> {

    /**
     * 加入键值对
     * @param key 键
     * @param value 值
     */
    void put(K key, V value);

    /**
     * 根据键获取值
     * @param key 键
     * @return 值
     */
    V get(K key);

    /**
     * 获取当前键值对数量
     * @return 当前键值对数量
     */
    int size();

    /**
     * 键值对
     * @param <K> 键类型
     * @param <V> 值类型
     */
    interface Entry<K, V> {
        /**
         * @return 键
         */
        K getKey();

        /**
         * @return 值
         */
        V getValue();
    }
}
