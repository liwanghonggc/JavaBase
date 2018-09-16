package lwh.java.innerClass;

public class OuterClass2 {

    private int age = 20;

    static String name = "lwh";

    public static class Inner{
        String name = "xcj";
        public void show(){
            System.out.println(OuterClass2.name);
            System.out.println(name);
            System.out.println(new OuterClass2().age);
        }
    }

    public static void main(String[] args) {
        Inner in = new Inner();
        in.show();
    }
}
