package lwh.java.other;

/**
 * @author lwh
 * @date 2019-03-02
 * @desp
 */
public class FinalTest2 {

    public static void main(String[] args) {
        final int a = 1;

        final Person p = new Person();
        System.out.println(p.age);

        p.age = 2;
        System.out.println(p.age);
    }
}

class Person {
    int age = 1;
}
