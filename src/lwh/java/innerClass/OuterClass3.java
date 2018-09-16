package lwh.java.innerClass;

public class OuterClass3 {
    public void show(){
        final int a = 25;
        int b = 3;
        class Inner{
            int c = 2;
            public void print(){
                System.out.println("访问外部类:" + a);
                System.out.println("访问内部类:" + c);
                System.out.println("访问外部类:" + b);
            }
        }
        Inner in = new Inner();
        in.print();
    }
    public static void Ouer(String[] args) {
        OuterClass3 out = new OuterClass3();
        out.show();
    }
}
