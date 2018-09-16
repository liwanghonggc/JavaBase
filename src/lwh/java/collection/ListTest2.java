package lwh.java.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new String("轻量级Java"));
        list.add(new String("哈利波特"));
        list.add(new String("数据库"));

        System.out.println(list);

        list.sort((o1, o2) -> ((String)o1).length() - ((String)o2).length());

        System.out.println(list);

        list.replaceAll(ele -> ((String)ele).length());
        System.out.println(list);
    }
}
