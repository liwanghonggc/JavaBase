package lwh.java.serial;

import java.io.*;
import java.util.*;

public class SimpleSerial {

    public static void main(String[] args) throws Exception {
        File file = new File("person.out");

        Person person = new Person("lwh", 23, Gender.MALE);
        Pet pet = new Pet("cat");
        person.setPet(pet);

        System.out.println(person);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(person);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = in.readObject();
        in.close();

        System.out.println(newPerson);

        Map<String, String> map = new HashMap<>();
        Set<String> keys = map.keySet();
        Iterator<String> itr = keys.iterator();
        while(itr.hasNext()){
            String key = itr.next();
            System.out.println(key + ", " + map.get(key));
        }

        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
        }

    }
}
