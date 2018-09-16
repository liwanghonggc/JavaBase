package lwh.java.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNotifyDemo {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        Thread.sleep(5000);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println(Thread.currentThread() + "flag is true. wait @" +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                //条件满足时,完成工作
                System.out.println(Thread.currentThread() + "flag is false. running @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        public void run() {
            synchronized (lock) {
                //获取lock的锁,然后进行通知,通知时不会释放lock的锁
                //直到当前线程释放了lock的锁后,WaitThread才能从wait方法返回
                System.out.println(Thread.currentThread() + "hold lock. notify @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }

                //再次加锁
                synchronized (lock) {
                    System.out.println(Thread.currentThread() + "hold lock again. sleep @" +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}

