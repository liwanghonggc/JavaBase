package lwh.java.thread;

/**
 * @author lwh
 * @date 2019-03-11
 * @desp
 */
public class Print_ThreeThread implements Runnable{

    private static int i = 0;

    @Override
    public void run() {
        int cur = Integer.parseInt(Thread.currentThread().getName());
        while (i < 300){
            if(i % 3 == cur - 1){
                System.out.println("T" + (i % 3 + 1));
                i++;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Print_ThreeThread(), "1");
        Thread t2 = new Thread(new Print_ThreeThread(), "2");
        Thread t3 = new Thread(new Print_ThreeThread(), "3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("OK");
    }
}
