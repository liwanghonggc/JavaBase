package lwh.java.collection.lwh.java.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

class MyCache extends LinkedHashMap{

    private final int MAX_CACHE_SIZE;

    public MyCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public Object get(Object key) {
        Object str = super.get(key);
        if(str == null){
            return -1;
        }
        return str;
    }


}

public class Main {

    public static void main(String[] args) {
        MyCache cache = new MyCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Object o = cache.get(1);
        System.out.println(o);
        cache.put(2, 102);
        cache.put(3, 3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
