package lwh.java.method;

class A{
    private void sayHello(){

    }

    public static void sayHaHa(){

    }

    public final void sayHeiHei(){

    }
}

class B extends A{
    public void sayHello(){

    }

    /** 直接编译失败 **/
//    public void sayHeiHei(){
//
//    }

    public static void sayHaHa(){

    }
}


interface C{
}

public class OverrideTest {


}
