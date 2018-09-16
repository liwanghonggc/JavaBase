package lwh.java.thread;

public class InterruptTest {

    public static void main(String[] args) throws 	InterruptedException {
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted When Sleep");
                        //需要重新设置中断标记位,若注释掉下行代码会死循环
                        //Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }

}
