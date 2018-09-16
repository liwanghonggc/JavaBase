package lwh.java.thread;

public class PrintA_To_Z_2 {

    public static volatile int i = 0;

    public static Object obj = new Object();

    public static volatile boolean flag_A = true;
    public static volatile boolean flag_B = false;
    public static volatile boolean flag_C = false;

    public static volatile StringBuilder sb = new StringBuilder();

    static class PrintThread_A implements Runnable{
        @Override
        public void run(){
           while(i < 26){
               if(flag_A && i < 26){
                   synchronized (obj){
                       System.out.print(Thread.currentThread().getName() + (char)('A' + i));
                       ++i;
                       flag_A = false;
                       flag_B = true;
                   }
               }
           }
        }
    }

    static class PrintThread_B implements Runnable{
        @Override
        public void run(){
            while(i < 26){
                if(flag_B && i < 26){
                    synchronized (obj){
                        System.out.print(Thread.currentThread().getName() + (char)('A' + i));
                        ++i;
                        flag_B = false;
                        flag_C = true;
                    }
                }
            }
        }
    }

    static class PrintThread_C implements Runnable{
        @Override
        public void run(){
            while(i < 26){
                if(flag_C && i < 26){
                    synchronized (obj){
                        System.out.print(Thread.currentThread().getName() + (char)('A' + i));
                        ++i;
                        flag_C = false;
                        flag_A = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new PrintThread_A(), "1");
        Thread t2 = new Thread(new PrintThread_B(), "2");
        Thread t3 = new Thread(new PrintThread_C(), "3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("OK");

    }
}
