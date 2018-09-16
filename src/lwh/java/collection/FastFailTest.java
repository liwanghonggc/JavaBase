package lwh.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastFailTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            Integer num = it.next();
            if(num == 1){
                it.remove();
                list.remove(1);
            }
            System.out.println(num);
        }

        System.out.println(list);
    }
}
