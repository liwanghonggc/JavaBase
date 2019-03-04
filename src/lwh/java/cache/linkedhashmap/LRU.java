package lwh.java.cache.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lwh
 * @date 2019-03-04
 * @desp
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private int maxSize;

    public LRU(int size){
        super(size, 0.75f, true);
        maxSize = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxSize;
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
        LRU<String, String> cache = new LRU<>(4);

        cache.put("1", "李旺红");
        cache.put("2", "许必宵");
        cache.put("3", "许春杰");
        cache.put("4", "严海斌");

        System.out.println(cache.toString());

        cache.get("1");
        System.out.println(cache.toString());

        cache.put("5", "刘泽城");
        System.out.println(cache.toString());
    }

}
