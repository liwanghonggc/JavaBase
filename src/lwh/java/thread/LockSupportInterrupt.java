package lwh.java.thread;

import java.util.concurrent.locks.LockSupport;

public class LockSupportInterrupt {

    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new InterruptThread());
        t.start();
        Thread.sleep(1000);
        System.out.println("I am going to interrupt");
        t.interrupt();
    }
}

class InterruptThread implements Runnable{
    @Override
    public void run() {
        System.out.println("I am going to park");
        LockSupport.park();
        System.out.println("I am going to again");
    }
}
