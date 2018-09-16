package lwh.java.thread;


import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyBlockingQueue {

    //1.需要一个承装元素的集合
    private static final LinkedList<Object> list = new LinkedList<>();

    //2.需要一个计数器
    private static final AtomicInteger count = new AtomicInteger(0);
    //3.需要指定上限下限
    private static final int maxSize = 5;
    private static final int minSize = 0;

    //4.初始化锁对象
    private static final Object lock = new Object();

    //put方法
    public void put(Object obj){
        synchronized (lock){
            //达到上限无法添加,等待
            while (count.get() == maxSize){
                try{
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            //加入元素,计数器增加
            list.add(obj);
            count.getAndIncrement();

            System.out.println("元素" + obj + "被添加");
            lock.notify();
        }
    }

    //get方法
    public Object get(){
        Object res;
        synchronized (lock){
            while (count.get() == minSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //计数器减并删除元素
            count.getAndDecrement();
            res = list.removeFirst();
            System.out.println("元素" + res + "被消费");
            lock.notify();
        }
        return res;
    }

    private int size(){
        return count.get();
    }

    public static void main(String[] args) throws Exception{
        final MyBlockingQueue queue = new MyBlockingQueue();
        queue.put("lwh");
        queue.put("xcj");
        queue.put("yhb");
        queue.put("lzc");
       // queue.put("xbx");

        System.out.println("当前元素个数为: " + queue.size());

        Thread t1 = new Thread(() -> {
            queue.put("cf");
            queue.put("lwl");
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                queue.get();
                Thread.sleep(2000);
                queue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
