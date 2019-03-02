package lwh.java.thread;

/**
 * @author lwh
 * @date 2019-03-02
 * @desp
 */
public class PrintA_To_Z_3 {

    private static int i = 0;

    static class PrintThread extends Thread {

        public PrintThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (i < 26) {
                int cur = Integer.parseInt(Thread.currentThread().getName());
                if (i % 3 == cur - 1) {
                    System.out.println(Thread.currentThread().getName() + (char) ('A' + i));
                    i++;
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new PrintThread("1");
        Thread t2 = new PrintThread("2");
        Thread t3 = new PrintThread("3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("OK");
    }
}
