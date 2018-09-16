package lwh.java.generic;

import lwh.java.innerClass.OuterClass2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ToolTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(23);
//      list.add("lwh");

        try{
            Method method = list.getClass().getDeclaredMethod("add", Object.class);

            method.invoke(list, "test");
            method.invoke(list, 42.95f);
        }catch (Exception e){
            e.printStackTrace();
        }

        for(Object o : list){
            System.out.println(o);
        }

    }
}
