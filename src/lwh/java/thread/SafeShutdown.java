package lwh.java.thread;

public class SafeShutdown {
    public static void main(String[] args) throws InterruptedException {
//        Thread countThread1 = new Thread(new Runner(), "countThread1");
//        countThread1.start();
//        Thread.sleep(20);
//        countThread1.interrupt();
        Runner run = new Runner();
        Thread countThread2 = new Thread(run, "countThread2");
        countThread2.start();
        Thread.sleep(20);
        run.cancel();
    }
    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while(on && !Thread.currentThread().isInterrupted()){
                i++;
                System.out.println(i);
            }
            System.out.println("Count i = " + i);
        }

        public void cancel(){
            on = false;
        }
    }
}

