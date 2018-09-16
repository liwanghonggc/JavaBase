package lwh.java.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest1 {

    private static final int THREAD_COUNT_NUM = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("召唤七位法师完毕,准备去寻找七龙珠");
                findGragon();
            }
        });

        for (int i = 1; i <= THREAD_COUNT_NUM; i++){
            int index = i;

            new Thread(() -> {
                try{
                    System.out.println("召唤第" + index + "位法师完毕");
                    cyclicBarrier1.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void findGragon(){
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("七龙珠找齐了");
            }

        });

        for (int i = 1; i <= THREAD_COUNT_NUM; i++){
            int index = i;

            new Thread(() -> {
                try {
                    System.out.println("找到第" + index + "颗龙珠");
                    cyclicBarrier2.await();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
