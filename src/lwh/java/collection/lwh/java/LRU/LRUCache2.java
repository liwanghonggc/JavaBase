package lwh.java.collection.lwh.java.LRU;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache2<K, V> {

    private final int MAX_CACHE_SIZE;

    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    LinkedHashMap<K, V> map;

    public LRUCache2(int cacheSize){
        MAX_CACHE_SIZE = cacheSize;

        int capacity = (int)Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;

        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTOR, true){

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized void put(K key, V value){
        map.put(key, value);
    }

    public synchronized V get(K key){
        return map.get(key);
    }

    public synchronized void remove(K key){
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll(){
        return map.entrySet();
    }

    public synchronized int size(){
        return map.size();
    }

    public synchronized void clear(){
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<K, V> entry: map.entrySet()){
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        LRUCache2<String, String> cache = new LRUCache2<String, String>(4);

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
