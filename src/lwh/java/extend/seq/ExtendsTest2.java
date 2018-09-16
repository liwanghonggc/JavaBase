package lwh.java.extend.seq;

class Mother{
    Mother(){
        System.out.println("母类的构造函数");
    }
}

class Father{
    static Mother mother1 = new Mother();

    Mother mother2 = new Mother();

    {
        System.out.println("父类的构造代码块");
    }

    Father(){
        System.out.println("父类的构造函数");
    }

    static{
        System.out.println("父类的静态代码块");
    }
}

class Son extends Father{
    static Father father1 = new Father();

    static{
        System.out.println("子类的静态代码块");
    }

    Son(){
        System.out.println("子类的构造函数");
    }

    Father father2 = new Father();

    {
        System.out.println("子类的构造代码块");
    }
}

public class ExtendsTest2 {

    public static void main(String[] args) {
        new Son();
    }
}
