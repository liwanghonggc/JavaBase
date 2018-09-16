package lwh.java.collection;

import java.util.ArrayList;
import java.util.List;

class A{
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

public class ListTest1 {

    public static void main(String[] args){
        List list = new ArrayList();
        list.add(new String("轻量级Java"));
        list.add(new String("哈利波特"));
        list.add(new String("数据库"));

        System.out.println(list);

        list.remove(new A());
        System.out.println(list);

        list.remove(new A());
        System.out.println(list);
    }
}
