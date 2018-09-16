package lwh.java.thread;

class Sync{

    public synchronized void test(){
        System.out.println("test开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束");
    }

}

class MyThread extends Thread{

    public void run(){
        Sync sync = new Sync();
        sync.test();
    }

}

public class SyncTest1 {

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            Thread thread = new MyThread();
            thread.start();
        }
    }
}
