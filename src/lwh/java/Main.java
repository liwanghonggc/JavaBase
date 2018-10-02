package lwh.java;

import java.util.*;

/**
 * @author lwh
 * @date 2018-09-16
 * @desp
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < m; i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                if(!map.containsKey(from)){
                    List<Integer> list = new ArrayList<>();
                    list.add(to);
                    map.put(from, list);
                }else{
                    List<Integer> list = map.get(from);
                    list.add(to);
                }
            }

            Map<Integer, Integer> in = getInMap(map);
            Map<Integer, Integer> out = getOutMap(map);
        }
    }

    private static Map<Integer,Integer> getOutMap(Map<Integer,List<Integer>> map) {
        Map<Integer, Integer> res = new HashMap<>();
        Set<Integer> keys = map.keySet();
        Iterator<Integer> itr = keys.iterator();
        while(itr.hasNext()){
            Integer key = itr.next();
            res.put(key, map.get(key).size());
        }
        return res;
    }

    private static Map<Integer,Integer> getInMap(Map<Integer,List<Integer>> map) {

        return null;
    }


}


