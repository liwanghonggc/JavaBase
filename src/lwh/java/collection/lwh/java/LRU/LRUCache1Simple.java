package lwh.java.collection.lwh.java.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1Simple {

    final static int cacheSize = 4;

    public static void main(String[] args){
        Map<String, String> cache = new LinkedHashMap<String, String>((int)Math.ceil(cacheSize / 0.75f) + 1, 0.75f, true){

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };

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
