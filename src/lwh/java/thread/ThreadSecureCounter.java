package lwh.java.thread;


import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSecureCounter {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++){
            new Thread(){
                @Override
                public void run() {
                    for(int j = 0; j < 20000; j++){
                        count.getAndIncrement();
                    }
                }
            }.start();
        }

        Thread.sleep(2000);

        System.out.println(count.get());
    }
}