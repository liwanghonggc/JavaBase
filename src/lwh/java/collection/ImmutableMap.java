package lwh.java.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMap {

    private static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);

        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        map.put(4, 6);
    }
}
