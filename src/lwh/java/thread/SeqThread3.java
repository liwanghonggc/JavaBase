package lwh.java.thread;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author lwh
 * @date 2018-09-18
 * @desp 三个线程顺序执行
 */
public class SeqThread3 {

    public static void main(String[] args) {
        BlockingQueue<Thread> queue = new LinkedBlockingQueue<>();
        Thread t1 = new Thread(new Work(), "thread1");
        Thread t2 = new Thread(new Work(), "thread2");
        Thread t3 = new Thread(new Work(), "thread3");

        queue.add(t1);
        queue.add(t2);
        queue.add(t3);

        for(int i = 0; i < 3; i++){
            Thread t = null;
            try {
                t = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
        }
    }

    static class Work implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}


