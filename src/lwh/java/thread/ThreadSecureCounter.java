package lwh.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSecureCounter implements Callable<Long> {

    private AtomicInteger ai = new AtomicInteger();

    public ThreadSecureCounter() {
    }

    @Override
    public Long call() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            ai.incrementAndGet();
        }
        Long end = System.currentTimeMillis();
        return end - start;

    }

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(1000);
        Long maxtime = 0l;
        ThreadSecureCounter mtc = new ThreadSecureCounter();
        List<Future<Long>> result = new ArrayList<Future<Long>>();
        for (int i = 0; i < 1000; i++) {
            Future<Long> time = es.submit(mtc);
            result.add(time);
        }

        es.shutdown();


        System.out.println(mtc.ai.get());
    }

}