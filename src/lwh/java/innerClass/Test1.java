package lwh.java.innerClass;

interface A{}

interface B{}

abstract class C{}

public class Test1 implements A, B{
}

class Test4 implements A, B{
}

interface Test2 extends A, B{

}

class Test3 extends C implements B{

    class D extends Test1{}

    class E extends Test1{}

    class F implements A{}

    class G implements A{}
}
