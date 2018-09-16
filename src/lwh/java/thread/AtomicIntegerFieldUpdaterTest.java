package lwh.java.thread;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    //原子更新字段类都是抽象类,要使用静态方法创建一个更新器
    //同时指定要更新的类和字段
    private static AtomicIntegerFieldUpdater<User> a =
            AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {
        User user = new User("lwh", 10);
        //输出10
        System.out.println(a.getAndIncrement(user));
        //输出11
        System.out.println(a.get(user));
    }

    static class User{
        private String name;
        //要更新的字段必须用public volatile修饰
        public volatile int old;

        public User(String name, int old){
            this.name = name;
            this.old = old;
        }

        public String getName(){
            return name;
        }

        public int getOld(){
            return old;
        }

    }
}
