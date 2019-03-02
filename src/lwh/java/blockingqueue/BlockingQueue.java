package lwh.java.blockingqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lwh
 * @date 2019-03-01
 * @desp 模拟实现一个阻塞队列
 */
public class BlockingQueue {

    /**
     * 存放元素
     */
    private static final LinkedList<Object> queue = new LinkedList<>();

    /**
     * 阻塞队列最小元素数量
     */
    private int minSize;

    /**
     * 阻塞队列最大元素数量
     */
    private int maxSize;

    /**
     * 获取释放元素时要获取锁
     */
    private static final Object lock = new Object();

    /**
     * 计数器,表示阻塞队列元素
     */
    private AtomicInteger num = new AtomicInteger(0);

    public BlockingQueue(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public void put(Object obj){
        synchronized (lock){
            //已达到最大值,则等待
            while (num.get() == maxSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            num.getAndIncrement();
            queue.add(obj);
            lock.notify();
        }
    }

    public Object get(){
        synchronized (lock){
            while (num.get() == minSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            num.getAndDecrement();
            lock.notify();
            return queue.removeFirst();
        }
    }
}
