package lwh.java.innerClass;

public class OuterClass1 {
    private int age = 23;
    String name = "xcj";

    public class Inner{
        String name = "lwh";

        public String address = "js";

        public void show(){
            String name = "yhb";
            System.out.println(age);
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(OuterClass1.this.name);
        }
    }

    public void getInnerAtt(){
        System.out.println(new OuterClass1().new Inner().address);
    }

    public static void main(String[] args) {
        OuterClass1 o1 = new OuterClass1();
        Inner in = o1.new Inner();
        in.show();
        o1.getInnerAtt();
    }
}
