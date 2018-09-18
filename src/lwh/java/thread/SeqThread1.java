package lwh.java.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lwh
 * @date 2018-09-18
 * @desp 三个线程依次输出
 */
public class SeqThread1 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAA");
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("BBB");
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("CCC");
            }
        });

        executor.shutdownNow();
    }
}
