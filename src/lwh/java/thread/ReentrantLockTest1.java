package lwh.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                runMethod(lock);
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                runMethod(lock);
            }
        }, "thread2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                runMethod(lock);
            }
        }, "thread3").start();

    }

    private static void runMethod(Lock lock){
        lock.lock();
        for (int i = 1; i <= 5; i++){
            System.out.println(Thread.currentThread().getName() + "  i = " + i);
        }
        System.out.println();
        lock.unlock();
    }

    

}
