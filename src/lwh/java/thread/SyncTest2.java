package lwh.java.thread;

class Sync1{

    public synchronized void test(){
        System.out.println("test开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束");
    }

    public synchronized void test2(){
        System.out.println("hh");
    }

}

class MyThread1 extends Thread{

    public void run(){
        Sync1 sync = new Sync1();
        sync.test();
        sync.test2();
    }

}

public class SyncTest2 {

    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.start();
    }
}