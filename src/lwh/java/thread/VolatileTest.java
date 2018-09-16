package lwh.java.thread;

public class VolatileTest {

    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    private static final int THREADS_COUNT = 200;

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[THREADS_COUNT];

        for(int i = 0; i < THREADS_COUNT; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 100000; j++){
                        increase();
                    }
                }
            });
            threads[i].start();
            threads[i].join();
        }

        System.out.println(race);
    }
}
