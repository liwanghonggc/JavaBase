package lwh.java.thread;

public class EnumSingleton {

    //私有构造函数
    private EnumSingleton(){

    }

    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private EnumSingleton enumSingleton;


        //JVM保证这个方法绝对只调用一次
        Singleton(){
            enumSingleton = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return enumSingleton;
        }
    }
}
