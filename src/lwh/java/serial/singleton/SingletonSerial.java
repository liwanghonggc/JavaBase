package lwh.java.serial.singleton;

import java.io.*;

public class SingletonSerial {

    public static void main(String[] args) throws Exception{
        File file = new File("user.out");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        /** 保存单例对象 **/
        out.writeObject(User.getInstance());
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object newUser = in.readObject();

        System.out.println(User.getInstance() == newUser);

    }
}
