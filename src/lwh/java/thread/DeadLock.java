package lwh.java.thread;

/**
 * @author lwh
 * @date 2018-09-16
 * @desp
 */
public class DeadLock implements Runnable{

    public boolean flag = true;

    private static final Object lock1 = new Object();

    private static final Object lock2 = new Object();

    @Override
    public void run() {
        if(flag){
            synchronized (lock1){
                System.out.println("Get Lock1");
                sleep();
                synchronized (lock2){

                }
            }
        }else {
            synchronized (lock2){
                System.out.println("Get Lock2");
                sleep();
                synchronized (lock1){

                }
            }
        }
    }

    private static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeadLock thread1 = new DeadLock();
        DeadLock thread2 = new DeadLock();
        thread1.flag = true;
        thread2.flag = false;
        new Thread(thread1).start();
        new Thread(thread2).start();
    }
}
