package lwh.java.extend.seq;

class A {
    {
        System.out.println("A 的构造代码块");
    }

    A() {
        System.out.println("A 的构造函数");
    }
}

class B extends A {
    A a = new A();

    {
        System.out.println("B 的构造代码块");
    }

    B() {
        System.out.println("B 的构造函数");
    }
}

public class ExtendsTest1 {

    public static void main(String[] args) {
        new B();
    }
}
