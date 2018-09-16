package lwh.java.thread;

public class PrintA_To_Z_1 {

    public static int i = 0;

    static class PrintThread implements Runnable{
        @Override
        public void run(){
           int cur = Integer.parseInt(Thread.currentThread().getName());
           while (i < 26){
               if (i % 3 == cur - 1){
                   System.out.println(Thread.currentThread().getName() + (char)('A' + i));
                   ++i;
               }
               try{
                   Thread.sleep(20);
               }catch (InterruptedException e){

               }
           }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new PrintThread(), "1");
        Thread t2 = new Thread(new PrintThread(), "2");
        Thread t3 = new Thread(new PrintThread(), "3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("OK");
    }
}
