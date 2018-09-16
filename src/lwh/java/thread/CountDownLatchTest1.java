package lwh.java.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 {

    private static final int THREAD_COUNT_NUM = 7;

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

//        for (int i = 1; i <= THREAD_COUNT_NUM; i++){
//            int index = i;
//            new Thread(() -> {
//                try {
//                    System.out.println("第" + index + "个线程跑完了");
//                    Thread.sleep(new Random().nextInt(1000));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                countDownLatch.countDown();
//            }).start();
//
//        }

        countDownLatch.await();

        System.out.println("等待七个线程跑完了,我才执行");
    }
}
