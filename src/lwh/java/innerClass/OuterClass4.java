package lwh.java.innerClass;

public class OuterClass4 {

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){

            }
        };
        t.start();
    }
}
