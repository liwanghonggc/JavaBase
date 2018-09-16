package lwh.java.collection.lwh.java.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap自身已经实现了顺序存储，默认情况下是按照元素的添加顺序存储，也可以启用按照访问顺序存储，即最近读取的数据
 * 放在最前面，最早读取的数据放在最后面，然后它还有一个判断是否删除最老数据的方法，默认是返回false，即不删除数据，我们使用
 * LinkedHashMap实现LRU缓存的方法就是对LinkedHashMap实现简单的扩展，扩展方式有两种，一种是inheritance，一种是delegation，
 * 具体使用什么方式看个人喜好.
 *
 * LinkedHashMap的一个构造函数，当参数accessOrder为true时，即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
 * public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
 *         super(initialCapacity, loadFactor);
 *         this.accessOrder = accessOrder;
 * }
 *
 * LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
 * 我们要做的就是重写这个方法，当满足一定条件时删除老数据
 * protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
 *         return false;
 * }
 *
 * 采用inheritance方式实现比较简单，而且实现了Map接口，在多线程环境使用时可以使用 Collections.synchronizedMap()方法实现
 * 线程安全操作
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache1<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;

    public LRUCache1(int cacheSize){
        super((int)Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<K, V> entry : entrySet()){
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        LRUCache1<String, String> cache = new LRUCache1<>(4);

        cache.put("1", "李旺红");
        cache.put("2", "许必宵");
        cache.put("3", "许春杰");
        cache.put("4", "严海斌");

        System.out.println(cache.toString());
        System.out.println(cache.toString());

        String str = cache.get("1");
        System.out.println(cache.toString());

        cache.put("5", "刘泽城");
        System.out.println(cache.toString());
    }
}
