package lwh.java.serial.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class User implements Serializable{

    private String name;

    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
    }

    private static class InstanceHolder{
        private static final User instance = new User("lwh", 24);
    }

    public static User getInstance(){
        return InstanceHolder.instance;
    }

    private Object readResolve() throws ObjectStreamException{
        return InstanceHolder.instance;
    }
}
