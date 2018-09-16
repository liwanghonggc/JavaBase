package lwh.java.collection;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {

    public static void main(String[] args){
        List fixedList = Arrays.asList("疯狂Java讲义", "轻量级Java讲义", "数据库");

        System.out.println(fixedList.getClass());

        fixedList.add("哈利波特");

        System.out.println(Integer.parseInt("0001111", 2) & 15);
        System.out.println(Integer.parseInt("0011111", 2) & 15);
        System.out.println(Integer.parseInt("0111111", 2) & 15);
        System.out.println(Integer.parseInt("1111111", 2) & 15);
    }
}
