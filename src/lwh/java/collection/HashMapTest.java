package lwh.java.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwh
 * @date 2018-09-14
 * @desp
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());

        map.put("1", "lwh");
        map.put("2", "lwh");
        map.put("3", "lwh");
        map.put("4", "lwh");
        map.put("5", "lwh");
    }
}
