package lwh.java.other;

class Father{

    public static void say(){

    }
}

class Son extends Father{

    public static void say(){

    }
}

public class Test1 {

    public static void main(String[] args) {
        String str = null;
        String res = str + "abc";
        System.out.println(res);
    }
}
