package lwh.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubmitDemo1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 5; i++){
            int index = i;
            executorService.submit(() -> divTask(100, index));
        }

        executorService.shutdown();
    }

    private static void divTask(int a, int b){
        double res = a / b;
        System.out.println(res);
    }
}
