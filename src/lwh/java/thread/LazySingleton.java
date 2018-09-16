package lwh.java.thread;

//线程不安全
public class LazySingleton {

    //构造函数私有化
    private LazySingleton(){

    }

    //单例对象
    private static LazySingleton instance = null;

    /**
     * 单线程情况下:
     * 1. memory = allocate() 分配内存空间
     * 2. ctorInstance() 初始化对象
     * 3. instance = memory 设置instance指向刚分配的内存
     *
     * 多线程情况下,JVM和CPU优化,发生了指令重排序
     * 1. memory = allocate() 分配内存空间
     * 3. instance = memory 设置instance指向刚分配的内存
     * 2. ctorInstance() 初始化对象
     */

    //静态工厂方法
    public static LazySingleton getInstance(){
        //双重检测机制
        if(instance == null){  //线程B执行到此处
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();  //发生乱序,线程A在此处执行到指令3
                }
            }
        }

        return instance;
    }

    /**
     * 上述情况下,发生乱序,线程A执行到指令3,此时instance != null,但还没有正确初始化.
     * 若此时切换到线程B执行,线程B发现instance != null,直接返回,但该对象还没有正确初始化
     */
}
