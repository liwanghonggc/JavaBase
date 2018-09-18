package lwh.java.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwh
 * @date 2018-09-17
 * @desp 方法引用
 */
public class MethodRef {

    public static void main(String[] args) {
        List names = new ArrayList();

        names.add("李旺红");
        names.add("许春杰");
        names.add("严海斌");

        names.forEach(System.out::println);
    }
}
