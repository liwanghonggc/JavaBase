package lwh.java.thread;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {

    public static void main(String[] args) {
        final Lock lock = new TwinsLock();

        class Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try{
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        //启动十个线程
        for (int i = 0; i < 10; i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        //每隔一秒换行
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
