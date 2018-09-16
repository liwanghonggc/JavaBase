package lwh.java.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest1 {

    private static final int N = 8;

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + num + "正在占用资源进行生产");
                Thread.sleep(2000);
                System.out.println("工人" + num + "释放资源");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 1; i <= N; i++){
            new Worker(i, semaphore).start();
        }
    }
}
