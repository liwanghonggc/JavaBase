package lwh.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 5; i++){
            int index = i;
            Future future = executorService.submit(() -> divTask(200, index));
            try {
                future.get();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    private static void divTask(int a, int b){
        double res = a / b;
        System.out.println(res);
    }
}
