package lwh.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 {

//    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//
//        new Thread(() -> runMethod(lock, 0), "thread1").start();
//        new Thread(() -> runMethod(lock, 5000), "thread2").start();
//        new Thread(() -> runMethod(lock, 1000), "thread3").start();
//        new Thread(() -> runMethod(lock, 3000), "thread4").start();
//        new Thread(() -> runMethod(lock, 10000), "thread5").start();
//    }
//
//    private static void runMethod(Lock lock, long sleepTime){
//        lock.lock();
//
//        try{
//            Thread.sleep(sleepTime);
//            System.out.println("ThreadName: " + Thread.currentThread().getName());
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//    }
}
