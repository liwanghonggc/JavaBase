package lwh.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lwh
 * @date 2018-09-16
 * @desp
 */
public class PeekIteratorTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        PeekIterator peekIterator = new PeekIterator(iterator);
        //System.out.println(peekIterator.peek());

        while(peekIterator.hasNext()){
            System.out.println(peekIterator.next());
            System.out.println(peekIterator.peek());
        }

    }
}
