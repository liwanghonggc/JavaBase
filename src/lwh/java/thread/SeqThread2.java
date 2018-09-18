package lwh.java.thread;

/**
 * @author lwh
 * @date 2018-09-18
 * @desp 三个线程依次输出
 */
public class SeqThread2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Work(null), "thread1");
        Thread t2 = new Thread(new Work(t1), "thread2");
        Thread t3 = new Thread(new Work(t2), "thread3");

        t2.start();
        t3.start();
        t1.start();
    }
}

class Work implements Runnable{

    private Thread beforeThread;

    public Work(Thread beforeThread){
        this.beforeThread = beforeThread;
    }

    @Override
    public void run() {
        if(beforeThread != null){
            try{
                beforeThread.join();
                System.out.println(Thread.currentThread().getName());
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println(Thread.currentThread().getName());
        }
    }
}
